<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">

	<form action="/auth/loginProc" method="post">
		<div class="form-group">
			<label for="username">User Name :</label> <input type="text" name="username" class="form-control" placeholder="Enter name" id="username">
		</div>
		<div class="form-group">
			<label for="password">Password:</label> <input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		<button id="btn-login" class="btn btn-primary">Sign In</button>
		<a href="https://kauth.kakao.com/oauth/authorize?client_id=91d132524c75d0114c3120e012d934ec&redirect_uri=http://localhost:8000/auth/kakao/callback&response_type=code"><img height="39px" src="/image/kakao_login_button.png"></a>
	</form>
</div>
<%@ include file="../layout/footer.jsp"%>
