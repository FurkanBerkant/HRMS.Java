package com.kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity

@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "system_employees")
public class Employee extends User{
	
	@NotBlank(message = "ismin bos birakilamaz")
    @Column(name = "firstname")
    private String firstName;
	@NotBlank(message = "soyad bos birakilamaz")
    @Column(name = "lastname")
    private String lastName;
}