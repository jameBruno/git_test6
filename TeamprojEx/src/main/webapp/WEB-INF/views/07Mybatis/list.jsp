<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name = "viewport" content="width=device-width,initial-scale=1" >
<link rel="stylesheet" href="../common/bootstrap3.3.7/css/bootstrap.min.css" >
<script src="../common/bootstrap3.3.7/jquery/jquery-3.2.1.min.js"></script>
<script src="../common/bootstrap3.3.7/js/bootstrap.min.js"></script>
<script>
function deleteRow(idx){
	if(confirm("정말로 삭제하시겠습니까?")){
		location.href="delete.do?idx="+idx;
	}
}
</script>
<style>
	div{
		border:0px solid #000;
	}
</style>
<title>Spring 답변형 게시판</title>
</head>
<body>
<div class="container-fluid">

<div class="row">
	<!-- Body영역 -->
	<div class="col-xs-3 col-md-3">
		<!-- 좌측영역 -->
	</div>
	<div class="col-xs-9 col-md-9">
		<!-- Contents영역시작-->
		<h3>방명록(한줄게시판) - <small>Mybatis로 제작한 방명록입니다.</small></h3>

<div class="row" style="text-align:right; border-bottom:1px solid #ddd; padding:10px">
	<button class="btn btn-success" onclick="location.href='write.do';">방명록쓰기</button>
</div>

<!-- 방명록 반복 부분 시작 -->
<c:forEach items="${lists }" var = "row" >
<div class="media">
  <div class="media-left">
    <img src="../common/img_avatar3.png" class="media-object" style="width:60px">
  </div>
  <div class="media-body">
    <h4 class="media-heading">작성자:${row.name }(${row.id })</h4>
    <p>       
    ${row.contents }
    </p>
  </div>
  <div class="media-right">
  <!-- 작성자 본인에게만 버튼 보임 -->
  <c:if test = "${sessionScope.siteUserInfo.id eq row.id }">
    <button class="btn btn-primary" onclick = "location.href = 'modify.do?idx=${row.idx}';" style="margin-bottom:5px">수정</button>
    <button class = "btn btn-danger" onclick="javascript:deleteRow(${row.idx});">삭제</button>
  </c:if>
  </div>
</div>
</c:forEach>
<!-- 페이지번호 -->
<div class="row text-center">
	<ul class="pagination">
		${pagingImg }
	</ul>
</div>
<!-- 방명록 반복 부분 끝 -->		
	</div>
</div>
<div class="row" style="border-top:1px solid #bbb; padding-top:20px; margin-top:20px;">
	<!-- 하단영역 -->
</div>
</div>
</body>
</html>