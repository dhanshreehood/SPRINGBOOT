package com.cybage.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="user_info")
public class User {
	@Id
	@GeneratedValue
	private int userId;
	private String username;
	private String password;
	private String email;
	private String gender;

	
	//user can have multiple product
	@OneToMany(targetEntity=Product.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "customerProductFK", referencedColumnName = "userId")
	private List<Product> products;
	
}
