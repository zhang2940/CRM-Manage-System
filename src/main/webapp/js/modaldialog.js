//警告框
window.alert = function(title, message) {
	//父窗口中添加遮罩层
	$('body', parent.document).append('<div id="modal-shadow" style="position:fixed;top:0px;right:0px;'
		+ 'bottom:0px;left:0px;background-color:rgba(0,0,0,0.4);z-index:10;display:flex;align-items:center;'
		+ 'justify-content:center;"></div>');
	//获得遮罩对象
	var modalShadow = $('#modal-shadow', parent.document);
	//alert(modalShadow.height());
	//添加模态对话框
	modalShadow.append('<div style="width:400px;background-color:#FFFFFF;border-radius:3px;">'
		+ '<p style="padding:15px 0px 5px;text-indent:5px;border-bottom:solid 1px #CECECE;">' 
		+     '<i class="glyphicon glyphicon-info-sign" style="font-size:14px;color:orange;"></i> ' + (!title ? '消息' : title) + '</p>'
		+ '<p style="padding:20px 0px;text-indent:40px;">' + message + '</p>'
		+ '<p style="padding:0px 10px 15px 0px;text-align:right;"><input type="button" value="确定" class="btn btn-primary" /></p>'
		+ '</div>');
	//按钮绑定事件
	modalShadow.children('div').children('p').children('input').on('click', function() {
		$('#modal-shadow', parent.document).remove();
	});
};

//选择对话框
window.confirm = function(title, message, callback) {
	//父窗口中添加遮罩层
	$('body', parent.document).append('<div id="modal-shadow" style="position:fixed;top:0px;right:0px;'
		+ 'bottom:0px;left:0px;background-color:rgba(0,0,0,0.4);z-index:10;display:flex;align-items:center;'
		+ 'justify-content:center;"></div>');
	//获得遮罩对象
	var modalShadow = $('#modal-shadow', parent.document);
	//alert(modalShadow.height());
	//添加模态对话框
	modalShadow.append('<div style="width:400px;background-color:#FFFFFF;border-radius:3px;">'
		+ '<p style="padding:15px 0px 5px;text-indent:5px;border-bottom:solid 1px #CECECE;">' 
		+     '<i class="glyphicon glyphicon-info-sign" style="font-size:14px;color:orange;"></i> ' + (!title ? '消息' : title) + '</p>'
		+ '<p style="padding:20px 0px;text-indent:40px;">' + message + '</p>'
		+ '<p style="padding:0px 10px 15px 0px;text-align:right;"><input type="button" value="确定" class="btn btn-primary" />'
		+ '   <input type="button" value="取消" class="btn btn-default" /></p>'
		+ '</div>');
	//按钮绑定事件
	modalShadow.children('div').children('p').children('input:first-child').on('click', function() {
		//执行回调函数
		callback.call();
		//删除模态对话框
		$('#modal-shadow', parent.document).remove();
	});
	modalShadow.children('div').children('p').children('input:last-child').on('click', function() {
		$('#modal-shadow', parent.document).remove();
	});
};