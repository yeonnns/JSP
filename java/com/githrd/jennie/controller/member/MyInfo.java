package com.githrd.jennie.controller.member;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.jennie.controller.*;
import com.githrd.jennie.dao.*;
import com.githrd.jennie.vo.*;

public class MyInfo implements BlpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인 검사
		HttpSession session = req.getSession();
		String sid = (String) session.getAttribute("SID");
		/*
			session 에 기억되는 데이터는 Object 타입으로 자동 형변환되서
			기억되어지므로
			사용해야 할 때는 원래 타입으로 강제 형변환해서 사용해야 한다.
			
			단지 내용이 채워져있는지만 확인하면
			강제형변환없이 사용해도 되지만
			지금의 경우는 세션에 기억시켜놓은 데이터를 사용해야 하므로
			원래타입으로 강제 형변환해서 꺼내왔다.
		 */
		String view = "/member/memberInfo";
		if(sid == null) {
			req.setAttribute("isRedirect", true);
			view = "/whistle/member/login.blp";
			return view;
		}
		
		// 로그인 되어있는 경우이므로 데이터베이스에서 데이터를 조회한다.
		MemberDao mDao = new MemberDao();
		MemberVO mVO = mDao.getIdInfo(sid);
		
		// 꺼낸 데이터 요청 객체에 기억시키고
		req.setAttribute("DATA", mVO);
		
		// 뷰 부르고...
		return view;
	}

}