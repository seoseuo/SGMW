package com.ssk.biz.enrollment;

import lombok.Data;

@Data
public class EnrollmentVO {
    private int enrollmentClassNum;   // 강의 번호
    private String enrollmentStudentNum;  // 강의 수강 학생 학번
    private int enrollmentMiddle;   // 중간고사 성적
    private int enrollmentFinal;    // 기말고사 성적
}
