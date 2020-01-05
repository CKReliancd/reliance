<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
	<title>催收系统</title>
	<script src="static/resources/scripts/jquery-1.7.1.min.js"></script>
    <script src="static/resources/scripts/jquery-ui-1.8.10.custom.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="static/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="static/easyui/themes/icon.css">
	
	<script type="text/javascript" src="static/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="static/easyui/jquery.easyui.min.js"></script>
	
	<script type="text/javascript" src="static/easyui/datagrid-detailview.js"></script>

</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">north region</div>
	
	<div data-options="region:'west',split:true,title:'West'" style="width:150px;padding:10px;">
		<div class="easyui-accordion" style="width:180px;">
			<div title="催收系统管理" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
				<ul>
                    <li>
                    	<a href="javascript:addOrganizationTabs();">组织机构</a>
                    </li>
                </ul>
				<ul>
                    <li>
                        <a href="javascript:addPositionTabs();">职位管理</a>
                    </li>
                </ul>
				<ul>
                    <li>
                        <a href="javascript:addClientTabs();">委托方管理</a>
                    </li>
                </ul>
				<ul>
                    <li>
                        <a href="javascript:addStaffTabs();">员工管理</a>
                    </li>
                </ul>
				<ul>
                    <li>
                        <a href="javascript:addBatchTabs();">批次管理</a>
                    </li>
                </ul>
				<ul>
                    <li>
                        <a href="javascript:addCaseTabs();">案件管理</a>
                    </li>
                </ul>
				<ul>
                    <li>
                        <a href="javascript:addRefundTabs();">还款管理</a>
                    </li>
                </ul>
			</div>
			
		</div>
	</div>
	
	
	<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div>
	
	<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
	
	
	<div data-options="region:'center',title:'Center'">
		<div id="tt" class="easyui-tabs" style="width:100%;height:100%;">
			
		</div>
	</div>
	
	<script language="JavaScript">
		function addOrganizationTabs(){
			
			var b = $("#tt").tabs("exists","组织机构");
			if(!b){
				$("#tt").tabs("add",{
					title:"组织机构",
					href:"organization.do",
					closable:true
				});
				
			}else{
				$("#tt").tabs("select","组织机构");
			}
			
			
		}
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 </script>
</body>
</html>