package com.ssk.biz.board;

import lombok.Data;

@Data
public class BoardVO {
	private int boardNum;            // 문의 번호
    private String boardFromNum;        // 문의 한 교번 혹은 학번
    private String boardTitle;       // 문의 제목
    private String boardContents;    // 문의 내용
    private String boardToNum;          // 문의 할 관리자 번호, 교수자 교번
    private String boardDate;        // 문의 일자
    
    // vo 객체에서만 사용하는 문의자 이름 , 직책
    private String boardName;
    private String boardPosition;
    
    public void setBoardPosition(String boardFromNum) {
    	if(boardFromNum.length()==8) {
    		this.boardPosition="학생";
    	}
    	else {
    		this.boardPosition="교수자";
    	}
    }
}
