package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiuzhentixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiuzhentixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiuzhentixingView;


/**
 * 就诊提醒
 *
 * @author 
 * @email 
 * @date 2025-04-26 21:39:30
 */
public interface JiuzhentixingService extends IService<JiuzhentixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiuzhentixingVO> selectListVO(Wrapper<JiuzhentixingEntity> wrapper);
   	
   	JiuzhentixingVO selectVO(@Param("ew") Wrapper<JiuzhentixingEntity> wrapper);
   	
   	List<JiuzhentixingView> selectListView(Wrapper<JiuzhentixingEntity> wrapper);
   	
   	JiuzhentixingView selectView(@Param("ew") Wrapper<JiuzhentixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiuzhentixingEntity> wrapper);

   	

}

