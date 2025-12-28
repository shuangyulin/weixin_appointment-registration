package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 科室信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-04-26 21:39:30
 */
@TableName("keshixinxi")
public class KeshixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public KeshixinxiEntity() {
		
	}
	
	public KeshixinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 科室名称
	 */
					
	private String keshimingcheng;
	
	/**
	 * 科室分类
	 */
					
	private String keshifenlei;
	
	/**
	 * 头像
	 */
					
	private String touxiang;
	
	/**
	 * 挂号费
	 */
					
	private Integer guahaofei;
	
	/**
	 * 剩余号源
	 */
					
	private Integer shengyuhaoyuan;
	
	/**
	 * 医生账号
	 */
					
	private String yishengzhanghao;
	
	/**
	 * 医生姓名
	 */
					
	private String yishengxingming;
	
	/**
	 * 医生介绍
	 */
					
	private String yishengjieshao;
	
	/**
	 * 专业特长
	 */
					
	private String zhuanyetezhang;
	
	/**
	 * 职称
	 */
					
	private String zhicheng;
	
	/**
	 * 预约规则
	 */
					
	private String yuyueguize;
	
	/**
	 * 收藏数
	 */
					
	private Integer storeupnum;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：科室名称
	 */
	public void setKeshimingcheng(String keshimingcheng) {
		this.keshimingcheng = keshimingcheng;
	}
	/**
	 * 获取：科室名称
	 */
	public String getKeshimingcheng() {
		return keshimingcheng;
	}
	/**
	 * 设置：科室分类
	 */
	public void setKeshifenlei(String keshifenlei) {
		this.keshifenlei = keshifenlei;
	}
	/**
	 * 获取：科室分类
	 */
	public String getKeshifenlei() {
		return keshifenlei;
	}
	/**
	 * 设置：头像
	 */
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
	/**
	 * 设置：挂号费
	 */
	public void setGuahaofei(Integer guahaofei) {
		this.guahaofei = guahaofei;
	}
	/**
	 * 获取：挂号费
	 */
	public Integer getGuahaofei() {
		return guahaofei;
	}
	/**
	 * 设置：剩余号源
	 */
	public void setShengyuhaoyuan(Integer shengyuhaoyuan) {
		this.shengyuhaoyuan = shengyuhaoyuan;
	}
	/**
	 * 获取：剩余号源
	 */
	public Integer getShengyuhaoyuan() {
		return shengyuhaoyuan;
	}
	/**
	 * 设置：医生账号
	 */
	public void setYishengzhanghao(String yishengzhanghao) {
		this.yishengzhanghao = yishengzhanghao;
	}
	/**
	 * 获取：医生账号
	 */
	public String getYishengzhanghao() {
		return yishengzhanghao;
	}
	/**
	 * 设置：医生姓名
	 */
	public void setYishengxingming(String yishengxingming) {
		this.yishengxingming = yishengxingming;
	}
	/**
	 * 获取：医生姓名
	 */
	public String getYishengxingming() {
		return yishengxingming;
	}
	/**
	 * 设置：医生介绍
	 */
	public void setYishengjieshao(String yishengjieshao) {
		this.yishengjieshao = yishengjieshao;
	}
	/**
	 * 获取：医生介绍
	 */
	public String getYishengjieshao() {
		return yishengjieshao;
	}
	/**
	 * 设置：专业特长
	 */
	public void setZhuanyetezhang(String zhuanyetezhang) {
		this.zhuanyetezhang = zhuanyetezhang;
	}
	/**
	 * 获取：专业特长
	 */
	public String getZhuanyetezhang() {
		return zhuanyetezhang;
	}
	/**
	 * 设置：职称
	 */
	public void setZhicheng(String zhicheng) {
		this.zhicheng = zhicheng;
	}
	/**
	 * 获取：职称
	 */
	public String getZhicheng() {
		return zhicheng;
	}
	/**
	 * 设置：预约规则
	 */
	public void setYuyueguize(String yuyueguize) {
		this.yuyueguize = yuyueguize;
	}
	/**
	 * 获取：预约规则
	 */
	public String getYuyueguize() {
		return yuyueguize;
	}
	/**
	 * 设置：收藏数
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}

}
