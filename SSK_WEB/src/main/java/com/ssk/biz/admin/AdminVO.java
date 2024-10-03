package com.ssk.biz.admin;

import lombok.Data;

@Data
public class AdminVO {
	private String adminNum;       // 관리자 번호
    private String adminName;   // 관리자 이름
    private String adminPassword; // 관리자 비밀번호
    private String adminPhone;  // 관리자 전화번호
    private String adminMajor;  // 관리자 소속(전공)
}
