<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>


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
<![endif]-->

<script>
   $(function(){

      if (getCookie('Mo')!='false') {
         if(isMobile()){
            if(confirm("모바일기기로 접근하셨습니다. 모바일페이지로 이동하시겠습니까?    ")){
               location.href = "/m/seoul/";
            }else{
               setCookie('Mo', 'false', 1);
            }
         }
      }

      $("[data-img]").each(function(){
         var img =  $(this).attr("data-img");
         $(this).css("background-image","url("+img+")");
      });
      var infiniteLoop = null
         , pager = null
         , liCount = $('.img-area').find('li').length;

      if (liCount <=3) {
         infiniteLoop = false;
         pager = false;
      } else {
         infiniteLoop = true;
         pager = true;
      }

      $('.img-area .bxslider').bxSlider({
         slideWidth: 356,
         slideMargin: 6,
         controls: false,
         stopAutoOnClick: false,
         touchEnabled: false,
         moveSlides:1,
         minSlides:0,
         maxSlides:3,
         pager: pager,
         infiniteLoop: infiniteLoop
      });

      $(".news-ticker .bxslider").bxSlider({
         mode: 'vertical',
         auto: true,
         speed: 400,
         autoControls: false,
         stopAutoOnClick: false,
         controls: false,
         touchEnabled: false,
         pager: false
      });

      // bxsliderThumb('.img-area .bxslider',360,0,0,3,1);
      bxsliderThumb('.banner-slider .bxslider',267,4,0,4,1);
      bxslider('.press-box .bxslider');

   });
</script> --%>
</head>
<body>
<!-- 상단 영역 -->
<%@ include file="./include/sourcecopy_header.jsp" %>
<div class="container">

	
	<!-- 컨텐츠 영역 -->
	<div class="row">
		프론트페이지 컨텐츠 내용입니다
		<br />
		<img src="../images/inner1.jpg" width="80%" height="600px;" />
	<br /><br /><br /><br /><br />
	<br /><br /><br /><br /><br />
	<br /><br /><br /><br /><br />
	<br /><br /><br /><br /><br />
	<br /><br /><br /><br /><br />
	
	</div>
 
</div>
<%@ include file="./include/sourcecopy_bottom.jsp" %>

</body>
</html>