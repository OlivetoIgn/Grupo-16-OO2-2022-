package com.unla.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="space")
public class Space {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="date")
    @Temporal(TemporalType.DATE)
    private LocalDate date;
	
	@Column(name="turn")
	private String turn;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Classroom classroom;

	@Column(name="free")
	private boolean free;

	public Space(LocalDate date, String turn, Classroom classroom, boolean free) {
		this.date = date;
		this.turn = turn;
		this.classroom = classroom;
		this.free = free;
	}

	public void setId(Long id) {
		this.id = id;
		
	}
	
	
	
}
