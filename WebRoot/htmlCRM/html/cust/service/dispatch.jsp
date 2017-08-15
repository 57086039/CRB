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
<title>jb-aptech��ҵ�����Ŀ</title>
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
				alert("����ɹ���");
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
		alert("ɾ���ɹ�");
	});
});
</script>
</head>
<body>

<div class="page_title">�ͻ�������� > �������</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">����</button>
	<button class="common_button" id="serviceSearch">��ѯ</button>  
</div>
<table class="query_form_table" height="53">
	<tr>
		<th height="28">�ͻ�</th>
			<td><input name="clientname" value="${sessionScope.condition.clientname }"/></td>
			<th height="28" value="${sessionScope.condition.clientname }">��Ҫ</th>
			<td><input name="summary" value="${sessionScope.condition.summary }" /></td>
			<th height="28">��������</th>
			<td>
				<s:select theme="simple" list="#request.typelist"
						 name="stid"
						listKey="stid" 
						listValue="stpoint"
				/>
			</td>
		</tr>
		<tr>
			<th height="32">��������</th>
			<td colspan="3">
				<input type="date" name="start" value="${sessionScope.condition.start }" size="50px" /> - <input type="date" name="end" value="${sessionScope.condition.end }"  size="50px" /></td>
		<th height="22">״̬</th>
		<td>
			<select name="ssid">
				<option value="2" selected>�´���</option>
			</select>
		</td>
	</tr>
</table>
<br />
<table class="data_list_table">
	<tr>
		<th>���</th>
		<th>�ͻ�</th>
		<th>��Ҫ</th>
		<th>��������</th>
		<th>������</th>
		<th>��������</th>
		<th>�����</th>
		<th>����</th>
	</tr>
	<s:iterator value="#request.servicelist" var="list">
		<tr>
		<td class="list_data_number">${list.serid }</td>
		<td class="list_data_text">${list.clienttable.clientname }</td>
		<td class="list_data_ltext">${list.summary }</td>
		<td class="list_data_text">${list.servicetypetable.stpoint }</td>
		<td class="list_data_text">${list.systemusertable.suname }</td>
		<td class="list_data_text"><s:date format="yyyy��MM��dd��" name="#list.createdate "/></td>
		<td class="list_data_text">
			<s:select theme="simple" list="#request.userlist"
					name="suid"
					listKey="suid" 
					listValue="suname"
			/>
			<s:if test="#session.users.restricttable.rid!=8">
				<button disabled="disabled" class="common_button" name="assignment" value="${list.serid }">����</button>
				 
			</s:if>
			
			<s:if test="#session.users.restricttable.rid==8">
				<button class="common_button" name="assignment" value="${list.serid }">����</button> 
			</s:if>  
			
		</td>
		<td class="list_data_op">
			<s:if test="#session.users.restricttable.rid!=8">
				<img title="ɾ��" src="<%=path %>/htmlCRM/html/images/bt_del.gif" class="op_button" />
			</s:if>  
			<s:if test="#session.users.restricttable.rid==8">
				<img onclick="to('../pyl/service!delService.action?serid=${list.serid }')"  name="delService" title="ɾ��" src="<%=path %>/htmlCRM/html/images/bt_del.gif" class="op_button" />
			</s:if>  
		</td>
	</tr>
	</s:iterator>
	
	<tr>
		<th colspan="8" class="pager">
<div class="pager">
	��<span id="count">${sessionScope.servicepage.count }</span>����¼ ÿҳ<input name="size" value="${sessionScope.servicepage.pagesize }" size="2" />��
	��<span>${sessionScope.servicepage.index }</span>ҳ/��<span id="pagecount">${sessionScope.servicepage.pagecount }</span>ҳ
	<c:if test="${sessionScope.servicepage.index==1 }">
		<span>��һҳ</span><span>��һҳ</span>
	</c:if>
	<c:if test="${sessionScope.servicepage.index!=1 }">
		<a href="../pyl/service!Change.action?index=1">��һҳ</a>
		<a href="../pyl/service!Change.action?index=${sessionScope.servicepage.index-1 }">��һҳ</a>
	</c:if>
	<c:if test="${sessionScope.servicepage.index==sessionScope.servicepage.pagecount }">
		<span>��һҳ</span><span>���һҳ</span>
	</c:if>
	<c:if test="${sessionScope.servicepage.index!=sessionScope.servicepage.pagecount }">
		<a href="../pyl/service!Change.action?index=${sessionScope.servicepage.index+1 }">��һҳ</a>
		<a href="../pyl/service!Change.action?index=${sessionScope.servicepage.pagecount }">���һҳ</a>
	</c:if>
	ת��<input name="index" value="${sessionScope.servicepage.index }" size="2" />ҳ
	<button width="20" id="pageGo">GO</button>
</div>
		</th>
	</tr>
</table>
</body>
</html>