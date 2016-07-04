<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${userInfo.name }-ユーザ情報</title>
</head>
	<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<body>
	<h2>ユーザの情報</h2>
	<h3>ユーザの基本情報</h3>
	<br> ID ：
	<c:out value="${userInfo.id }" />
	<br> ログインID：
	<c:out value="${userInfo.loginId }" />
	<br> 名前 ：
	<c:out value="${userInfo.name }" />
	<br> 所属 ：
	<c:out value="${userInfo.branch.name }" />
	<c:out value="${userInfo.department.name }" />
	<br>

	<hr>
	<h3>このユーザの投稿一覧</h3>
	<c:if test="${not empty messages }">
		<c:forEach var = "message" items="${messages }">
			投稿ID：<a href="${contextPath}/post/comment/id/<c:out value="${message.id }" />/"><c:out value="${message.id }" /></a><br>
			タイトル：<c:out value="${message.title }" /><br>
			本文：<c:out value="${message.text }" /><br>
			投稿日時：<fmt:formatDate value="${message.insertDate }" pattern ="yyyy/MM/dd HH:mm:ss" /><br>
			<hr>
		</c:forEach>

	</c:if>
	<c:if test="${empty messages }">
		投稿はありません
	</c:if>
</body>
</html>