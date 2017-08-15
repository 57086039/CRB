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
		alert(size);
		window.location.href="../lu/kaifa!shuaxin.action?index="+index+"&size="+size;
		/* $.post("../lu/ajax!shuaxin.action",{"index":index},function(data){
			alert("ss");
			
		}); */
		
	});
	 $("#butn1").click(function(){
		 var mingcheng=$("#mingcheng").val();
		 var gaiyao=$("#gaiyao").val();
		 var lianxiren=$("#lianxiren").val();
		// alert(mingcheng+" "+gaiyao+" "+lianxiren);
		 window.location.href="../lu/kaifa!shaixuan.action?mingcheng="+mingcheng+"&gaiyao="+gaiyao+"&lianxiren="+lianxiren;
	 });
});

function del(msg){
	alert(msg);
	if (window.confirm("确认删除吗？")){
		
		
		window.location.href="../lu/chance!del.action?cid="+msg;
	}
	
}
</script>
</head>
<body>

<div class="page_title">客户开发计划</div>

<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" id="butn1">查询</button> 
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
		<th>状态</th>
		<th>操作</th>
	</tr>
	<s:iterator value="#request.list" var="k" >
	<tr>
		<td class="list_data_number">${k.CID }</td>
		<td class="list_data_text">${k.CLIENTELENAME}</td>
		<td class="list_data_ltext">${k.COUTLINE }</td>
		<td class="list_data_text">${k.COINTACTSNAME }</td>
		<td class="list_data_text">${k.DIANHUA }</td>
		<td class="list_data_text">${k.CREATEDATE }</td>
		
		<c:if test="${k.CSID==4 }">
		<td class="list_data_text">已归档</td>
		<td class="list_data_op">
			<img onclick="to('<%=path %>/lu/kaifa!chakan.action?cid=${k.CID }');" title="查看" src="<%=path %>/htmlCRM/html/images/bt_detail.gif" class="op_button" />
		</td>
		</c:if>
		<c:if test="${k.CSID==3 }">
		<td class="list_data_text">正在开发</td>
		<td class="list_data_op">
		<c:if test="${users.restricttable.rid==8||users.suid==k.ZHIPAI }">
			<img onclick="to('<%=path %>/lu/kaifa!zhiding.action?cid=${k.CID }');" title="制定计划" src="<%=path %>/htmlCRM/html/images/bt_plan.gif" class="op_button" />
		</c:if>
		<c:if test="${users.suid==k.ZHIPAI }">
			<img onclick="to('<%=path %>/lu/kaifa!zhixing.action?cid=${k.CID }');" title="执行计划" src="<%=path %>/htmlCRM/html/images/bt_feedback.gif" class="op_button" />
			</c:if>
			<c:if test="${users.suid==k.ZHIPAI }">
			<img onclick="alert('用户开发成功，已添加新客户记录。');window.location.href='<%=path %>/lu/kaifa!succeed.action?cid=${k.CID }';" title="开发成功" src="<%=path %>/htmlCRM/html/images/bt_yes.gif" class="op_button" />
		</c:if>
		</td>
		</c:if>
		
	</tr>
	</s:iterator>
	<tr>
		<th colspan="10" class="pager">
<div class="pager">
	共${count }条记录 每页<input value=${size } size="2" id="s1"/>条
	第<input value="${index }" size="2"/>页/共<span >${MaxPage }</span>页
	<c:if test="${requestScope.index==1&&requestScope.MaxPage!=1 }">
	   <a href="<%=path %>/lu/kaifa!paging.action?index=1" >第一页</a>
	   <a href="#" id="shang">上一页</a>
	   <a href="<%=path %>/lu/kaifa!paging.action?index=${index+1}" >下一页</a>
	   <a href="<%=path %>/lu/kaifa!paging.action?index=${MaxPage}" >最后一页</a>
	</c:if>
	<c:if test="${requestScope.index==1&&requestScope.MaxPage==1 }">
	   <a href="<%=path %>/lu/chance!paging.action?index=1" >第一页</a>
	   <a href="#" id="shang">上一页</a>
	   <a href="#" id="xia">下一页</a>
	   <a href="<%=path %>/lu/chance!paging.action?index=${MaxPage}" >最后一页</a>
	</c:if>
	 <c:if test="${requestScope.index!=1&&requestScope.index!=requestScope.MaxPage }">
	<a href="<%=path %>/lu/kaifa!paging.action?index=1">第一页</a>
	<a href="<%=path %>/lu/kaifa!paging.action?index=${index-1}">上一页</a>
	<a href="<%=path %>/lu/kaifa!paging.action?index=${index+1}">下一页</a>
	<a href="<%=path %>/lu/kaifa!paging.action?index=${MaxPage}">最后一页</a>
	</c:if>
	<c:if test="${requestScope.index==requestScope.MaxPage&&requestScope.index!=1}">
      <a href="<%=path %>/lu/kaifa!paging.action?index=1">第一页</a>
	<a href="<%=path %>/lu/kaifa!paging.action?index=${index-1}">上一页</a>
	<a href="#" id="xia">下一页</a>
	<a href="<%=path %>/lu/kaifa!paging.action?index=${MaxPage}">最后一页</a>
       </c:if>
	转到<input value="1" size="2" id="index"/>页
	<button width="20"  id="tiaozhua">GO</button>
</div>
		</th>
	</tr>
</table>
</body>
</html>