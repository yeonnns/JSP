$(document).ready(function(){
	$('#lbtn').click(function(){
		$(location).attr('href', '/whistle/member/memberList.blp');
	});
	
	$('#dbtn').click(function(){
		// 보낼 데이터 읽고
		var sno = $('#mno').html();
		var sid = $('#id').html();
		// 보낼 데이터 셋팅하고
		$('#smno').val(sno);
		$('#sid').val(sid);
		// 보낼주소 수정하고
		$('#frm').attr('action', '/whistle/member/delInfo.blp');
		
		if(confirm('정말 탈퇴합니까?')){
			// form 태그가 완성이 됬으니 전송한다.
			$('#frm').submit();
		}
	});
	$('#ebtn').click(function(){
		$(location).attr('href', '/whistle/member/editInfo.blp');
	});
});