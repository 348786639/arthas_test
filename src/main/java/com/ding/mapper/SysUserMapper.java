package com.ding.mapper;

import com.ding.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * SysUserMapper数据库操作接口类
 * 
 **/

public interface SysUserMapper{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	SysUser  selectByPrimaryKey(@Param("id") Long id);


}