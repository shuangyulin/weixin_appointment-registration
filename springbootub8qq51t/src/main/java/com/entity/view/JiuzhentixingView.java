package com.entity.view;

import com.entity.JiuzhentixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 就诊提醒
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-26 21:39:30
 */
@TableName("jiuzhentixing")
public class JiuzhentixingView  extends JiuzhentixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiuzhentixingView(){
	}
 
 	public JiuzhentixingView(JiuzhentixingEntity jiuzhentixingEntity){
 	try {
			BeanUtils.copyProperties(this, jiuzhentixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
