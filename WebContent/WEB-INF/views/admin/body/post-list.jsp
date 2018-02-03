<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1 class="page-header">
	Post List <small>admin</small>
</h1>

<!-- Post View Table -->
<table class="table table-hover table-responsive table-bordered">
	<thead>
		<tr>
			<th>Serial No.</th>
			<th>Title</th>
			<th>Text</th>
			<th>File</th>
			<th>Date</th>
		</tr>
	</thead>
	<tbody>
		<%
			int count = 1;
		%>
		<c:forEach items="${list}" var="post">
			<tr>
				<td><%=count%></td>
				<%
					count++;
				%>
				<td>${post.title}</td>
				<td>${post.description}</td>
				<td>${post.date}</td>
				<td><a href="post-list/e/${post.id}">edit</a></td>
				<td><a href="post-list/d/${post.id}">delete</a></td>
			</tr>
		</c:forEach>

	</tbody>
</table>