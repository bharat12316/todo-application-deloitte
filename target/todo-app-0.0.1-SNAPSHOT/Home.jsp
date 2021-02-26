<%@ include file="header.jspf"%>
<%@ include file="navigation.jspf"%>
<div class="container">

 <div class="panel panel-primary">
     <div class="panel-heading">Home Page</div>
        <div class="panel-body">
           Welcome ${name}!! <a href=/todo-app-0.0.1-SNAPSHOT/list-todos>Click here</a> to manage your
           todo's.
        </div>
     </div>
 </div>
<%@ include file="footer.jspf"%>