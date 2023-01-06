package com.yh.blog.example;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

//인터넷 브라우저 요청은 get 방식으로만 가능하다.
//사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {
	
	private static  final  String TAG = "HttpControllerTest:" ;
	@GetMapping("/lomkoTest")
	public String lomokTest() {
		Memeber m = Memeber.builder().userName("sar").passwWord("1234").email("sar@naver.com").build();
		System.out.println(TAG+"getter:"+m.getId());
		m.setId(5000);
		System.out.println(TAG+"setter:"+m.getId());
		return "lombk 완료";
	}
	@GetMapping("/get")
	public String getTest(Memeber m ) {
		
		return "get요청:" +m.getId()+ " :"+m. getUserName()+":"+m.getEmail();
	}
	
	@PostMapping("/post")
	public String postTest(Memeber m) {
		return "get요청:" +m.getId()+ " :"+m.getUserName()+":"+m.getEmail();
	}
	@PutMapping("/put")
	public String putTest() {
		return "put요청";
	}
	@DeleteMapping("/delete")
	public String deleteTest() {
		return "delete요청";
	}
}
