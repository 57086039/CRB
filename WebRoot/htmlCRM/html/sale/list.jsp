<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="<%=path %>/htmlCRM/html/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path %>/html/script/jquery-1.5.2.js"></script>
<script src="<%=path %>/htmlCRM/html/script/common.js"></script>
<script src="<%=path %>/htmlCRM/html/script/chance.js"></script>
</head>
<body>

<div class="page_title">销售机会管理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="to('../lu/chance!add.action');">新建</button>  
	<button class="common_button" onclick="reload();">查询</button> 
	</div>
<table class="query_form_table">
	<tr>
		<th>客户名称</th>
		<td><input /></td>
		<th>概要</th>
		<td><input /></td>
		<th>联系人</th>
		<td>
			<input name="T1" size="20" />
		</td>
	</tr>
	</table>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>客户名称</th>
		<th>概要</th>
		<th>联系人</th>
		<th>联系人电话</th>
		<th>创建时间</th>
		<th>操作</th>
	</tr>
	<s:iterator value="#request.list" var="k">
	<tr>
		<td class="list_data_number">${ k.cid}</td>
		<td class="list_data_text">${k.clientelename}</td>
		<td class="list_data_ltext">${ k.coutline}</td>
		<td class="list_data_text">${k.cointactsname }</td>
		<td class="list_data_text">${k.contactsphone }</td>
		<td class="list_data_text">${k.time}</td>
		<td class="list_data_op">
			<img onclick="to('dispatch.jsp');" title="指派" src="<%=path %>/htmlCRM/html/images/bt_linkman.gif" class="op_button" />
			<img onclick="to('edit.jsp');" title="编辑" src="<%=path %>/htmlCRM/html/images/bt_edit.gif" class="op_button" />
			<img onclick="del('“销售机会：采购笔记本电脑意向”');" title="删除" src="<%=path %>/htmlCRM/html/images/bt_del.gif" class="op_button" />
			
		</td>
	</tr>
	</s:iterator>
	<tr>
		<th colspan="7" class="pager">
<div class="pager">
	共${count }条记录 每页<input value="3" size="2" />条
	第<input value="1" size="2"/>页/共5页
	<a href="#">第一页</a>
	<a href="#">上一页</a>
	<a href="#">下一页</a>
	<a href="#">最后一页</a>
	转到<input value="1" size="2" />页
	<button width="20" onclick="reload();">GO</button>
</div>
		</th>
	</tr>
</table>
</body>
</html>