package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.Dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	
	public int join(UserVo userVo) {
		System.out.println("[UserService.join()]");
		
		int count = userDao.joinUser(userVo);
		
		return count;
	}
	
	public boolean idChk(String id) {
		System.out.println("[UserService.idChk()]");
		
		String userId = userDao.chkId(id);
		
		if(userId == null) {
			return true;
		}
		
		return false;
	}
	
	
}
