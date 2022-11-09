<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 정보 화면</title>
<c:import url="classpath:static/importer.html" />
</head>
<body>
	<div class="container">
		<nav class="navbar bg-light">
		    <div class="container-fluid">
			    <a class="navbar-brand">Navbar</a>
			    <form class="d-flex" role="search">
			        <a href="/movie/showAll" class="btn btn-outline-primary ms-3">영화 정보</a>
			        <a href="/theater/showAll" class="btn btn-outline-primary ms-3">영화관 정보</a>
			        <a href="/user/index" class="btn btn-outline-primary ms-3">회원 정보</a>
			        <a href="/user/logOut" class="btn btn-outline-secondary ms-3">로그아웃</a>
			    </form>
	    	</div>
		</nav>
		
		<div class="row justify-content-center align-items-center">
			<div class="col-8">
				<div class="table-responsive">
					<table class="table table-striped table-hover text-center align-middle">
						<thead>
							<tr>
								<th class="col-1">번호</th>
								<th class="col-3">제목</th>
								<th class="col-2">시청등급</th>
								<th class="col-2">평점</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach items="${list}" var="movie">
								<tr onclick="location.href='/movie/showOne/${movie.id}'">
									<td>${movie.id }</td>
									<td>${movie.title }</td>
									<td>${movie.degree }</td>
									<td>0.0</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>