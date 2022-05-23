<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>预借书籍</title>
	<%@ include file="/pages/common/head.jsp"%>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/Logo_深学习-100-480x200px_youtube.png" >
			<span class="wel_word">预借书籍</span>

		<%@ include file="/pages/common/login_success_menu.jsp"%>

	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>书籍名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>		
			<tr>
				<td>时间简史</td>
				<td>2</td>
				<td>30.00</td>
				<td>60.00</td>
				<td><a href="#">删除</a></td>
			</tr>	
			
			<tr>
				<td>母猪的产后护理</td>
				<td>1</td>
				<td>10.00</td>
				<td>10.00</td>
				<td><a href="#">删除</a></td>
			</tr>	
			
			<tr>
				<td>百年孤独</td>
				<td>1</td>
				<td>20.00</td>
				<td>20.00</td>
				<td><a href="#">删除</a></td>
			</tr>		
			
		</table>
		
		<div class="cart_info">
			<span class="cart_span">预借书籍中共有<span class="b_count">4</span>件书籍</span>
			<span class="cart_span">总金额<span class="b_price">90.00</span>元</span>
			<span class="cart_span"><a href="#">清空预借书籍</a></span>
			<span class="cart_span"><a href="pages/cart/checkout.jsp">去结账</a></span>
		</div>
	
	</div>


	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>