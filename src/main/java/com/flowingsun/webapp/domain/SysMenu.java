package com.flowingsun.webapp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author flowingsun
 * @description 系统菜单实体
 */
@Entity
@Table(name="SysMenu")
public class SysMenu implements Serializable {
	private static final long serialVersionUID = 3L;

	private int ID;//ID
	private String menuName;//菜单名称
	private String text;//菜单名称(用于ExtJs展示)
	private String pageThemes;//跳转控件
	private int previousNodeID;//上级节点ID
	private int sort;//排序
	private Date edittime;//修改时间
	private boolean leaf;//是否为子节点
	private String Description;//描述
	
	private List<SysMenu> children = new ArrayList<SysMenu>();//子节点
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	@Column(name = "MenuName")
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPageThemes() {
		return pageThemes;
	}
	public void setPageThemes(String pageThemes) {
		this.pageThemes = pageThemes;
	}
	public int getPreviousNodeID() {
		return previousNodeID;
	}
	public void setPreviousNodeID(int previousNodeID) {
		this.previousNodeID = previousNodeID;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public Date getEdittime() {
		return edittime;
	}
	public void setEdittime(Date edittime) {
		this.edittime = edittime;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Transient
	public List<SysMenu> getChildren() {
		return children;
	}
	public void setChildren(List<SysMenu> children) {
		this.children = children;
	}
}
