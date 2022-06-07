package com.githrd.jennie.controller.reboard;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.jennie.controller.*;
import com.githrd.jennie.dao.*;
import com.githrd.jennie.vo.*;

public class ReboardWriteProc implements BlpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", true);
		String view = "/whistle/reboard/reboardList.blp";
		
		// 할일
		// 로그인 체크
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			view = "/whistle/member/login.blp";
			return view;
		}
		
		// 파라미터 꺼내고
		String sno = req.getParameter("mno");
		String spage = req.getParameter("nowPage");
		String body = req.getParameter("body");
		String supno = req.getParameter("upno");
		
		BoardVO bVO = new BoardVO();
		bVO.setMno(Integer.parseInt(sno));
		bVO.setBody(body);
		if(supno != null) {
			bVO.setUpno(Integer.parseInt(supno));
		}
		
		System.out.println("################ body : " + bVO.getBody());
		// 데이터베이스 작업하고
		ReboardDao rDao = new ReboardDao();
		int cnt = rDao.addReboard(bVO);
		
		req.setAttribute("NOWPAGE", spage);
		// 결과에 따라서 처리하고
		if(cnt == 0 && supno == null) {
			// 원글 등록 실패
//			view = "/whistle/reboard/reboardWrite.blp?nowPage=" + spage; // get 방식 리다이렉트
			
			// post 방식 - forward 처리...
			req.setAttribute("isRedirect", false);
			req.setAttribute("VIEW", "/whistle/reboard/reboardWrite.blp");
			return "/reboard/redirect";
		} else if(cnt == 0 && supno != null) {
			// 댓글 등록 실패
			req.setAttribute("isRedirect", false);
			req.setAttribute("VIEW", "/whistle/reboard/reboardComment.blp");			
			view = "/reboard/redirect";
		} else if(cnt == 1 && supno != null) {
			// 댓글 등록 성공
			req.setAttribute("isRedirect", false);
			req.setAttribute("VIEW", "/whistle/reboard/reboardList.blp");
			view = "/reboard/redirect";
			
		}
		
		return view;
	}

}