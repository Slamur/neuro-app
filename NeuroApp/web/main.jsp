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

      <script type="text/javascript">
          $(document).ready(function(){
              if(window.location.hash != "") {
                  $('a[href="' + window.location.hash + '"]').click()
              }
          });
      </script>
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
              <form:form action="/create_parameter" method="get">
                  <input type="submit" value="Add parameter"/>
              </form:form>

              <table class="table table-striped">
                  <caption>Parameters</caption>
                  <thead>
                  <tr>
                      <td>Id</td>
                      <td>Name</td>
                      <td>Description</td>
                      <td>Type</td>
                      <td>Actions</td>
                  </tr>
                  </thead>
                  <c:forEach items="${parameters}" var="parameter">
                      <tr>
                          <td>${parameter.id}</td>
                          <td>${parameter.name}</td>
                          <td>${parameter.description}</td>
                          <td>${types.get(parameter.typeId - 2).name}</td>
                          <td>
                              <form:form action="/edit_parameter/${parameter.id}" method="get">
                                  <input type="submit" value="Edit"/>
                              </form:form>

                              <form:form action="/delete_parameter/${parameter.id}" method="get">
                                  <input type="submit" value="Delete"/>
                              </form:form>
                          </td>
                      </tr>
                  </c:forEach>
              </table>
          </div>

          <div role="tabpanel" class="tab-pane" id="queries">
              <form:form action="/create_query" method="get">
                  <input type="submit" value="Add query"/>
              </form:form>

              <table class="table table-striped">
                  <caption>Queries</caption>
                  <thead>
                  <tr>
                      <td>Id</td>
                      <td>Added time</td>
                      <td>Started time</td>
                      <td>Ended time</td>
                      <td>Result</td>
                      <td>Actions</td>
                  </tr>
                  </thead>
                  <c:forEach items="${queries}" var="query">
                      <tr>
                          <td>${query.id}</td>
                          <td>${query.timeAdded}</td>
                          <td>${query.timeStarted}</td>
                          <td>${query.timeFinished}</td>
                          <td>${query.resultString}</td>
                          <td>
                              <form:form action="/edit_query/${query.id}" method="get">
                                  <input type="submit" value="Edit parameters"/>
                              </form:form>

                              <form:form action="/delete_query/${query.id}" method="get">
                                  <input type="submit" value="Delete"/>
                              </form:form>

                              <c:if test="${query.stateType < states.length - 1}">
                                  <form:form action="/change_query_state/${query.id}" method="get">
                                      <input type="submit" value="${states[query.stateType + 1]}"/>
                                  </form:form>
                              </c:if>
                          </td>
                      </tr>
                  </c:forEach>
              </table>
          </div>
      </div>


  </div>
  </body>
</html>
