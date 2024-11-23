package com.emotionlog.mapper;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.emotionlog.domain.DiaryVO;

import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:**/*-context.xml")
@Log4j
public class DiaryMapperTests {

	@Autowired
	private DiaryMapper mapper;
	
	// 월별 일기 리스트
	@Test
	public void testGetList() {
		DiaryVO diary = new DiaryVO();
		diary.setUsername(1L);
	    diary.setRegdate(new Date()); // 오늘 날짜
		
		
		mapper.getList(diary).forEach(d -> log.info(d));
//		assertNotEquals(null,mapper.getList());
	}
	
	// 1. create(insert) 처리
	@Ignore
	@Test
	public void testInsert() {
		DiaryVO diary = new DiaryVO();
		diary.setDno(11L);
		diary.setTitle("새로 작성하는 제목2");
		diary.setContent("새로 작성하는 내용2");
		diary.setEmotionStatus("슬픔");
		diary.setUsername(1L);
		
		mapper.insert(diary);
		
		log.info(diary);
	}
	
	// 1. 등록 작업의 구현과 테스트
	@Ignore
	@Test
	public void testInsertSelectKey() {
		DiaryVO diary = new DiaryVO();
		diary.setTitle("새로 작성하는 제목2");
		diary.setContent("새로 작성하는 내용2");
		diary.setEmotionStatus("슬픔");
		diary.setUsername(1L);
		
		mapper.insertSelectKey(diary);
		
		log.info(diary);
	}
	
	// 2. read(select) 처리
	// 3. 조회 작업의 구현과 테스트
	@Test
	public void testRead() {
		// 존재하는 게시물 번호로 테스트
		
		DiaryVO diary = new DiaryVO();
		diary.setDno(2L);

		mapper.read(diary);
		
		//log.info(diary);
	}
	
	// 3. delete 처리
	@Ignore
	@Test
	public void testDelete() {
		DiaryVO diary = new DiaryVO();
		diary.setDno(12L);
		log.info("DELETE COUNT:" + mapper.delete(diary));
	}
	
	// 4. update 처리
	@Ignore
	@Test
	public void testUpdate() {
		
		DiaryVO diary = new DiaryVO();
		// 실행 전 존재하는 번호 인지 확인 할 것
		diary.setDno(2L);
		diary.setTitle("수정된 제목");
		diary.setContent("수정된 내용");
		diary.setEmotionStatus("슬픔");
		
		int count = mapper.update(diary);
		log.info("UPDATE COUNT:" + count);
	}
	
}