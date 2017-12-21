<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="base/base.jsp" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
		<!-- bootstrap 3.0.2 -->
		<link href="${ctx}/static/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<!-- font Awesome -->
		<link href="${ctx}/static/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
		<!-- Theme style -->
		<link href="${ctx}/static/css/AdminLTE.css" rel="stylesheet" type="text/css" />
		<title>课堂帮登录</title>
		<script type="text/javascript" src="${ctx}/static/js/plugins/particles/particles.min.js"></script>
		<link rel="stylesheet" href="${ctx}/static/css/login.css" />
	      <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
	</head>

	<body>
		<div id="particles-js">
		</div>
		<div class="form-box" id="login-box">
			<div class="header">课堂帮系统登录</div>
			<form action="" method="post">
				<div class="body bg-gray">
				
					<div class="form-group">
						<label class="control-label error-label" for="inputError2">${error}</label>
						<input type="email" name="email" value="<shiro:principal/>" class="form-control" placeholder="输入邮箱" />
					</div>
					<div class="form-group">
						<input type="password" name="password" class="form-control" placeholder="输入密码" />
					</div>
					<div class="form-group">
						<input type="text" name="jcaptchaCode" class="form-control" placeholder="输入验证码" />
					</div>

					<div class="form-group">
						 <img class="jcaptcha-btn jcaptcha-img" src="${ctx}/jcaptcha.jpg" title="点击更换验证码">  
                         <a class="jcaptcha-btn" href="javascript:;">换一张</a>  
					</div>
					<div class="form-group">
						<input type="checkbox" name="rememberMe" value="true">记住我
					</div>
				</div>
				<div class="footer">
					<input type="submit" class="btn bg-olive btn-block" value="登录"/>
					<p>
						<a href="#">忘记密码?</a>

						<a href="#" class="pull-right">点我注册</a>
					</p>
				</div>
			</form>

			<!--
          	
         <div class="margin text-center">
                <span>Sign in using social networks</span>
                <br/>
                <button class="btn bg-light-blue btn-circle"><i class="fa fa-facebook"></i></button>
                <button class="btn bg-aqua btn-circle"><i class="fa fa-twitter"></i></button>
                <button class="btn bg-red btn-circle"><i class="fa fa-google-plus"></i></button>

            </div> -->
		</div>

	</body>
	<!-- Bootstrap -->
	<script src="${ctx}/static/js/bootstrap.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="${ctx}/static/js/plugins/particles/particlesJsConfig.js"></script>
    <script>
    //更换验证码
    $(function() {
        $(".jcaptcha-btn").click(function() {
            $(".jcaptcha-img").attr("src", '${pageContext.request.contextPath}/jcaptcha.jpg?'+new Date().getTime());
        });
    });
</script>
</html>

