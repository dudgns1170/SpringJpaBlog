package com.yh.blog.model;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //빌더 패턴 
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;

	//대용량 데이터 일때 사용 
	@Lob
	//썸머노트 라이브러리 사용함
	private String content;
	
	@ColumnDefault("0")
	private int cnt; //조회수
	
	//작성자
	@ManyToOne (fetch = FetchType.EAGER)// many =board user =one 연관관계 
	@JoinColumn(name = "userId")
	private User user; //DB는 오브젝트를 저장할 수없다. FK, 자바는 오브젝트를 저장할 수 있다.
	
	//여러 건 수
	//mappedBy =  연관관계의 주인이 아니다 (FK 가 아니다). = 필드 이름이 들어간다.
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
	private List<Reply> reply;
	
	//자동으로 업데이트 됨
	@CreationTimestamp
	private Timestamp createDate;

}
