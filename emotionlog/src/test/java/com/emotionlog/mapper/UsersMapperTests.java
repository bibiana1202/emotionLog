package com.emotionlog.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.emotionlog.domain.UsersVO;

import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:**/*-context.xml")
@Log4j
public class UsersMapperTests {

	@Autowired
	private UsersMapper mapper;
	
	// 회원가입 테스트 ( users create )
	@Test
	public void testInsert( ) {
		
		UsersVO user = new UsersVO();
		user.setName("user6");
		user.setPhone_number("010-1234-5678");
	    user.setPassword("pw66");
	    user.setGender('M');
        user.setBirthday("1995-11-20"); 
        
	    mapper.insert(user);
	    
	    log.info("insert된 user : " + user);
		
	}
	
}