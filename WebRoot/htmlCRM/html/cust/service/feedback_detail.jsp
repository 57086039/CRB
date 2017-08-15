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
<title>jb-aptech��ҵ�����Ŀ</title>
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
				alert("�����ɹ�");
				window.location.href="<%=path %>/pyl/service!findService.action?ssid=4";
			}
		});
	});
});
</script>
</head>
<body>

<div class="page_title">�ͻ�������� &gt; ������</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">����</button>
	<button class="common_button" onclick="back();">����</button> 
	<button class="common_button" id="add">����</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>���</th>
		<td>${requestScope.assignment.servicetable.serid }</td>
		<th>��������</th>
		<td>
			${requestScope.assignment.servicetable.servicetypetable.stid }</td>
	</tr>
	<tr>
		<th>��Ҫ</th>
		<td colspan="3">${requestScope.assignment.servicetable.summary }</td>
	</tr>	
	<tr>
		<th>�ͻ�</th>
		<td>${requestScope.assignment.servicetable.clienttable.clientname }</td>
		<th>״̬</th>
		<td>${requestScope.assignment.servicetable.servicestatetable.ssid }</td>
	</tr>	
	<tr>
		<th>��������</th>
		<td colspan="3">${requestScope.assignment.servicetable.srequest }<br>
��</td>
	</tr>
	<tr>
		<th>������</th>
		<td>${requestScope.assignment.servicetable.systemusertable.suname }</td>
		<th>����ʱ��</th>
		<td>${requestScope.assignment.servicetable.createdate }</td>
	</tr>
	</table>
<br />
<table class="query_form_table" id="table3">
	<tr>
		<th>�����</th>
		<td>
			${requestScope.assignment.systemusertableBySuids.suname }</td>
		<th>����ʱ��</th>
		<td>${requestScope.assignment.allocationtime }</td>
	</tr>
</table>
<br/>
<table class="query_form_table" id="table1">
	<tr>
		<th>������</th>
		<td colspan="3">${requestScope.handle.handlecontect }</td>
	</tr>
	<tr>
		<th>������</th>
		<td>${requestScope.handle.systemusertable.suname }</td>
		<th>����ʱ��</th>
		<td>${requestScope.handle.hadletime }</td>
	</tr>
</table>
<br />
<form id="frm">
<table class="query_form_table" id="table2">
	<tr>
		<th>������</th>
		<td><input readonly name="feedback.servicetable.serid" style="display: none" value="${requestScope.assignment.servicetable.serid }" /><input name="feedback.feedcontent" size="20" /><span class="red_star">*</span></td>
		<th>�����</th>
		<td>
			<select name="feedback.feedgrade">
				<option value="0">��ѡ��...</option>
				<option value="5">������</option>
				<option value="4">�����</option>
				<option value="3">����</option>
				<option value="2">���</option>
				<option value="1">��</option>
			</select><span class="red_star">*</span></td>
	</tr>
</table>
</form>
</body>
</html>