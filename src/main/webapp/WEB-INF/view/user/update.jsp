<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정 페이지</title>
<c:import url="classpath:static/importer.html" />
</head>
<body>
	<div class="container">
		<nav class="navbar bg-light">
		    <div class="container-fluid">
			    <a class="navbar-brand">Navbar</a>
			    <form class="d-flex" role="search">
			        <a href="/movie/showAll/1" class="btn btn-outline-primary ms-3">영화 정보</a>
			        <a href="/theater/showAll" class="btn btn-outline-primary ms-3">영화관 정보</a>
			        <a href="/user/index" class="btn btn-outline-primary ms-3">회원 정보</a>
			        <a href="/user/logOut" class="btn btn-outline-secondary ms-3">로그아웃</a>
			    </form>
	    	</div>
		</nav>
		
		<c:if test="${message ne null}">
			<div class="row justify-content-center align-items-center">
				<div class="col-6 alert alert-danger" role="alert">${message}
				</div>
			</div>
		</c:if>
		
		<form action="/user/update" method="post">
			<div class="row justify-content-center align-items-center mt-4">
				<div class="col-2 text-end">
					<label for="username">아이디 : </label>
				</div>
				
				<div class="col-4">
					<input class="form-control" name="username" value="${logIn.username}" readonly>
				</div>
			</div>
			
			<div class="row justify-content-center align-items-center mt-2">
				<div class="col-2 text-end">
					<label for="password">기존 비밀번호 : </label>
				</div>
				
				<div class="col-4">
					<input class="form-control" name="password" type="password">
				</div>
			</div>
			
			<div class="row justify-content-center align-items-center mt-2">
				<div class="col-2 text-end">
					<label for="newPassword">새 비밀번호 : </label>
				</div>
				
				<div class="col-4">
					<input class="form-control" name="newPassword" type="password">
				</div>
			</div>
			
			<div class="row justify-content-center align-items-center mt-2">
				<div class="col-2 text-end">
					<label for="nickname">닉네임 : </label>
				</div>
				
				<div class="col-4">
					<input class="form-control" value="${logIn.nickname}" name="nickname">
				</div>
			</div>
			
			<div class="row justify-content-center align-items-center mt-3">
				<div class="col-2 text-end">
					<button type="submit" class="btn btn-outline-success">수정하기</button>				
				</div>
				
				<div class="col-2 text-end">
					<a href="/user/index" class="btn btn-outline-secondary">돌아가기</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>