
<%@ include file="header.jspf"%>
<%@ include file="navigation.jspf"%>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">Add TODO</div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="todo">
						<form:hidden path="id" />
						<fieldset class="form-group">
							<form:label path="description">Description</form:label>
							<form:input path="description" type="text" class="form-control"
								required="required" />
							<form:errors path="description" cssClass="text-warning" />
						</fieldset>
						<fieldset class="form-group">
							<form:label path="targetDate">Target Date</form:label>
							<form:input path="targetDate" type="text" class="form-control"
								required="required" />
							<form:errors path="targetDate" cssClass="text-warning" />
						</fieldset>
						<fieldset class="form-group">
							<form:label path="updatedDate">Update Date</form:label>
							<form:input path="updatedDate" type="text" class="form-control"
								required="required" />
							<form:errors path="updatedDate" cssClass="text-warning" />
						</fieldset>
						<fieldset class="form-group">
							<label>Todo Status</label> <select class="form-control"
								name="complete">
								<option value="false">In Progress</option>
								<option value="true">Complete</option>
							</select>
						</fieldset>
						<button type="submit" class="btn btn-success">Save</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="footer.jspf"%>