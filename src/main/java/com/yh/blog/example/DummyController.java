package com.yh.blog.example;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yh.blog.model.RoleType;
import com.yh.blog.model.User;
import com.yh.blog.repository.UserRepository;

import jakarta.transaction.Transactional;

//더미 데이터  Test 
@RestController
public class DummyController {
	
	@Autowired //의존성 주입 하는것 (DI)
	private UserRepository userRepository;
	
	//save 함수는 id 를 전달하지 않으면  insert
	//save 함수는 id 를 전달하면 해당 id에 대한 데이터 가 있으면 update
	//save 함수는 id 를 전달하면 해당 id에 대한 데이터 가 없으면 insert 
	//json 데이터를 요청 -> java  Object변환하여 받아줌
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			return"삭제에 실패하였습니다."+id;
		}
		return"삭제가 완료되었습니다."+id;
	}
	@Transactional //함수 종료시 자동commit 됨
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
		System.out.println("id:::"+id);
		System.out.println("getPassword:::"+requestUser.getPassword());
		System.out.println("getEmail:::"+requestUser.getEmail());
		
		//파라미터 안에 함수를 넣을 수 없다.
		User user = userRepository.findById(id). orElseThrow(()->{
			return new IllegalArgumentException("수정 실패 ");
		});
		
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		
//		userRepository.save(user);
		//변경 감지 -> db수정
		//더티 체킹 
		
		return user;
	}
	@GetMapping("/dummy/users")
	public List<User> list(){
		return userRepository.findAll();
	}
	
	//하나의 페이지당 2건의 데이터를 리턴 페이징 처리
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size=2, sort="id", direction = Sort.Direction.DESC) Pageable pageable){
		Page<User> pagingUser = userRepository.findAll(pageable);
		
		List<User> users = pagingUser.getContent();
		return users;
	}
	
	//{id}주소로 파라메터를 전달 받을 수 있음.
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		 User user =  userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			 @Override
			 public IllegalArgumentException get() {
				 return new IllegalArgumentException("해당유저는 없습니다. id :"+id);
			 }
		});
		 //user객체 = 자바오브젝트
		 // 요청은 웹브라우저에서 함
		return user;
	}
	
	@PostMapping("/dummy/join")
	public String join(User user) { // key=value (약속된 규칙)
		System.out.println("id : "+user.getId());
		System.out.println("username : "+user.getUsername());
		System.out.println("password : "+user.getPassword());
		System.out.println("email : "+user.getEmail());
		System.out.println("role : "+user.getRole());
		System.out.println("createDate : "+user.getCreatedTime());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입이 완료되었습니다.";
	}

}
