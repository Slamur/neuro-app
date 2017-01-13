<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
      <title>Neuro app entities</title>
      <script type="text/javascript" src="resources/js/jquery-3.1.1.js"></script>

      <spring:url value="resources/css/bootstrap.css" var="bootstrap"/>
      <link href="${bootstrap}" rel="stylesheet" />
      <script type="text/javascript" src="resources/js/bootstrap-3.3.5.js"></script>
  </head>
  <body>
  <div class="container">

      <ul class="nav nav-tabs" role="tablist">
          <li role="presentation" class="active"><a href="#dictionaries" aria-controls="dictionaries" role="tab" data-toggle="tab">Dictionaries</a></li>
          <li role="presentation"><a href="#parameters" aria-controls="parameters" role="tab" data-toggle="tab">Parameters</a></li>
          <li role="presentation"><a href="#queries" aria-controls="queries" role="tab" data-toggle="tab">Queries</a></li>
      </ul>

      <div class="tab-content">
          <div role="tabpanel" class="tab-pane active" id="dictionaries">
              <form:form action="/create_dictionary" method="get">
                  <input type="submit" value="Add dictionary record"/>
              </form:form>

              <c:forEach items="${dictionaries}" var="dictionariesByType">
                  <table class="table table-striped">
                      <caption>${dictionariesByType.key.name}s</caption>
                      <thead>
                      <tr>
                          <td>Id</td>
                          <td>Name</td>
                          <td>Description</td>
                          <td>Actions</td>
                      </tr>
                      </thead>
                      <c:forEach items="${dictionariesByType.value}" var="dictionary" varStatus="loop">
                          <tr>
                              <td>${loop.count}</td>
                              <td>${dictionary.name}</td>
                              <td>${dictionary.description}</td>
                              <td>
                                  <form:form action="/edit_dictionary/${dictionary.id}" method="get">
                                      <input type="submit" value="Edit"/>
                                  </form:form>

                                  <form:form action="/delete_dictionary/${dictionary.id}" method="get">
                                      <input type="submit" value="Delete"/>
                                  </form:form>
                              </td>
                          </tr>
                      </c:forEach>

                  </table>
              </c:forEach>
          </div>

          <div role="tabpanel" class="tab-pane" id="parameters">
              <table class="table table-striped">
                  <caption>Parameters</caption>
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
              <table class="table table-striped">
                  <caption>Queries</caption>
                  <thead>
                  <tr>
                      <td>Id</td>
                      <td>Added time</td>
                      <td>Started time</td>
                      <td>Ended time</td>
                      <td>Result</td>
                  </tr>
                  </thead>
                  <c:forEach items="${queries}" var="query">
                      <tr>
                          <td>${query.id}</td>
                          <td>${query.timeAdded}</td>
                          <td>${query.timeStarted}</td>
                          <td>${query.timeEnded}</td>
                          <td>${query.resultString}</td>
                      </tr>
                  </c:forEach>
              </table>
          </div>
      </div>


  </div>
  </body>
</html>
