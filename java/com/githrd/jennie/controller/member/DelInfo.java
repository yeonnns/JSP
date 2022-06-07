package com.githrd.jennie.controller.member;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.jennie.controller.*;
import com.githrd.jennie.dao.*;

public class DelInfo implements BlpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 할일
		// 뷰 부르는 방식 설정하고
		req.setAttribute("isRedirect", true);
		// 뷰 설정하고
		String view = "/whistle/";
		// 로그인 체크
		HttpSession session = req.getSession();
		// 세션값 꺼내고
		String sid = (String) session.getAttribute("SID");
		if(sid == null) {
			// 로그인 안된 경우이므로 로그인 페이지로 보낸다
			view = "/whistle/member/login.blp";
			return view;
		}
		// 파라미터 꺼내고
		String sno = req.getParameter("mno");
		int mno = Integer.parseInt(sno);
		String id = req.getParameter("id");
		// 신원확인하고
		if(!sid.equals(id)) {
			// 세션에 기억한 아이디와 전달받은 아이디가 다른경우
			view = "/whistle/member/memberList.blp";
			return view;
		}
				
		// 데이터베이스 작업하고 결과받고
		MemberDao mDao = new MemberDao();
		int cnt = mDao.delMember(mno);
		// 결과에 따라서 처리하고
		if(cnt != 1) {
			// 실패한 경우
			view = "/whistle/member/myInfo.blp";
		} else {
			// 로그아웃 처리하고
			session.removeAttribute("SID");
		}
		// 뷰 반환하고
		return view;
	}

}