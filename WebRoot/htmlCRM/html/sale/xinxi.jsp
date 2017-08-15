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

<div class="page_title">添加 客户信息</div>
<form action="<%=path %>/lu/kaifa!bckh.action?cid=${zd.CID}" method="post">
<div class="button_bar">
	<button class="common_button" onclick="to('<%=path %>/lu/kaifa!chushi.action');">返回</button>
	<input class="common_button" type="submit" value="保存" onclick="alert('保存客户信息成功')" />
</div>
<table class="query_form_table">
	<tr>
		<th>客户编号</th>
		<td></td>
		<th>名称</th>
		<td><input value="${zd.CLIENTELENAME }" name="clienttable.clientname"/><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>地区</th>
		<td>
			<select name="clienttable.area">
				<option>请选择...</option>
				<c:forEach items="${dq }" var="d">
				<option value="${d.rid }">${d.rpoint }</option>
				</c:forEach>
			</select>
			<span class="red_star">*</span></td>
		<th>客户经理</th>
		<td>
		<select  name="clienttable.systemusertable.suid" >	
		
		 <option  value="${zd.ZHIPAI }">${zd.XINMING }</option>	 
		</select>
		<span class="red_star">*</span>
		
		</td>
	</tr>	
	<tr>
		<th>客户等级</th>
		<td>
			<select name="clienttable.enterprisegrade.egid">
				<option>请选择...</option>
				<option value="6" >战略合作伙伴</option>
				<option value="5">合作伙伴</option>
				<option value="4">大客户</option>
				<option value="3">重点开发客户</option>
				<option selected="selected" value="2">普通客户</option>
			</select><span class="red_star">*</span>
		</td>
		<th>　</th>
		<td>　</td>
	</tr>
	<tr>
		<th>客户满意度</th>
		<td>
			<select name="clienttable.satisficing">
			<option value="1">未指定</option>
					<option value="5">☆☆☆☆☆</option>
					<option value="4">☆☆☆☆</option>
					<option value="3" selected="selected">☆☆☆</option>
					<option value="2">☆☆</option>
					<option value="1">☆</option></select><span class="red_star">*</span>
		</td>
		<th>客户信用度</th>
		<td>
			<select name="clienttable.creditgrder"><option value="1">未指定</option>
					<option value="5">☆☆☆☆☆</option>
					<option value="4">☆☆☆☆</option>
					<option value="3" selected="selected">☆☆☆</option>
					<option value="2">☆☆</option>
					<option value="1">☆</option></select><span class="red_star">*</span>
		</td>
	</tr>
</table>
<br />
<table class="query_form_table" id="table1">
	<tr>
		<th>地址</th>
		<td><input name="clienttable.csite"  /><span class="red_star">*</span>
		</td>
		<th>邮政编码</th>
		<td><input name="clienttable.postalcode"  size="20" /><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>电话</th>
		<td>
			<input value="${zd.DIANHUA }" name="clienttable.phone" size="20"  /><span class="red_star">*</span></td>
		<th>传真</th>
		<td>
			<input  name="clienttable.fax" size="20"  /><span class="red_star">*</span>
		</td>
	</tr>	
	<tr>
		<th>网址</th>
		<td>
			<input  name="clienttable.curl" size="20"  /><span class="red_star">*</span>
		</td>
		<th>　</th>
		<td>　</td>
	</tr>
</table>
<br />
<table class="query_form_table" id="table2">
	<tr>
		<th>营业执照注册号</th>
		<td><input value="" name="clienttable.license" size="20" /></td>
		<th>法人</th>
		<td><input value="${zd.COINTACTSNAME}" name="clienttable.legalpreson" size="20" /><span class="red_star">*</span>
		</td>
	</tr>
	<tr>
		<th>注册资金（万元）</th>
		<td>
			<input value="" name="clienttable.registeredprice" size="20" /> </td>
		<th>年营业额</th>
		<td>
			<input value="" name="clienttable.annualprice" size="20" />
		</td>
	</tr>	
	<tr>
		<th>开户银行</th>
		<td>
			<input  name="clienttable.depositbank" size="20" /><span class="red_star">*</span>
		</td>
		<th>银行帐号</th>
		<td><input  name="clienttable.banknumber" size="20" /><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>地税登记号</th>
		<td>
			<input value="" name="clienttable.governmentnumber" size="20" /></td>
		<th>国税登记号</th>
		<td><input value="" name="clienttable.centralnumber" size="20" /></td>
	</tr>
</table>
<p>　</p>
</form>
</body>
</html>