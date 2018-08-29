<%@page import="java.math.BigInteger"%>
<%@page import="java.security.SecureRandom"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String clientId = "AZk2SWQ3d_Adr28suG1r";//애플리케이션 클라이언트 아이디값";
    String redirectURI = URLEncoder.encode("http://localhost:8080/git_test2/member/callback.jsp", "UTF-8");
    SecureRandom random = new SecureRandom();
    String state = new BigInteger(130, random).toString();
    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
    apiURL += "&client_id=" + clientId;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&state=" + state;
    session.setAttribute("state", state);
 %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>apago_bottom</title>
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
<script type="text/javascript" src="<%=request.getContextPath() %>/js/ui.js?1807051"></script> --%>
<!-- <link rel="stylesheet" href="../common/bootstrap3.3.7/css/bootstrap.min.css" />
<script src="../common/bootstrap3.3.7/jquery/jquery-3.2.1.min.js"></script> -->
</head>
<body>

	<!-- Footer -->
		<footer id="footer">
		<div class="inner">
			<div class="info">
				<!-- 로고 삽입 -->
				<div class="apago_logo">
					<img src="<%=request.getContextPath() %>/resources/images/go_big.png" style="width:250px; height:60px; padding-bottom:10px;" alt="아파GO로고" />
				</div>
				<ul class="footer-link">
					<li>
						<a href="#popupPrivacyList" onclick="ajaxPopup('.ajaxPopup', '', '/seoul/etc/privacy_policy.asp', this, '.popup-privacyList'); return false;">
							<span class="white fs14">개인정보처리방침</span>
						</a>
					</li>
					<li class="link-policy">
						<a href="#popupVideoPolicy" onclick="ajaxPopup('.ajaxPopup', '', '/seoul/etc/video_policy.asp', this,'.popup-videoPolicy'); return false;">
							영상정보처리기기운영방침
						</a>
					</li>
					<li>
						<a href="#popRights" onclick="ajaxPopup('.ajaxPopup', '', '/seoul/etc/popRights.asp', this,'.popup-popRights'); return false;">
							환자권리장전
						</a>
					</li>
				</ul>
				<div class="copyright">
					<address>서울시 가산디지털2로 123 (가산동 426-5) 월드메르디앙2차 410호&nbsp;|&nbsp;(우)&nbsp;08505 (04551)</address>
					<span>COPYRIGHT ⓒ 2018 KOSMO. ALL RIGHTS RESERVED.</span>
				</div>
			</div>
			<div class="tel-num">
				<dl>
					<dt>대표전화</dt>
					<dd style="padding:5px;">02-1111-2222</dd>
				</dl>
				<br />
				<br />
				<dl>
					<dt>고객지원센터</dt>
					<dd style="padding:5px;">070-1111-2222</dd>
				</dl>
			</div>
			<div class="family-site" style="padding-left:25px;">
				<dl>
					<dt><em>로그인 사이트&nbsp;▶ </em></dt>
					<dd>
						<ul>
							<li><a href="<%=apiURL%>"><img height="50" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/></a></li>
							<li><a href="#">구글 로그인</a></li>
							<li><a href="#">페이스북 로그인</a></li>
							<li><a href="#">인스타 로그인</a></li>
						</ul>
					</dd>
				</dl>

			</div>
		</div>
		<!-- footer_menu -->
		<!-- footer navigation bar -->
		<!-- 
		<div class="footer-menu">
			<div class="inner">
				<ul class="clearfix">
					<li><a href="/seoul/info/outclinic.asp"><i class="ico ico-hosp"></i>병원이용안내</a></li>
					<li><a href="/seoul/info/tell_info.asp"><i class="ico ico-phone"></i>전화번호안내</a></li>
					<li><a href="/seoul/info/direction.asp"><i class="ico ico-pin"></i>오시는길</a></li>
					<li><a href="/seoul/reservation/certificate.asp?tabIndex=0"><i class="ico ico-doc"></i>증명서발급</a></li>
					<li><a href="http://www.e-irb.com/index.jsp?irbcd=20b237a1cb4549745266b0588a7f12a8" target="_blank" title="새창열림"><i class="ico ico-eirb"></i>E-IRB</a></li>
					<li><a href="/seoul/intro/recruit_list.asp"><i class="ico ico-people"></i>채용공고</a></li>
					<li><a href="/seoul/intro/tender_list.asp"><i class="ico ico-stamp"></i>입찰공고</a></li>
				</ul>
				<a href="/seoul/main.asp" class="btn-home"><i class="ico ico-home"></i>HOME</a>
				<button type="button" class="btn-top"><i class="ico ico-top"></i>TOP</button>
			</div>
		</div>
		 -->
		<!-- footer navigation bar -->
		<!--// footer_menu -->
	</footer>


</body>
</html>