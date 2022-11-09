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
	<div class="container">
		<c:choose>
			<c:when test="${logIn.grade eq 1}">
				<c:set var="grade" value="일반 관람객" />
			</c:when>
			
			<c:when test="${logIn.grade eq 2}">
				<c:set var="grade" value="전문 평론가" />		
			</c:when>
			
			<c:when test="${logIn.grade eq 3}">
				<c:set var="grade" value="관리자" />
			</c:when>
		</c:choose>
		
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
				<span class="form-control">${grade}</span>
			</div>
		</div>
		
		<div class="row justify-content-center align-items-center mt-4">
			<div class="col-2 text-center">
				<a href="/user/update" class="btn btn-outline-primary">회원정보 수정</a>
			</div>
			
			<div class="col-2 text-center">
				<button class="btn btn-outline-danger" onclick="showAlert();">회원정보 삭제</button>
			</div>
		</div>
	</div>
	
	<script>
		function showAlert(){
			Swal.fire({
				icon : 'warning',
				title : '! 경고 !',
				text : '해당 아이디를 정말 삭제하시겠습니까?',
				showCancelButton : true,
				confirmButtonText : '예',
				cancelButtonText : '아니요'
			}).then((result) => {
				if(result.isConfirmed){
					location.href="/user/delete";
				}
			})
		}
	</script>
</body>
</html>