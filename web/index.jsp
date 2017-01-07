<%@ page import="com.slamur.app.neuro.model.AlgorithmEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
  <head>
      <title>$Title$</title>
      <script type="text/javascript" src="resources/js/jquery-3.1.1.js"></script>

      <spring:url value="resources/css/bootstrap.css" var="bootstrap"/>
      <link href="${bootstrap}" rel="stylesheet" />
      <script type="text/javascript" src="resources/js/bootstrap-3.3.5.js"></script>
  </head>
  <body>
  <div class="container">
      <ul class="nav nav-tabs" role="tablist">
          <li role="presentation" class="active"><a href="#dictionaries" aria-controls="dictionaries" role="tab" data-toggle="tab">Dictionaries</a></li>
          <li role="presentation"><a href="#queries" aria-controls="queries" role="tab" data-toggle="tab">Queries</a></li>
      </ul>

      <div class="tab-content">
          <div role="tabpanel" class="tab-pane active" id="dictionaries">
              <table>
                  <thead>Algorithms</thead>
                  <c:forEach items="${algorithms}" var="algorithm">
                      <td>${algorithm.id}</td>
                      <td>${algorithm.name}</td>
                      <td>${algorithm.description}</td>
                  </c:forEach>
              </table>
              Dictionaries
          </div>

          <div role="tabpanel" class="tab-pane" id="queries">
              Queries
          </div>
      </div>


  </div>
  </body>
</html>
