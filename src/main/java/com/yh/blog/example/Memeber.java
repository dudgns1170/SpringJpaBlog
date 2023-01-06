package com.yh.blog.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//get/set 동시에 사용
@Data
//생성자 모든 페이지를 쓰는 생성자
//빈생성자 
@NoArgsConstructor
//final 사용 이유는 불변성을 지키기 위해서  변경할 일이 있는 컬럼들은 final 재거해야함
//@RequiredArgsConstructor
public class Memeber {
	private  int id;
	private  String userName;
	private  String passwWord;
	private  String email;
	
	//생성자의 순서가 맞지 않아도 된다. 
	@Builder
	public Memeber(int id, String userName, String passwWord, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.passwWord = passwWord;
		this.email = email;
	}
	
}
