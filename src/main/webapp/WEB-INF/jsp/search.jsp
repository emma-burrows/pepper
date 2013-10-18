<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="search" method="get">
  <input type="search" name="name"/>
  <input type="submit" value="Submit"/>
</form>
<c:if test="${not empty drugs}">
  <ul>
    <c:forEach var="drug" items="${drugs}">
      <li>${drug.name}
        <ul>
          <li>${drug.formula}</li>
          <li>${drug.weight}</li>
        </ul>
      </li>
    </c:forEach>
  </ul>
</c:if>
