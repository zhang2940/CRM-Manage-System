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
	<article style="margin-top:30px;">
		<form id="form1" method="post" action="role/grant.do" class="form-inline">
			<dl>
				<dt>分配权限</dt>
				<dd><label>角色名:</label><input type="text" class="form-control input" disabled value="${role.roleName }"  />
					 <input type="hidden" name="roleId" value="${role.roleId }" /></dd>
				<dd><label style="margin-top:8px;vertical-align:top;">权限:</label><table class="table table-bordered table-hover" 
						style="display:inline-table;width:260px;">
						<c:forEach var="perm" items="${perms }">
							<tr>
								<td style="width:40px;text-align:center;"><input type="checkbox" name="id" value="${perm.permId }" 
									<c:forEach var="rp" items="${role.crmPermissions }">${rp.permId==perm.permId ? 'checked' : '' }</c:forEach> /></td>
								<td style="${perm.permOrder==null ? '' : 'text-indent:'.concat((perm.permOrder.length()/3-1)*24).concat('px') }">${perm.permName }</td>
							</tr>
						</c:forEach>
					</table></dd>
				<dd class="btn-groups"><input type="submit" value="确定" class="btn btn-primary" />
					<input type="reset" value="重置" class="btn btn-success" /> 
				</dd>
			</dl>
		</form>
	</article>
</body>
</html>