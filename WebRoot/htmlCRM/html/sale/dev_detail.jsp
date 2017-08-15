<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path %>/htmlCRM/html/css/style.css" rel="stylesheet" type="text/css">
<script src="<%=path %>/htmlCRM/html/script/common.js"></script>
</head>
<body>

<div class="page_title">客户开发计划 &gt; 查看</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td>${zd.CID }</td>
		<th>机会来源</th>
		<td>
			${zd.CSOURCE	 }　</td>
	</tr>
	<tr>
		<th>客户名称</th>
		<td>${zd.CLIENTELENAME	 }</td>
		<th>成功机率（%）</th>
		<td>&nbsp;${zd.CODDS	 }</td>
	</tr>	
	<tr>
		<th>概要</th>
		<td>${zd.COUTLINE	 }</td>
		<th>状态</th>
		<td style="color:red;">开发失败</td>	
	</tr>
	<tr>
		<th>联系人</th>
		<td>${zd.COINTACTSNAME }</td>
		<th>联系人电话</th>
		<td>${zd.DIANHUA }</td>
	</tr>
	<tr>
		<th>机会描述</th>
		<td colspan="3">${zd.DESCRIBE }</td>
	</tr>
	<tr>
		<th>创建人</th>
		<td>${zd.CHUANGJIANREN }</td>
		<th>创建时间</th>
		<td>${zd.CREATEDATE }</td>
	</tr>
	<tr>
		<th>指派给</th>
		<td>
			${zd.XINMING }</td>
		<th>指派时间</th>
		<td>
			${zd.SHIJIAN }</td>
	</tr>
</table>
<br />
<table class="data_list_table" id="table1">
	<tr>
		<th>日期</th>
		<th>计划</th>
		<th>执行效果</th>
	</tr>
	 <c:forEach items="${lp }" var="p">
	<tr >
		<td class="list_data_text">${p.plandate }</td>
		<td class="list_data_ltext">${p.planitem }</td>
		<td class="list_data_ltext">${p.effect }
		</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>