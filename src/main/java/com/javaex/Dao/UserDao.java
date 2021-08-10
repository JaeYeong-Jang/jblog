package com.javaex.Dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;
	
	
	public int joinUser(UserVo userVo) {
		System.out.println("[UserDao.joinUser()]");

		int count = sqlSession.insert("user.joinUser",userVo);
		
		return count;
	}
	
	public String chkId(String id) {
		System.out.println("[UserDao.chkId()]");
		
		return sqlSession.selectOne("user.chkId",id);
	}
	
	
}
