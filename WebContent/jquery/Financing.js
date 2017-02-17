/**
 * 
 */
var code="";
$(document).ready(function() {
	getCode();
	$("#registLogin").click(function() {
		//账号注册页直接进入账号登录页
		location.href="login.jsp";
	});
	$("#loginRegist").click(function() {
		//账号登录页进入注册页
		location.href="regist.jsp";
	});
	/*
	 * 注册手机号失去焦点事件
	 */
	$("#registPhone").blur(function() {
		registPhone();
	});
	/*
	 * 注册手机号验证
	 */
	function registPhone() {
		var reg=/^[0-9]{11}$/;
		if($("#registPhone").val().length==0)
		{
			$("#phone").html("手机号不能为空");
			return false;
		}			
		else if(!$("#registPhone").val().match(reg))
		{
			$("#phone").html("格式有误，11位有效数字");
			return false;
		}	
		else
		{
			$("#phone").html("");
			return true;
		}			
	}
	/*
	 * 注册密码失去焦点事件
	 */	
	$("#registPassword").blur(function() {
		registPassword();
	});
	/*
	 * 注册密码验证
	 */
	function registPassword() {
		var reg=/^[0-9a-z]{6,10}$/;
		if($("#registPassword").val().length==0)
		{
			$("#password").html("密码不能为空");
			return false;
		}			
		else if(!$("#registPassword").val().match(reg))
		{
			$("#password").html("格式有误，6-10位字母、数字组合");
			return false;
		}			
		else
		{
			$("#password").html("");
			return true;
		}			
	}
	/*
	 * 获取验证码
	 */
	function getCode() {
		code="";
		var random=[0,0,0,0];
		for(var i=0;i<random.length;i++)
		{			
			random[i]=Math.floor(Math.random()*10);		
			code+=random[i];
		}
		$("#getCode").val(code);
	}
	/*
	 * 验证码失去焦点事件
	 */
	$("#setCode").blur(function() {
		setCode();
	});
	/*
	 * 验证码验证
	 */
	function setCode() {
		if($("#setCode").val().length==0)
		{
			$("#code").html("验证码不能为空");
			return false;
		}			
		else if($("#setCode").val()!=code)
		{
			$("#code").html("验证码错误，重新输入");
			//验证码重新获取
			getCode();
			//验证码输入清空
			$("#setCode").val("");
			return false;
		}			
		else
		{
			$("#code").html("");
			return true;
		}			
	}
	/*
	 * 账号注册提交验证
	 */
	$("#regists").click(function() {
		if(registPhone()&&registPassword()&&setCode()&&$("input[name='check']").is(":checked"))
		{
			$.post("registSelect","registPhone="+$("#registPhone").val(),function(text){
				var user=JSON.parse(text);
				if(user!=null)
				{
					alert("该用户已存在，重新注册");
					getCode();
					$("#setCode").val("");	
				}					
				else
					$("#form").submit();
			});
		}
		else
		{
			alert("注册信息有误，重新注册");
			getCode();
			$("#setCode").val("");
		}
	});
	/*
	 * 登录手机号失去焦点事件
	 */
	$("#loginPhone").blur(function() {
		loginPhone();
	});
	/*
	 * 登录手机号验证
	 */
	function loginPhone() {
		var reg=/^[0-9]{11}$/;
		if($("#loginPhone").val().length==0)
		{
			return false;
		}			
		else if(!$("#loginPhone").val().match(reg))
		{
			return false;
		}	
		else
		{
			return true;
		}			
	}
	/*
	 * 登录密码失去焦点事件
	 */	
	$("#loginPassword").blur(function() {
		loginPassword();
	});
	/*
	 * 登录密码验证
	 */
	function loginPassword() {
		var reg=/^[0-9a-z]{6,10}$/;
		if($("#loginPassword").val().length==0)
		{
			return false;
		}			
		else if(!$("#loginPassword").val().match(reg))
		{
			return false;
		}			
		else
		{
			return true;
		}			
	}
	/*
	 * 获取手机验证码
	 */	
	var phoneCodes="";
		$("#achieves").on('click',function() {
			$.post("getPhoneCode",null,function(text){							
				if(text==null)
					alert("获取手机验证码失败");
				else
				{
					phoneCodes=text;
					alert("六位手机验证码："+phoneCodes);
				}					
			});
		});
		/*
		 * 手机验证码失去焦点事件
		 */
		$("#phoneCode").blur(function() {
			phoneCode();
		});
		function phoneCode()
		{
			if($("#phoneCode").val().length==0)
			{
				return false;
			}
			else if($("#phoneCode").val().match(phoneCodes))
			{
				return false;
			}
			else
			{
				return true;
			}			
		}
		/*
		 * 登陆验证
		 */
	$("#login").click(function() {
		if(loginPhone()&&loginPassword()&&phoneCode())
		{
			$.post("loginSelect","loginPhone="+$("#loginPhone").val()+"&loginPassword="+$("#loginPassword").val(),function(text){
				var user=JSON.parse(text);
				if(user==null)
					alert("账号、密码错误或该用户不存在，重新登陆或注册");
				else
					location.href="show.jsp";
			});
		}
		else
			alert("信息格式有误，重新登陆");
	});
	/*
	 * 产品展出
	 */
	var goods=[];
	$.post("showGood","kind=vip1",function(text){
		goods=JSON.parse(text);
		var add=[];
		$("#tc  table:gt(1)").remove();
		for(var i=0;i<goods.length;i++)
		{
			add[i]="<table border='1' class='goodTable'><tr><td rowspan='4'><img src='"+goods[i].url+"'/></td><td colspan='3'>"+goods[i].name+"(vip1)"+"</td></tr><tr><td>"+goods[i].yield+"</td><td>"+goods[i].time+"</td><td>"+goods[i].money+"</td></tr><tr><td>收益率</td><td>期限</td><td>总额</td></tr><tr><td>可投金额</td><td>"+goods[i].surplus+"</td><td><div class='buy'></div><div class='change'><input type='button' value='-' name='down'/><span>0</span><input type='button' value='+' name='up'/><div class='sure'></div></div></td></tr></table>";
			$("#tc").append(add[i]);
		}
	});
	/*
	 * 展出对应等级产品
	 */
	$("input[name='vip']").click(function() {
		var vip=$(this).val();
		$.post("showGood","kind="+vip,function(text){
			goods=JSON.parse(text);
			var add=[];
			$("#tc  table:gt(0)").remove();
			for(var i=0;i<goods.length;i++)
			{
				add[i]="<table border='1' class='goodTable'><tr><td rowspan='4'><img src='"+goods[i].url+"'/></td><td colspan='3'>"+goods[i].name+"("+vip+")"+"</td></tr><tr><td>"+goods[i].yield+"</td><td>"+goods[i].time+"</td><td>"+goods[i].money+"</td></tr><tr><td>收益率</td><td>期限</td><td>总额</td></tr><tr><td>可投金额</td><td>"+goods[i].surplus+"</td><td><div class='buy'></div><div class='change'><input type='button' value='-' name='down'/><span>0</span><input type='button' value='+' name='up'/><div class='sure'></div></div></td></tr></table>";
				$("#tc").append(add[i]);
			}
		});
	});
	/*
	 * 对投资者进行判定验证
	 */
	$(".buy").live('click',function(){
		var rode=$(this).parents("table").children(":first").children(":first").text();
		var goodVip=rode.substr(5,rode.length-6);
		var vip=$(".de").text();
		var userVip=vip.substr(17,vip.length-20);
		if(userVip=="")
		{
			if(confirm("尚未登陆，请登录")==true)
				location.href="login.jsp";
		}
		else if(userVip==0)
		{
			if(confirm("您是非会员，请注册会员")==true)
				location.href="vipRegist.jsp";
		}
		else if(userVip<goodVip)
		{
			if(confirm("会员等级较低，无权购买本商品，请提高等级")==true)
				location.href="vipRegist.jsp";
		}			
		else
		{
			$(this).hide();
			$(this).next().show();
		}			
	});
	/*
	 * 会员注册和提高
	 */
	$("#vipRegists").click(function() {
		if($("#vipMoney").val()<=1000)
			alert("输入金额不合法");
		else
		{
			 $.post("vipRegist","user.money="+$("#vipMoney").val(),function(text){
				$("#vipForm").submit();
			 });
		}		
	});
	$("input[name='down']").live('click',function(){
		var inserv=$(this).next().text();
		if(inserv>0)
			inserv--;
		$(this).next().text(inserv)
	});
	$("input[name='up']").live('click',function(){
		var inserv=$(this).prev().text();
		var surplus=$(this).parents("td").prev().text();
		if(inserv<surplus)
			inserv++;
		$(this).prev().text(inserv);
	});
	/*$(".sure").live('click',function(){
		var inserv=$(this).prev().prev().text();
		var text=$(".de").text();
		var phone=text.substr(2,text.length-10);
		var texts=$(this).parents("table").children(":first").children(":first").text();
		var name=texts.substr(0,texts.length-6);
		$.post("buyGood","phone="+phone+"&name="+name+"&inserv="+inserv,function(text){
			goods=JSON.parse(text);
			var add=[];
			$("#tc  table:gt(0)").remove();
			for(var i=0;i<goods.length;i++)
			{
				add[i]="<table border='1'><tr><td colspan='3'>"+goods[i].name+"("+vip+")"+"</td></tr><tr><td>"+goods[i].yield+"</td><td>"+goods[i].time+"</td><td>"+goods[i].money+"</td></tr><tr><td>收益率</td><td>期限</td><td>总额</td></tr><tr><td>可投金额</td><td>"+goods[i].surplus+"</td><td><div class='buy'></div><div class='change'><input type='button' value='-' name='down'/><span>0</span><input type='button' value='+' name='up'/><div class='sure'></div></div></td></tr></table>";
				$("#tc").append(add[i]);
			}
		});
	});*/
});