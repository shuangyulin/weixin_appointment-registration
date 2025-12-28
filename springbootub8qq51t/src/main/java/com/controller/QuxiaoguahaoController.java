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

import com.entity.QuxiaoguahaoEntity;
import com.entity.view.QuxiaoguahaoView;

import com.service.QuxiaoguahaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 取消挂号
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-26 21:39:30
 */
@RestController
@RequestMapping("/quxiaoguahao")
public class QuxiaoguahaoController {
    @Autowired
    private QuxiaoguahaoService quxiaoguahaoService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QuxiaoguahaoEntity quxiaoguahao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
			quxiaoguahao.setYishengzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			quxiaoguahao.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<QuxiaoguahaoEntity> ew = new EntityWrapper<QuxiaoguahaoEntity>();


        //查询结果
		PageUtils page = quxiaoguahaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quxiaoguahao), params), params));
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
    public R list(@RequestParam Map<String, Object> params,QuxiaoguahaoEntity quxiaoguahao, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<QuxiaoguahaoEntity> ew = new EntityWrapper<QuxiaoguahaoEntity>();

        //查询结果
		PageUtils page = quxiaoguahaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quxiaoguahao), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QuxiaoguahaoEntity quxiaoguahao){
       	EntityWrapper<QuxiaoguahaoEntity> ew = new EntityWrapper<QuxiaoguahaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( quxiaoguahao, "quxiaoguahao")); 
        return R.ok().put("data", quxiaoguahaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QuxiaoguahaoEntity quxiaoguahao){
        EntityWrapper< QuxiaoguahaoEntity> ew = new EntityWrapper< QuxiaoguahaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( quxiaoguahao, "quxiaoguahao")); 
		QuxiaoguahaoView quxiaoguahaoView =  quxiaoguahaoService.selectView(ew);
		return R.ok("查询取消挂号成功").put("data", quxiaoguahaoView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QuxiaoguahaoEntity quxiaoguahao = quxiaoguahaoService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(quxiaoguahao,deSens);
        return R.ok().put("data", quxiaoguahao);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QuxiaoguahaoEntity quxiaoguahao = quxiaoguahaoService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(quxiaoguahao,deSens);
        return R.ok().put("data", quxiaoguahao);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QuxiaoguahaoEntity quxiaoguahao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(quxiaoguahao);
        quxiaoguahaoService.insert(quxiaoguahao);
        return R.ok().put("data",quxiaoguahao.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QuxiaoguahaoEntity quxiaoguahao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(quxiaoguahao);
        quxiaoguahaoService.insert(quxiaoguahao);
        return R.ok().put("data",quxiaoguahao.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody QuxiaoguahaoEntity quxiaoguahao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(quxiaoguahao);
        //全部更新
        quxiaoguahaoService.updateById(quxiaoguahao);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        quxiaoguahaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
