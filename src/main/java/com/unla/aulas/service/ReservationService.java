package com.unla.aulas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.unla.aulas.dto.ReservationDto;
import com.unla.aulas.entity.ClassroomEntity;
import com.unla.aulas.entity.ReservationEntity;
import com.unla.aulas.repository.ReservationRepository;

@Service
public class ReservationService  {
	@Lazy
	@Autowired
	private ReservationRepository reservationRepository;

	@Lazy
	@Autowired
	private ClassroomService classroomService;

	public ReservationService(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}


	public ArrayList<ReservationEntity> getAllReservations() {
		return (ArrayList<ReservationEntity>) reservationRepository.findAll();
	}


	public boolean insertOrUpdateReservation(ReservationDto reservationDto) {
		boolean flag = true;
		ReservationEntity reservationEntity = new ReservationEntity();
		ClassroomEntity classroomEntity = classroomService.getClassroomById(reservationDto.getClassroom().getId());
		
		if (classroomEntity == null) {
			flag = false; 
		}else {

			reservationEntity.setDateFrom(reservationDto.getDateFrom());
			reservationEntity.setDateTo(reservationDto.getDateTo());
			reservationEntity.setTurn(reservationDto.getTurn());
			reservationEntity.setClassroom(classroomEntity);
			reservationRepository.save(reservationEntity);
			flag = true;
		}


		return flag;
	}


	public ReservationEntity getReservationById(int id) {
		return reservationRepository.findById(id);
	}


	public boolean deleteReservation(int id) {
		try {
			reservationRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<ReservationEntity> getReservations(List<ReservationEntity> list) {
		return (List<ReservationEntity>) getAllReservations();
	}

}
