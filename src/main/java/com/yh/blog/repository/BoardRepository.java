package com.yh.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yh.blog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{

}
