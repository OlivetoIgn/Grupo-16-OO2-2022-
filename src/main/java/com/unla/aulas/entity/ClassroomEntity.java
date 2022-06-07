package com.unla.aulas.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "classroom")
public class ClassroomEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "number")
	private int number;

	@Column(name = "quantity_of_chairs")
	private int quantityOfChairs;
	
	@Column(name = "quantity_of_PC")
	private int quantityOfPC;
	
	@Column(name="blackboard")
	private boolean blackboard;


	private String building;
	
	@Column(name = "classroom_type")
    @Enumerated(value = EnumType.STRING)
    private ClassroomTypeEntity typeSolicitude;
	
    @OneToMany(mappedBy="classroom")
    private List<ReservationEntity> reservations;
	
}
