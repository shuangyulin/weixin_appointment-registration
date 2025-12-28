package com.dao;

import com.entity.TuifeishenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TuifeishenqingVO;
import com.entity.view.TuifeishenqingView;


/**
 * 退费申请
 * 
 * @author 
 * @email 
 * @date 2025-04-26 21:39:31
 */
public interface TuifeishenqingDao extends BaseMapper<TuifeishenqingEntity> {
	
	List<TuifeishenqingVO> selectListVO(@Param("ew") Wrapper<TuifeishenqingEntity> wrapper);
	
	TuifeishenqingVO selectVO(@Param("ew") Wrapper<TuifeishenqingEntity> wrapper);
	
	List<TuifeishenqingView> selectListView(@Param("ew") Wrapper<TuifeishenqingEntity> wrapper);

	List<TuifeishenqingView> selectListView(Pagination page,@Param("ew") Wrapper<TuifeishenqingEntity> wrapper);

	
	TuifeishenqingView selectView(@Param("ew") Wrapper<TuifeishenqingEntity> wrapper);
	

}
