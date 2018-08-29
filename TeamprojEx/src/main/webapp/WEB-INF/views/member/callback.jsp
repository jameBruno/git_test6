<%@page import="org.json.simple.parser.ParseException"%>  
<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>네이버로그인</title>
    <!-- 
	<script>
$(document).ready(function(){
	$.ajax({
		url : "../NaverCheck.json",//"시도를 받아서 DAO호출할 파일"
		type : "get",
		data : {
			access_token : $("#sido option:selected").val()
		},
		dataType : "json",
		contentType : "text/html; charset:utf-8",
		success : function(d){
			//alert("성공"+d);
			var optionStr = "";
			optionStr += "<option value=''>";
			optionStr += "-구/군을 선택하세요-";
			optionStr += "</option>";
			
			$('#gugun').html(optionStr);
		},
		error : function(e){
			//alert("실패"+e.status+e.statusText);
		}
	});
});
</script>
--> 
  </head>
  <body>
  <%
    String clientId = "AZk2SWQ3d_Adr28suG1r";//애플리케이션 클라이언트 아이디값";
    String clientSecret = "A8BQcreUvO";//애플리케이션 클라이언트 시크릿값";
    String code = request.getParameter("code");
    String state = request.getParameter("state");
    String redirectURI = URLEncoder.encode("http://localhost:8080/git_test2/member/login.jsp", "UTF-8");
    String apiURL;
    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
    apiURL += "client_id=" + clientId;
    apiURL += "&client_secret=" + clientSecret;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&code=" + code;
    apiURL += "&state=" + state;
    String access_token = "";
    String refresh_token = "";
    System.out.println("apiURL="+apiURL);
    StringBuffer res = new StringBuffer();
    String apiResult = null;
    try {
      URL url = new URL(apiURL);
      HttpURLConnection con = (HttpURLConnection)url.openConnection();
      con.setRequestMethod("GET");
      int responseCode = con.getResponseCode();
      BufferedReader br;
      System.out.print("responseCode="+responseCode);
      if(responseCode==200) { // 정상 호출
        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
      } else {  // 에러 발생
        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
      }
      String inputLine;
      //StringBuffer res = new StringBuffer();
      while ((inputLine = br.readLine()) != null) {
        res.append(inputLine);
      }
      br.close();
      if(responseCode==200) {
        out.println(res.toString());
      }
    } catch (Exception e) {
      System.out.println(e);
    }
	     
    apiResult = res.toString();
    System.out.println(apiResult);
    
	JSONParser parser = new JSONParser();
	Object obj = null;
	try {
		obj = parser.parse(apiResult);
	} catch (ParseException e) {
		
		e.printStackTrace();
	} 
	
	JSONObject jsonobj = (JSONObject) obj;

	String token = (String) jsonobj.get("access_token");
        
	session.setAttribute("token", token);
      
    response.sendRedirect("../NaverCheck.json"); 
    
  %>
  </body>
</html>