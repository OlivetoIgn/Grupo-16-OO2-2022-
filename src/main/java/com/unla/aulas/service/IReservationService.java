package com.unla.aulas.service;

import java.util.ArrayList;
import java.util.List;

import com.unla.aulas.dto.ReservationDto;
import com.unla.aulas.entity.ReservationEntity;


public interface IReservationService {
	  public ArrayList<ReservationEntity> getAllReservations();
	  
	  public boolean insertOrUpdateReservation(ReservationDto spaceDto);
	  
	  public ReservationEntity getReservationById(int id);
	  
	  public boolean deleteReservation(int id);
	  
	  public List<ReservationEntity> getReservations(List<ReservationEntity> reservations);
}
