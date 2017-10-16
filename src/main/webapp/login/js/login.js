$(function(){
	$("#sub").click(function(){
		
		url = "login.do";
		params = {"username":$("#username").val(),
				  "password":$("#password").val()};
		console.log($("#username").val()+""+$("#password").val());
		$.post(url,params,function(result){
			check(result);
		})
		
	});
	
	
})
function check(result){
	console.log(1);
	if(-1!=result.indexOf("没有")){
		alert("用户名或桌号不存在")
		return false;
	}
	if(1==result.indexOf("用户名密码错误")){
		alert("用户名密码错误")
		return false;
	}
	if(1==result.indexOf("桌号密码错误")){
		alert("桌号密码错误")
		return false;
	}
	else if(1==result.indexOf("桌号登陆成功")){
		window.location.href ="js/200.jsp";
	}else if(1==result.indexOf("用户登陆成功")){
		window.location.href ="js/200-2.jsp";
	}
	
}