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
	<link rel="stylesheet" href="css/list.css" />
	<script src="js/jquery.min.js"></script>
	<script src="js/modaldialog.js"></script>
	<script>
		/**
		 * desc: 分页
		 */
		function pageQuery(pageNum) {
			//设置提交的请求参数
			$('#form1 p input[name=saccountName]').val($('#saccountName').val());
			$('#pageNum').val(pageNum);
			//提交表单
			$('#form1').get(0).submit();
		}
	
		/**
		 * desc: 添加
		 */
	    function add() {
	    	location.href = 'user/addview.do';
	    }
		
		/**
		 * desc: 修改
		 */
		function update(id) {
			$('body').append('<form id="tempForm"></form>');
			var form = $('#tempForm');
			form.attr('method', 'post');
			form.attr('action', 'user/updateview.do');
			form.append('<input type="hidden" name="id" value="' + id + '" />');
			form.get(0).submit();
		}
		
		/**
		 * desc: 删除
		 */
		function deleting(id) {
			confirm(null, "确定要删除数据?", function() {
				var saccountName = $('#form1 #saccountName').val();
				var pageNum = $('#form1 #pageNum').val();
				$('body').append('<form id="tempForm"></form>');
				var form = $('#tempForm');
				form.attr('method', 'post');
				form.attr('action', 'user/delete.do');
				form.append('<input type="hidden" name="id" value="' + id + '" />');
				form.append('<input type="hidden" name="saccountName" value="' + saccountName + '" />');
				form.append('<input type="hidden" name="pageNum" value="' + pageNum + '" />');
				form.get(0).submit();
			});
		}
		
	    /**
	     * desc: 批量删除
	     */
		function deleteBatch() {
	    	 //获得选择行的数量
	    	 var count = $('#form2 input[name="id"]:checked').length;
	    	 //判断是否未选择数据
	    	 if(count < 1) {
	    		 alert('警告', '请选择要删除的数据!');
	    		 return;
	    	 }
	    	 //弹出选择对话框
	    	 confirm(null, "确定要删除选择的数据?", function() {
	    		 var saccountName = $('#form1 #saccountName').val();
				 var pageNum = $('#form1 #pageNum').val();
				 var form =  $('#form2');
				 form.attr('action', 'user/delete.do');
				 form.append('<input type="hidden" name="saccountName" value="' + saccountName + '" />');
				 form.append('<input type="hidden" name="pageNum" value="' + pageNum + '" />');
				 form.get(0).submit();
	    	 });
		}
	</script>
</head>
<body>
	<header style="">
		<form id="form1" method="post" action="user/query.do" class="form-inline">
			<section class="form-group">
				<p><input type="text" name="saccountName" placeholder="按用户名搜索!"  value="${param.saccountName }"
					class="form-control" /></p><input type="submit" value="搜索"  class="btn btn-success"/>
					<input type="hidden" id="saccountName" value="${param.saccountName }" />
					<input type="hidden" id="pageNum" name="pageNum" value="${pageInfo.pageNum }" />
			</section>
		</form>
	</header>
	<article>
		<form id="form2" method="post" action="">
			<table class="table table-hover table-bordered">
				<tr>
					<th><input type="checkbox" /></th>
					<th>序号</th>
					<th>用户名</th>
					<th>密码</th>
					<th>身份</th>
					<th>性别</th>
					<th>注册时间</th>
					<th>操作</th>
				</tr>
				<c:forEach var="user" items="${list }" varStatus="status">
					<tr>
						<td><input type="checkbox" name="id" value="${user.accountId }" /></td>
						<td>${(pageInfo.pageNum-1)*pageInfo.pageSize + status.count }</td>
						<td>${user.accountName }</td>
						<td>${user.accountPassword }</td>
						<td>${user.crmRole.roleName }</td>
						<td>${user.accountGender }</td>
						<td><fmt:formatDate value="${user.operTime }" pattern="yyyy年MM月dd日 HH:mm:ss" /></td>
						<td>
							<a href="javascript:void(0);" onclick="update(${user.accountId})"><i class="glyphicon glyphicon-edit edit"></i>修改</a>
							<a href="javascript:void(0);" onclick="deleting(${user.accountId});"><i class="glyphicon glyphicon-remove remove"></i>删除</a>
						</td>
					</tr>
				</c:forEach>
				<c:if test="${requestScope.list.size()==0 }">
					<tr>
						<td colspan="6">未查找到数据!</td>
					</tr>
				</c:if>
			</table>
		</form>
		<section>
			<section class="btn-groups">
				<button class="btn btn-primary" onclick="add();"><i class="glyphicon glyphicon-plus"></i>&nbsp;添加</button>
				<button class="btn btn-danger" onclick="deleteBatch();"><i class="glyphicon glyphicon-trash"></i>&nbsp;批量删除</button>
			</section>
			<section class="page-info">
				共${pageInfo.total}行, 第${pageInfo.pageNum }/${pageInfo.pages<1 ? 1 : pageInfo.pages }页
			</section>
			<section class="page-bar">
				<c:forEach var="pageNum" items="${pageInfo.navigatepageNums }">
					<a href="javascript:void(0);" onclick="pageQuery(${pageNum});" 
						${pageNum==pageInfo.pageNum ? 'class="active"' : '' }>${pageNum }</a>
				</c:forEach>
			</section>
		</section>
	</article>
</body>
</html>