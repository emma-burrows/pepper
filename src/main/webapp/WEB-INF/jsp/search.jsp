<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <form action="search" method="get">
      <input type="search" name="name"/>
      <input type="submit" value="Submit"/>
    </form>
    <c:if test="${not empty drugs}">
      <c:forEach var="drug" items="${drugs}">
        <p>${drug.name}</p>
      </c:forEach>
    </c:if>
