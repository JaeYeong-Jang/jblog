package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.Dao.BlogDao;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;
	
	public String getUserInfo(String id) {
		System.out.println("[BlogService.getUserInfo()]");
		
		
		
		return "";
	}
	
	
}
