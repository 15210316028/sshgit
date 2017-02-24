<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示</title>
<link rel="stylesheet" type="text/css" href="../css/Financing.css" />
<script type="text/javascript" src="../jquery/jquery-1.8.0.min.js"></script>
 <script src="../jquery/Financing.js"></script>
</head>
<body id="tc">
<c:if test="${user!=null}" scope="session" var="n">
<span class="de">欢迎${user.phone}登陆</span>
</c:if>
</body>
</html>