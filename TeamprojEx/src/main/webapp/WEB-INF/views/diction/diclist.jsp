<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>제목은 여기에</title>
<link rel="stylesheet" href="../resources/bootstrap3.3.7/css/bootstrap.min.css" />
<script src="../resources/bootstrap3.3.7/jquery/jquery-3.2.1.min.js"></script>
</head>
<body>
<%@ include file="../include/sourcecopy_header.jsp" %>
<div class="container">

<h4>검색결과</h4>

<table class="table table-bordered table-striped">
<colgroup>
	<col width="20%"/>
	<col width="*"/>
</colgroup>
<tbody>
	<c:forEach items="${list }" var = "row" >
	<tr>
		<td class="text-center" style="vertical-align:middle;">
		<a href="../diction/dicView.do?title=${row.title }">${row.title }</a></td>
	</tr>
	</c:forEach>
</tbody>
</table>

</div>
<%@ include file="../include/sourcecopy_bottom.jsp" %>
</body>
</html>