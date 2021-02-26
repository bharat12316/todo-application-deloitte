
<!DOCTYPE html>
<html lang="en">

<meta charset="UTF-8">
<%@ include file="header.jspf"%>
<%@ include file="navigation.jspf"%>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<div class="container">
	<div>
		<a type="button" class="btn btn-primary btn-md"
			href="/todo-app-0.0.1-SNAPSHOT/add-todo">Add Todo</a>
	</div>
	<br>
	<div class="panel panel-primary" style="width: 1150px">
		<div class="panel-heading" style="width: 1150px">
			<h3>List of todos</h3>
		</div>
		<div class="panel-body" style="width: 1150px">
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="20%">Description</th>
						<th width="20%">Updated Date</th>
						<th width="20%">Target Date</th>
						<th width="20%">Actions</th>
						<th width="20%">Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todos}" var="todo">
						<tr>
							<td>${todo.description}</td>
							<td><fmt:formatDate value="${todo.updatedDate}"
									pattern="dd/MM/yyyy" /></td>
							<td><fmt:formatDate value="${todo.targetDate}"
									pattern="dd/MM/yyyy" /></td>
							<td><a type="button" id="updateButton"
								class="btn btn-success"
								href="/todo-app-0.0.1-SNAPSHOT/update-todo?id=${todo.id}">Update</a>
								<a type="button" class="btn btn-warning"
								href="/todo-app-0.0.1-SNAPSHOT/delete-todo?id=${todo.id}">Delete</a></td>
							<c:choose>
								<c:when test="${todo.complete == true}">
									<td>Completed</td>
								</c:when>
								<c:otherwise>
									<td>In Progress</td>

								</c:otherwise>
							</c:choose>


						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>


<%@ include file="/footer.jspf"%>