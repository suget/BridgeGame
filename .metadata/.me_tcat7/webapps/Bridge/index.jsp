<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/index.css">

	<script type="text/javascript">
		var code; //在全局定义验证码
		
		//产生验证码
		function createVerCode(){
		    code = "";
		    var codeLength = 4;//验证码的长度
		    var checkCode = document.getElementById("code");
		    var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R', 'S','T','U','V','W','X','Y','Z');//随机数
		    
		    for(var i = 0; i < codeLength; i++) {//循环操作  
		        var index = Math.floor(Math.random()*36);//取得随机数的索引（0~35）  
		        code += random[index];//根据索引取得随机数加到code上  
		    }
		    checkCode.value = code;//把code值赋给验证码 
		}
		
		function check() {
			var userName = document.getElementById("user_name").value;   // 获取输入框中的用户名
			var userPWD = document.getElementById("user_pwd").value; // 获取输入框中的密码
			var userCode = document.getElementById("verification_code");  // 获取输入框中的验证码
			var checkCode = document.getElementById("code");
			
			//-- 验证用户名
			if(userName == "") {
				alert("用户名不存在！");
				return false;
			}
			
			//-- 验证密码
			if(userPWD == "") {
				alert("密码不能为空！");
				return false;
			}
			
			//-- 验证验证码
			if(checkCode.value.length == 5) {
				alert("尚未获取验证码！");
				userCode.value = "";
				createVerCode();
				return false;
			}
			
			if(userCode.value != checkCode.value) {
				alert("验证码错误!");
				userCode.value = "";
				createVerCode();
				return false;
			}
			
			return true;
		}
		
		/* 获取HTML标签对象*/
		function getObject(id) {
			return document.getElementById(id);
		}
		
	</script>
  </head>
  
  <body>
    <form action="check" method="post" id="myForm" name="myForm" onsubmit="return check()" autocomplete="off">
    <div align="center">
    	<table height="500px">
    		<tr>
    			<th colspan="3" align="center"> <font class="title">欢迎登录桥牌叫牌练习网站</font> </th>
    		</tr>
    		<tr height="150px">
    		</tr>
    		<tr class="line">
    			<td align="right" class="load_font">用户名：</td>
				<td align="center" width="30px"> <input type="text" id="user_name" name="user_name" maxlength="20" onBlur="validateUserName()"> </td>
				<td align="left" class="load_font">(1~20位字符)</td>
    		</tr>
    		<tr class="line">
    			<td align="right" class="load_font">密码：</td>
				<td align="center" width="30px"> <input type="password" id="user_pwd" name="user_pwd" maxlength="20"> </td>
				<td align="left" class="load_font">(1~20位字符)</td>
    		</tr>
    		<tr class="line">
    			<td align="right" class="load_font">验证码：</td>
    			<td align="center" width="30px"> <input type="text" id="verification_code" name="verification_code" maxlength="4"> </td>
    			<td align="left"> <input type="button" id="code" value="获取验证码" onclick="createVerCode()"> </td>
    		</tr>
    		<tr height="40px" >
    			<td colspan="2" align="right">
    				<input type="submit" value="登录" class="upload" /> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    				<input type="reset" value="重置" class="upload" />
    			</td>
    		</tr>
    	</table>
    </div>
    </form>
  </body>
</html>