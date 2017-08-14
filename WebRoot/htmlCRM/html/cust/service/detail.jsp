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
</head>
<body>

<div class="page_title">客户服务管理 &gt; 服务处理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>  
</div>
<table class="query_form_table">
<c:if test="${requestScope.service.servicestatetable.ssid==2 }">
	<tr>
		<th>编号</th>
		<td>${requestScope.service.serid }</td>
		<th>服务类型</th>
		<td>
			${requestScope.service.servicetypetable.stid }</td>
	</tr>
	<tr>
		<th>概要</th>
		<td colspan="3">${requestScope.service.summary }</td>
	</tr>	
	<tr>
		<th>客户</th>
		<td>${requestScope.service.clienttable.clientname }</td>
		<th>状态</th>
		<td>${requestScope.service.servicestatetable.ssid }</td>
	</tr>	
	<tr>
		<th>服务请求</th>
		<td colspan="3">${requestScope.service.srequest }<br>
　</td>
	</tr>
	<tr>
		<th>创建人</th>
		<td>${requestScope.service.systemusertable.suname }</td>
		<th>创建时间</th>
		<td>${requestScope.service.createdate }</td>
	</tr>
	</c:if>
	<c:if test="${requestScope.assignment.servicetable.servicestatetable.ssid>2 }">
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
	</c:if>
	</table>
<br />
<table class="query_form_table" id="table3">
<c:if test="${requestScope.assignment.servicetable.servicestatetable.ssid>=3 }">
	<tr>
		<th>分配给</th>
		<td>
			${requestScope.assignment.systemusertableBySuids.suname }</td>
		<th>分配时间</th>
		<td>${requestScope.assignment.allocationtime }</td>
	</tr>
</c:if>
<c:if test="${requestScope.assignment.servicetable.servicestatetable.ssid<3 }">
	<tr>
		<th>分配给</th>
		<td></td>
		<th>分配时间</th>
		<td></td>
	</tr>
</c:if>
</table>
<br/>
<table class="query_form_table" id="table1">
<c:if test="${requestScope.assignment.servicetable.servicestatetable.ssid>=4 }">
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
</c:if>
<c:if test="${requestScope.assignment.servicetable.servicestatetable.ssid<4 }">
	<tr>
		<th>服务处理</th>
		<td colspan="3"></td>
	</tr>
	<tr>
		<th>处理人</th>
		<td></td>
		<th>处理时间</th>
		<td></td>
	</tr>
</c:if>
</table>
<br />
<table class="query_form_table" id="table2">
<c:if test="${requestScope.assignment.servicetable.servicestatetable.ssid==5 }">
	<tr>
		<th>处理结果</th>
		<td>${requestScope.feedback.feedcontent }</td>
		<th>满意度</th>
		<td>
			<c:forEach begin="1" end="${requestScope.feedback.feedgrade }" var="feed">
				<img src="<%=path %>/htmlCRM/html/images/star.jpg" class="star_pic" />
			</c:forEach>
		</td>
	</tr>
</c:if>
<c:if test="${requestScope.assignment.servicetable.servicestatetable.ssid<5 }">
	<tr>
		<th>处理结果</th>
		<td></td>
		<th>满意度</th>
		<td>
		</td>
	</tr>
</c:if>
</table>
</body>
</html>