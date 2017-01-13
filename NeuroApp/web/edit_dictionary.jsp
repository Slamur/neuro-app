<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
      <title>!!! TODO change to entity class name ??? Dictionary editing</title>
      <script type="text/javascript" src="resources/js/jquery-3.1.1.js"></script>

      <spring:url value="resources/css/bootstrap.css" var="bootstrap"/>
      <link href="${bootstrap}" rel="stylesheet" />
      <script type="text/javascript" src="resources/js/bootstrap-3.3.5.js"></script>
  </head>
  <body>
  <div class="container">
      <form:form method="post" action="/save_dictionary" modelAttribute="dictionary">
          <p><form:input type="text" required="true" title="Name" path="name"/></p>
          <p><form:textarea name="description" title="Description" path="description"/></p>
          <p>
            <form:select name="types" path="typeId">
              <c:forEach var="type" items="${types}">
                  <form:option value="${type.id}">${type.name}</form:option>
              </c:forEach>
            </form:select>
          </p>
          <p><input type="submit" value="Save"></p>
      </form:form>

      <%--rows="10" cols="45"--%>


  </div>
  </body>
</html>
