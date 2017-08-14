<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
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


$(function(){
	$("#add").click(function(){
		var stid=$("[name=stid]").val();
		var summary=$("[name=summary]").val();
		var clientid=$("[name=clientid]").val();
		var state=2;
		var srequest=$("[name=srequest]").val();
		var suid=$("[name=suid]").val();
		var createdate=$("[name=createdate]").val();
		//alert(srequest);
		//alert(stid+"     "+summary+"     "+clientid+"     "+state+"     "+srequest+"     "+suid+createdate)
		$.ajax({
			url:"../pyl/ajax!test.action",
			type:"post",
			data:{"stid":stid,"summary":summary,"clientid":clientid,"state":state,"srequest":srequest,"suid":suid,"createdate":createdate},
			dataType:"json",
			success:function(data){	
				alert("新建成功！");
				$("[name=stid]").val("");
				$("[name=summary]").val("");
				$("[name=clientid]").val("");
				$("[name=srequest]").val("");
			}
		});
	});
});
function method(){
	var now=new Date();
	var e = document.getElementById("t1");
	e.value=now.getFullYear()+"-"+ (now.getMonth()+1)+"-"+ now.getDate()+" "+ now.getHours()+":"+ now.getMinutes()+":"+ now.getSeconds();
}
setInterval(method,1000);



</script>
</head>
<body>

<div class="page_title">客户服务管理 > 服务创建</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" id="add">保存</button>  
</div>
<table class="query_form_table">
<s:form id="frm" theme="simple">
	<tr>
		<th>编号</th>
		<td><input disabled /></td>
		<th>服务类型</th>
		<td>
			
			<s:select list="#request.typelist"
					name="stid"
					listKey="stid" 
					listValue="stpoint"
			/>
			<span class="red_star">*</span>
		</td>
	</tr>
	<tr>
		<th>概要</th>
		<td colspan="3"><input size="53" name="summary" /><span class="red_star">*</span></td>
	</tr>	
	<tr>
		<th>客户</th>
		<td><input size="20" name="clientid" /><span class="red_star">*</span></td>
		<th>状态</th>
		<td>新创建</td>
	</tr>	
	<tr>
		<th>服务请求</th>
		<td colspan="3"><textarea rows="6" cols="50" name="srequest"></textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>创建人</th>
		<td><input value="${sessionScope.users.suid }" type="hidden" name="suid" /><input name="T19" value="${sessionScope.users.suname }" readonly size="20" /><span class="red_star">*</span></td>
		<th>创建时间</th>
		<td><input id="t1" name="createdate" readonly size="20" /><span class="red_star">*</span></td>
	</tr>
	</s:form>
</table>
<br />
<table disabled class="query_form_table" id="table3">
	<tr>
		<th>分配给</th>
		<td>
			<select disabled>
				<option>请选择...</option>
				<option>小明</option>
				<option>旺财</option>
				<option>球球</option>
				<option>孙小美</option>
				<option>周洁轮</option>
			</select> <span class="red_star">*</span></td>
		<th>分配时间</th>
		<td><input id="t2" name="T18" readonly size="20" /><span class="red_star">*</span></td>
	</tr>
</table>
<br />	
<table disabled class="query_form_table" id="table1">
	<tr>
		<th>服务处理</th>
		<td colspan="3"><textarea disabled rows="6" cols="50"></textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>处理人</th>
		<td><input name="T17" disabled value="刘颖" readonly size="20" /><span class="red_star">*</span></td>
		<th>处理时间</th>
		<td><input id="t3" disabled name="T16" readonly size="20" /><span class="red_star">*</span></td>
	</tr>
</table>
<br />
<table disabled class="query_form_table" id="table2">
	<tr>
		<th>处理结果</th>
		<td><input name="T10" disabled size="20" /><span class="red_star">*</span></td>
		<th>满意度</th>
		<td>
			<select name="D1" disabled>
				<option>请选择...</option>
				<option>☆☆☆☆☆</option>
				<option>☆☆☆☆</option>
				<option>☆☆☆</option>
				<option>☆☆</option>
				<option>☆</option>
			</select><span class="red_star">*</span></td>
	</tr>
</table>
<script>
	setCurTime('t1');
	setCurTime('t2');
	setCurTime('t3');
</script>
</body>
</html>