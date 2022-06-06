package com.unla.aulas.dto;
import java.util.ArrayList;
import java.util.Date;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
	private int id;
	private Date date;
	private String turn;
	private ClassroomDto classroom;
}
