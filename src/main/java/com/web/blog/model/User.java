package com.web.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
	
	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // auto_increment , userIndex
	
	@Column(nullable = false,length = 100,unique = true)
	private String username; // ID
	
	@Column(nullable = false,length = 100) // 해쉬(비밀번호 암호화) 하기 위해 넉넉하게 길이 조정.
	private String password;
	
	@Column(nullable = false,length = 50)
	private String email;
	
	@Enumerated(EnumType.STRING)
	private RoleType role;
	
	private String oauth; // kakao, google
	
	@CreationTimestamp
	private Timestamp createDate;

}
