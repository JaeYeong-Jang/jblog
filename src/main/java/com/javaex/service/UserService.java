package com.javaex.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.Dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	//회원가입
	public int join(UserVo userVo) {
		System.out.println("[UserService.join()]");
		
		int count = userDao.joinUser(userVo);
		
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("id", userVo.getId());
		userMap.put("blogTitle", userVo.getUserName() + "의 블로그 입니다.");
		userMap.put("logoFile", "C:\\javaStudy\\jblogImages\\"); //이거 뭐야

		userDao.crtBlog(userMap);
		
		return count;
	}
	
	//아이디 중복체크 확인
	public boolean idChk(String id) {
		System.out.println("[UserService.idChk()]");
		
		String userId = userDao.chkId(id);
		
		if(userId == null) {
			return true;
		}
		
		return false;
	}
	
	//로그인
	public UserVo login(UserVo userVo) {
		System.out.println("[UserService.login()]");
		
		return userDao.getUser(userVo);
	}
	
	
}
