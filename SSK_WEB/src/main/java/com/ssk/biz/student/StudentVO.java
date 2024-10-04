package com.ssk.biz.student;

import lombok.Data;

@Data
public class StudentVO {
	private String studentNum;        // 학생 학번
    private String studentName;    // 학생 이름
    private String studentPassword;// 학생 비밀번호
    private String studentPhone;   // 학생 전화번호
    private String studentMajor;   // 학생 소속 (전공)
    private String studentAdminNum;   // 학생의 관리자 번호 (외래키)
}
