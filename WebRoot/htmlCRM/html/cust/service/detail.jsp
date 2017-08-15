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
</head>
<body>

<div class="page_title">�ͻ�������� &gt; ������</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">����</button>
	<button class="common_button" onclick="back();">����</button>  
</div>
<table class="query_form_table">
<c:if test="${requestScope.service.servicestatetable.ssid==2 }">
	<tr>
		<th>���</th>
		<td>${requestScope.service.serid }</td>
		<th>��������</th>
		<td>
			${requestScope.service.servicetypetable.stid }</td>
	</tr>
	<tr>
		<th>��Ҫ</th>
		<td colspan="3">${requestScope.service.summary }</td>
	</tr>	
	<tr>
		<th>�ͻ�</th>
		<td>${requestScope.service.clienttable.clientname }</td>
		<th>״̬</th>
		<td>${requestScope.service.servicestatetable.ssid }</td>
	</tr>	
	<tr>
		<th>��������</th>
		<td colspan="3">${requestScope.service.srequest }<br>
��</td>
	</tr>
	<tr>
		<th>������</th>
		<td>${requestScope.service.systemusertable.suname }</td>
		<th>����ʱ��</th>
		<td>${requestScope.service.createdate }</td>
	</tr>
	</c:if>
	<c:if test="${requestScope.assignment.servicetable.servicestatetable.ssid>2 }">
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
	</c:if>
	</table>
<br />
<table class="query_form_table" id="table3">
<c:if test="${requestScope.assignment.servicetable.servicestatetable.ssid>=3 }">
	<tr>
		<th>�����</th>
		<td>
			${requestScope.assignment.systemusertableBySuids.suname }</td>
		<th>����ʱ��</th>
		<td>${requestScope.assignment.allocationtime }</td>
	</tr>
</c:if>
<c:if test="${requestScope.assignment.servicetable.servicestatetable.ssid<3 }">
	<tr>
		<th>�����</th>
		<td></td>
		<th>����ʱ��</th>
		<td></td>
	</tr>
</c:if>
</table>
<br/>
<table class="query_form_table" id="table1">
<c:if test="${requestScope.assignment.servicetable.servicestatetable.ssid>=4 }">
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
</c:if>
<c:if test="${requestScope.assignment.servicetable.servicestatetable.ssid<4 }">
	<tr>
		<th>������</th>
		<td colspan="3"></td>
	</tr>
	<tr>
		<th>������</th>
		<td></td>
		<th>����ʱ��</th>
		<td></td>
	</tr>
</c:if>
</table>
<br />
<table class="query_form_table" id="table2">
<c:if test="${requestScope.assignment.servicetable.servicestatetable.ssid==5 }">
	<tr>
		<th>������</th>
		<td>${requestScope.feedback.feedcontent }</td>
		<th>�����</th>
		<td>
			<c:forEach begin="1" end="${requestScope.feedback.feedgrade }" var="feed">
				<img src="<%=path %>/htmlCRM/html/images/star.jpg" class="star_pic" />
			</c:forEach>
		</td>
	</tr>
</c:if>
<c:if test="${requestScope.assignment.servicetable.servicestatetable.ssid<5 }">
	<tr>
		<th>������</th>
		<td></td>
		<th>�����</th>
		<td>
		</td>
	</tr>
</c:if>
</table>
</body>
</html>