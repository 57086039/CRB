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
<script src="<%=path %>/htmlCRM/html/script/jquery-1.8.2.js"></script>
<script type="text/javascript">
$(function (){
	$("#pageGo").click(function (){
		var index=$("[name=index]").val();
		var count=$("[name=size]").val();
		window.location.href="../pyl/service!pageGo.action?index="+index+"&count="+count;
		
	});
	$("[name=assignment]").click(function(){
		var serid=$(this).val();
		var suids=$(this).prev().val();
		$.ajax({
			url:"../pyl/ajax!addAssignment.action",
			type:"post",
			data:{"serid":serid,"suids":suids},
			dataType:"json",
			success:function(data){	
				alert($(this).parent().html());
				$(this).parent().parent().remove();
				alert("分配成功！");
			}
		});
		
	});
	
	
	$("#serviceSearch").click(function (){
		
		var clientname=$("[name=clientname]").val();
		var summary=$("[name=summary]").val();
		var stid=$("[name=stid]").val();
		var start=$("[name=start]").val();
		var end=$("[name=end]").val();
		var ssid=$("[name=ssid]").val();
		//alert(clientname);
		window.location.href="../pyl/service!search.action?clientname="+encodeURI(encodeURI(clientname))+"&summary="+encodeURI(encodeURI(summary))+"&condition.stid="+stid+"&condition.start="+start+"&condition.end="+end+"&condition.ssid="+ssid+"&id=2";
		
		
	});
	$("[name=delService]").click(function (){
		var serid=$(this).parent().prev().prev().prev().prev().prev().prev().prev().html();
		alert("删除成功");
	});
});
</script>
</head>
<body>

<div class="page_title">客户服务管理 > 服务分配</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" id="serviceSearch">查询</button>  
</div>
<table class="query_form_table" height="53">
	<tr>
		<th height="28">客户</th>
			<td><input name="clientname" value="${sessionScope.condition.clientname }"/></td>
			<th height="28" value="${sessionScope.condition.clientname }">概要</th>
			<td><input name="summary" value="${sessionScope.condition.summary }" /></td>
			<th height="28">服务类型</th>
			<td>
				<s:select theme="simple" list="#request.typelist"
						 name="stid"
						listKey="stid" 
						listValue="stpoint"
				/>
			</td>
		</tr>
		<tr>
			<th height="32">创建日期</th>
			<td colspan="3">
				<input type="date" name="start" value="${sessionScope.condition.start }" size="50px" /> - <input type="date" name="end" value="${sessionScope.condition.end }"  size="50px" /></td>
		<th height="22">状态</th>
		<td>
			<select name="ssid">
				<option value="2" selected>新创建</option>
			</select>
		</td>
	</tr>
</table>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>客户</th>
		<th>概要</th>
		<th>服务类型</th>
		<th>创建人</th>
		<th>创建日期</th>
		<th>分配给</th>
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
		<td class="list_data_text">
			<s:select theme="simple" list="#request.userlist"
					name="suid"
					listKey="suid" 
					listValue="suname"
			/>
			<s:if test="#session.users.restricttable.rid!=8">
				<button disabled="disabled" class="common_button" name="assignment" value="${list.serid }">分配</button>
				 
			</s:if>
			
			<s:if test="#session.users.restricttable.rid==8">
				<button class="common_button" name="assignment" value="${list.serid }">分配</button> 
			</s:if>  
			
		</td>
		<td class="list_data_op">
			<s:if test="#session.users.restricttable.rid!=8">
				<img title="删除" src="<%=path %>/htmlCRM/html/images/bt_del.gif" class="op_button" />
			</s:if>  
			<s:if test="#session.users.restricttable.rid==8">
				<img onclick="to('../pyl/service!delService.action?serid=${list.serid }')"  name="delService" title="删除" src="<%=path %>/htmlCRM/html/images/bt_del.gif" class="op_button" />
			</s:if>  
		</td>
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
		<a href="../pyl/service!Change.action?index=1">第一页</a>
		<a href="../pyl/service!Change.action?index=${sessionScope.servicepage.index-1 }">上一页</a>
	</c:if>
	<c:if test="${sessionScope.servicepage.index==sessionScope.servicepage.pagecount }">
		<span>下一页</span><span>最后一页</span>
	</c:if>
	<c:if test="${sessionScope.servicepage.index!=sessionScope.servicepage.pagecount }">
		<a href="../pyl/service!Change.action?index=${sessionScope.servicepage.index+1 }">下一页</a>
		<a href="../pyl/service!Change.action?index=${sessionScope.servicepage.pagecount }">最后一页</a>
	</c:if>
	转到<input name="index" value="${sessionScope.servicepage.index }" size="2" />页
	<button width="20" id="pageGo">GO</button>
</div>
		</th>
	</tr>
</table>
</body>
</html>