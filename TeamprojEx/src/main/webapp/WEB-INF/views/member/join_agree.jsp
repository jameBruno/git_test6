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
<%@ include file="../include/sourcecopy_header.jsp" %>
<div class="container">
	<div class="container-header">
		<div class="inner">
			<h1 class="tit-page">회원가입</h1>
			<p class="summary">회원가입을 하시면 다양한 서비스를 편리하게 이용하실 수 있습니다.</p>
		</div>
	</div>
	<div class="contents-wrap">
		<div class="inner">
		<!-- contents -->
				<article class="contents snb-none">
					<h3 class="tit-line">개인정보 입력</h3>
					<div class="tit-tableWrap mar-t30">
						<h4 class="tit-table">필수입력사항</h4>
						<p class="essential">
							<em class="emphasis-red">* 필수입력사항</em>입니다. 빠짐없이 기재해 주세요.(14세 미만은
							회원가입이 되지 않습니다)
						</p>
					</div>

					<form name="memberFrm" id="regfm" action="mybatis/join.do"
						method="post" onsubmit="return mValidate(this);">
						<input type="hidden" name="edit" value="ins"> <input
							type="hidden" name="hpid" value="DA">
						<div class="table-wrap">
							<table class="table-row">
								<caption>필수입력사항</caption>
								<colgroup>
									<col style="width: 174px">
									<col>
								</colgroup>
								<tbody>
									<tr>
										<th>회원구분</th>
										<td style="text-align: left;"><input type="radio"
											name="mem_flag" value="일반" /> 일반 &nbsp;&nbsp;&nbsp;<input
											type="radio" name="mem_flag" value="병원관리자" />병원관리자</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="btn-area mar-t40">
							<button type="submit" class="btn btn-primary btn-sm">
								<em>확인</em>
							</button>
						</div>
					</form>
			</article>
			<!--// Contents -->
		</div>
	</div>
</div>
<%@ include file="../include/sourcecopy_bottom.jsp" %>
</body>
</html>