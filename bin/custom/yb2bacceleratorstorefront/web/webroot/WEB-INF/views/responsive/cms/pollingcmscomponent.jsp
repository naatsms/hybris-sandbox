<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="poll">
    <div class="variants">
        <div class="item-box" style="font-weight: bold">${question}</div>
        <form:form>
        <fieldset>
                <c:choose>
                    <c:when test="${pollType.equals('MULTI')}">
                        <c:forEach items="${answers}" var="variant">
                            <label><input type="checkbox">${variant}</label><br/>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${answers}" var="variant">
                            <label><input type="radio">${variant}</label><br/>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </fieldset>
            <input type="submit" value="Send">
        </form:form>
    </div>
</div>