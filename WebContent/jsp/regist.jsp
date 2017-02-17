<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link rel="stylesheet" type="text/css" href="../css/Financing.css" />
<script type="text/javascript" src="../jquery/jquery-1.8.0.min.js"></script>
<script src="../jquery/Financing.js"></script>
</head>
<body>
<div class="background">
	<div id="registLogo"></div>
	<div class="regist">
		<form action="regist" method="post" id="form">
			<table class="ta">
				<tr>
					<td>账号注册</td><td><a href="#" id="registLogin">已有账号请登录</a></td>
				</tr>
				<tr>
					<td><div class="phone"></div>手机号</td><td><input type="text" placeHolder="请输入手机号" id="registPhone" name="user.phone"/><div id="phone" class="valiable"></div></td>
				</tr>
				<tr>
					<td><div class="password"></div>密码</td><td><input type="password" id="registPassword" placeHolder="输入密码" name="user.password"/><div id="password" class="valiable"></div></td>
				</tr>
				<tr>
					<td><div class="password"></div>验证码</td><td><input type="text" size="12px" id="setCode" placeHolder="输入验证码"/><input type="button" id="getCode"/><div id="code" class="valiable"></div></td>
				</tr>
				<tr>
					<td style="font-size: 15px;width: 200px"><input type="checkbox" class="check" name="check"/>我同意《协议》</td><td><div id="regists"></div></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>