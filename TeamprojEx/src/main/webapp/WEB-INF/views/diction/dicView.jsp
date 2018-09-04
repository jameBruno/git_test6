<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>제목은 여기에</title>
<link rel="stylesheet" href="../resources/bootstrap3.3.7/css/bootstrap.min.css" />
<script src="../resources/bootstrap3.3.7/jquery/jquery-3.2.1.min.js"></script>
</head>
<body>
<!-- 상단 영역 -->
<%@ include file="../include/sourcecopy_header.jsp" %>
<div class="container">
<br/>
		<h4>검색결과</h4>
		<table class="table table-bordered table-striped">
		<colgroup>
			<col width="20%"/>
			<col width="*"/>
		</colgroup>
		<tbody>
			<tr>
				<th class="text-center" style="vertical-align:middle;">제목</th>
				<td>${vo.title }</td>
			</tr>
			<tr>
				<th class="text-center" style="vertical-align:middle;">내용</th>
				<td>
					${vo.dic_contents}					
				</td>
			</tr>
		</tbody>
		</table>
	</div>
</div>
<%@ include file="../include/sourcecopy_bottom.jsp" %>
</body>
</html>