<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 보기</title>
<c:import url="classpath:static/importer.html" />
</head>
<body>
	<c:if>
	</c:if>

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
		
		<div class="row justify-content-center align-items-center mt-4">
			<div class="col-2 text-end">
				<label>아이디 : </label>
			</div>
			
			<div class="col-4">
				<span class="form-control">${logIn.username}</span>
			</div>
		</div>
		
		<div class="row justify-content-center align-items-center mt-2">
			<div class="col-2 text-end">
				<label>닉네임 : </label>
			</div>
			
			<div class="col-4">
				<span class="form-control">${logIn.nickname}</span>
			</div>
		</div>
		
		<div class="row justify-content-center align-items-center mt-2">
			<div class="col-2 text-end">
				<label>회원 등급 : </label>
			</div>
			
			<div class="col-4">
				<span class="form-control">${logIn.grade}</span>
			</div>
		</div>
		
		<div class="row justify-content-center align-items-center mt-4">
			<div class="col-2 text-center">
				<a href="/user/update" class="btn btn-outline-primary">회원정보 수정</a>
			</div>
			
			<div class="col-2 text-center">
				<a href="/user/delete" class="btn btn-outline-danger">회원정보 삭제</a>
			</div>
			
			<div class="col-2 text-center">
				<button class="btn btn-outline-secondary" onclick="history.back();">돌아가기</button>
			</div>
		</div>
	</div>
</body>
</html>