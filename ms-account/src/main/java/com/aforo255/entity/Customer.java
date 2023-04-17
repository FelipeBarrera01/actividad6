package com.aforo255.entity;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="customer")
public class Customer  {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_customer")
	private Integer IdCustomer ; 
	@Column(name="full_name")
	private String FullName ;
	public Integer getIdCustomer() {
		return IdCustomer;
	}
	public void setIdCustomer(Integer idCustomer) {
		IdCustomer = idCustomer;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	} 
}

