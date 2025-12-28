package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.TuifeishenqingEntity;
import com.entity.view.TuifeishenqingView;

import com.service.TuifeishenqingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 退费申请
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-26 21:39:31
 */
@RestController
@RequestMapping("/tuifeishenqing")
public class TuifeishenqingController {
    @Autowired
    private TuifeishenqingService tuifeishenqingService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TuifeishenqingEntity tuifeishenqing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
			tuifeishenqing.setYishengzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			tuifeishenqing.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<TuifeishenqingEntity> ew = new EntityWrapper<TuifeishenqingEntity>();


        //查询结果
		PageUtils page = tuifeishenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tuifeishenqing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TuifeishenqingEntity tuifeishenqing, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<TuifeishenqingEntity> ew = new EntityWrapper<TuifeishenqingEntity>();

        //查询结果
		PageUtils page = tuifeishenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tuifeishenqing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TuifeishenqingEntity tuifeishenqing){
       	EntityWrapper<TuifeishenqingEntity> ew = new EntityWrapper<TuifeishenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tuifeishenqing, "tuifeishenqing")); 
        return R.ok().put("data", tuifeishenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TuifeishenqingEntity tuifeishenqing){
        EntityWrapper< TuifeishenqingEntity> ew = new EntityWrapper< TuifeishenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tuifeishenqing, "tuifeishenqing")); 
		TuifeishenqingView tuifeishenqingView =  tuifeishenqingService.selectView(ew);
		return R.ok("查询退费申请成功").put("data", tuifeishenqingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TuifeishenqingEntity tuifeishenqing = tuifeishenqingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(tuifeishenqing,deSens);
        return R.ok().put("data", tuifeishenqing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TuifeishenqingEntity tuifeishenqing = tuifeishenqingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(tuifeishenqing,deSens);
        return R.ok().put("data", tuifeishenqing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TuifeishenqingEntity tuifeishenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tuifeishenqing);
        tuifeishenqingService.insert(tuifeishenqing);
        return R.ok().put("data",tuifeishenqing.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TuifeishenqingEntity tuifeishenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tuifeishenqing);
        tuifeishenqingService.insert(tuifeishenqing);
        return R.ok().put("data",tuifeishenqing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TuifeishenqingEntity tuifeishenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tuifeishenqing);
        //全部更新
        tuifeishenqingService.updateById(tuifeishenqing);
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<TuifeishenqingEntity> list = new ArrayList<TuifeishenqingEntity>();
        for(Long id : ids) {
            TuifeishenqingEntity tuifeishenqing = tuifeishenqingService.selectById(id);
            tuifeishenqing.setSfsh(sfsh);
            tuifeishenqing.setShhf(shhf);
            list.add(tuifeishenqing);
        }
        tuifeishenqingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tuifeishenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
