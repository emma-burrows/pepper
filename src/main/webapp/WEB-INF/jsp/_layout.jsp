<!DOCTYPE HTML>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
    <title>${title}</title>
    <link href="//netdna.bootstrapcdn.com/bootswatch/3.0.0/cerulean/bootstrap.min.css" rel="stylesheet">
    <link href="<c:url value='/resources/css/custom.css'/>" rel="stylesheet">
  </head>
  <body style="padding-top: 70px; padding-bottom: 70px; padding-left: 1%; padding-right: 1%;">
    <header>
      <tiles:insertAttribute name="header" />
    </header>
    <div id="content" class="container">
      <tiles:insertAttribute name="body" />
    </div>
    <footer>
      <tiles:insertAttribute name="footer" />
    </footer>
    <script src="//code.jquery.com/jquery-2.0.3.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-2.0.3.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
  </body>
</html>