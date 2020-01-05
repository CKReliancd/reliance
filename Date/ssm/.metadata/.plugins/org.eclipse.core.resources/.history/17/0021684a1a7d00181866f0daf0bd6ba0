<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

	<link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
	<link rel="stylesheet" href="${APP_PATH}/css/main.css">
	<style>
	.tree li {
        list-style-type: none;
		cursor:pointer;
	}
	table tbody tr:nth-child(odd){background:#F4F4F4;}
	table tbody td:nth-child(even){color:#C00;}
	</style>
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <div><a class="navbar-brand" style="font-size:32px;" href="#">众筹平台 - 用户维护</a></div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li style="padding-top:8px;">
				<div class="btn-group">
				  <button type="button" class="btn btn-default btn-success dropdown-toggle" data-toggle="dropdown">
					<i class="glyphicon glyphicon-user"></i>${sessionScope.loginUser.username } <span class="caret"></span>
				  </button>
					  <ul class="dropdown-menu" role="menu">
						<li><a href="#"><i class="glyphicon glyphicon-cog"></i> 个人设置</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-comment"></i> 消息</a></li>
						<li class="divider"></li>
						<li><a href="index.html"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
					  </ul>
			    </div>
			</li>
            <li style="margin-left:10px;padding-top:8px;">
				<button type="button" class="btn btn-default btn-danger">
				  <span class="glyphicon glyphicon-question-sign"></span> 帮助
				</button>
			</li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
			<div class="tree">
				<jsp:include page="/WEB-INF/jsp/common/menu.jsp"></jsp:include>
			</div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="panel panel-default">
			  <div class="panel-heading">
				<h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
			  </div>
<div class="panel-body">
<form class="form-inline" role="form" style="float:left;">
  <div class="form-group has-feedback">
    <div class="input-group">
      <div class="input-group-addon">查询条件</div>
      <input id="queryText" class="form-control has-success" type="text" placeholder="请输入查询条件">
    </div>
  </div>
  <button id="queryBtn" type="button" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询</button>
</form>
<button id="deleteBatchUser" type="button" class="btn btn-danger" style="float:right;margin-left:10px;"><i class=" glyphicon glyphicon-remove"></i> 删除</button>
<button type="button" class="btn btn-primary" style="float:right;" onclick="window.location.href='${APP_PATH}/user/toAdd.htm'"><i class="glyphicon glyphicon-plus"></i> 新增</button>
<br>
 <hr style="clear:both;">
          <div class="table-responsive">
            <table class="table  table-bordered">
              <thead>
                <tr >
                  <th width="30">#</th>
				  <th width="30"><input id="selectAllCheckbox" type="checkbox"></th>
                  <th>账号</th>
                  <th>名称</th>
                  <th>邮箱地址</th>
                  <th width="100">操作</th>
                </tr>
              </thead>
              <tbody>
           
              </tbody>
			  <tfoot>
			     <tr >
				     <td colspan="6" align="center">
						<ul class="pagination">
						
						</ul>
					 </td>
				 </tr>

			  </tfoot>
            </table>
          </div>
			  </div>
			</div>
        </div>
      </div>
    </div>
    <script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
    <script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${APP_PATH}/script/docs.min.js"></script>
	<script src="${APP_PATH}/jquery/layer/layer.js"></script>

        <script type="text/javascript">
            $(function () {
			    $(".list-group-item").click(function(){
				    if ( $(this).find("ul") ) {
						$(this).toggleClass("tree-closed");
						if ( $(this).hasClass("tree-closed") ) {
							$("ul", this).hide("fast");
						} else {
							$("ul", this).show("fast");
						}
					}
				});
			    var pageno = "${param.pageno}";
			    if(pageno==""){
			    	queryPage(1);
			    }else{
			    	queryPage(pageno);
			    }
            });
            
            var jsonObj = {
        			pageno:1,
        			pagesize:10
        	};
            
            function queryPage(pageno){
            	jsonObj.pageno = pageno;
            	var index = -1;
            	$.ajax({
            		type:"post",
            		url:"${APP_PATH}/user/queryUserByPage.do",
            		data:jsonObj,
            		beforeSend:function(){
            			index = layer.load(2, {time: 10*1000});
            			return true;
            		},
            		success:function(result){
            			
            			layer.close(index);//完成请求结果后，关掉弹层
            			
            			if (result.success) {
							//局部刷新
							var page = result.data;
							var list = page.datas;
							var content = '';
							//i 迭代的当前元素索引，  e 迭代的当前元素
							$.each(list, function(i,e){
								content+='<tr>';
								//拼串的时候，外面是"",则里面用'',如果外面是'',则里面是""
            					content+='  <td>'+(i+1)+'</td>';//序号
            					content+='  <td><input type="checkbox" id="'+e.id+'" loginacct="'+e.loginacct+'"></td>';
            					content+='  <td>'+e.loginacct+'</td>';
            					content+='  <td>'+e.username+'</td>';
            					content+='  <td>'+e.email+'</td>';
            					content+='  <td>';
            					content+='	  <button type="button" class="btn btn-success btn-xs" onclick="window.location.href=\'${APP_PATH}/user/toAssign.do?userid='+e.id+'\'"><i class=" glyphicon glyphicon-check"></i></button>';//用“/”转译'
								content+='	  <button type="button" class="btn btn-primary btn-xs" onclick="window.location.href=\'${APP_PATH}/user/toUpdate.do?pageno='+page.pageno+'&id='+e.id+'\'"><i class=" glyphicon glyphicon-pencil"></i></button>';           					
            					content+='	  <button type="button" class="btn btn-danger btn-xs" onclick="deleteUser('+e.id+',\''+e.loginacct+'\')"><i class=" glyphicon glyphicon-remove"></i></button>';
            					content+='  </td>';
            					content+='</tr>';
							});
							$("tbody").html(content);
							
							//分页条显示
							var navicontent = '';
							//当前第一页，则“上一页”的按钮不可用，class=disabled
							if (page.pageno == 1) {
								navicontent += '<li class="disabled"><a href="#">上一页</a></li>'
							
							} else {
							//不是第一页，则“上一页”的按钮是返回当前页-1， page.pageno-1
								navicontent += '<li><a onclick="queryPage('+(page.pageno-1)+')">上一页</a></li>';
							}
							
							for(var i=1; i <= page.totalno; i++){
								if (i == page.pageno) {//i等于当前页，navicontent带上小黑块  class=active
									navicontent+='<li class="active"><a onclick="queryPage('+i+')">'+i+'</a></li>';
								} else {//i不等于当前页，则不带
									navicontent+='<li><a onclick="queryPage('+i+')">'+i+'</a></li>';
								}
							}
							
							//当前页是最后一页，则"下一页"的按钮不可用，class=disabled
							if (page.pageno==page.totalno) {
								navicontent+='<li class="disabled"><a href="#">下一页</a></li>';
							} else {
							//不是第一页，则“下一页”的按钮是返回 当前页+1， page.pageno+1
								navicontent+='<li><a onclick="queryPage('+(page.pageno+1)+')">下一页</a></li>';
							}
							
							$(".pagination").html(navicontent);
						}else{
							layer.msg(result.message,{time:1000,icon:5,shift:6});
						}
            		}
            	});
            }
            
            $("#queryBtn").click(function(){
            	var queryText = $("#queryText").val();
            	jsonObj.queryText = queryText
            	queryPage(1);
            });
            
            function deleteUser(id, loginacct){
            	layer.confirm("是否确认删除【"+loginacct+"】数据？", {icon: 3, title:'提示'}, function(cindex){
    			    layer.close(cindex);
    			}, function(cindex){
    			    layer.close(cindex);
    			});
            	
            	$.ajax({
            		type:"post",
            		url:"${APP_PATH}/user/doDelete.do",
            		data:{
            			id:id
            		},
            		beforeSend:function(){
            			index = layer.load("正在删除数据",{time:10*1000});
            			return true;
            		},
            		success:function(result){
            			layer.close(index);
            			if (result.success) {//删除成功，因为删除的数据就在当前页面，不进行跳转，只需要调用queryPage()发起异步请求查询数据，进行局部刷新
            				var pageno = "${param.pageno}"; 
            			    if(pageno==""){
            			    	queryPage(1);
            			    }else{
            			    	queryPage(pageno);
            			    }
						} else {
							layer.msg(result.message,{time:1000, icon:5, shift:6});
						}
            		}
            	});
            	
            }
            
            
            $("#selectAllCheckbox").click(function(){
            	//this是个Dom对象，表示当前触发事件的对象，checkbox，".checked"表示有没有没选中的状态 true or false
            	var allCheckBoxStatus = this.checked; 
            	//$("tbody: checkbox")表示把tbody里的所有checkbox找出来,格式“$(tbody+空格+:checkbox)”
            	var checkboxArray = $("tbody :checkbox");
            	
            	$.each(checkboxArray, function(i,e){
            		//表体中复选框状态等于表头复选框的状态
            		e.checked = allCheckBoxStatus;
            	});
            });
            
            
            $("#deleteBatchUser").click(function(){
            	//获取需要删除用户id
            	var checkedBoxArray = $("tbody :checked");//把被勾选的复选框获取到
            	
            	if (checkedBoxArray.length==0) {
					layer.msg("请至少选择一个用户才能进行删除！",{time:1000, icon:5, shift:6});
					return false;
				}
             	//在循环的过程中拼串
            	var json ={};//"id=1&id=2&id=3"
            	$.each(checkedBoxArray,function(i,e){//迭代函数迭代带出来的是DOM对象
            		var userid = e.id;
            	
            		var loginacct = $(e).attr("loginacct");//$(e)表示将DOM对象转换为jquery对象
            	
            		json['userList['+i+'].id'] = userid;
            		json['userList['+i+'].loginacct'] = loginacct;
            	});
           
            	/*var ids = "";//"id=1&id=2&id=3"
            	$.each(checkedBoxArray,function(i,e){//迭代函数迭代带出来的是DOM对象
            		var userid = e.id;
            	  	//var loginacct = e.loginacct;//用户自定义属性，通过DOM对象无法获取
            		//var loginacct = $(e).attr("loginacct");//$(e)表示将DOM对象转换为jquery对象
            		if(i!=0){
            			ids+="&";
            		}
            		ids+="id="+userid;
            	});*/
            	
            	//询问是否要删除
            	layer.confirm("是否确认删除这些用户吗？", {icon: 3, title:'提示'}, function(cindex){
    			    layer.close(cindex);
    			    
    			    $.ajax({
    			    	type:"post",
    			    	url:"${APP_PATH}/user/doDeleteBatch.do",
						//ajax()函数的data属性，有两种传递参数方式：json对象，字符串 			    	
    			    	//data:{},
    			    	//data:"id=1&id=2&id=3",
    			    	data:json,
    			    	beforeSend:function(){
    			    		index = layer.load("正在删除数据",{time: 10*1000});
    			    		return true;
    			    	},
    			    	success:function(result){
    			    		layer.close(index);
    			    		if (result.success) {
								queryPage(1);
							} else {
								layer.msg(result.message, {time:1000, icon:5, shift:6});
							}
    			    	}
    			    });
    			    
    			    
    			    
    			    
    			}, function(cindex){
    			    layer.close(cindex);
    			});
            	
            	
            	
            	
            	
            	
            	
            	
            });
            
            
           
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        </script>
  </body>
</html>
    