<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<link rel="stylesheet" type="text/css" href="../css/Financing.css" />
<script type="text/javascript" src="../jquery/jquery-1.8.0.min.js"></script>
<script src="../jquery/Financing.js"></script>
</head>
<body>
<div class="background">
	<div id="loginLogo"></div>
	<div class="login">
		<div class="loginImg"></div>
		<div>
			<form action="login" method="post">
				<table class="tb" >
					<tr>
							<td>账号登录</td><td><a href="#" id="loginRegist">立即注册</a></td>
					</tr>
					<tr>
						<td colspan="2"><div class="phone"></div><input type="text" placeholder="请输入账号" id="loginPhone"/></td>
					</tr>
					<tr>
						<td colspan="2"><div class="password"></div><input type="password" placeholder="请输入密码" id="loginPassword"/></td>
					</tr>
					<tr>
						<td colspan="2"><div class="password"></div><input type="text" size="10px" placeholder="请输入验证码" id="phoneCode"/><input type="button" value="获取手机验证码" style="font-size: 10px" id="achieves"/></td>
					</tr>
					<tr>
						<td colspan="2"><div id="login"></div></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>
</body>
</html>