package com.yh.blog.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //빌더 패턴 
@Entity
public class Reply {
	//답변 테이블 
	
	@Id//PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)//프로젝트에서 연결된  db의 넘버링 전략을 따라간다.
	private int id ;
	
	@Column(nullable = false, length = 200)
	private String content ;
	
	@ManyToOne //여러개의 답변이 하나의 개시글의 존재 할 수 있다.
	@JoinColumn(name = "boardId")
	private Board board;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user ;
	
	private Timestamp createDate;  
	
}
