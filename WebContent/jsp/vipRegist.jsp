<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员注册和提高</title>
<link rel="stylesheet" type="text/css" href="../css/Financing.css" />
<script type="text/javascript" src="../jquery/jquery-1.8.0.min.js"></script>
<script src="../jquery/Financing.js"></script>
</head>
<body>
<div class="background">
	<div class="regist">
		<form action="vipRegist" method="post" id="vipForm">
			<table class="ta">
				<tr>
					<td colspan="2">会员注册</td>
				</tr>
				<tr>
					<td><div class="phone"></div>身份证号</td><td><input type="text" placeHolder="输入银行卡号" name="person.idCard" id="idCard"/></td>
				</tr>
				<tr>
					<td><div class="phone"></div>姓名</td><td><input type="text" placeHolder="输入姓名" name="person.name"/></td>
				</tr>
				<tr>
					<td><div class="phone"></div>手机号</td><td><input type="text" placeHolder="输入银行预留手机号" name="person.phone"/></td>
				</tr>
				<tr>
					<td><div class="phone"></div>银行卡种类</td><td><input type="text" placeHolder="输入银行卡种类" name="person.carKind"/></td>
				</tr>
				<tr>
					<td><div class="phone"></div>银行卡号</td><td><input type="text" placeHolder="输入银行卡号" name="person.carNum"/></td>
				</tr>
				<tr>
					<td style="font-size: 15px;width: 200px"><input type="checkbox" class="check" name="check"/>我同意《协议》</td><td><div id="vipRegists"></div></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>