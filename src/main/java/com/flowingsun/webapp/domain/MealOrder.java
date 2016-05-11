package com.flowingsun.webapp.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


/**
 * @author flowingsun
 * @description 订餐记录表
 */
@Entity
@Table(name = "MealOrder")
@Component
public class MealOrder extends BaseDomain implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long mealOrderID;// ID
	private int orderState;// 订单状态
	// private Long userID;//用户ID
	private String userName;// 用户名
	private String postion;// 职位
	private String telePhone;// 用户电话
	private String userLocation;// 用户位置
	private Date orderTime;// 订餐时间
	private String canteenName;// 餐厅名称
	private int canteenID;// 餐厅ID
	private String supplyTimeType;// 用餐餐时类型
	private Date beginSupplyTime;// 起始订餐时间
	private Date endSupplyTime;// 终止订餐时间
	private Date beginSupplyDate;// 起始订餐日期
	private Date endSupplyDate;// 终止订餐日期
	private int mealMenuID;// 菜单ID
	private String mealMenuName;// 菜单名称
	private String mealPackageName;// 套餐名称
	private int mealPackageID;// 套餐ID
	private float mealPackagePrice;// 套餐价格

	private User user;// 多对一用户信息

	@Id
	@GeneratedValue
	@Column(name = "ID", updatable = false)
	public Long getMealOrderID() {
		return mealOrderID;
	}

	public void setMealOrderID(Long mealOrderID) {
		this.mealOrderID = mealOrderID;
	}

	public int getOrderState() {
		return orderState;
	}

	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}

	// public Long getUserID() {
	// return userID;
	// }
	//
	// public void setUserID(Long userID) {
	// this.userID = userID;
	// }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getCanteenName() {
		return canteenName;
	}

	public void setCanteenName(String canteenName) {
		this.canteenName = canteenName;
	}

	public int getCanteenID() {
		return canteenID;
	}

	public void setCanteenID(int canteenID) {
		this.canteenID = canteenID;
	}

	public String getSupplyTimeType() {
		return supplyTimeType;
	}

	public void setSupplyTimeType(String supplyTimeType) {
		this.supplyTimeType = supplyTimeType;
	}

	public Date getBeginSupplyTime() {
		return beginSupplyTime;
	}

	public void setBeginSupplyTime(Date beginSupplyTime) {
		this.beginSupplyTime = beginSupplyTime;
	}

	public Date getEndSupplyTime() {
		return endSupplyTime;
	}

	public void setEndSupplyTime(Date endSupplyTime) {
		this.endSupplyTime = endSupplyTime;
	}

	public Date getBeginSupplyDate() {
		return beginSupplyDate;
	}

	public void setBeginSupplyDate(Date beginSupplyDate) {
		this.beginSupplyDate = beginSupplyDate;
	}

	public Date getEndSupplyDate() {
		return endSupplyDate;
	}

	public void setEndSupplyDate(Date endSupplyDate) {
		this.endSupplyDate = endSupplyDate;
	}

	public int getMealMenuID() {
		return mealMenuID;
	}

	public void setMealMenuID(int mealMenuID) {
		this.mealMenuID = mealMenuID;
	}

	public String getMealMenuName() {
		return mealMenuName;
	}

	public void setMealMenuName(String mealMenuName) {
		this.mealMenuName = mealMenuName;
	}

	public String getMealPackageName() {
		return mealPackageName;
	}

	public void setMealPackageName(String mealPackageName) {
		this.mealPackageName = mealPackageName;
	}

	public int getMealPackageID() {
		return mealPackageID;
	}

	public void setMealPackageID(int mealPackageID) {
		this.mealPackageID = mealPackageID;
	}

	public float getMealPackagePrice() {
		return mealPackagePrice;
	}

	public void setMealPackagePrice(float mealPackagePrice) {
		this.mealPackagePrice = mealPackagePrice;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "UserID")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
