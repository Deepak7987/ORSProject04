<%@page import="com.rays.pro4.controller.LessionCtl"%>
<%@page import="com.rays.pro4.Util.DataUtility"%>
<%@page import="com.rays.pro4.Util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCName html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<jsp:useBean id="bean" class="com.rays.pro4.Bean.LessionBean"
		scope="request"></jsp:useBean>
	<form action="<%=ORSView.LESSION_CTL%>" method="post">
		<%@ include file="Header.jsp"%>

		<%
			String uri = (String) request.getAttribute("URI");
			System.out.print("uri in jsp" + uri);
		%>
		<input Name="hidden" name="URI" value="<%=uri%>"> <input
			Name="hidden" name="id" value="<%=bean.getId()%>">
		<center>
			<%
				if (bean.getId() > 0) {
			%>
			<h1>update LESSION</h1>
			<%
				} else {
			%>
			<h1>Add LESSION</h1>
			<%
				}
			%>

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
						value="<%=DataUtility.getStringData(bean.getName())%>"><font
						style="position: fixed" color="red"> <%=ServletUtility.getErrorMessage("name", request)%></font></td>
				</tr>
				<tr>
					<th>Subject<font color="red">*</font></th>
					<td><input type="text" name="subject" size=30
						placeholder="Enter valid Email-Id"
						value="<%=DataUtility.getStringData(bean.getSubject())%>"><font
						style="position: fixed" color="red"> <%=ServletUtility.getErrorMessage("subject", request)%></font></td>
				</tr>

				<%
					if (bean.getId() > 0) {
				%>
				<tr>
					<th></th>
					<td colspan="2"><input type="submit" name="operation"
						value="<%=LessionCtl.OP_UPDATE%>"></td> &nbsp;
					<%--  <input
						Name="submit" name="operation" value="<%=LoginCtl.OP_SIGN_UP%>">
						&nbsp;</td> --%>
				</tr>

				<%
					} else {
				%>



				<tr>
					<th></th>
					<td colspan="2"><input type="submit" name="operation"
						value="<%=LessionCtl.OP_SAVE%>"></td> &nbsp;
					<%--  <input
						Name="submit" name="operation" value="<%=LoginCtl.OP_SIGN_UP%>">
						&nbsp;</td> --%>
				</tr>
				<%
					}
				%>
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