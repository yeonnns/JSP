/**
 * /resources/js/whistle/main.js
 */
 $(document).ready(function(){
	// 회원가입버튼 클릭이벤트
	$('#jbtn').click(function(){
		$(location).attr('href', '/whistle/member/join.blp');
	});

	$('#lbtn').click(function(){
		$(location).attr('href', '/whistle/member/login.blp');
	});
	
	$('#obtn').click(function(){
		$(location).attr('href', '/whistle/member/logout.blp');
	});
	
	$('#mlbtn').click(function(){
		$(location).attr('href', '/whistle/member/memberList.blp');
	});
	
	$('#ibtn').click(function(){
		$(location).attr('href', '/whistle/member/myInfo.blp');
	});
	$('#gbtn').click(function(){
		$(location).attr('href', '/whistle/guestBoard/gBoardList.blp');
	});
	$('#rbtn').click(function(){
		$(location).attr('href', '/whistle/reboard/reboardList.blp');
	});
	
	$('#fbtn').click(function(){
		$(location).attr('href', '/whistle/board/boardList.blp');
	});
	
});