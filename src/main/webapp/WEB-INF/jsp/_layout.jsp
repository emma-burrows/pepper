<!DOCTYPE HTML>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
    <title>${title}</title>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
    <div id="header">
      <tiles:insertAttribute name="header" />
    </div>
    <div id="body">
      <tiles:insertAttribute name="body" />
    </div>
    <div id="footer">
      <tiles:insertAttribute name="footer" />
    </div>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
  </body>
</html>