<!DOCTYPE HTML>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
  <head>
    <c:set var="uri">${pageContext.request.requestURI}</c:set>
    <c:set var="url">${pageContext.request.requestURL}</c:set>
    <c:set var="path">${pageContext.request.contextPath}</c:set>
    <base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${path}/"/>
    <title>${title}</title>
    <link href="css/cerulean.min.css" rel="stylesheet">
    <link href="css/custom.css" rel="stylesheet">
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
    <script src="javascript/jquery-2.0.3.min.js"></script>
    <script src="javascript/bootstrap-3.0.0/js/bootstrap.min.js"></script>
    <script src="javascript/formula.js"></script>
  </body>
</html>
