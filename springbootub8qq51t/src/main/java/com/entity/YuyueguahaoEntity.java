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
 * 预约挂号
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-04-26 21:39:30
 */
@TableName("yuyueguahao")
public class YuyueguahaoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YuyueguahaoEntity() {
		
	}
	
	public YuyueguahaoEntity(T t) {
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
	 * 医生账号
	 */
					
	private String yishengzhanghao;
	
	/**
	 * 医生姓名
	 */
					
	private String yishengxingming;
	
	/**
	 * 专业特长
	 */
					
	private String zhuanyetezhang;
	
	/**
	 * 科室分类
	 */
					
	private String keshifenlei;
	
	/**
	 * 预约时间
	 */
					
	private String yuyueshijian;
	
	/**
	 * 挂号费
	 */
					
	private Integer guahaofei;
	
	/**
	 * 头像
	 */
					
	private String touxiang;
	
	/**
	 * 挂号号源
	 */
					
	private Integer shengyuhaoyuan;
	
	/**
	 * 挂号状态
	 */
					
	private String guahaozhuangtai;
	
	/**
	 * 挂号时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date guahaoshijian;
	
	/**
	 * 账号
	 */
					
	private String zhanghao;
	
	/**
	 * 姓名
	 */
					
	private String xingming;
	
	/**
	 * 电话
	 */
					
	private String dianhua;
	
	/**
	 * 年龄
	 */
					
	private String nianling;
	
	/**
	 * 性别
	 */
					
	private String xingbie;
	
	/**
	 * 是否支付
	 */
					
	private String ispay;
	
	
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
	 * 设置：预约时间
	 */
	public void setYuyueshijian(String yuyueshijian) {
		this.yuyueshijian = yuyueshijian;
	}
	/**
	 * 获取：预约时间
	 */
	public String getYuyueshijian() {
		return yuyueshijian;
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
	 * 设置：挂号号源
	 */
	public void setShengyuhaoyuan(Integer shengyuhaoyuan) {
		this.shengyuhaoyuan = shengyuhaoyuan;
	}
	/**
	 * 获取：挂号号源
	 */
	public Integer getShengyuhaoyuan() {
		return shengyuhaoyuan;
	}
	/**
	 * 设置：挂号状态
	 */
	public void setGuahaozhuangtai(String guahaozhuangtai) {
		this.guahaozhuangtai = guahaozhuangtai;
	}
	/**
	 * 获取：挂号状态
	 */
	public String getGuahaozhuangtai() {
		return guahaozhuangtai;
	}
	/**
	 * 设置：挂号时间
	 */
	public void setGuahaoshijian(Date guahaoshijian) {
		this.guahaoshijian = guahaoshijian;
	}
	/**
	 * 获取：挂号时间
	 */
	public Date getGuahaoshijian() {
		return guahaoshijian;
	}
	/**
	 * 设置：账号
	 */
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
	/**
	 * 设置：姓名
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
	/**
	 * 设置：电话
	 */
	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}
	/**
	 * 获取：电话
	 */
	public String getDianhua() {
		return dianhua;
	}
	/**
	 * 设置：年龄
	 */
	public void setNianling(String nianling) {
		this.nianling = nianling;
	}
	/**
	 * 获取：年龄
	 */
	public String getNianling() {
		return nianling;
	}
	/**
	 * 设置：性别
	 */
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
	/**
	 * 设置：是否支付
	 */
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}

}
