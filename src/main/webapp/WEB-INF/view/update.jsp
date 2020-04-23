<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
		<form action="/allUp.do" method="post">
		<br>
				编号&emsp;&emsp;&emsp;&emsp;<input type="text" name="id" readonly="readonly" value="${id }"><br><br>
				用户名&emsp;&emsp;&emsp;<input type="text" name="name" ><br><br>
				日期&emsp;&emsp;&emsp;&emsp;<input type="text" name="time" onclick="WdatePicker()"><br><br>
				分发优惠券:&emsp;<span id="c"></span><br><br>
				<input type="button" value="保存" onclick="sub()">&emsp;
				<input type="button" onclick="come()" value="关闭">
		</form>
</body>
<script type="text/javascript">
		$(function(){
			$.ajax({
				url:"/selectCoupon",
				type:"post",
				dataType:"json",
				async:false,
				success:function(obj){
				/* 	alert(JSON.stringify(obj)); */
					for ( var i in obj) {
						$("#c").append("<input type='checkbox' name='ids' value='"+obj[i].cid+"'>"+obj[i].cname+"")
					}
				}
			})
			
			var id = $("[name='id']").val();
			$.ajax({
				url:"/updateto.do",
				data:{"id":id},
				type:"post",
				dataType:"json",
				success:function(obj){
				/* 	alert(JSON.stringify(obj)); */
				 	/* var  time = obj.time;
					time = new Date(time).toLocaleDateString(); */
					$("[name='name']").val(obj.name);
					$("[name='time']").val(obj.time);
					for ( var i in obj.list) {
						$("[name='ids'][value='"+obj.list[i].cid+"']").attr("checked",true);
					}
					
				}
			})
		})
		function come(){
			location.href="/list.do";
		}
		 function sub(){
			var ids=[];
			ids=$("[name='ids']:checked").map(function(){
				return  this.value;
			}).get().join();
			alert(ids);
			/* alert(ids.length); */
			if(ids.length>0){
				 $("form").submit();
			}else{
				alert("至少选择一张优惠券");
			}
		}
</script>
</html>