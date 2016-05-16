package com.flowingsun.webapp.domain;

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
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "mealPackageUserMark")
@Component
public class MealPackageUserMark {
	private Long mealPackageUserMarkId;
	private String markName;
	private int state;
	// private int createUser;
	private String description;

	private Set<MealPackage> mealPackages;
	private Set<User> users;
	private User createUser;

	@Id
	@GeneratedValue
	@Column(name = "ID", updatable = false)
	public Long getMealPackageUserMarkId() {
		return mealPackageUserMarkId;
	}

	public void setMealPackageUserMarkId(Long mealPackageUserMarkId) {
		this.mealPackageUserMarkId = mealPackageUserMarkId;
	}

	public String getMarkName() {
		return markName;
	}

	public void setMarkName(String markName) {
		this.markName = markName;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToMany(targetEntity = MealPackage.class, fetch = FetchType.LAZY)
	@JoinTable(name = "R_MealPackage_MealPackageUserMark", joinColumns = @JoinColumn(name = "MealPackageUserMark_ID"), inverseJoinColumns = @JoinColumn(name = "MealPackage_ID"))
	public Set<MealPackage> getMealPackages() {
		return mealPackages;
	}

	public void setMealPackages(Set<MealPackage> mealPackages) {
		this.mealPackages = mealPackages;
	}

	@ManyToMany(targetEntity = User.class, fetch = FetchType.LAZY)
	@JoinTable(name = "R_User_MealPackageUserMark", joinColumns = @JoinColumn(name = "MealPackageUserMark_ID"), inverseJoinColumns = @JoinColumn(name = "User_ID"))
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "UserID")
	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

}
