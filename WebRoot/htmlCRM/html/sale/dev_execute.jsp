<!DOCTYPE>
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
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="<%=path %>/htmlCRM/html/css/style.css" rel="stylesheet" type="text/css">
<script src="<%=path %>/htmlCRM/html/script/jquery-1.5.2.js"></script>
<script src="<%=path %>/htmlCRM/html/script/common.js"></script>
<script type="text/javascript">
   $(function(){
	  $("[name=baocun]").click(function(){
		 var jieguo=  $(this).prev().val();
		 var pid=$(this).prev().prev().val();
		window.location.href="../lu/kaifa!jieguo.action?jieguo="+jieguo+"&pid="+pid;
		alert("保存成功");
	  });
	
   });
</script>
</head>
<body>

<div class="page_title">客户开发计划 &gt; 执行计划</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="alert('开发失败，已归档。');window.location.href='<%=path %>/lu/kaifa!zhongzhi.action?cid=${zd.CID }';">终止开发</button>
	<button class="common_button" onclick="to('<%=path %>/lu/kaifa!zhiding.action');">返回</button>
	
	<button class="common_button" onclick="to('<%=path %>/lu/kaifa!zhiding.action');">制定计划</button>

	
	<button class="common_button" onclick="alert('用户开发成功，请添加新客户记录。');window.location.href='<%=path %>/lu/kaifa!succeed.action?cid=${zd.CID }';">开发成功</button>

	</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td>${zd.CID }</td>
		<th>机会来源</th>
		<td>
			${zd.CSOURCE	 }　　</td>
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
<table algin="chenter" class="data_list_table" id="table1">
	<tr>
		<th>日期</th>
		<th>计划</th>
		<th>执行效果</th>
	</tr>
	<div id="mydiv">
	 <c:forEach items="${lp }" var="p">
	<tr algin="center">
		<td class="list_data_text" height="24">${p.plandate }</td>
		<td class="list_data_ltext" height="24"><input size="50" value="${p.planitem }" />
		
	<!--  <input type="button" class="common_button" onclick="to('<%=path %>/lu/kaifa!del.action?pid=${p.planid }&cid=${zd.CID  }');" value="删除"/>-->
		<td class="list_data_ltext"><input type="hidden" value="${p.planid }"/><input name="jieguo" value="${p.effect }" type="text"/>　
	<button name="baocun" >保存</button>
		</td>
	</tr>
	</c:forEach>
	</div>
	</table>
</body>
</html>