package com.web.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.web.blog.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping({ "", "/" })
	public String index(Model model,
			@PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("boards", boardService.boardList(pageable));
		return "index";
	}

	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}

	@GetMapping("/board/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.boardDetail(id));
		return "board/detail";

	}

	@GetMapping("/board/{id}/updateForm")
	public String updateForm(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.boardDetail(id));
		return "board/updateForm";
	}

}
