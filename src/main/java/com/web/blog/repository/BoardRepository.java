package com.web.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.blog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}
