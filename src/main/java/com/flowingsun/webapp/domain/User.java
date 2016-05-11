package com.flowingsun.webapp.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.flowingsun.webapp.util.CustomDateSerializer;

/**
 * @author flowingsun
 * @description 用户基本信息实体
 */
@Entity
@Table(name = "UserBaseInfo")
public class User extends BaseDomain implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long userID;// id
	private String userName;// 用户名
	private String loginname;// 账号
	private String userPassword;// 密码
	private String cleartextPassword;// 明文密码
	private String postion;// 职位
	private String telePhone;// 电话
	private String email;// 邮箱
	private String sex;// 性别
	private Date birthday;// 生日
	private String userLocation;// 用户所在位置
	private Date createTime;// 创建日期
	private Date lastEditTime;// 最后修改时间
	private Date passwordEditTime;// 最后修改密码时间
	private int onlineTime;// 在线时长(分钟)
	private String lastLoginIP;// 最后登录IP
	private int loginCount;// 登录次数
	private int userState;// 用户状态
	private int adminLevelID;// 管理员权限id

	private Set<MealOrder> mealOrders = new HashSet<MealOrder>();

	@Id
	@GeneratedValue
	@Column(name = "ID", updatable = false)
	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(updatable = false)
	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@JsonIgnore
	public String getCleartextPassword() {
		return cleartextPassword;
	}

	public void setCleartextPassword(String cleartextPassword) {
		this.cleartextPassword = cleartextPassword;
	}

	public String getPostion() {
		return postion;
	}

	public void setPostion(String postion) {
		this.postion = postion;
	}

	public String getTelePhone() {
		return telePhone;
	}

	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(columnDefinition = "nvarchar(10) default 'unknown'", nullable = false)
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@JsonSerialize(using = CustomDateSerializer.class)
	@Column(updatable = false)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	public Date getPasswordEditTime() {
		return passwordEditTime;
	}

	public void setPasswordEditTime(Date passwordEditTime) {
		this.passwordEditTime = passwordEditTime;
	}

	public int getOnlineTime() {
		return onlineTime;
	}

	public void setOnlineTime(int onlineTime) {
		this.onlineTime = onlineTime;
	}

	@Column(updatable = false)
	public String getLastLoginIP() {
		return lastLoginIP;
	}

	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}

	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}

	public int getUserState() {
		return userState;
	}

	public void setUserState(int userState) {
		this.userState = userState;
	}

	@Column(updatable = false)
	public int getAdminLevelID() {
		return adminLevelID;
	}

	public void setAdminLevelID(int adminLevelID) {
		this.adminLevelID = adminLevelID;
	}

	@JsonIgnore
	@OneToMany(targetEntity = MealOrder.class, fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, mappedBy = "user")
	public Set<MealOrder> getMealOrders() {
		return mealOrders;
	}

	public void setMealOrders(Set<MealOrder> mealOrders) {
		this.mealOrders = mealOrders;
	}

}
