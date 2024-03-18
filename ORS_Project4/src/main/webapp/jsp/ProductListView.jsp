<%@page import="com.rays.pro4.controller.ProductListCtl"%>
<%@page import="com.rays.pro4.Bean.ProductBean"%>
<%@page import="com.rays.pro4.Bean.OrderBean"%>
<%@page import="com.rays.pro4.controller.OrderListCtl"%>
<%@page import="com.rays.pro4.Bean.PaymentBean"%>
<%@page import="com.rays.pro4.controller.PaymentListCtl"%>
<%@page import="com.rays.pro4.Model.RoleModel"%>
<%@page import="com.rays.pro4.Util.HTMLUtility"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.pro4.Util.DataUtility"%>
<%@page import="com.rays.pro4.Util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<link rel="icon" type="image/png"
	href="<%=ORSView.APP_CONTEXT%>/img/logo.png" sizes="16*16" />
<title>PRODUCT List</title>

<script src="<%=ORSView.APP_CONTEXT%>/js/jquery.min.js"></script>
<script src="<%=ORSView.APP_CONTEXT%>/js/Checkbox11.js"></script>


<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</head>
<body>
	<jsp:useBean id="bean" class="com.rays.pro4.Bean.ProductBean"
		scope="request"></jsp:useBean>
	<%@include file="Header.jsp"%>


	<form action="<%=ORSView.PRODUCT_LIST_CTL%>" method="post">

		<center>

			<div align="center">
				<h1>PRODUCT List</h1>
				<h3>
					<font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
					<font color="green"><%=ServletUtility.getSuccessMessage(request)%></font>
				</h3>

			</div>

			<%
				List lmodel = (List) request.getAttribute("PRODUCTModel");
				//	List rlist = (List) request.getAttribute("RoleList");

				//List ulist = (List) request.getAttribute("LoginId");

				int next = DataUtility.getInt(request.getAttribute("nextlist").toString());
			%>


			<%
				int pageNo = ServletUtility.getPageNo(request);
				int pageSize = ServletUtility.getPageSize(request);
				int index = ((pageNo - 1) * pageSize) + 1;

				List list = ServletUtility.getList(request);
				Iterator<ProductBean> it = list.iterator();

			%>
			
			<tr>
					<th></th>
					
					<td align="center"><label>Name</font> :
					</label> <input type="text" name="name" placeholder="Enter  name"
						value="<%=ServletUtility.getParameter("name", request)%>">
						</tr>
						
						<tr>
						<tr>
					<th></th>
					
					<td align="center"><label>Description</font> :
					</label> <input type="text" name="description" placeholder="Enter  description"
						value="<%=ServletUtility.getParameter("description", request)%>">
						</tr>
						
						<tr>
					<th></th>
					
					<td align="center"><label>Size</font> :
					</label> <input type="text" name="size" placeholder="Enter  size"
						value="<%=ServletUtility.getParameter("size", request)%>">
						</tr>
							<tr>
					<th></th>
					
					<td align="center"><label>Prize</font> :
					</label> <input type="text" name="prize" placeholder="Enter  prize"
						value="<%=ServletUtility.getParameter("prize", request)%>">
						</tr>
						
						<tr>
						
						<tr>
						
						
						
						<input type="submit" name="operation"
						value="<%=ProductListCtl.OP_SEARCH%>"> &nbsp; <input
						type="submit" name="operation" value="<%=OrderListCtl.OP_RESET%>">
						</tr>

			<table border="1" width="100%" align="center" cellpadding=6px
				cellspacing=".2">
				<tr style="background: skyblue">
					<th><input type="checkbox" id="select_all" name="select">Select
						All</th>
					<th>id</th>
					<th>Name</th>
					<th>Description</th>
					<th>Size</th>
					<th>Prize</th>
					<th>Edit</th>
				</tr>

				<%
					while (it.hasNext()) {
							bean = it.next();
				%>


				<tr align="center">
					<td><input type="checkbox" class="checkbox" name="ids"
						value="<%=bean.getId()%>" ></td>
					<td><%=index++%></td>
					<td><%=bean.getName() %></td>
					<td><%=bean.getDescription() %></td>
					<td><%=bean.getSize() %></td>
					<td><%=bean.getPrize() %></td>
					<td><a href="ProductCtl?id=<%=bean.getId()%>">Edit</a></td>
				</tr>
				<%
					}
				%>
			</table>

			<table width="100%">
				<tr>
					<th></th>
					<%
						if (pageNo == 1) {
					%>
					<td><input type="submit" name="operation" disabled="disabled"
						value="<%=ProductListCtl.OP_PREVIOUS%>"></td>
					<%
						} else {
					%>
					<td><input type="submit" name="operation"
						value="<%=ProductListCtl.OP_PREVIOUS%>"></td>
					<%
						}
					%>

					<td><input type="submit" name="operation"
						value="<%=ProductListCtl.OP_DELETE%>"></td>
					<td><input type="submit" name="operation"
						value="<%=ProductListCtl.OP_NEW%>"></td>

					<%--  <%	PAYMENTModel model = new PAYMENTModel();
                     %>
                     
                     <% if(list.size() < pageSize || model.nextPK()-1 == bean.getId() ){%>

                     		<td align="right"><input type="submit" name="operation" disabled="disabled" value="<%=PAYMENTListCtl.OP_NEXT%>"></td>
                     <% }else{%>
                     		<td align="right"><input type="submit" name="operation" value="<%=PAYMENTListCtl.OP_NEXT%>"></td>
                     <%} %>
        --%>
					<td align="right"><input type="submit" name="operation"
						value="<%=ProductListCtl.OP_NEXT%>"
						<%=(list.size() < pageSize || next == 0) ? "disabled" : ""%>></td>



				</tr>
			</table>
			<%
				if (list.size() == 0) {
			%>
			<td align="center"><input type="submit" name="operation"
				value="<%=ProductListCtl.OP_BACK%>"></td>
			<%
				}
			%>

			<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
				type="hidden" name="pageSize" value="<%=pageSize%>">
	</form>
	</br>
	</br>
	</br>
	</br>
	</br>
	</br>
	</br>

	</center>

	<%@include file="Footer.jsp"%>
</body>
</html>
