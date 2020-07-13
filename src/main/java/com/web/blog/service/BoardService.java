package com.web.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.blog.model.Board;
import com.web.blog.model.User;
import com.web.blog.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Transactional
	public void write(Board board, User user) {
		board.setUser(user);
		boardRepository.save(board);
	}

	@Transactional
	public void delete(int id) {
		boardRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Page<Board> boardList(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}

	@Transactional(readOnly = true)
	public Board boardDetail(int id) {
		return boardRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("Board detail failed");
		});
	}
	
	@Transactional
	public void boardUpdate(int id, Board requestBoard) {
		Board board = boardRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("Board finding failed");
		});
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
	}
}
