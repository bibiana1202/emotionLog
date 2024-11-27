package com.emotionlog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.emotionlog.domain.AboardVO;
import com.emotionlog.domain.DiaryCountsVO;
import com.emotionlog.domain.QboardVO;
import com.emotionlog.domain.UsersVO;

public interface AdminMapper {

	public List<UsersVO> getUserList(@Param("limit") Integer limit);
	
	public List<DiaryCountsVO> getDiaryCountsByDateRange();
	
	public List<QboardVO> getQboardList(@Param("limit") Integer limit);
	
	public QboardVO getQboardDetails(Long qno);
	
	public AboardVO getAnswer(Long qno);
	
	public void createAnswer(AboardVO vo);
}
