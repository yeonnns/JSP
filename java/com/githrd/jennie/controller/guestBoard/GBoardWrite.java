package com.githrd.jennie.controller.guestBoard;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.jennie.controller.*;
import com.githrd.jennie.dao.*;
import com.githrd.jennie.vo.BoardVO;

public class GBoardWrite implements BlpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 세션검사
		HttpSession session = req.getSession();
		String sid = (String) session.getAttribute("SID");
		if(sid == null) {
			req.setAttribute("isRedirect", true);
			return "/whistle/member/login.blp";
		}
		
		// 파라미터 꺼내고
		String spage = req.getParameter("nowPage");
		// 작성게시글 검사
		GBoardDao gDao = new GBoardDao();
		int cnt = gDao.getWriteCount(sid);
		if(cnt == 1) {
			// 이 경우는 이미 작성한 경우이므로 리스트페이지로 돌려보낸다.
			req.setAttribute("isRedirect", true);
			return "/whistle/guestBoard/gBoardList.blp?nowPage=" + spage; // get 방식으로 요청
		}
		
		BoardVO bVO = gDao.getWriteInfo(sid);
		
		req.setAttribute("DATA", bVO);
		String view = "/guestBoard/gBoardWrite"; // forward 방식으로 뷰를 부르게 되므로 요청객체는 계속 유지된다.
		return view;
	}

}