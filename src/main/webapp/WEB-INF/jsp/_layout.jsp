<!DOCTYPE HTML>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>${title}</title>
    <link href="/pepper/css/cerulean.min.css" rel="stylesheet">
    <link href="/pepper/css/custom.css" rel="stylesheet">
  </head>
  <body>
    <header>
      <tiles:insertAttribute name="header" />
    </header>
    <div id="content" class="container">
      <tiles:insertAttribute name="body" />
    </div>
    <footer>
      <tiles:insertAttribute name="footer" />
    </footer>
    <script src="/pepper/javascript/jquery-2.0.3.min.js"></script>
    <script src="/pepper/javascript/bootstrap-3.0.0/js/bootstrap.min.js"></script>
    <script src="/pepper/javascript/formula.js"></script>
  </body>
</html>
