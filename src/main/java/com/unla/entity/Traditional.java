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
@Table(name="traditional")
public class Traditional extends Classroom{

	@Column(name="blackboard")
	private String blackboard;
	
	public Traditional(int number, int quantityOfChairs, Building building, String blackboard) {
		super(number, quantityOfChairs, building);
		this.blackboard = blackboard;
	}
 
}
