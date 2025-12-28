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


import com.dao.TuifeishenqingDao;
import com.entity.TuifeishenqingEntity;
import com.service.TuifeishenqingService;
import com.entity.vo.TuifeishenqingVO;
import com.entity.view.TuifeishenqingView;

@Service("tuifeishenqingService")
public class TuifeishenqingServiceImpl extends ServiceImpl<TuifeishenqingDao, TuifeishenqingEntity> implements TuifeishenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TuifeishenqingEntity> page = this.selectPage(
                new Query<TuifeishenqingEntity>(params).getPage(),
                new EntityWrapper<TuifeishenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TuifeishenqingEntity> wrapper) {
		  Page<TuifeishenqingView> page =new Query<TuifeishenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<TuifeishenqingVO> selectListVO(Wrapper<TuifeishenqingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TuifeishenqingVO selectVO(Wrapper<TuifeishenqingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TuifeishenqingView> selectListView(Wrapper<TuifeishenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TuifeishenqingView selectView(Wrapper<TuifeishenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
