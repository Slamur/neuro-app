<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
      <title>Query parameter editing</title>
      <script type="text/javascript" src="/resources/js/jquery-3.1.1.js"></script>
      <script type="text/javascript" src="/resources/js/jquery.validate.js"></script>

      <spring:url value="/resources/css/bootstrap.css" var="bootstrap"/>
          <link href="${bootstrap}" rel="stylesheet" />
      <script type="text/javascript" src="/resources/js/bootstrap-3.3.5.js"></script>
  </head>
  <body>
  <div class="container">
      <form:form id="edit_form" method="post" action="/save_query_parameter" modelAttribute="queryParameter">
          <p>Name: ${parameter.name}</p>
          <p>
            <c:if test="${parameter.typeId < 4}">
                <form:input path="stringValue"/>
            </c:if>
            <c:if test="${parameter.typeId == 4}">
                <form:radiobutton path="booleanValue" value="false"/> False
                <form:radiobutton path="booleanValue" value="true"/> True
            </c:if>
            <c:if test="${parameter.typeId > 4}">
                <form:select name="values" path="idValue">
                    <c:forEach var="dictonaryValue" items="${dictionaryValues}">
                        <form:option value="${dictonaryValue.id}">${dictonaryValue.name}</form:option>
                    </c:forEach>
                </form:select>
            </c:if>
          </p>
          <p><input type="submit" value="Save"></p>
      </form:form>
  </div>
  </body>
</html>
