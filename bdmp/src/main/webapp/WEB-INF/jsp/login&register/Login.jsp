<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="/bdmp/css/register.css"  />
<link rel="stylesheet" type="text/css" href="/bdmp/webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>

<body>
 
	<div class="container" style="margin-left: -30px">
		<div class="header">
			<a target="_self "> <img
				src="" style="background:black">
			</a>
		</div>
		<div class="wrapper">
			<div>
				<h1>登录</h1>
			</div>
			<form action="" method="post" modelAttribute="Admin" class="col-sm-9">
				<div class="registry2">
					<div>
						<label>账号</label> <input type="text" name="email" id="you">
					</div>

					<div>
						<label>密码</label> <input type="password" name="password"
							class="shou" >
					</div>
					<div style="margin: 15px 5px 15px;">
						<input name="state" type="checkbox" checked="checked" id="state"><a
							class="remember" style="text-decoration: none">下次自动登录</a>|<a
							href=" " class="ru" style="text-decoration: none">忘记密码了</a>
					</div>
					<div>
						<input type="submit" name="" id="" value="登录" class="zhu2" />
					</div>
				</div>
			</form>

			<form  class="col-sm-3"
				style="margin-top: 10px">
				<a class="yi" style="text-decoration: none">还没有思特奇帐号？ </a> <a
					href=" " class="ru" style="text-decoration: none">立即注册</a>

			</form>
		</div>
	</div>
</body>

</html>