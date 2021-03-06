<!DOCTYPE HTML>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
  <head>
    <c:set var="uri">${pageContext.request.requestURI}</c:set>
    <c:set var="url">${pageContext.request.requestURL}</c:set>
    <c:set var="path">${pageContext.request.contextPath}</c:set>
    <base
      href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${path}/"/>
    <title>Pepper</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="css/cerulean.min.css">
    <link rel="stylesheet" href="css/layout.css">
    <link rel="stylesheet" href="css/autocomplete.css">
  </head>
  <body>
    <div id="wrap">
      <tiles:insertAttribute name="header"/>
      <div id="content" class="container">
        <tiles:insertAttribute name="body"/>
      </div>
    </div>
    <tiles:insertAttribute name="footer"/>
    <script src="javascript/jquery-2.0.3.min.js"></script>
    <script src="javascript/bootstrap-3.0.0/js/bootstrap.min.js"></script>
    <script src="javascript/jquery-ui-1.10.3.custom.min.js"></script>
    <script src="javascript/docready.js"></script>
  </body>
</html>
