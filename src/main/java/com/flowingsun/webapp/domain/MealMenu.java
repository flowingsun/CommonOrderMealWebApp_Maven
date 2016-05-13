/**
 * @author flowingsun
 * @description 
 */
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.flowingsun.webapp.util.CustomDatetimeSerializer;

/**
 * 
 * @author flowingsun
 * @description 菜单实体
 */
@Entity
@Component
public class MealMenu extends BaseDomain {

	private Long mealMenuId;
	private String menuName;
	private int menuType;
	private int canteenId;
	private int state;//状态1:启用,0:停用
	private Date createTime;// 创建时间
	private Date editTime;// 编辑时间
	private String description;

	private Set<MealPackage> mealPackages;
	private Canteen canteen;

	@Id
	// @GeneratedValue(generator = "system-uuid")
	// @GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue
	@Column(name = "ID", unique = true, nullable = false)
	public Long getMealMenuId() {
		return mealMenuId;
	}

	public void setMealMenuId(Long mealMenuId) {
		this.mealMenuId = mealMenuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuType() {
		return menuType;
	}

	public void setMenuType(int menuType) {
		this.menuType = menuType;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getCanteenId() {
		return canteenId;
	}

	public void setCanteenId(int canteenId) {
		this.canteenId = canteenId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToMany(targetEntity = MealPackage.class, fetch = FetchType.EAGER)
	@JoinTable(name = "R_MealPackage_MealMenu", joinColumns = @JoinColumn(name = "MealMenu_ID"), inverseJoinColumns = @JoinColumn(name = "MealPackage_ID"))
	public Set<MealPackage> getMealPackages() {
		return mealPackages;
	}

	public void setMealPackages(Set<MealPackage> mealPackages) {
		this.mealPackages = mealPackages;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "CanteenID")
	public Canteen getCanteen() {
		return canteen;
	}

	public void setCanteen(Canteen canteen) {
		this.canteen = canteen;
	}
}
