package com.yh.blog.tset;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//인터넷 브라우저 요청은 get 방식으로만 가능하다.
//사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {
	@GetMapping("/get")
	public String getTest(Memeber m ) {
		return "get요청:" +m.getId()+ " :"+m.getUsername()+":"+m.getEmail();
	}
	
	@PostMapping("/post")
	public String postTest(Memeber m) {
		return "get요청:" +m.getId()+ " :"+m.getUsername()+":"+m.getEmail();
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
