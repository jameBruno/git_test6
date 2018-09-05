<%@page import="diction.DicVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
ArrayList<DicVO> list = (ArrayList<DicVO>)request.getAttribute("list");
String trimTitle[] = new String[100];
int i = 0;
for(DicVO vo : list) {
	/* 
	trimTitle[i] = vo.getTitle().trim();
	i++;
	 */
}
%>
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
<%
int j = 0;
for(DicVO vo : list){
	
%>
	<tr>
		<td class="text-center" style="vertical-align:middle;">
		<a href="../diction/dicView.do?dic_id=<%=vo.getDic_id()%>">
		<%=vo.getTitle() %>
		<%-- <%= trimTitle[j] %> --%>
		</a></td>
	</tr>
<%
	j++;
} %>
</tbody>
</table>

</div>
<%@ include file="../include/sourcecopy_bottom.jsp" %>
</body>
</html>