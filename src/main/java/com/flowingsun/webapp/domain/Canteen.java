package com.flowingsun.webapp.domain;

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

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.flowingsun.webapp.util.CustomDatetimeSerializer;

/**
 * @author flowingsun
 * @description 餐厅信息
 */
@Entity
@Table(name = "Canteen")
@Component
public class Canteen extends BaseDomain {
	private int canteenId;
	private String canteenName;// 餐厅名称
	private int canteenStatus;// 餐厅状态
	private String description;// 备注
	private Date createTime;// 创建时间
	private Date editTime;// 编辑时间

	private Set<MealPackage> mealPackages = new HashSet<MealPackage>();


	@Id
	@GeneratedValue
	@Column(name = "ID", updatable = false)
	public int getCanteenId() {
		return canteenId;
	}

	public void setCanteenId(int canteenId) {
		this.canteenId = canteenId;
	}

	public String getCanteenName() {
		return canteenName;
	}

	public void setCanteenName(String canteenName) {
		this.canteenName = canteenName;
	}

	public int getCanteenStatus() {
		return canteenStatus;
	}

	public void setCanteenStatus(int canteenStatus) {
		this.canteenStatus = canteenStatus;
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

	@JsonIgnore
	@OneToMany(targetEntity = MealPackage.class, fetch = FetchType.LAZY, cascade = {
			CascadeType.ALL }, mappedBy = "canteen")
	public Set<MealPackage> getMealPackages() {
		return mealPackages;
	}

	public void setMealPackages(Set<MealPackage> mealPackages) {
		this.mealPackages = mealPackages;
	}
}
