package com.unla.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="laboratory")
public class Laboratory extends Classroom {
	
	@Column(name = "quantity_of_PC")
	private int quantityOfPC;
	
	public Laboratory(int number, Building building, int quantityOfChairs, int quantityOfPC) {
		super(number, quantityOfChairs, building);
		this.quantityOfPC = quantityOfPC;
	}

}
