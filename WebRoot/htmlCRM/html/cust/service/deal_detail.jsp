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
			url:"<%=path%>/pyl/ajax!handle.action",
			type:"post",
			data:$("#frm").serialize(),
			dataType:"json",
			success:function(data){	
				alert("����ɹ�");
				window.location.href="<%=path %>/pyl/service!findService.action?ssid=3";
			}
		});
	});
});

function method(){
	var now=new Date();
	var e = document.getElementById("t1");
	e.value=now.getFullYear()+"-"+ (now.getMonth()+1)+"-"+ now.getDate()+" "+ now.getHours()+":"+ now.getMinutes()+":"+ now.getSeconds();
}
setInterval(method,1000);
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
<br />	
<form id="frm">
<table class="query_form_table" id="table1">
	<tr>
		<th>������</th>
		<td colspan="3"><input readonly size="20" name="servicehandle.servicetable.serid" style="display: none" value="${requestScope.assignment.servicetable.serid }" /><textarea rows="6" cols="50" name="servicehandle.handlecontect"></textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>������</th>
		<td><input name="suname" value="${sessionScope.users.suname }" readonly size="20" /><input name="servicehandle.systemusertable.suid" value="${sessionScope.users.suid }" style="display: none" /><span class="red_star">*</span></td>
		<th>����ʱ��</th>
		<td><input id="t1" readonly size="20" name="servicehandle.hadletime" /><span class="red_star">*</span></td>
	</tr>
</table>
</form>
<br />
<table disabled class="query_form_table" id="table2">
	<tr>
		<th>������</th>
		<td><input name="T10" size="20" /><span class="red_star">*</span></td>
		<th>�����</th>
		<td>
			<select name="D1">
				<option>��ѡ��...</option>
				<option>������</option>
				<option>�����</option>
				<option>����</option>
				<option>���</option>
				<option>��</option>
			</select><span class="red_star">*</span></td>
	</tr>
</table>
</body>
</html>