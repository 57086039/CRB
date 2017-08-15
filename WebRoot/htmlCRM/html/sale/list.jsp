<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path %>/htmlCRM/html/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path %>/htmlCRM/html/script/jquery-1.5.2.js"></script>
<script src="<%=path %>/htmlCRM/html/script/common.js"></script>

<script type="text/javascript">
$(function(){
	$("#shang").click(function(){
		alert("已经是第一页");
	});
	$("#xia").click(function(){
		
		alert("已经是最后一页了");
	});
	$("#tiaozhua").click(function(){
		
		var index=$("#index").val();
		var size=$("#s1").val();
	
		window.location.href="../lu/chance!shuaxin.action?index="+index+"&size="+size;
		/* $.post("../lu/ajax!shuaxin.action",{"index":index},function(data){
			alert("ss");
			
		}); */
		
	});
	 $("#butn1").click(function(){
		 var mingcheng=$("#mingcheng").val();
		 var gaiyao=$("#gaiyao").val();
		 var lianxiren=$("#lianxiren").val();
		// alert(mingcheng+" "+gaiyao+" "+lianxiren);
		 window.location.href="../lu/chance!shaixuan.action?mingcheng="+mingcheng+"&gaiyao="+gaiyao+"&lianxiren="+lianxiren;
	 });
});

function del(msg){
	
	if (window.confirm("确认删除吗？概要"+msg)){
		
		
		window.location.href="../lu/chance!del.action?cid="+msg;
	}
	
}
</script>
</head>
<body>

<div class="page_title">销售机会管理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="to('<%=path %>/htmlCRM/html/sale/add.jsp');">新建</button>  
	<button class="common_button" id="butn1" >查询</button> 
	</div>
<table class="query_form_table">
	<tr>
		<th>客户名称</th>
		<td><input type="text"  id="mingcheng" value="${clientelename }"/></td>
		<th>概要</th>
		<td><input id="gaiyao" type="text" value="${coutline }"/></td>
		<th>联系人</th>
		<td>
			<input id="lianxiren" name="T1" type="text" size="20" value="${cointactsname }" />
		</td>
	</tr>
	</table>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>客户名称</th>
		<th>概要</th>
		<th>联系人</th>
		<th>联系人电话</th>
		<th>创建时间</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${list }" var="k">
	<tr>
		<td id="cid" class="list_data_number">${ k.cid}</td>
		<td class="list_data_text">${k.clientelename}</td>
		<td class="list_data_ltext">${ k.coutline}</td>
		<td class="list_data_text">${k.cointactsname }</td>
		<td class="list_data_text">${k.contactsphone }</td>
		<td class="list_data_text">${k.time}</td>
		<td class="list_data_op">
		
		
			<c:if test="${users.restricttable.rid==8}">
			<img onclick="to('<%=path %>/lu/chance!zhipai.action?id=${k.cid }');" title="指派" src="<%=path %>/htmlCRM/html/images/bt_linkman.gif" class="op_button" />
			</c:if>
			<c:if test="${users.restricttable.rid==8 }">
			<img onclick="to('<%=path %>/lu/chance!bianji.action?cid=${k.cid }');" title="编辑" src="<%=path %>/htmlCRM/html/images/bt_edit.gif" class="op_button" />
			</c:if>
		
			<c:if test="${ k.systemusertable.suid==users.suid&&users.restricttable.rid!=8}">
			<img onclick="to('<%=path %>/lu/chance!bianji.action?cid=${k.cid }');" title="编辑" src="<%=path %>/htmlCRM/html/images/bt_edit.gif" class="op_button" />
			
			</c:if>
			<c:if test="${ k.systemusertable.suid==users.suid&&users.restricttable.rid!=8}">
			<img onclick="del('${k.coutline}');" title="删除" src="<%=path %>/htmlCRM/html/images/bt_del.gif" class="op_button" />
		    </c:if>
		  
		    <c:if test="${users.restricttable.rid==8}">
			<img onclick="del('${k.coutline}');" title="删除" src="<%=path %>/htmlCRM/html/images/bt_del.gif" class="op_button" />
		    </c:if>
			
		</td>
	</tr>
  </c:forEach>
	<tr>
		<th colspan="7" class="pager">
<div class="pager">
	共${count }条记录 每页<input value=${size } size="2" id="s1"/>条
	第<input value="${index }" size="2"/>页/共<span >${MaxPage }</span>页
	<c:if test="${requestScope.index==1&&requestScope.MaxPage!=1 }">
	   <a href="<%=path %>/lu/chance!paging.action?index=1" >第一页</a>
	   <a href="#" id="shang">上一页</a>
	   <a href="<%=path %>/lu/chance!paging.action?index=${index+1}" >下一页</a>
	   <a href="<%=path %>/lu/chance!paging.action?index=${MaxPage}" >最后一页</a>
	</c:if>
	<c:if test="${requestScope.index==1&&requestScope.MaxPage==1 }">
	   <a href="<%=path %>/lu/chance!paging.action?index=1" >第一页</a>
	   <a href="#" id="shang">上一页</a>
	   <a href="#" id="xia">下一页</a>
	   <a href="<%=path %>/lu/chance!paging.action?index=${MaxPage}" >最后一页</a>
	</c:if>
	 <c:if test="${requestScope.index!=1&&requestScope.index!=requestScope.MaxPage }">
	<a href="<%=path %>/lu/chance!paging.action?index=1">第一页</a>
	<a href="<%=path %>/lu/chance!paging.action?index=${index-1}">上一页</a>
	<a href="<%=path %>/lu/chance!paging.action?index=${index+1}">下一页</a>
	<a href="<%=path %>/lu/chance!paging.action?index=${MaxPage}">最后一页</a>
	</c:if>
	<c:if test="${requestScope.index==requestScope.MaxPage&&requestScope.index!=1}">
      <a href="<%=path %>/lu/chance!paging.action?index=1">第一页</a>
	<a href="<%=path %>/lu/chance!paging.action?index=${index-1}">上一页</a>
	<a href="#" id="xia">下一页</a>
	<a href="<%=path %>/lu/chance!paging.action?index=${MaxPage}">最后一页</a>
       </c:if>
	转到<input value="1" size="2" id="index"/>页
	<button width="20"  id="tiaozhua">GO</button>
</div>
		</th>
	</tr>
</table>
</body>
</html>