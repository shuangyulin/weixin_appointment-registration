package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TuifeishenqingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TuifeishenqingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TuifeishenqingView;


/**
 * 退费申请
 *
 * @author 
 * @email 
 * @date 2025-04-26 21:39:31
 */
public interface TuifeishenqingService extends IService<TuifeishenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TuifeishenqingVO> selectListVO(Wrapper<TuifeishenqingEntity> wrapper);
   	
   	TuifeishenqingVO selectVO(@Param("ew") Wrapper<TuifeishenqingEntity> wrapper);
   	
   	List<TuifeishenqingView> selectListView(Wrapper<TuifeishenqingEntity> wrapper);
   	
   	TuifeishenqingView selectView(@Param("ew") Wrapper<TuifeishenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TuifeishenqingEntity> wrapper);

   	

}

