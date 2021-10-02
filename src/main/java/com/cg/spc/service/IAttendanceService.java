package com.cg.spc.service;

import java.util.Date;
import java.util.List;

import com.cg.spc.entities.Attendance;

public interface IAttendanceService {
	public Attendance addAttendance(Attendance a);
	public Attendance updateAttendance(Attendance a);
	public List<Attendance> listAttendanceByMonth(Date ld);
	List<Attendance> listAttendanceByStudent(long userId);
	
	
}
