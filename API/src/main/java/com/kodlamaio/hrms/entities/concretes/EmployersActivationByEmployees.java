package com.kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employers_activation_by_employees")
public class EmployersActivationByEmployees {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@Column(name = "is_confirmed")
	private boolean isConfirmed;

	@Column(name = "confirm_date")
	private LocalDate confirmDate = LocalDate.now();

}
