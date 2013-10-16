<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <c:if test="${not empty drugs}">
     <c:forEach var="drug" items="${drugs}">
       <p>${drug.name}</p>
     </c:forEach>
   </c:if>
