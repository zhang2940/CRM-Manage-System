<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<base href="${pageContext.request.contextPath}/" />
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="css/input.css" />
	<script src="js/jquery.min.js"></script>
</head>
<body>
	<header>
		<a href="javascript:history.back()"><i class="glyphicon glyphicon-chevron-left" title="返回"></i></a>
	</header>
	<article>
		<form id="form1" method="post" action="role/update.do" class="form-inline">
			<dl>
				<dt>修改角色</dt>
				<dd><label>角色名:</label><input type="text" id="roleName" name="roleName"
					 required autofocus class="form-control input" value="${role.roleName }" />
					 <input type="hidden" name="roleId" value="${role.roleId }" /></dd>
				<dd class="btn-groups"><input type="submit" value="确定" class="btn btn-primary" />
					<input type="reset" value="重置" class="btn btn-success" /> 
				</dd>
			</dl>
		</form>
	</article>
</body>
</html>