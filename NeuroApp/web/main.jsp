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
              <table class="table table-striped">
                  <caption>Algorithms</caption>
                  <thead>
                    <tr>
                        <td>Id</td>
                        <td>Name</td>
                        <td>Description</td>
                    </tr>
                  </thead>
                  <c:forEach items="${algorithms}" var="algorithm">
                      <tr>
                          <td>${algorithm.id}</td>
                          <td>${algorithm.name}</td>
                          <td>${algorithm.description}</td>
                      </tr>
                  </c:forEach>
              </table>

              <table class="table table-striped">
                  <caption>Networks</caption>
                  <thead>
                  <tr>
                      <td>Id</td>
                      <td>Name</td>
                      <td>Description</td>
                  </tr>
                  </thead>
                  <c:forEach items="${networks}" var="network">
                      <tr>
                          <td>${network.id}</td>
                          <td>${network.name}</td>
                          <td>${network.description}</td>
                      </tr>
                  </c:forEach>
              </table>

              <table class="table table-striped">
                  <caption>Parameter types</caption>
                  <thead>
                  <tr>
                      <td>Id</td>
                      <td>Name</td>
                      <td>Description</td>
                  </tr>
                  </thead>
                  <c:forEach items="${parameterTypes}" var="parameterType">
                      <tr>
                          <td>${parameterType.id}</td>
                          <td>${parameterType.name}</td>
                          <td>${parameterType.description}</td>
                      </tr>
                  </c:forEach>
              </table>
          </div>

          <div role="tabpanel" class="tab-pane" id="queries">
              Queries
          </div>
      </div>


  </div>
  </body>
</html>
