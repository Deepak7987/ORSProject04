<%@page import="com.rays.pro4.controller.OrderCtl"%>
<%@page import="com.rays.pro4.controller.PaymentCtl"%>
<%@page import="com.rays.pro4.Util.DataUtility"%>
<%@page import="com.rays.pro4.Util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<jsp:useBean id="bean" class="com.rays.pro4.Bean.OrderBean"
			scope="request"></jsp:useBean>
<form action="<%=ORSView.ORDER_CTL%>" method="post">
		<%@ include file="Header.jsp"%>

		<%
			String uri = (String) request.getAttribute("URI");
			System.out.print("uri in jsp" + uri);
		%>
		<input type="hidden" name="URI" value="<%=uri%>">
		<input type="hidden" name="id" value="<%=bean.getId()%>">
		<center>
		<%if(bean.getId()>0){ %>
			<h1>update Order</h1>
		<%}else{ %>
			<h1>Add Order</h1>
			<%} %>
			
			<H2>
				<font color="red"> <%=ServletUtility.getErrorMessage(request)%>
				</font>
			</H2>	
			<h2>
				<font color="green"> <%=ServletUtility.getSuccessMessage(request)%></font>
			</h2>


			<table>
				<tr>
					<th>Name<font color="red">*</font></th>
					<td><input type="text" name="name" size=30
						placeholder="Enter valid Email-Id"
						value="<%=(DataUtility.getStringData(bean.getName())) %>"><font
						style="position: fixed" color="red"> <%=ServletUtility.getErrorMessage("name", request)%></font></td>
				</tr>
				<tr>
					<th>Date<font color="red">*</font></th>
					<td><input type="text" name="dob" size=30
						placeholder="Enter amount"
						value="<%=(DataUtility.getStringData(bean.getDob())) %>"><font
						style="position: fixed" color="red"> <%=ServletUtility.getErrorMessage("dob", request)%></font></td>
				</tr>
				<tr>
					<th>Order type<font color="red">*</font></th>
					<td><input type="text" name="ordertype" size=30
						placeholder="Enter amount"
						value="<%=(DataUtility.getStringData(bean.getOrdertype())) %>"><font
						style="position: fixed" color="red"> <%=ServletUtility.getErrorMessage("ordertype", request)%></font></td>
				</tr>
				<%if(bean.getId()>0){ %>
				<tr>
					<th></th>
					<td colspan="2"><input type="submit" name="operation"
						value="<%=OrderCtl.OP_UPDATE%>"></td> &nbsp;
						<%--  <input
						type="submit" name="operation" value="<%=LoginCtl.OP_SIGN_UP%>">
						&nbsp;</td> --%>
				</tr>
			
		<%}else{ %>
			
			
				
				<tr>
					<th></th>
					<td colspan="2"><input type="submit" name="operation"
						value="<%=OrderCtl.OP_SAVE%>"></td> &nbsp;
						<%--  <input
						type="submit" name="operation" value="<%=LoginCtl.OP_SIGN_UP%>">
						&nbsp;</td> --%>
				</tr>
				<%} %>
				<%-- <tr>
					<th></th>
					<td><a href="<%=ORSView.FORGET_PASSWORD_CTL%>"><b>Forget
								my password</b></a>&nbsp;</td>
				</tr> --%>
			</table>
	</form>
	</center>
	<%@ include file="Footer.jsp"%>



</body>
</html>