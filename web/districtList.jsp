<%-- 
    Document   : districtList
    Created on : Feb 13, 2023, 2:08:44 PM
    Author     : hp
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<option >select a district</option>
<c:if test="${User.getState()!=null}">
<c:forEach items="${DistList}" var="district">
    <option value=${district.getDistrict()} <c:if test="${district.getDistrict().equalsIgnoreCase(User.getDistrict())}" > selected </c:if>> 
        ${district.getDistrictName()}  
    </option>
</c:forEach>
    </c:if>
    <c:if test="${Organisation.getState()!=null}">
<c:forEach items="${DistList}" var="district">
    <option value=${district.getDistrict()} <c:if test="${district.getDistrict().equalsIgnoreCase(Organisation.getDistrict())}" > selected </c:if>> 
        ${district.getDistrictName()}  
    </option>
</c:forEach>
    </c:if>