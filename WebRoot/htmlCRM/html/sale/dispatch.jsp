<!DOCTYPE>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path %>/htmlCRM/html/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path %>/htmlCRM/html/script/jquery-1.5.2.js"></script>
<script src="<%=path %>/htmlCRM/html/script/common.js"></script>
<script type="text/javascript">
      $(function(){
    	  $("#btnt").click(function(){
    		  var tid=$("#tid").html();
    		  var sele=$("#sele").val();
    		  var date=$("#t2").val();
    		 window.location.href="../lu/chance!zhipai1.action?cid="+tid+"&sele="+sele+"&date="+date;;
    		  
    	  });
      });

</script>
</head>
<body>

<div class="page_title">销售机会管理&nbsp; &gt; 指派销售机会</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" id="btnt">保存</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td id="tid">${cb.cid }</td>
		<th>机会来源</th>
		<td>${cb.csource }
			　</td>
	</tr>
	<tr>
		<th>客户名称</th>
		<td>${cb.clientelename }</td>
		<th>成功机率（%）</th>
		<td>&nbsp;${cb.codds }</td>
	</tr>	
	<tr>
		<th>概要</th>
		<td colspan="3">${cb.coutline }</td>
	</tr>
	<tr>
		<th>联系人</th>
		<td>${cb.cointactsname }</td>
		<th>联系人电话</th>
		<td>${cb.contactsphone }</td>
	</tr>
	<tr>
		<th>机会描述</th>
		<td colspan="3">${cb.describe }</td>
	</tr>
	<tr>
		<th>创建人</th>
		<td>${cb.systemusertable.suname }</td>
		<th>创建时间</th>
		<td>${cb.createdate }</td>
	</tr>
</table>
<br />
<table class="query_form_table" id="table1">
	<tr>
		<th>指派给</th>
		<td>
			<select name="ct.systemusertable.suid" id="sele">
		<option value="-1">请选择</option>
		  <s:iterator value="%{#session.managers}" var="r">
		 <option value="${r[0] }">${r[1] }</option>
		 </s:iterator>
		</select>
			
			<span class="red_star">*</span>
			</td>
		<th>指派时间</th>
		<td>
			<input id="t2" name="T20" readonly size="20" /><span class="red_star">*</span></td>
	</tr>
</table>
<script>
	setCurTime('t2');
</script>
</body>
</html>