package com.ding.entity;
import java.io.Serializable;


/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class SysUser implements Serializable {

	private Long id;	// 

	private String userName;	// 登录名

	private String nickName;	// 昵称

	private String password;	// 密码

	private String email;	// 邮箱

	private String phone;	// 手机号

	private String jobNumber;	// 员工工号

	private String workPlace;	// 工作地点：厦门  杭州  北京  广州

	private String createTime;	// 创建时间

	private String updateTime;	// 编辑时间

	private Integer status;	// 1 启用 0禁用

	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return this.id;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return this.userName;
	}

	public void setNickName(String nickName){
		this.nickName = nickName;
	}

	public String getNickName(){
		return this.nickName;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return this.password;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return this.email;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return this.phone;
	}

	public void setJobNumber(String jobNumber){
		this.jobNumber = jobNumber;
	}

	public String getJobNumber(){
		return this.jobNumber;
	}

	public void setWorkPlace(String workPlace){
		this.workPlace = workPlace;
	}

	public String getWorkPlace(){
		return this.workPlace;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
	}
}
