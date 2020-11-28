<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		<form id="form1" method="post" action="user/update.do" class="form-inline">
			<dl>
				<dt>修改用户</dt>
				<dd><label>用户名:</label><input type="text" id="accountName" name="accountName" value="${account.accountName }"
					 required autofocus class="form-control input" />
					 <input type="hidden" name="accountId" value="${account.accountId }" /></dd>
				<dd><label>密码:</label><input type="text" id="accountPassword" name="accountPassword" value="${account.accountPassword }"
					 required autofocus class="form-control input" /></dd>
					
				<dd><label>身份:</label>
				<c:forEach var="crmRole" items="${roles }">
							<tr>
								<td style="width:40px;text-align:center;">
								 	<input type="radio" name="crmRole.roleId" id = "${crmRole.roleId }" ${crmRole.roleId==account.crmRole.roleId ? 'checked' : '' } value="${crmRole.roleId }" />
								</td>
								<td >${crmRole.roleName }</td>
							</tr>
				</c:forEach>
				</dd>
				<dd><label>性别:</label>
					<input type="radio" id="accountGender" name="accountGender" value="男" ${account.accountGender=="男" ? 'checked' : '' } />男
					<input type="radio" id="accountGender" name="accountGender" value="女" ${account.accountGender=="女" ? 'checked' : '' }/>女
				</dd>
				<dd class="btn-groups"><input type="submit" value="确定" class="btn btn-primary" />
					<input type="reset" value="重置" class="btn btn-success" /> 
				</dd>
			</dl>
		</form>
	</article>
</body>
</html>