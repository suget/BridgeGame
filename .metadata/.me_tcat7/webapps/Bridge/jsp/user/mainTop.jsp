<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'mainTop.jsp' starting page</title>

  </head>
  
  <body>
  
  	<div id="inf" style="position: absolute; width: 1260px; height: 70px;">
	  	<div class="inf" id="webInf" style="position: absolute; left: 0px; top: 0px">
	  		<label style="font: italic; font-family: cursive; font-size: 35px; color: blue; background-color: fuchsia;">桥牌叫牌练习网站</label>
	  	</div>
	  	
	  	<div class="inf" id="userInf">
	  		<label id="label_userInf">${sessionScope.nowUser.getName()}，你好</label>
	  	</div>
	  	
	  	<div class="inf" id="toolInf" style="position: absolute; left: 0px; bottom: 0px;">
	  		<a href="jsp/user/mainBottom.jsp" target="bottom"><label style="font: italic; font-family: cursive; font-size: 25px; color: purple; background-color: threedshadow;">首页</label></a>
	  	</div>
	 </div>
	 
  </body>
  
</html>