<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="configurations" required="true" type="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="configuration" items="${configurations}">
    <div class="row">
        <div class="col-md-6 col-lg-3">
            <label for="configurationsKeyValueMap[${configuration.configuratorType}][${configuration.configurationLabel}]">
                    ${configuration.configurationLabel}
            </label>
        </div>
        <div class="col-md-6">
            <c:choose>
                <c:when test="${configuration.configurationValue eq 'true'}">
                    <input id="configurationsKeyValueMap[${configuration.configuratorType}][${configuration.configurationLabel}]"
                           name="configurationsKeyValueMap[${configuration.configuratorType}][${configuration.configurationLabel}]"
                           type="checkbox" checked="checked">
                </c:when>
                <c:otherwise>
                    <input id="configurationsKeyValueMap[${configuration.configuratorType}][${configuration.configurationLabel}]"
                           name="configurationsKeyValueMap[${configuration.configuratorType}][${configuration.configurationLabel}]"
                           type="checkbox">
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</c:forEach>