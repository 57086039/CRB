<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
<script src="<%=path %>/htmlCRM/html/script/common.js"></script>
<script src="<%=path %>/htmlCRM/html/script/jquery-1.8.2.js"></script>

<script type="text/javascript">
$(function(){
	$("#add").click(function(){
		
		$.ajax({
			url:"../pyl/ajax!feedback.action",
			type:"post",
			data:$("#frm").serialize(),
			dataType:"json",
			success:function(data){	
				alert("反馈成功");
				window.location.href="<%=path %>/pyl/service!findService.action?ssid=4";
			}
		});
	});
});
</script>
</head>
<body>

<div class="page_title">客户服务管理 &gt; 服务处理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button> 
	<button class="common_button" id="add">保存</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td>${requestScope.assignment.servicetable.serid }</td>
		<th>服务类型</th>
		<td>
			${requestScope.assignment.servicetable.servicetypetable.stid }</td>
	</tr>
	<tr>
		<th>概要</th>
		<td colspan="3">${requestScope.assignment.servicetable.summary }</td>
	</tr>	
	<tr>
		<th>客户</th>
		<td>${requestScope.assignment.servicetable.clienttable.clientname }</td>
		<th>状态</th>
		<td>${requestScope.assignment.servicetable.servicestatetable.ssid }</td>
	</tr>	
	<tr>
		<th>服务请求</th>
		<td colspan="3">${requestScope.assignment.servicetable.srequest }<br>
　</td>
	</tr>
	<tr>
		<th>创建人</th>
		<td>${requestScope.assignment.servicetable.systemusertable.suname }</td>
		<th>创建时间</th>
		<td>${requestScope.assignment.servicetable.createdate }</td>
	</tr>
	</table>
<br />
<table class="query_form_table" id="table3">
	<tr>
		<th>分配给</th>
		<td>
			${requestScope.assignment.systemusertableBySuids.suname }</td>
		<th>分配时间</th>
		<td>${requestScope.assignment.allocationtime }</td>
	</tr>
</table>
<br/>
<table class="query_form_table" id="table1">
	<tr>
		<th>服务处理</th>
		<td colspan="3">${requestScope.handle.handlecontect }</td>
	</tr>
	<tr>
		<th>处理人</th>
		<td>${requestScope.handle.systemusertable.suname }</td>
		<th>处理时间</th>
		<td>${requestScope.handle.hadletime }</td>
	</tr>
</table>
<br />
<form id="frm">
<table class="query_form_table" id="table2">
	<tr>
		<th>处理结果</th>
		<td><input readonly name="feedback.servicetable.serid" style="display: none" value="${requestScope.assignment.servicetable.serid }" /><input name="feedback.feedcontent" size="20" /><span class="red_star">*</span></td>
		<th>满意度</th>
		<td>
			<select name="feedback.feedgrade">
				<option value="0">请选择...</option>
				<option value="5">☆☆☆☆☆</option>
				<option value="4">☆☆☆☆</option>
				<option value="3">☆☆☆</option>
				<option value="2">☆☆</option>
				<option value="1">☆</option>
			</select><span class="red_star">*</span></td>
	</tr>
</table>
</form>
</body>
</html>