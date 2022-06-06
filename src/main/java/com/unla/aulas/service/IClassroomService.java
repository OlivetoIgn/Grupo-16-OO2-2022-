package com.unla.aulas.service;

import java.util.ArrayList;
import com.unla.aulas.entity.ClassroomEntity;

public interface IClassroomService {
	  public ArrayList<ClassroomEntity> getAllClassrooms();
	  
	  public boolean insertOrUpdateClassroom(ClassroomEntity classroomEntity);
	  
	  public ClassroomEntity getClassroomById(int id);
	  
	  public boolean deleteClassroom(int id);
	  
	  public ClassroomEntity getClassroomEntityById(int id);
	  
	  public ClassroomEntity getClassroomEntityByNumber(int number);
}
