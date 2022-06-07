$(document).ready(function(){
	/* 페이지 버튼 클릭이벤트 처리 */
	$('.pbtn').click(function(){
		// 페이지번호 읽고
		var pno = $(this).attr('id');
		// 페이지 번호 셋팅하고
		$('#nowPage').val(pno);
		// 폼 태그 전송
		$('#frm').submit();
	});
	
	/*
	// 홈버튼 클릭 이벤트 처리 
	$('#hbtn').click(function(){
		$(location).attr('href', '/whistle/main.blp');
	});
	
	// 로그인 버튼 클릭 이벤트 처리 
	$('#lbtn').click(function(){
		$(location).attr('href', '/whistle/member/login.blp');
	});
	
	// 회원 가입 버튼 클릭 이벤트 처리 
	$('#jbtn').click(function(){
		$(location).attr('href', '/whistle/member.join.blp');
	});
	
	// 로그아웃 버튼 클릭이벤트 처리 
	$('#obtn').click(function(){
		$(location).attr('href', '/whistle/member/logout.blp');
	});
	*/
	
	$('.menubtn').click(function(){
		var bid = $(this).attr('id');
		
		var addr = '/whistle/';
		switch(bid){
		case 'hbtn':
			// 기본 주소를 사용
			break;
		case 'lbtn':
			addr = '/whistle/member/login.blp';
			break;
		case 'jbtn':
			addr = '/whistle/member/join.blp';
			break;
		case 'obtn':
			addr = '/whistle/member/logout.blp';
			break;
		case 'wbtn':
			$('#frm').attr('action', '/whistle/reboard/reboardWrite.blp');
			$('#frm').submit();
			return;
		}
		
		$(location).attr('href', addr);
	});
	
	// 댓글등록
	$('#cmtbtn').click(function(){
		var btxt = $('#body').val();
		btxt = btxt.trim();		
		if(!btxt){
			$('body').focus();
			return;
		}
		
		if(btxt.length > 200){
			btxt = btxt.substring(0, 200);
			$('#body').val(btxt);
			alert('코멘트의 글자수는 200 자를 초과할 수 없다.')
			return;
		}
		
		$('#frm').submit();
	});
	
	$('.w3-button.w70').click(function(){
		// 어떤 버튼이 클릭이 되었는지 알아내고
		var btxt = $(this).html();
		
		// 글번호 읽어오기(부모의 id="${data.bno})
		var sno = $(this).parent().attr('id');
		
		$('#bno').val(sno);
		if(btxt == '댓글'){		
			
			$('#frm').attr('action', '/whistle/reboard/reboardComment.blp');
		} else if(btxt == '삭제'){
			$('#frm').attr('action', '/whistle/reboard/reboardDel.blp');	
		} else if(btxt == '수정'){
			$('#frm').attr('action', '/whistle/reboard/reboardEdit.blp')
		}
			$('#frm').submit();	
	});
	
	
	
	
	/* 글쓰기 페이지 */
	$('#listbtn').click(function(){
		// form 태그의 액션 속성값 변경
		$('#frm').attr('action', '/whistle/reboard/reboardList.blp');
		// 사용하지 않는 태그 비활성시키고
		$('#mno').prop('disabled', true);
		$('#body').prop('disabled', true);
		
		$('#frm').submit();
	});
	
	$('#rbtn').click(function(){
		document.frm.reset();
	});
	
	$('#wpbtn').click(function(){
		// 입력된 글 유효성 검사
		var txt = $('#body').val();
		txt = txt.trim();
		if(!txt || txt.length == 0){
			$('#body').val('');
			$('#body').focus();
			return;
		}
		
		$('#body').val(txt);
		
		$('#frm').submit();
	});
	
	$('#editbtn').click(function(){
		// 원래 바디
		var ttxt = $('#obody').val();
		// 수정한 바디
		var txt = $('#body').val();
		
		
		if(txt == ttxt){
			return;
		}
		
		$('#frm').submit();
	});
	
});