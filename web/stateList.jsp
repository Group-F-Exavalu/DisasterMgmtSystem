<%-- 
    Document   : stateList
    Created on : Feb 13, 2023, 11:58:23 AM
    Author     : hp
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<option >select a province</option>
<c:if test="${User.getCountry()!=null}">
<c:forEach items="${StateList}" var="state">
    <option value=${state.getState()} <c:if test="${state.getState().equalsIgnoreCase(User.getState())}" > selected </c:if>> 
        ${state.getStateName()}  
    </option>
</c:forEach>
    </c:if>
    <c:if test="${Organisation.getCountry()!=null}">
<c:forEach items="${StateList}" var="state">
    <option value=${state.getState()} <c:if test="${state.getState().equalsIgnoreCase(Organisation.getState())}" > selected </c:if>> 
        ${state.getStateName()}  
    </option>
</c:forEach>
    </c:if>