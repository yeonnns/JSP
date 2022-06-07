package com.githrd.jennie.controller.board;

import java.util.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.jennie.controller.BlpInter;
import com.githrd.jennie.dao.*;
import com.githrd.jennie.vo.*;
import com.githrd.jennie.util.*;

public class BoardList implements BlpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/board/boardList";
		
		int nowPage = 1;
		String spage = req.getParameter("nowPage");
		if(spage != null) {
			nowPage = Integer.parseInt(spage);
		}
		
		BoardDao bDao = new BoardDao();
		int total = bDao.getTotalCount();
		
		PageUtil page = new PageUtil(nowPage, total);
		
		ArrayList<BoardVO> list = bDao.getBoardList(page);
		
		req.setAttribute("LIST", list);
		req.setAttribute("PAGE", page);
		
		return view;
	}

}