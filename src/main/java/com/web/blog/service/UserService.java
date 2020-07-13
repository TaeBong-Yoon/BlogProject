package com.web.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.blog.model.RoleType;
import com.web.blog.model.User;
import com.web.blog.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Transactional
	public void joinService(User user) {
		String rawPassword = user.getPassword(); // 원래 비밀번호
		String encPassword = encoder.encode(rawPassword); // 해쉬화 된 비밀번호
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}

	@Transactional
	public void update(User user) {
		User persistance = userRepository.findById(user.getId()).orElseThrow(() -> {
			return new IllegalArgumentException("Can't find user");
		});

		// OAuth를 통한 로그인 유저는 비밀번호를 수정할 수 없도록 한다.
		if (persistance.getOauth() == null || persistance.getOauth().equals("")) {
			String rawPassword = user.getPassword();
			String encPassword = encoder.encode(rawPassword);
			persistance.setPassword(encPassword);
			persistance.setEmail(user.getEmail());
		}
	}

	@Transactional(readOnly = true)
	public User findUser(String username) {

		User user = userRepository.findByUsername(username).orElseGet(() -> {
			return new User();
		});
		return user;

	}
}
