<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head>
	<body>
		<h2>${message}</h2>

		<c:if test="${not empty userInfoList }">
			<c:forEach var="userInfo" items="${userInfoList }"><br>
				ID：<c:out value="${userInfo.id }" /><br>
				ログインID：<c:out value="${userInfo.loginId }" /><br>
				名前：<c:out value="${userInfo.name }" /><br>
				所属部署：<c:out value="${userInfo.branch.name }" /> <c:out value="${userInfo.department.name }" /><br>
			</c:forEach>

		</c:if>
	</body>
</html>
