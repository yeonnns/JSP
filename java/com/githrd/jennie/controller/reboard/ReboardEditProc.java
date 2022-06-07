package com.githrd.jennie.controller.reboard;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.jennie.controller.*;
import com.githrd.jennie.dao.*;
import com.githrd.jennie.vo.*;

public class ReboardEditProc implements BlpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			req.setAttribute("isRedirect", true);
			return "/whistle/member/login.blp";
		}
		String view = "/reboard/redirect";
		
		// 파라미터 가져오기 
		String body = req.getParameter("body");
		String sno = req.getParameter("bno");
		int bno = Integer.parseInt(sno);
		String spage = req.getParameter("nowPage");
		
		ReboardDao rDao = new ReboardDao();
		int cnt = rDao.updateReboard(body, bno);
		
		
		req.setAttribute("NOWPAGE", spage);
		// 결과에 따라 처리하고
		// isRedirect 기본값 false 임
		if(cnt == 0 ) {
			// 실패한 경우
			req.setAttribute("VIEW", "/whistle/reboard/reboardEdit.blp");
		}else {
			req.setAttribute("VIEW", "/whistle/reboard/reboardList.blp");
		}
		return view;
	}

}
