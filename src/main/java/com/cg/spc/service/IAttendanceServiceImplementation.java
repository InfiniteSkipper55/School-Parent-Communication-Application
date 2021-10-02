package com.cg.spc.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.Attendance;
import com.cg.spc.entities.Student;
import com.cg.spc.repository.IAttendanceRepository;
import com.cg.spc.repository.IStudentRepository;

@Service
public class IAttendanceServiceImplementation implements IAttendanceService{
	@Autowired
	private IAttendanceRepository attendanceRepository;
	
	@Autowired
	private IStudentRepository studentRepository;

	@Override
	public Attendance addAttendance(Attendance attendance) {
		return attendanceRepository.save(attendance);
	}

	@Override
	public Attendance updateAttendance(Attendance attendance) {
		Optional<Attendance> existingAttendanceContainer = attendanceRepository.findById(attendance.getAttendanceId());
		if (existingAttendanceContainer.isPresent()) {
			attendanceRepository.saveAndFlush(attendance);
		}
		return attendance;
	}

	@Override
	public List<Attendance> listAttendanceByMonth(Date date) {
		List<Attendance> existingAttendance = null;
		Collections.sort(existingAttendance, new Comparator<Attendance>() {
		    public int compare(Attendance m1, Attendance m2) {
		        return m1.getDateOfClass().compareTo(m2.getDateOfClass());
		    }
		});
		return existingAttendance;
	}

	@Override
	public List<Attendance> listAttendanceByStudent(long userId) {
		Optional<Student> student = studentRepository.findById(userId);
		if (student.isPresent()) {
			return attendanceRepository.findByStudent(student.get());
		}
		return null;
		
	}
	

}
