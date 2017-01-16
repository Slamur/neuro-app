<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
      <title>Parameter editing</title>
      <script type="text/javascript" src="/resources/js/jquery-3.1.1.js"></script>
      <script type="text/javascript" src="/resources/js/jquery.validate.js"></script>

      <spring:url value="/resources/css/bootstrap.css" var="bootstrap"/>
          <link href="${bootstrap}" rel="stylesheet" />
      <script type="text/javascript" src="/resources/js/bootstrap-3.3.5.js"></script>

      <script type="text/javascript">
          $(document).ready(function() {
              $("#edit_form").validate({
                  rules : {
                      name : {
                          required : true
                      }
                  },
                  messages : {
                      name : {
                          required : "Name can't be empty"
                      }
                  }
              });
          });
      </script>
  </head>
  <body>
  <div class="container">
      <form:form id="edit_form" method="post" action="/save_parameter" modelAttribute="parameter">
          <div class="form-group">
              <label for="name">Name:</label>
              <form:input class="form-control" id="name" type="text" path="name"/>
          </div>
          <div class="form-group">
              <label for="description">Description:</label>
              <form:textarea class="form-control" id="description" path="description"/>
          </div>
          <div class="form-group">
              <label for="types">Dictionary types:</label>
              <form:select class="form-control" id="types" name="types" path="typeId">
                  <c:forEach var="type" items="${types}">
                      <form:option value="${type.id}">${type.name}</form:option>
                  </c:forEach>
              </form:select>
          </div>
          <p><input type="submit" class="btn btn-primary" value="Save"></p>
      </form:form>
  </div>
  </body>
</html>
