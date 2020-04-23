<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/css/index3.css" rel="stylesheet">
<script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
</head>
<body>
<form action="/list.do" method="post">
					
		<table>
				
				<tr>
						<td	colspan="10">
								<input type="button" onclick="add()" value="新增">
						</td>
				</tr>
				<tr>
						<td><input type="checkbox" class="cx" onclick="qfx()"></td>
						<td>编号</td>
						<td>用户名</td>
						<td>日期</td>
						<td>拥有优惠券</td>
						<td>操作</td>
				</tr>
				<c:forEach items="${list }" var="c">
						<tr>
							<td><input type="checkbox" class="cx" value="${c.id }"></td>
							<td>${c.id }</td>
							<td>${c.name }</td>
							<td><fmt:formatDate value="${c.time }" pattern="yyyy-MM-dd"/></td>
							<td>${c.names }</td>
							<td><input type="button" value="查看" onclick="update(${c.id})"></td>
						</tr>
				</c:forEach>
				<tr>
					<td colspan="10">
							当前第${info.pageNum }/${info.pages }页&emsp;共${info.total }条数据&emsp;
							<a onclick="page(1)">首页</a>&emsp;
							<a onclick="page(${info.prePage==0?1:info.prePage})">上一页</a>&emsp;
							<input type="text" style="width:36px" id="pageNum">
							<a onclick="page(${info.nextPage==0?info.pages:info.nextPage})">下一页</a>&emsp;
							<a onclick="page(${info.pages})">尾页</a>&emsp;
							<a onclick="page()">跳转</a>
					</td>
				</tr>
		</table>
</form>
</body>
<script type="text/javascript">
		function page(pageNum){
			if(pageNum == null){
				var num=$("#pageNum").val();
			/* 	alert(num); */
				location.href="/list.do?pageNum="+num;
			}else{
				location.href="/list.do?pageNum="+pageNum;
			}
		}
		function qfx(){
			$(".cx").each(function(){
				this.checked = !this.checked
			})
		}
		function update(id){
			 location.href="/update.do?id="+id; 
		}
		function add(){
			location.href="/add.do";
		}
</script>
</html>