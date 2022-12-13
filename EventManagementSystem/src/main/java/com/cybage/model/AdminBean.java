package com.cybage.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@NoArgsConstructor
//@Getter
//@Setter
//@ToString

@Entity
@Table(name="category",uniqueConstraints = {@UniqueConstraint(columnNames = "categoryId")})

public class AdminBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="categoryId", unique = true, nullable = false)
	private int categoryId;
	
	@Column(name="categoryName")
	private String categoryName;
	
	@OneToMany(mappedBy= "eventCategory", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<EventBean> eventBeans;

	@ManyToOne
	@JoinColumn(name="adminId")
	private RegistrationBean admin;
	
	public RegistrationBean getAdmin() {
		return admin;
	}

	public void setAdmin(RegistrationBean admin) {
		this.admin = admin;
	}

	public List<EventBean> getEventBeans() {
		return eventBeans;
	}

	public void setEventBeans(List<EventBean> eventBeans) {
		this.eventBeans = eventBeans;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "AdminBean [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	
	
	
	

}
