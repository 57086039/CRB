<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<!DOCTYPE >
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=path %>htmlCRM/html/css/style.css" rel="stylesheet" type="text/css">
<script src="<%=path %>/htmlCRM/html/script/common.js"></script>
</head>
<body>

<div class="page_title">销售机会管理&nbsp; &gt; 新建销售机会</div>
<form action="<%=path %>/lu/chance!insert.action"  method="post">
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<input class="common_button" type="submit" value="保存">  
	<input type="button" onclick="window.location.href='chance!insert.action'" value="saa">
</div>

<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td><input readonly /></td>
		<th>机会来源</th>
		<td>
			<input name="ct.csource" size="20" /></td>
	</tr>
	<tr>
		<th>客户名称</th>
		<td><input required="required" name="ct.clientelename" /><span class="red_star">*</span></td>
		<th>成功机率</th>
		<td><input required="required" name="ct.codds"/><span class="red_star">*</span></td>
	</tr>	
	<tr>
		<th>概要</th>
		<td colspan="3"><input name="ct.coutline" size="52" required="required"/><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>联系人</th>
		<td><input name="ct.cointactsname" size="20" /></td>
		<th>联系人电话</th>
		<td><input name="ct.contactsphone" size="20" /></td>
	</tr>
	<tr>
		<th>机会描述</th>
		<td colspan="3"><textarea rows="6" cols="50" name="ct.describe" required="required"></textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>创建人</th>
		<td><input name="T19" value="${users.suname }" readonly size="20"  /><span class="red_star">*</span></td>
		<th>创建时间</th>
		<td><input id="t1" name="ct.createdate"  size="20" required="required"/><span class="red_star">*</span></td>
	</tr>
</table>
<br />
<table >
	<tr>
		<th>指派给</th>
		<td>
		<select >
		<option value="-1">请选择</option>
		  <s:iterator value="%{#request.managers}" var="r">
		 <option value="${r[0] }">${r[1] }</option>
		 </s:iterator>
		</select>
		  <span class="red_star">*</span></td>
		<th>指派时间</th>
		<td>
			<input id="t2" name="T20" readonly size="20" required="required"/><span class="red_star">*</span></td>
	</tr>
</table>
</form> 
<script>
	
	setCurTime('t2');
	setCurTime('t1');
	
	
</script>
</body>
</html>