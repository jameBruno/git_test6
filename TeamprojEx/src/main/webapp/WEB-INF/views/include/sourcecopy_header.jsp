<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>apago_header</title>
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/base.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/ui_style.css?180711">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/common.css?180604">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/layout.css?180315">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/content.css?1807172">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/colorChange.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/content_seoul.css?1805141">
<!-- 
<script type="text/javascript" src="/common/js/libs/jquery-1.11.2.js"></script>
<script type="text/javascript" src="/common/js/libs/jquery-ui-1.12.1.js"></script>
<script type="text/javascript" src="/common/js/libs/jquery.browser.check.js"></script>
<script type="text/javascript" src="/common/js/libs/modernizr.min.js?180413"></script>
<script type="text/javascript" src="/common/js/plugins.js"></script>
<script type="text/javascript" src="/common/js/ui.js?1807051"></script>
 -->
<!-- <link rel="stylesheet" href="../common/bootstrap3.3.7/css/bootstrap.min.css" />
<script src="../common/bootstrap3.3.7/jquery/jquery-3.2.1.min.js"></script> -->
</head>
<body>
	
	<!-- header -->
	<header id="header">
		<div class="inner">
			<div class="logo"><a href="<%=request.getContextPath() %>"><img src="<%=request.getContextPath() %>/resources/images/go_big.png" style="width:300px; height:60px;" alt="apago_logo" /></a></div>
			<div class="gnb">
				<ul>
					
					<!-- Before Login -->
					<li><a href="<%=request.getContextPath() %>/mybatis/login.do" class="btn-login">로그인</a></li>
					<li><a href="<%=request.getContextPath() %>/Captcha" class="btn-join">회원가입</a></li>
					<!--// Before Login -->
					
					<li>
						<div class="ui-select">
							<button type="button" class="ui-select-val"><span>KOR</span></button>
							<div class="ui-select-wrap">
								<ul class="ui-select-menu">
									<li class="current"><a href="http://www.paik.ac.kr/seoul/main.asp" target="_blank" title="새창 열기">KOR</a></li>
									<li><a href="http://www.paik.ac.kr/seoul/eng/main.asp" target="_blank" title="새창 열기">ENG</a></li>
									<li><a href="http://www.paik.ac.kr/seoul/chn/main.asp" target="_blank" title="새창 열기">CHN</a></li>
									<li><a href="http://www.paik.ac.kr/seoul/jpn/main.asp" target="_blank" title="새창 열기">JPN</a></li>
								</ul>
							</div>
						</div>
					</li>
				</ul>
			</div>
			<div class="lnb-wrap">
				<div class="lnb-allMenu">
					<button type="button" id="lnbBtnOpen">전체메뉴</button>
					<div class="lnb-allMenuSec" style="display:none;">
						<div class="inner">
							<div class="lnb-header">
								<h2 class="lnb-title">전체메뉴</h2>
								<p class="lnb-explan">서울백병원의 모든 페이지를 한눈에 보실 수 있습니다.</p>
							</div>
							<div class="lnb-body">
								<div class="row">
									<div class="col col3">
										<h3 class="lnb-sub-header">병원검색</h3>
										<div id="lnbAllMenu1" class="depth02"></div>
									</div>
									<div class="col col3">
										<h3 class="lnb-sub-header">병원예약</h3>
										<div id="lnbAllMenu2" class="depth02"></div>
									</div>
									<div class="col col6">
										<h3 class="lnb-sub-header">이벤트보러가기</h3>
										<div id="lnbAllMenu3" class="depth02"></div>
									</div>
								</div>
								<div class="row">
									<div class="col col3">
										<h3 class="lnb-sub-header">마이페이지</h3>
										<div id="lnbAllMenu4" class="depth02"></div>
									</div>
									<div class="col col6">
										<h3 class="lnb-sub-header">의학백과/실시간 진료 상담</h3>
										<div id="lnbAllMenu5" class="depth02"></div>
									</div>
									<!--
									<div class="col col3">
										<h3 class="lnb-sub-header">기타</h3>
										<div class="depth02">
											<ul>
												<li><a href="/seoul/member/agreement.asp">회원이용약관</a></li>
												<li><a href="/seoul/etc/privacy_policy.asp">개인정보처리방침</a></li>
												<li><a href="/seoul/etc/video_policy.asp">영상정보처리기기 운영&middot;관리 방침</a></li>
											</ul>
										</div>
									</div>
									-->
								</div>
							</div>
							<a href="#lnbBtnOpen" class="lnb-close"><i class="ico ico-close">닫기</i></a>
						</div>
					</div>
				</div>

				<!-- LNB -->
				<nav class="lnb">
					<ul>
						<li><a href="<%=request.getContextPath() %>/hptintro/hptintro.jsp" class="depth01">병원검색</a>
							<div class="depth02">
								<div class="inner">
									<span class="tit_depth02">예약/조회/<span class="dis_inBlock">발급</span></span>
									<ul id="lnbMenu1">
										<li><a href="https://www.paik.ac.kr/seoul/reservation/intro.asp">예약안내</a></li>
										<li><a href="https://www.paik.ac.kr/seoul/reservation/reservation.asp">온라인예약</a></li>
										<li><a href="https://www.paik.ac.kr/seoul/reservation/cancel.asp">예약조회 / 취소</a></li>
										<li><a href="/seoul/reservation/certificate.asp?tabIndex=0">증명서 발급</a>
											<ul class="depth03">
												<!--li><a href="/seoul/reservation/certificate.asp?tabIndex=0">인터넷 발급</a></li-->
												<li><a href="/seoul/reservation/certificate.asp?tabIndex=0">진단서 발급</a></li>
												<li><a href="/seoul/reservation/certificate.asp?tabIndex=1">의무기록사본 발급</a></li>
												<li><a href="/seoul/reservation/certificate.asp?tabIndex=2">의료영상자료 복사</a></li>
											</ul>
										</li>
									</ul>
									<div class="major-menu">
										<a href="https://www.paik.ac.kr/seoul/reservation/reservation.asp" class="btn16">진료예약</a>
										<a href="https://www.paik.ac.kr/seoul/reservation/cancel.asp" class="btn17">예약조회</a>
										<a href="/seoul/reservation/certificate.asp?tabIndex=0" class="btn18">증명서 발급</a>
									</div>
								</div>
							</div>
						</li>
						<li><a href="<%=request.getContextPath() %>/reserve/resList" class="depth01">병원예약</a>
							<div class="depth02">
								<div class="inner">
									<span class="tit_depth02">의료진/<span class="dis_inBlock">진료과</span></span>
									<ul id="lnbMenu2">
										<li><a href="/seoul/treatment/search.asp?tabIndex=0">의료진</a></li>
										<li><a href="/seoul/treatment/treatment_parts.asp">진료과</a></li>
										<li><a href="/seoul/treatment/center_clinic.asp?tabIndex=0">센터 / 클리닉</a>
											<ul class="depth03">
												<li><a href="/seoul/treatment/center_clinic.asp?tabIndex=0">전문진료센터</a></li>
												<li><a href="/seoul/treatment/center_clinic.asp?tabIndex=1">특수클리닉</a></li>
											</ul>
										</li>
										<li><a href="/seoul/treatment/ethics_info.asp">기타부서</a>
											<ul class="depth03">
												<li><a href="/seoul/treatment/medicaments_info.asp">약제부</a></li>
												<li><a href="http://www.e-irb.com/index.jsp?irbcd=20b237a1cb4549745266b0588a7f12a8" target="_blank">임상시험심사위원회</a></li>
												<!-- li><a href="/seoul/treatment/nurse_info.asp">간호부</a></li -->
												<!-- li><a href="/seoul/treatment/training_info.asp">교육수련부</a></li -->
											</ul>
										</li>
									</ul>
									<div class="major-menu">
										<a href="/seoul/treatment/search.asp?tabIndex=0" class="btn13">의료진</a>
										<a href="/seoul/treatment/treatment_parts.asp" class="btn14">진료과</a>
										<a href="/seoul/treatment/center_clinic.asp" class="btn15">센터 / 클리닉</a>
									</div>
								</div>
							</div>
						</li>
						<li><a href="<%=request.getContextPath() %>/point/HpointList" class="depth01">이벤트보러가기</a>
							<div class="depth02">
								<div class="inner">
									<span class="tit_depth02">이용안내</span>
									<ul id="lnbMenu3">
										<li><a href="/seoul/info/outclinic.asp">진료절차</a>
											<ul class="depth03">
												<li><a href="/seoul/info/outclinic.asp">외래진료</a></li>
												<li><a href="/seoul/info/emergency.asp">응급진료</a></li>
												<li><a href="/seoul/info/noInsurance_cost.asp">비급여진료비용</a></li>
											</ul>
										</li>
										<li><a href="/seoul/info/hospitalization_info.asp">입&middot;퇴원 안내</a></li>
										<li><a href="/seoul/info/visit.asp">병문안 안내</a></li>
										<li><a href="/seoul/info/insurance.asp">보험별 이용안내</a></li>
										<li><a href="/seoul/info/social_work.asp">의료사회사업</a></li>
										<li><a href="/seoul/info/nursing_care.asp">간호간병서비스</a></li>
										<li><a href="/seoul/info/convenient.asp">편의시설 안내</a></li>
										<li class="col-right"><a href="/seoul/info/floor.asp">층별안내</a></li>
										<li class="col-right"><a href="/seoul/info/tell_info.asp">전화번호 안내</a></li>
										<li class="col-right"><a href="/seoul/info/direction.asp">찾아오시는 길</a></li>
										<li class="col-right"><a href="/seoul/info/parking_info.asp">주차안내</a></li>
										<li class="col-right"><a href="/seoul/info/cs_center.asp">고객상담실</a></li>
									</ul>
									<div class="major-menu">
										<a href="/seoul/info/direction.asp" class="btn08">찾아오시는길</a>
										<a href="/seoul/info/floor.asp" class="btn09">층별위치안내</a>
										<a href="/seoul/info/parking_info.asp" class="btn10">주차안내</a>
									</div>
								</div>
							</div>
						</li>
						<li><a href="<%=request.getContextPath() %>/Event/EventList" class="depth01">마이페이지</a>
							<div class="depth02">
								<div class="inner">
									<span class="tit_depth02">건강정보</span>
									<ul id="lnbMenu4">
										<li><a href="/seoul/medicine/disease_info_list.asp">질병정보</a></li>
										<li><a href="/seoul/medicine/good_doctor_list.asp">굿닥터</a></li>
										<li><a href="/seoul/medicine/healthletter_list.asp">이달의 건강정보</a></li>
										<li><a href="/seoul/medicine/medicine_info_list.asp">복약정보</a></li>
										<li><a href="/seoul/medicine/nutrition_info_list.asp">영양정보</a></li>
										<li><a href="/seoul/medicine/check_info_list.asp">검사정보</a></li>
										<!--li><a href="/seoul/medicine/infection_info_list.asp">감염병정보</a></li-->
										<!--li><a href="/seoul/medicine/medical_equipment.asp">첨단장비</a></li-->
										<li><a href="/seoul/medicine/health_list.asp?tabIndex=0">건강강좌</a></li>
										<li><a href="/seoul/medicine/health_tv.asp">건강TV 동영상</a></li>
										<li><a href="/seoul/medicine/disease_pdf_list.asp">질병정보PDF</a></li>
									</ul>
									<div class="major-menu major04">
										<a href="/seoul/medicine/disease_info_list.asp" class="btn04">질병정보</a>
										<a href="/seoul/medicine/check_info_list.asp" class="btn05">검사정보</a>
										<a href="/seoul/medicine/medicine_info_list.asp" class="btn06">복약정보</a>
										<a href="/seoul/medicine/health_tv.asp" class="btn07">건강TV동영상</a>
									</div>
								</div>
							</div>
						</li>
						<li><a href="<%=request.getContextPath() %>/stats/sourcecopy_analyzer.jsp" class="depth01">의학백과/실시간 진료 상담</a>
							<div class="depth02">
								<div class="inner">
									<span class="tit_depth02">병원소개</span>
									<ul id="lnbMenu5">
										<li><a href="/seoul/intro/intro.asp">원장인사말</a></li>
										<li><a href="/seoul/intro/history.asp">병원소개</a>
											<ul class="depth03">
												<li><a href="/seoul/intro/history.asp">연혁</a></li>
												<li><a href="/seoul/intro/organization.asp">조직도</a></li>
												<li><a href="/seoul/intro/mission.asp">미션/비전/핵심가치</a></li>
												<li><a href="/seoul/intro/periodical.asp">정기간행물</a></li>
												<!--li><a href="/seoul/intro/promotion_video.asp">병원홍보동영상</a></li-->
											</ul>
										</li>
										<li class="col-right"><a href="/seoul/intro/news_list.asp">병원소식</a>
											<ul class="depth03">
												<li><a href="/seoul/intro/news_list.asp">뉴스</a></li>
												<li><a href="/seoul/intro/notice_list.asp">공지</a></li>
												<li><a href="/seoul/intro/recruit_list.asp">채용</a></li>
												<li><a href="/seoul/intro/tender_list.asp">입찰</a></li>
												<li><a href="/seoul/intro/media_list.asp">언론보도</a></li>
											</ul>
										</li>
										<!-- <li class="col-right"><a href="/seoul//">발전기금</a>
											<ul class="depth03">
												<li><a href="/seoul/intro/">발전기금운영위원회</a></li>
											</ul>
										</li> -->
										<li class="col-right"><a href="/seoul/intro/contribution_list.asp">사회공헌활동</a>
											<ul class="depth03">
												<li><a href="/seoul/intro/contribution_list.asp">의료봉사</a></li>
												<li><a href="/seoul/intro/meet_list.asp">좋은인연</a></li>
											</ul>
										</li>
										<li class="col-right"><a href="/seoul/intro/direction.asp">찾아오시는 길</a></li>
									</ul>
									<div class="major-menu">
										<a href="/seoul/intro/media_list.asp" class="btn01">언론보도</a>
										<a href="/seoul/intro/contribution_list.asp" class="btn02">사회공헌</a>
										<a href="/seoul/intro/recruit_list.asp" class="btn03">채용</a>
									</div>
								</div>
							</div>
						</li>
					</ul>
				</nav>
				<!-- //LNB -->
				<span class="lnb-line left"></span>
				<span class="lnb-line mid"></span>
				<span class="lnb-line right"></span>
				<button type="button" class="btn-srchWrap"><span class="ico ico-srch">검색</span></button>
			</div>
			<!-- 우측 바(네비게이션 바) -->
			<%-- <%@ include file="../include/quick.jsp" %> --%>
		</div>

		<div class="bg-lnb"><!-- lnb bg --></div>

		<div class="search-wrap">
			<div class="inner">
				<span class="input-search">
					<form name="searchFrm" method="post" action="/seoul/etc/search_result.asp">
					<input type="hidden" name="i_s" value="">
					<input type="text" maxlength="50" name="i_t" placeholder="검색어를 입력해주세요." title="통합검색">
					<button type="submit" class="btn-srch"><span class="ico ico-srch">검색</span></button>
					</form>
				</span>
			</div>
		</div>
	</header>

</body>
</html>