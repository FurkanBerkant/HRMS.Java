package com.kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "activation_codes")
public class ActivationCode{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "activation_code")
	private String activationCode;
	
	@Column(name = "is_confirmed")
	private boolean isConfirmed;
	
	@UpdateTimestamp
	@Column(name="confirm_date",insertable = false)
	private Date confirmDate;
	
	@JoinColumn(name = "user_id")
	private int userId;
	
	@CreationTimestamp
	@Column(name = "created_Date",updatable = false)
	private Date createdDate;
	
	public ActivationCode() {
		super();
	}
	
	public ActivationCode(int userId, String activationCode, boolean isConfirmed) {
		super();
		this.activationCode = activationCode;
		this.isConfirmed = isConfirmed;
		this.userId = userId;
	}

	
	
	
}
