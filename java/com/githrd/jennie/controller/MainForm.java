package com.githrd.jennie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainForm implements BlpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String view ="/WEB-INF/views/main.jsp"; 디스패치에서 주소 간편하게 설정
		String view ="/main";
		return view;
	}

}

