package com.cg.spc.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spc.entities.Attendance;
import com.cg.spc.service.IAttendanceService;

@RestController
@RequestMapping("/api")
public class AttendanceController {
	@Autowired
	private IAttendanceService attendanceService;
	
	public AttendanceController(IAttendanceService attendanceService) {
		super();
		this.attendanceService = attendanceService;
	}

	@PostMapping("/attendance")
	public Attendance addAttendance(@RequestBody Attendance attendance) {
		return attendanceService.addAttendance(attendance);
	}
	
	@PutMapping("/attendance")
	public Attendance updateAttendance(@RequestBody Attendance attendance) {
		return attendanceService.updateAttendance(attendance);
	}
	
	@GetMapping("/attendance/{dateOfClass}")
	public List<Attendance> listAttendanceByMonth(@RequestBody Date dateOfClass){
		return attendanceService.listAttendanceByMonth(dateOfClass);
	}
	
	@GetMapping("/attendance/{userId}")
	public List<Attendance> listAttendanceByStudent(@PathVariable long userId){
		return attendanceService.listAttendanceByStudent(userId);
	}

}
