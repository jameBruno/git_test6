<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String key = session.getAttribute("key").toString();
String vkey = key.substring(8, 24);
session.setAttribute("vkey", vkey);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>title</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap3.3.7/css/bootstrap.min.css" />
<script src="<%=request.getContextPath() %>/resources/bootstrap3.3.7/jquery/jquery-3.2.1.min.js"></script>
</head>
<body>
<%@ include file="../include/sourcecopy_header.jsp" %>
<div class="container">
	<br/>
	<form action="CaptchaRes">
		<h3>먼저 자동생성문자를 입력해주세요</h3><br/>
		<img src = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=<%=vkey %>" />
		<input type="text" name = "inputText" />
		<button type="submit" class="btn btn-danger">확인</button>
	</form>
	<br/>	
</div>
<%@ include file="../include/sourcecopy_bottom.jsp" %>
</body>
</html>