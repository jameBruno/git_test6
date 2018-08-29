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
<script type="text/javascript">
    var newName, n=0;

    function newWindow(value)
    {
       n = n + 1;
       newName = value + n;     
    }

	//한번에 2개의 창을 띄워서 서로 상담이 가능하도록 했다.
    function MyOpenWindow()
    {
        newWindow("MyWindow");
        window.open("../chat", newName, 
         "width=1050,height=800,toolbar=no,location=no,status=no," +

         "menubar=no,scrollbars=yes,resizable=yes,left=200,top=50");
    }
</script>   
<body>
	<aside id="aside">
	     <!-- snb wrap -->
	      <div class="snb-wrap">
	      <h2 class="tit-snb">의학백과/웹채팅</h2>
	      <nav class="snb">
	         <ul style="text-align:left;">
	            <li>
	               <a href="#" class="depth1">의학백과</a>
	            </li>
	            <li>
	               <a href="../chat" class="depth1" target="_blank" onclick="return MyOpenWindow();">실시간진료상담</a>
	            </li>
	         </ul>
	      </nav>
	   </div>
	</aside>
</body>
</html>