<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
			<form action="add.doing" method="post">
		<br>
				
				用户名&emsp;&emsp;&emsp;<input type="text" name="name" ><br><br>
				日期&emsp;&emsp;&emsp;&emsp;<input type="text" name="time" onclick="WdatePicker()"><br><br>
				分发优惠券:&emsp;
				<input name="ids" type="checkbox" value="1">笔记本100元优惠券&emsp;
				<input name="ids" type="checkbox" value="2">内存50元优惠券&emsp;
				<input name="ids" type="checkbox" value="3">手机200元优惠券&emsp;<br><br>
				<input type="button" value="保存" onclick="sub()">&emsp;
				<input type="button" onclick="come()" value="关闭">
		</form>
</body>
<script type="text/javascript">
function come(){
	location.href="/list.do";
}
function sub(){
	var ids=[];
	ids=$("[name='ids']:checked").map(function(){
		return  this.value;
	}).get().join();
	/* alert(ids); */
	if(ids.length>0){
		$("form").submit();
	}else{
		alert("至少选择一张优惠券");
	}
}
</script>
</html>