package com.dao;

import com.entity.JiuzhentixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiuzhentixingVO;
import com.entity.view.JiuzhentixingView;


/**
 * 就诊提醒
 * 
 * @author 
 * @email 
 * @date 2025-04-26 21:39:30
 */
public interface JiuzhentixingDao extends BaseMapper<JiuzhentixingEntity> {
	
	List<JiuzhentixingVO> selectListVO(@Param("ew") Wrapper<JiuzhentixingEntity> wrapper);
	
	JiuzhentixingVO selectVO(@Param("ew") Wrapper<JiuzhentixingEntity> wrapper);
	
	List<JiuzhentixingView> selectListView(@Param("ew") Wrapper<JiuzhentixingEntity> wrapper);

	List<JiuzhentixingView> selectListView(Pagination page,@Param("ew") Wrapper<JiuzhentixingEntity> wrapper);

	
	JiuzhentixingView selectView(@Param("ew") Wrapper<JiuzhentixingEntity> wrapper);
	

}
