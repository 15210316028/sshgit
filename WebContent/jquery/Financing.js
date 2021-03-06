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
//	$(".l").click(function() {
//		//产品页进入登陆页
//		location.href="login.jsp";
//	});
//	$(".r").click(function() {
//		//产品页进入注册页
//		location.href="regist.jsp";
//	});
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
	$.post("showGood",null,function(text){
		goods=JSON.parse(text);
		var add=[];
		$("#tc  table:gt(1)").remove();
		for(var i=0;i<goods.length;i++)
		{
			add[i]="<table border='1' class='goodTable'><tr><td rowspan='4'><img src='"+goods[i].url+"'/></td><td colspan='3'>"+goods[i].name+"</td><input type='hidden' value='"+goods[i].id+"' name='id'/></tr><tr><td>"+goods[i].yield+"</td><td>"+goods[i].time+"</td><td>"+goods[i].money+"元</td></tr><tr><td>收益率</td><td>期限</td><td>总额</td></tr><tr><td>可投金额</td><td name='surplus'>"+goods[i].surplus+"元</td><td width='100px'><div class='buy' name='buy'></div><div class='change' name='change'><input type='button' value='-' name='down'/><span name='inserv'>0</span><input type='button' value='+' name='up'/><select name='xuanze'><option selected='selected' value='100'>百元</option><option value='1000'>千元</option><option value='10000'>万元</option><option value='100000'>十万</option><option value='1000000'>百万</option><option value='10000000'>千万</option></select><div class='sure'></div></div></td></tr></table>";
			$("#tc").append(add[i]);
		}
	});
//	/*
//	 * 展出对应等级产品
//	 */
//	$("input[name='vip']").click(function() {
//		var vip=$(this).val();
//		$.post("showGood",null,function(text){
//			goods=JSON.parse(text);
//			var add=[];
//			$("#tc  table:gt(0)").remove();
//			for(var i=0;i<goods.length;i++)
//			{
//				add[i]="<table border='1' class='goodTable'><tr><td rowspan='4'><img src='"+goods[i].url+"'/></td><td colspan='3'>"+goods[i].name+"("+vip+")"+"</td></tr><tr><td>"+goods[i].yield+"</td><td>"+goods[i].time+"</td><td>"+goods[i].money+"</td></tr><tr><td>收益率</td><td>期限</td><td>总额</td></tr><tr><td>可投金额</td><td>"+goods[i].surplus+"</td><td><div class='buy'></div><div class='change'><input type='button' value='-' name='down'/><span>0</span><input type='button' value='+' name='up'/><div class='sure'></div></div></td></tr></table>";
//				$("#tc").append(add[i]);
//			}
//		});
//	});
	/*
	 * 对投资者进行判定验证
	 */
	$("[name='buy']").live('click',function(){
		var texts=$(".de").text();
		var phone=texts.substr(2,texts.length-4);
		var name=$(this).parents("table").children(":first").children(":first").text();
		var $buy=$(this);
		var $change=$(this).next();
		if(phone=="")
		{
			if(confirm("尚未登陆，请登录"))
				location.href="login.jsp";
		}
		else
		{
			$.post("vipSelect","phone="+phone,function(text){
				var person=JSON.parse(text);
				if(person==null)
				{
					if(confirm("您是非会员，请注册会员"))
						location.href="vipRegist.jsp";						
				}
				else
				{
					$buy.hide();
					$change.show();
				}		
			});
		}			
	});
	/*
	 * 会员注册和提高
	 */
	$("#vipRegists").click(function() {		
		$.post("selectPerson","idCard="+$("#idCard").val(),function(text){
			var person=JSON.parse(text);
			if(person!=null)
			{
				alert("该身份已被注册会员，请登录或重新输入");
			}
			else
				$("#vipForm").submit();
		});				
	});
	$("input[name='down']").live('click',function(){
		var inserv=$(this).next().text();
		if(inserv>0)
			inserv--;
		$(this).next().text(inserv)
	});
	$("input[name='up']").live('click',function(){
		var $inserv=$(this).prev().text();
		var $surplus=$(this).parents("td").prev().text();
		var touzi=(parseInt($inserv)+1)*($(this).next().val());
		if(touzi<$surplus)
			$inserv++;
		$(this).prev().text($inserv);
	});
	$(".sure").live('click',function(){
		var texts=$(".de").text();
		var phone=texts.substr(2,texts.length-4);
		var name=$(this).parents("table").children(":first").children(":first").text();
		var num=$(this).parent().text();
		var nums=num.substr(0,num.length-12);
		var inserv=(parseInt(nums))*(parseInt($(this).prev().val()));
		var id=$("input[name='id']").val();
		$.post("buyGood","phone="+phone+"&name="+name+"&inserv="+inserv+"&id="+id,function(text){
			if(text==null)
				alert("您未能成功购买本产品");
			else
			{
				alert(text);
				location.href="show.jsp";
			}
		});
	});
});