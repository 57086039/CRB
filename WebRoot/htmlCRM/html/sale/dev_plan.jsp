<%@page import="java.text.SimpleDateFormat"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=path %>/htmlCRM/html/css/style.css" rel="stylesheet" type="text/css">
<script src="<%=path %>/htmlCRM/html/script/jquery-1.5.2.js"></script>
<script src="<%=path %>/htmlCRM/html/script/common.js"></script>


<script type="text/javascript">
$(function(){
	   
	
	
})

</script>
</head>
<body>

<div class="page_title">客户开发计划 &gt; 制定计划</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<c:if test="${users.restricttable.rid!=8}">
	<button class="common_button" onclick="to('<%=path %>/lu/kaifa!zhixing.action');">执行计划</button>
	</c:if>
	<c:if test="${users.restricttable.rid==8}">
	<button class="common_button" onclick="alert('请安排被指派的客户经理执行计划')">执行计划</button>
	</c:if>
	<button class="common_button" onclick="to('<%=path %>/lu/kaifa!chushi.action');">返回</button>
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
		<td colspan="3">${zd.COUTLINE	 }</td>
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
		<th width="150px">日期</th>
		<th height="31">计划项</th>
	</tr>
	 <c:forEach items="${lp }" var="p">
	<tr>
		<td class="list_data_text" height="24">${p.plandate }</td>
		<td class="list_data_ltext" height="24"><input size="50" value="${p.planitem }" />
		
	<input type="button" class="common_button" onclick="to('<%=path %>/lu/kaifa!del.action?pid=${p.planid }&cid=${zd.CID  }');" value="删除"/>
		</td>
	</tr>
	</c:forEach>
</table>
<form action="<%=path %>/lu/kaifa!baocun.action?cid=${zd.CID }" method="post">
<div class="button_bar">
   
	<input type="submit" class="common_button" value="保存" onclick="add('保存成功');"/>
	
	</div>
	
<table class="query_form_table" id="table2">

	<tr>
		<th>日期</th>
	
		<td><input type="date" value="<%= new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>" name="p.plandate" id="riqi"/><span class="red_star">*</span></td>
		<th>计划项</th>
		<td>
			<input type="text" size="50" name="p.planitem" id="jihua"/><span class="red_star">*</span>
		   <input type="hidden" name="p.chancetable.cid" value="${zd.CID }"/>
		</td>
		
	</tr>
	
</table>
</form>
</body>
</html>