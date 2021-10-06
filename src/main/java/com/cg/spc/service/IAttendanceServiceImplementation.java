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
import com.cg.spc.repository.AttendanceRepository;
import com.cg.spc.repository.StudentRepository;

@Service
public class IAttendanceServiceImplementation implements AttendanceService{
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Attendance addAttendance(Attendance attendance) {
		Student student  = attendance.getStudent();
		if(student != null) {
			long studentId = student.getUserId();
			Optional<Student> studentContainer = studentRepository.findById(studentId);
			if(studentContainer.isPresent()) {
				attendance.setStudent(studentContainer.get());
			}
		}
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
		List<Attendance> existingAttendance = attendanceRepository.findByDate(date);
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
			return attendanceRepository.findByStudentId(student.get());
		}
		return null;
		
	}
	

}
