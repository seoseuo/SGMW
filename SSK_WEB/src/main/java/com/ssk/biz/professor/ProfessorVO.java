package com.ssk.biz.professor;

import lombok.Data;

@Data
public class ProfessorVO {
	 private String professorNum;         // 교수자 번호
	    private String professorName;     // 교수자 이름
	    private String professorPassword; // 교수자 비밀번호
	    private String professorPhone;    // 교수자 전화번호
	    private String professorMajor;    // 교수자 소속 (전공)
	    private String professorAdminNum;    // 교수자의 관리자 번호 (외래키)
}
