package com.yh.blog.tset;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//데이터를 리턴하는것이 아닌 파일을 리턴
@Controller
public class TempControllerTest {
	
	//http://localhost:8000/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		//파일 리턴 기본경로
		return"/home.html";
	}
	@GetMapping("/temp/Jsp")
	public String tempJsp() {
		//파일 리턴 기본경로
		return"test";
	}


}
