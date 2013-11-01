<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
  <c:when test="${not empty drugs}">
    <c:set var="count" value="1" scope="page" />

    <!-- Drug result accordion -->
    <div class="panel-group" id="accordion">

      <c:forEach var="drug" items="${drugs}">
        <div class="panel panel-default">
          <div class="panel-heading">
            <h4 class="panel-title">
              <a class="accordion-toggle" data-toggle="collapse"
                data-parent="#accordion" href="#drug${count}">
                ${drug.name}</a>
            </h4>
          </div>
          <div id="drug${count}" class="panel-collapse collapse">
            <div class="panel-body">
              <dl class="dl-horizontal">
                <dt>formula</dt>
                <dd class="formula">${drug.formula}</dd>
                <dt>weight (g/mol)</dt>
                <dd>${drug.weight}</dd>
                <dt>CAS</dt>
                <dd>${drug.cas}</dd>
                <dt>ATC</dt>
                <dd>${drug.atc}</dd>
                <dt>UNII</dt>
                <dd>${drug.unii}</dd>
                <dt>structure</dt>
                <dd>
                  <img src="/pepper/images/${drug.imageName}.png"
                    width="300">
                </dd>
              </dl>
            </div>
          </div>
        </div>
        <c:set var="count" value="${count + 1}" scope="page" />
      </c:forEach>

    </div>
    <!-- End accordion div -->
  </c:when>
  <c:otherwise>
    <p>Please perform a search.</p>
  </c:otherwise>
</c:choose>
