<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jstl/fmt_rt" %>
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
<script src="<%=path %>/htmlCRM/html/script/jquery-1.8.2.js"></script>
<script type="text/javascript">
	$(function (){
		$("#pageGo").click(function (){
			var index=$("[name=index]").val();
			var count=$("[name=size]").val();
			//alert(index+count);
			window.location.href="../pyl/service!pageGo.action?index="+index+"&count="+count;
			
		});
		$("#serviceSearch").click(function (){
			
			var clientname=$("[name=clientname]").val();
			var summary=$("[name=summary]").val();
			var stid=$("[name=stid]").val();
			var start=$("[name=start]").val();
			var end=$("[name=end]").val();
			var ssid=$("[name=ssid]").val();
			//alert(clientname);
			window.location.href="../pyl/service!search.action?clientname="+encodeURI(encodeURI(clientname))+"&summary="+encodeURI(encodeURI(summary))+"&condition.stid="+stid+"&condition.start="+start+"&condition.end="+end+"&condition.ssid="+ssid+"&id=5";
			//
			/* $.ajax({
				url:"../pyl/ajax!search.action",
				type:"post",
				data:$("#condition").serialize(),
				dataType:"json",
				success:function(data){	
					window.location.reload();
				}
			}); */
			
		});
	});
</script>
</head>
<body>

<div class="page_title">客户服务管理 &gt; 服务归档</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" id="serviceSearch">查询</button>  
</div>
<s:form id="condition">
	<table class="query_form_table">
		<tr>
			<th height="28">客户</th>
			<td><input name="clientname" value="${sessionScope.condition.clientname }"/></td>
			<th height="28" value="${sessionScope.condition.clientname }">概要</th>
			<td><input name="summary" value="${sessionScope.condition.summary }" /></td>
			<th height="28">服务类型</th>
			<td>
				<s:select theme="simple" list="#request.typelist"
						 name="stid"
						 headerKey="0"
						 headerValue="全部"
						listKey="stid" 
						listValue="stpoint"
						value="%{#sessionScope.condition.stid}"
				/>
			</td>
		</tr>
		<tr>
			<th height="32">创建日期</th>
			<td colspan="3">
				<input type="date" name="start" value="${sessionScope.condition.start }" size="50px" /> - <input type="date" name="end" value="${sessionScope.condition.end }"  size="50px" /></td>
			<th height="32">状态</th>
			<td>
				<select name="ssid"">
					<option value="0">全部</option>
					<option value="2">新创建</option>
					<option value="3">已分配</option>
					<option value="4">已处理</option>
					<option value="5">已归档</option>
				</select>
			</td>
		</tr>
	</table>
</s:form>

<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>客户</th>
		<th>概要</th>
		<th>服务类型</th>
		<th>创建人</th>
		<th>创建日期</th>
		<th>状态</th>
		<th>操作</th>
	</tr>
	<s:iterator value="#request.servicelist" var="list">	
		<tr>
			<td class="list_data_number">${list.serid }</td>
			<td class="list_data_text">${list.clienttable.clientname }</td>
			<td class="list_data_ltext">${list.summary }</td>
			<td class="list_data_text">${list.servicetypetable.stpoint }</td>
			<td class="list_data_text">${list.systemusertable.suname }</td>
			<td class="list_data_text"><s:date format="yyyy年MM月dd日" name="#list.createdate "/></td>
			<td class="list_data_text">${list.servicestatetable.sspoint }</td>
			<td class="list_data_op">
										
				<img onclick="to('../pyl/service!findFileBySerid.action?serid=${list.serid }');" title="查看" src="<%=path %>/htmlCRM/html/images/bt_detail.gif" class="op_button" /></td>
		</tr>
	</s:iterator>
	<tr>
		<th colspan="8" class="pager">
<div class="pager">
	共<span id="count">${sessionScope.servicepage.count }</span>条记录 每页<input name="size" value="${sessionScope.servicepage.pagesize }" size="2" />条
	第<span>${sessionScope.servicepage.index }</span>页/共<span id="pagecount">${sessionScope.servicepage.pagecount }</span>页
	<c:if test="${sessionScope.servicepage.index==1 }">
		<span>第一页</span><span>上一页</span>
	</c:if>
	<c:if test="${sessionScope.servicepage.index!=1 }">
		<a href="<%=path%>/pyl/service!Change.action?index=1">第一页</a>
		<a href="<%=path%>/pyl/service!Change.action?index=${sessionScope.servicepage.index-1 }">上一页</a>
	</c:if>
	<c:if test="${sessionScope.servicepage.index==sessionScope.servicepage.pagecount }">
		<span>下一页</span><span>最后一页</span>
	</c:if>
	<c:if test="${sessionScope.servicepage.index!=sessionScope.servicepage.pagecount }">
		<a href="<%=path%>/pyl/service!Change.action?index=${sessionScope.servicepage.index+1 }">下一页</a>
		<a href="<%=path%>/pyl/service!Change.action?index=${sessionScope.servicepage.pagecount }">最后一页</a>
	</c:if>
	转到<input name="index" value="${sessionScope.servicepage.index }" size="2" />页
	<button width="20" id="pageGo">GO</button>
</div>
		</th>
	</tr>
</table>
</body>
</html>