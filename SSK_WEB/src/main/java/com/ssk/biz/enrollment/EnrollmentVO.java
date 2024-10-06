package com.ssk.biz.enrollment;

import java.util.List;

import lombok.Data;

@Data
public class EnrollmentVO {
	private int enrollmentCourseNum; // 강의 번호
	private String enrollmentStudentNum; // 강의 수강 학생 학번
	private int enrollmentMiddle; // 중간고사 성적
	private int enrollmentFinal; // 기말고사 성적

	// vo 객체에서만 사용하는 해당 강의이름
	private String enrollmenCourseName; // 강의 수강 학생 학번

	// vo 객체에서만 사용하는 해당 강의를 수강하는 학생 정보
	private String enrollmentStudentName;
	private String enrollmentStudentPhone;
	private String enrollmentStudentMajor;

	// vo 객체에서만 사용하는 해당 학생의 중간 + 기말
	private int enrollmentStudentSum;

	// vo 객체에서만 사용하는 해당 학생의 학점
	private String enrollmentStudentGrade;

	// 총점 세터
	public void setEnrollmentStudentSum(int enrollmentMiddle, int enrollmentFinal) {
		this.enrollmentStudentSum = enrollmentMiddle + enrollmentFinal;
	}

	// 학점 설정 메서드
	public void assignGrade(List<EnrollmentVO> enlist) {
		int length = enlist.size();

		for (int i = 0; i < length; i++) {
			EnrollmentVO envo = enlist.get(i); // 현재 학생 객체
			double percentile = (double) i / length; // 현재 학생의 백분율 위치 계산

			if (percentile < 0.1) { // 상위 10%
				envo.setEnrollmentStudentGrade("A+");
			} else if (percentile < 0.3) { // 20% (10% ~ 30%)
				envo.setEnrollmentStudentGrade("A");
			} else if (percentile < 0.5) { // 20% (30% ~ 50%)
				envo.setEnrollmentStudentGrade("B");
			} else if (percentile < 0.7) { // 20% (50% ~ 70%)
				envo.setEnrollmentStudentGrade("C");
			} else if (percentile < 0.9) { // 20% (70% ~ 90%)
				envo.setEnrollmentStudentGrade("D");
			} else { // Bottom 10%
				envo.setEnrollmentStudentGrade("F");
			}
		}
	}

}
