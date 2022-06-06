package com.unla.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="classroom")
public abstract class Classroom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "number")
	private int number;
	
	@Column(name = "quantity_of_chairs")
	private int quantityOfChairs;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Building building;

	public Classroom(int number, int quantityOfChairs, Building building) {
		this.number = number;
		this.quantityOfChairs = quantityOfChairs;
		this.building = building;
	}

	public void setId(Long id) {
		this.id = id;
		
	}
		
}
