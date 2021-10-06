package com.cg.spc.service;

import java.util.Date;
import java.util.List;

import com.cg.spc.entities.Attendance;

public interface AttendanceService {
	public Attendance addAttendance(Attendance attendance);
	public Attendance updateAttendance(Attendance attendance);
	public List<Attendance> listAttendanceByMonth(Date date);
	public List<Attendance> listAttendanceByStudent(long userId);
	
	
}
