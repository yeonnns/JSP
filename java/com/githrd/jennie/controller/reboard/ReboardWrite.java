package com.githrd.jennie.controller.reboard;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.jennie.controller.*;
import com.githrd.jennie.dao.*;
import com.githrd.jennie.vo.*;

public class ReboardWrite implements BlpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/reboard/reboardWrite";
		// 로그인 체크
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			req.setAttribute("isRedirect", true);
			view = "/whistle/member/login.blp";
			return view;
		}
		
		// 로그인 한 경우이므로 데이터베이스에서 데이터꺼내온다.
		ReboardDao rDao = new ReboardDao();
		BoardVO bVO = rDao.getWriterInfo(sid);
		
		// 데이터 심고
		req.setAttribute("DATA", bVO);
		
		return view;
	}

}