<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>密码错误！</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style type="text/css">
		body {
			background: url(./picture/bg/errorFace_bg.png);
			background-repeat: no-repeat;
			background-size: 100% 100%;
			background-attachment: fixed;
		}
	</style>
	
	
	<script type="text/javascript">
		setInterval("setTime()",1000);
		
		var i = 5;
		function setTime() {
			i--;
			document.getElementById("time").innerText = i;
			if(i==0) {
			location.href = "../Bridge";	
			}
		}	
	</script>
	

  </head>
  
  <body>
  		<font color="#6237A4" size="30">
    		${sessionScope.errInf}
    	</font>
    	<br>
    	<span id="time" style="color: red; font-size: 20">5</span>秒之后，跳转到登录页面
  </body>
</html>