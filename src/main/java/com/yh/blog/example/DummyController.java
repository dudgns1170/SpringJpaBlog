package com.yh.blog.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yh.blog.model.RoleType;
import com.yh.blog.model.User;
import com.yh.blog.repository.UserRepository;

//더미 데이터  Test
@RestController
public class DummyController {
	
	@Autowired //의존성 주입 하는것 (DI)
	private UserRepository userRepository;
	
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
