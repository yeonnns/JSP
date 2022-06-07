<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID PW SEARCH</title>
<link rel="stylesheet" type="text/css" href="/whistle/resources/css/w3.css">
<link rel="stylesheet" type="text/css" href="/whistle/resources/css/base.css">
<script type="text/javascript" src="/whistle/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#idck').click(function(){
			$(location).attr('href','/whistle/member/idSearchProc.blp')	
		});
		
		$('#pwck').click(function(){
			$(location).attr('href','/whistle/member/pwSearchProc.blp')	
		});
	});
</script>
</head>
<body>
	<!-- 아이디 찾기 -->
	<div class="w3-content w3-center mx650">
		<h1 class="w3-indigo w3-text-white">아이디 찾기</h1>
		<form method="POST" action="" class="w3-col w3-padding w3-margin-top" id="frm" name="frm">
			<div class="w3-col w3-margin-top">
				<label for="name" class="w3-col s2 w3-right-align">이    름 : </label>
				<div class="w3-col m9 pdl10" >
					<input type="text" name="name" id="name" placeholder="이름을 입력하세요" class="w3-col w3-input w3-border">			
				</div>
			</div>
			<div class="w3-col w3-margin-top">
				<label for="tel" class="w3-col m2 w3-right-align">전화번호 : </label>
				<div class="w3-col m9 pdl10" >
						<input type="text" name="tel" id="tel" placeholder="전화번호를 입력하세요" class="w3-col w3-input w3-border">			
				</div>
			</div>
		</form>
		<div class="w3-col w3-margin-top">
			<div class="w3-button w3-indigo w3-text-white w3-hover-grey" id="idck">아이디 찾기</div>
		</div>
	</div>
		<!-- 비번 찾기 -->
	<div class="w3-content w3-center mx650">
		<h1 class="w3-indigo w3-text-white">비밀번호 찾기</h1>
		<form method="POST" action="" class="w3-col w3-padding w3-margin-top" id="frm" name="frm">
			<div class="w3-col w3-margin-top">
				<label for="name" class="w3-col s2 w3-right-align">이    름 : </label>
				<div class="w3-col m9 pdl10" >
					<input type="text" name="name" id="name" placeholder="이름을 입력하세요" class="w3-col w3-input w3-border">			
				</div>
			</div>
			<div class="w3-col w3-margin-top">
				<label for="mail" class="w3-col m2 w3-right-align">이 메 일 : </label>
				<div class="w3-col m9 pdl10" >
						<input type="text" name="mail" id="mail" placeholder="이메일을 입력하세요" class="w3-col w3-input w3-border">			
				</div>
			</div>
		</form>
		<div class="w3-col w3-margin-top">
			<div class="w3-button w3-indigo w3-text-white w3-hover-grey" id="pwck">비밀번호 찾기</div>
		</div>
	</div>
</body>
</html>