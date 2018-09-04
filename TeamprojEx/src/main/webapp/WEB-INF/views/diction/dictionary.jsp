<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
 
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta http-equiv="Pragma" CONTENT="no-cache">
<meta http-equiv="Expires" CONTENT="-1">

<meta name="Description" content="아파고병원">
<title>인제대학교 서울백병원</title>
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/base.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/ui_style.css?180711">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/common.css?180604">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/layout.css?180315">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/content.css?1807172">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/colorChange.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/content_seoul.css?1805141">
<%-- <script type="text/javascript" src="<%=request.getContextPath() %>/js/libs/jquery-1.11.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/libs/jquery-ui-1.12.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/libs/jquery.browser.check.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/libs/modernizr.min.js?180413"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/plugins.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/ui.js?1807051"></script>
<!--[if lt IE 9]>
<script type="text/javascript" src="/common/js/libs/html5shiv-printshiv.js"></script>
<![endif]--%>
</head>
<body>
<!-- 상단 영역 -->
<%@ include file="../include/sourcecopy_header.jsp" %>
<div class="container">
	<div class="col-xs-3 col-md-3">
		<%@ include file="left_menu.jsp" %>
	</div>
	<div class="col-xs-9 col-md-9">	
	<!-- Contents영역 시작-->
	<br/><br/>
	<h2>질환명을 검색하세요.</h2>
<form class="form-inline">
	<!-- <div class="form-group">
		<select name="searchColumn" class="form-control">
			<option value="title">제목</option>
			<option value="content">내용</option>
			<option value="both">제목+내용</option>
		</select>
	</div> -->
	<div class="input-group">
		<input type="text" name="searchWord"  class="form-control"/>
		<div class="input-group-btn">
			<button type="submit" class="btn btn-default">
				<i class="glyphicon glyphicon-search"></i>
			</button>
		</div>
	</div>
</form>
	<a href="../diction/diclist.do?charc=ㄱ" onmouseover = "this.style.color = 'blue';" onmouseout="this.style.color ='#000'">ㄱ</a>
	<a href="../diction/diclist.do?charc=ㄴ" onmouseover = "this.style.color = 'blue';" onmouseout="this.style.color ='#000'">ㄴ</a>
	<a href="../diction/diclist.do?charc=ㄷ" onmouseover = "this.style.color = 'blue';" onmouseout="this.style.color ='#000'">ㄷ</a>
	<a href="../diction/diclist.do?charc=ㄹ" onmouseover = "this.style.color = 'blue';" onmouseout="this.style.color ='#000'">ㄹ</a>
	<a href="../diction/diclist.do?charc=ㅁ" onmouseover = "this.style.color = 'blue';" onmouseout="this.style.color ='#000'">ㅁ</a>
	<a href="../diction/diclist.do?charc=ㅂ" onmouseover = "this.style.color = 'blue';" onmouseout="this.style.color ='#000'">ㅂ</a>
	<a href="../diction/diclist.do?charc=ㅅ" onmouseover = "this.style.color = 'blue';" onmouseout="this.style.color ='#000'">ㅅ</a>
	<a href="../diction/diclist.do?charc=ㅇ" onmouseover = "this.style.color = 'blue';" onmouseout="this.style.color ='#000'">ㅇ</a>
	<a href="../diction/diclist.do?charc=ㅈ" onmouseover = "this.style.color = 'blue';" onmouseout="this.style.color ='#000'">ㅈ</a>
	<a href="../diction/diclist.do?charc=ㅊ" onmouseover = "this.style.color = 'blue';" onmouseout="this.style.color ='#000'">ㅊ</a>
	<a href="../diction/diclist.do?charc=ㅋ" onmouseover = "this.style.color = 'blue';" onmouseout="this.style.color ='#000'">ㅋ</a>
	<a href="../diction/diclist.do?charc=ㅌ" onmouseover = "this.style.color = 'blue';" onmouseout="this.style.color ='#000'">ㅌ</a>
	<a href="../diction/diclist.do?charc=ㅍ" onmouseover = "this.style.color = 'blue';" onmouseout="this.style.color ='#000'">ㅍ</a>
	<a href="../diction/diclist.do?charc=ㅎ" onmouseover = "this.style.color = 'blue';" onmouseout="this.style.color ='#000'">ㅎ</a>

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