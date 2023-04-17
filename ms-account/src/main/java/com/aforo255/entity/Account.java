package com.aforo255.entity;

import javax.persistence.*;

@Entity
@Table(name="account")
public class Account  {

	@Id
	@Column(name = "id_account")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdAccount ; 
	@Column(name="total_amount")
	private double TotalAmount ;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_customer" , insertable =false , updatable = false)
	private Customer customer ;


	public Integer getIdAccount() {
		return IdAccount;
	}
	public void setIdAccount(Integer idAccount) {
		IdAccount = idAccount;
	}
	public double getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		TotalAmount = totalAmount;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	} 
	
}
