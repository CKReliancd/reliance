<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>组织机构</title>
</head>
<body>

<table id="ifk" class="easyui-treegrid" style="width:100%;height:100%" 
data-options="url:'getOrganizationList.do',idField:'id',treeField:'name',rownumbers:'true'">   
 	<div>
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">新增</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="edit()">编辑</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="remove()">删除</a>
		
	</div>
  	<thead>   
        <tr>  
            <th data-options="field:'name',width:200,sortable:'true'">机构名称</th>   
            <th data-options="field:'type',width:60,align:'right'">机构类型</th>   
            <th data-options="field:'code',width:120">机构编码</th>   
            <th data-options="field:'principalId',width:80">负责人</th> 
            <th data-options="field:'address',width:80">地址</th>  
            <th data-options="field:'phone',width:80">电话号码</th>  
            <th data-options="field:'postCode',width:80">邮政编码</th>  
            <th data-options="field:'fax',width:80">传真号</th>  
            <th data-options="field:'createTime',width:80">创建时间</th>  
            <th data-options="field:'modifyTime',width:180">修改时间</th> 
        </tr>   
   	</thead>   
</table>
 
<div id="addDlg" class="easyui-dialog" title="机构详细信息" style="width:400px;height:450px;"
	closed="true" data-options="iconCls:'icon-save',resizable:true,modal:true,buttons:'#bb'">
	
	   <div style="padding-left:60px;padding-top:10px">	
			
			<form id="ffAddOrg" class="easyui-form" method="post" data-options="novalidate:true">
				<table>
					<tr>
						<td>上级机构</td>
						<td>
							<select id="parentId" class="easyui-combobox" name="parentId" style="width:200px;" data-options="">   
     							<option value="请选择">请选择</option>  
								<c:forEach items="${sessionScope.parentName}" var="i" >
								
									<option value="1">${i}</option> 
	     						</c:forEach>
							</select> 
						</td>
					</tr>
					
					<tr>
						<td>机构类型</td>
						<td>
							<select id="type" class="easyui-combobox" name="type" style="width:200px;">   
							    <option value="请选择">请选择</option>   
							    <option value="0">总公司</option>   
							    <option value="1">分公司</option>   
							</select> 
						</td>
					</tr>
					<tr>
						<td>负责人</td>
						<td><input id="principalId" name="principalId" class="easyui-textbox" data-options="" style="width:200px"/></td>
					</tr>
					<tr>
						<td>机构名称</td>
						<td><input id="name" name="name" class="easyui-textbox" data-options="" style="width:200px"/></td>
					</tr>
					<tr>
						<td>地址</td>
						<td><input id="address" name="address" class="easyui-textbox" data-options="" style="width:200px"/></td>
					</tr>
					<tr>
						<td>电话号码</td>
						<td><input id="phone" name="phone" class="easyui-textbox" data-options="" style="width:200px"/></td>
					</tr>
					<tr>
						<td>邮政编码</td>
						<td><input id="postCode" name="postCode" class="easyui-textbox" data-options="" style="width:200px"/></td>
					</tr>
					<tr>
						<td>传真号</td>
						<td><input id="fax" name="fax" class="easyui-textbox" data-options="" style="width:200px"/></td>
					</tr>
				</table>
	    </form>

	</div>
</div>
<div id="bb">
    <a href="#" class="easyui-linkbutton" onclick="saveAttr()">保存</a>
    <a href="#" class="easyui-linkbutton" onclick="closeAttr()">关闭</a>
</div>
<script src="${APP_PATH }/jquery/jquery-2.1.1.min.js"></script>
<script src="${APP_PATH }/bootstrap/js/bootstrap.min.js"></script>
<script src="${APP_PATH }/script/docs.min.js"></script>
<script src="${APP_PATH }/jquery/layer/layer.js"></script>
<script language="JavaScript">
	
	function add(){
		
		$("#addDlg").dialog("open");
	}
	function edit(){
		
	}
	function remove(){
		
	}

/* 	function saveAttr(){
		$.ajax({
			type:"post",
			url:"${APP_PATH}/doAdd.do",
			data:{
				parentId:$("#parentId").combobox("getValue"),
				type:$("#type").combobox("getValue"),
				principalId:$("#principalId").val(),
				name:$("#name").val();
				address:$("#address").val();
				phone:$("#phone").val();
				postCode:$("#postCode").val();
				fax:$("#fax").val();
			},
			
    		success:function(result){
    			if(result.success){
    				window.location.href="${APP_PATH}/organization.htm";
    			}else{
    				layer.msg("保存失败!", {time:1000, icon:5, shift:6});
    			}
    		}
			
		});
	} */






</script>

</body>
</html>