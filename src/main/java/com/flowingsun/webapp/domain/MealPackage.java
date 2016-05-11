package com.flowingsun.webapp.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.flowingsun.webapp.util.CustomDatetimeSerializer;

@Entity
@Component
public class MealPackage extends BaseDomain {
	private int mealPackageId;
	private String packageName;// 套餐名称
	private String mealTimeType;// 早/中/晚餐
	private double packagePrice;// 价格
	private String description;// 描述
	private Date createTime;
	private Date editTime;

	private Canteen canteen;
	private Set<MealMenu> mealMenus;

	@Id
	@GeneratedValue
	@Column(name = "ID", updatable = false)
	public int getMealPackageId() {
		return mealPackageId;
	}

	public void setMealPackageId(int mealPackageId) {
		this.mealPackageId = mealPackageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getMealTimeType() {
		return mealTimeType;
	}

	public void setMealTimeType(String mealTimeType) {
		this.mealTimeType = mealTimeType;
	}

	public double getPackagePrice() {
		return packagePrice;
	}

	public void setPackagePrice(double packagePrice) {
		this.packagePrice = packagePrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using = CustomDatetimeSerializer.class)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@JsonSerialize(using = CustomDatetimeSerializer.class)
	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "CanteenID")
	public Canteen getCanteen() {
		return canteen;
	}

	public void setCanteen(Canteen canteen) {
		this.canteen = canteen;
	}

	@ManyToMany(targetEntity = MealMenu.class, fetch = FetchType.LAZY)
	public Set<MealMenu> getMealMenus() {
		return mealMenus;
	}

	public void setMealMenus(Set<MealMenu> mealMenus) {
		this.mealMenus = mealMenus;
	}
}
