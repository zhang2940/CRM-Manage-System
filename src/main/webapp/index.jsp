<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/index.css" />
		<script src="js/jquery.min.js"></script>
		<script>
		    //页面加载完毕后执行
			$(function() {
				//父级菜单节点绑定事件
				$('aside ul li.active').on('click', function() {
					//获得父节点ID
					var parentId = $(this).attr('id');
					//获得所有子节点
					var subNodes = $('aside ul li[data-parentId="'+parentId+'"]');
					//打开或关闭子菜单
					subNodes.slideToggle();
				});
				//标签页首页节点绑定单击事件
				$('ul.nav-tabs li').on('click', function() {
					$('ul.nav-tabs li').removeClass('active');
					$(this).addClass('active');
				});
				//子级父级节点绑定事件
				$('aside ul li[data-url]').on('click', function() {
					//获得当前子节点
					var subNode = $(this);
					//获得ID
					var id = subNode.attr("id");
					//获得URL
					var url = subNode.attr("data-url");
					//判断是否是禁用连接
					if(url == 'javascript:void(0);') {
						return;
					}
					//获得名称
					var name = subNode.children("a").text();
					//标签栏中追加标签
					//获得标签栏
					var tabs = $('ul.nav-tabs');
					//通过当前ID属性选取子元素，获得当前子节点
					var currentNode = tabs.children('li[id="'+id+'"]');
					//判断当前子元素是否不存在
					if(currentNode.length == 0) {
						//添加标签
						tabs.append('<li id="'+id+'" class="active"><a href="'+url+'" target="mainFrame">'
								+name+'</a>'+'<i class="glyphicon glyphicon-remove"></i></li>');
						//获取当前子节点
						var currentNode = tabs.children('li[id="'+id+'"]');
						//当前子节点绑定事件
						currentNode.on('click', function() {
							$('ul.nav-tabs li').removeClass('active');
							$(this).addClass('active');
						});
						//标签关闭按钮绑定事件
						currentNode.children('i').on('click', function() {
							//获得父级节点
							var parentNode = $(this).parent();
							//判断是否是激活状态
							if(parentNode.attr('class') == 'active') {
								//获得兄弟级元素
								var siblingNode = parentNode.next();
								if(siblingNode.length == 0) {
									siblingNode = parentNode.prev();
								}
								//设置激活状态
								$('ul.nav-tabs li').removeClass('active');
								siblingNode.addClass('active');
								//单击节点中超链接
								siblingNode.children('a').get(0).click();
							}
							//删除父级节点
							parentNode.remove();
						});
					}
					//清除所有子节点的激活状态
					tabs.children('li').removeClass('active');
					//当前子节点设置激活状态
					currentNode.addClass('active');
					//主页面区域显示新的网页
					mainFrame.location.href = url;
				});
			});
		</script>
	</head>
	<body>
		<header>
			<a href="logout.do" class="logout"><i class="glyphicon glyphicon-log-out" title="注销"></i></a>
			<p class="user-info"><i class="glyphicon glyphicon-user" style='${sessionScope.userInfo.accountGender=="男"  ?  "color:orange;" : "color:red;"}'></i> 
				${sessionScope.userInfo.accountName}[${sessionScope.userInfo.crmRole.roleName}]</p>
		</header>
		<aside>
			<ul class="nav nav-pills nav-stacked">
				<c:forEach var="perm" items="${sessionScope.userInfo.crmRole.crmPermissions }">
					<li ${perm.permParentId==null ? "class='active'" : ""} id="${perm.permId}" 
						data-parentId="${perm.permParentId}" ${perm.permUrl==null ? "" : "data-url=\"".concat(perm.permUrl).concat("\"")}>
					    <a href="javascript:void(0);"  target="mainFrame">${perm.permName }</a></li>
				</c:forEach>
			</ul>
		</aside>
		<section>
			<ul class="nav nav-tabs">
				<li class="active"><a href="welcome.jsp" target="mainFrame">首页</a></li>
			</ul>
		</section>
		<article>
			<iframe src="welcome.jsp" id="mainFrame" name="mainFrame" width="100%" height="100%" frameborder="0"></iframe>
		</article>
		<footer></footer>
	</body>
</html>
