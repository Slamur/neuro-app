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
  </head>
  <body>
  <div class="container">
      <form:form method="post" action="/save_query" modelAttribute="query">
          <input type="submit" class="btn btn-primary"
                 value="Save query" style="margin-top: 25px">
      </form:form>

      <form:form action="/create_query_parameter" method="post" modelAttribute="queryParameter">
          <div class="form-group">
              <label for="parameters">Parameters: </label>
              <form:select class="form-control" id="parameters" name="parameters" path="parameterId">
                  <c:forEach var="parameter" items="${parameters}">
                      <form:option value="${parameter.id}">${parameter.name}</form:option>
                  </c:forEach>
              </form:select>
          </div>
          <input type="submit" class="btn btn-success" value="Add query parameter"/>
      </form:form>

      <table class="table table-striped">
          <caption>Query parameters</caption>
          <thead>
          <tr>
              <td>Id</td>
              <td>Parameter</td>
              <td>Value</td>
              <td>Actions</td>
          </tr>
          </thead>
          <c:forEach items="${queryParameters}" var="queryParameter" varStatus="loop">
              <tr>
                  <td>${loop.count}</td>
                  <td>${queryParameter.parameter.name}</td>
                  <td>
                      <c:if test="${queryParameter.parameter.typeId <= 4}">
                          ${queryParameter.value}
                      </c:if>
                      <c:if test="${queryParameter.parameter.typeId > 4}">
                          ${valueNames.get(queryParameter.value)}
                      </c:if>
                  </td>
                  <td>
                      <form:form action="/edit_query_parameter/${queryParameter.id}" method="get">
                          <input type="submit" class="btn btn-primary" value="Edit"/>
                      </form:form>

                      <form:form action="/delete_query_parameter/${queryParameter.id}" method="get">
                          <input type="submit" class="btn btn-danger" value="Delete"/>
                      </form:form>
                  </td>
              </tr>
          </c:forEach>
      </table>
  </div>
  </body>
</html>
