package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.JiuzhentixingDao;
import com.entity.JiuzhentixingEntity;
import com.service.JiuzhentixingService;
import com.entity.vo.JiuzhentixingVO;
import com.entity.view.JiuzhentixingView;

@Service("jiuzhentixingService")
public class JiuzhentixingServiceImpl extends ServiceImpl<JiuzhentixingDao, JiuzhentixingEntity> implements JiuzhentixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiuzhentixingEntity> page = this.selectPage(
                new Query<JiuzhentixingEntity>(params).getPage(),
                new EntityWrapper<JiuzhentixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiuzhentixingEntity> wrapper) {
		  Page<JiuzhentixingView> page =new Query<JiuzhentixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JiuzhentixingVO> selectListVO(Wrapper<JiuzhentixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiuzhentixingVO selectVO(Wrapper<JiuzhentixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiuzhentixingView> selectListView(Wrapper<JiuzhentixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiuzhentixingView selectView(Wrapper<JiuzhentixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
