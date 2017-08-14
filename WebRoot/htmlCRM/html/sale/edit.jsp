<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="<%=path %>/htmlCRM/html/css/style.css" rel="stylesheet" type="text/css">
<script src="<%=path %>/htmlCRM/html/script/common.js"></script>
</head>
<body>

<div class="page_title">销售机会管理&nbsp; &gt; 编辑销售机会</div>
<form action="<%=path %>/lu/chance!xiugai.action?uid=${c.systemusertable.suid}"  method="post">
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<input type="button" class="common_button" onclick="window.history.go(-1);" value="返回"/>
	<input class="common_button" type="submit" value="保存">    
</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td><input name="ct.cid" readonly value="${c.cid }" /></td>
		<th>机会来源</th>
		<td>
			<input name="ct.csource" size="20" value="${c.csource }"/></td>
	</tr>
	<tr>
		<th>客户名称</th>
		<td><input name="ct.clientelename" value="${c.clientelename }" /><span class="red_star">*</span></td>
		<th>成功机率（%）</th>
		<td><input value="${c.codds }" name="ct.codds" /><span class="red_star">*</span></td>
	</tr>	
	<tr>
		<th>概要</th>
		<td colspan="3"><input value="${c.coutline }" name="ct.coutline" size="52" /><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>联系人</th>
		<td><input name="ct.cointactsname" value="${c.cointactsname }" size="20" /></td>
		<th>联系人电话</th>
		<td><input name="ct.contactsphone" value="${c.contactsphone }" size="20" /></td>
	</tr>
	<tr>
		<th>机会描述</th>
		<td colspan="3"><textarea rows="6" cols="50" name="ct.describe">${c.describe }</textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>创建人</th>
		<td><input name="T19" value="${c.systemusertable.suname }" readonly size="20" /><span class="red_star">*</span></td>
		<th>创建时间</th>
		<td><input id="to" name="ct.createdate" value="${c.createdate }" readonly size="20" /><span class="red_star">*</span></td>
	</tr>
</table>
<br />
<table class="query_form_table" id="table1">
	<tr>
		<th>指派给</th>
		<c:if test="${users.restricttable.rid!=8}">
		<td>
		<select disabled="disabled" name="ct.systemusertable.suid" >
		<option >请选择</option>
		  <s:iterator value="%{#session.managers}" var="r">
		 <option value="${r[0] }">${r[1] }</option>
		 </s:iterator>
		</select>
		  <span class="red_star">*</span></td>
		  </c:if>
		 <c:if test="${users.restricttable.rid==8}">
		  <td>
		<select  name="ct.systemusertable.suid" >
		<option value="-1" >请选择</option>
		  <s:iterator value="%{#session.managers}" var="r">
		 <option value="${r[0] }">${r[1] }</option>
		 </s:iterator>
		</select>
		  <span class="red_star">*</span></td>		
		 </c:if>
		<th>指派时间</th>
		<td>
			<input id="t1" name="T20" readonly size="20" /><span class="red_star">*</span></td>
	</tr>
</table>
</form>
<script>
	setCurTime('t1');
	setCurTime('t2');
</script>
</body>
</html>