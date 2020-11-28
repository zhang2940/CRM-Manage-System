<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<base href="${pageContext.request.contextPath}/" />
	<meta charset="UTF-8">
	<title>登录</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
	<style>
	    body {
	       font-size: 12px;
	       background-image: url("img/bg.jpg");
	       background-size: cover;
	    }
		article {
			position: relative;
			width: 420px;
			margin: 230px auto 0px;
			padding: 10px 0px 10px;
			border-radius: 3px;
			background-color: rgba(255, 255, 255, 0.8);
			box-shadow: -7px 7px 10px 5px #000000;
		}
		#form1 p {
			margin: 20px 0px;
			text-align: center;
		}
		#form1 p.title {
		    font-size: 14px;
			letter-spacing: 2px;
		}
		#form1 p input {
			width: 260px;
			height: 36px;
			box-sizing: border-box;
		}
		#form1 p input.input {
			text-indent: 10px;
			border-radius: 3px;
			border: solid 1px #CECECE;
			outline: none; /* 清除外边线 */
		}
		#form1 p input.input:focus {
			border: solid 1px #4F94CD;
		}
		#form1 p input.btn {
		    font-size: 12px;
		    letter-spacing: 2px;
			color: #FFFFFF;
			background-color: #1874CD;
			cursor: pointer;
		}
		#form1 p input.btn:hover {
			background-color: #4F94CD;
		}
		#form1 p.error {
			margin: 0px;
			color: red;
		}
	</style>
</head>
<body>
	<article>
		<form id="form1" method="post" action="login.do">
			<p class="title">用户登录</p>
			<p><input type="text" name="account" autofocus required placeholder="帐号/邮箱/手机号" value="${param.account }" class="input" /></p>
			<p><input type="password" name="password" required placeholder="密码" value="${param.password }" class="input"></p>
			<p class="error">${requestScope.error }</p>
			<p><input type="submit" value="登录" class="btn" /></p>
		</form>
	</article>
</body>
</html>