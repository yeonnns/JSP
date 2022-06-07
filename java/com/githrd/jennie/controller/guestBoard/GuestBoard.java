package com.githrd.jennie.controller.guestBoard;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.jennie.controller.*;
import com.githrd.jennie.dao.*;
import com.githrd.jennie.vo.*;
import com.githrd.jennie.util.*;

public class GuestBoard implements BlpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/guestBoard/gBoardList";
		
		// 현재 보고있는 페이지 
		String spage = req.getParameter("nowPage");
		int nowPage = 1;
		if(spage != null) {
			nowPage = Integer.parseInt(spage);
		}
		
		GBoardDao gDao = new GBoardDao();
		// 총 게시글 수 조회
		int total = gDao.getTotal();
		
		// 페이지 객체 만들고
		PageUtil page = new PageUtil(nowPage, total);
		
		// 데이터베이스에서 게시글 리스트 가져오고
		ArrayList<BoardVO> list = gDao.getGBoardList(page);
		int cnt = 0 ;
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid != null) {
			cnt = gDao.getWriteCount(sid);
		}
		
		// 뷰에 데이터 심고
		//?~? 페이지 게시글 정보
		req.setAttribute("LIST", list);
		//id=?가 작성한 게시글 수
		req.setAttribute("CNT", cnt);
		// 페이지 게시글 정보
		req.setAttribute("PAGE", page);
		
		// 뷰 부르고
		return view;
	}

}