<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<c:import url="classpath:static/importer.html" />
</head>
<body>
	<div class="container py-5">
		<c:if test="${message ne null}">
			<div class="row justify-content-center align-items-center">
				<div class="col-6 alert alert-danger" role="alert">${message}
				</div>
			</div>
		</c:if>
		
		<form action="/user/register" method="post">
			<div class="row justify-content-center align-items-center">
				<div class="col-2 text-end">
					<label for="username">아이디: </label>
				</div>
				
				<div class="col-4">
					<input class="form-control" name="username" value="${userDTO.username }">
				</div>
			</div>
			
			<div class="row justify-content-center align-items-center mt-2">
				<div class="col-2 text-end">
					<label for="password">비밀번호: </label>
				</div>
				
				<div class="col-4">
					<input class="form-control" name="password">
				</div>
			</div>
			
			<div class="row justify-content-center align-items-center mt-2">
				<div class="col-2 text-end">
					<label for="nickname">닉네임: </label>
				</div>
				
				<div class="col-4">
					<input class="form-control" name="nickname" value="${userDTO.nickname }">
				</div>
			</div>
			
			<div class="row justify-content-center align-items-center mt-4">
				<div class="col-2 justify-content-center text-end">
					<button type="submit" class="btn btn-outline-primary" onclick="validate">가입하기</button>
				</div>
				
				<div class="col-2 justify-content-center text-center">
					<a href="/" class="btn btn-outline-secondary">돌아가기</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>