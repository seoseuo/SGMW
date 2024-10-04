package com.ssk.biz.course;

import lombok.Data;

@Data
public class CourseVO {
	  private int courseNum;           // 강의 번호
	    private String courseName;       // 강의 이름
	    private String courseProfessorNum;  // 강의 교수자 번호 (외래키)
	    private int coursePoint;         // 강의 학점
	    private String courseProfessorName; // 강의 교수자 이름 (vo에서만 사용)
	    private String courseProfessorMajor; // 강의 교수자 소속 (전공) (vo에서만 사용)
}
