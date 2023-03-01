<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/all.min.css">
        <link rel="stylesheet" href="css/reset-min.css">
        <link rel="stylesheet" href="css/algolia-min.css">
        <link rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="css/docs.min.css">
        <link rel="stylesheet" href="css/index.css">

        <title>Edit Essential Donation Status</title>

    </head>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="menu.jsp"></jsp:include>
<!--            <script>
                init({
                    title: 'Large data',
                    desc: 'Use `virtualScroll` to enable the virtual scroll to play with large data sets (10000 rows).',
                    links: ['bootstrap-table.min.css'],
                    scripts: ['bootstrap-table.min.js']
                });
            </script>-->

           <main class="px-4 py-2">
           <div id="myMsg"></div>
            <div class="pt-2 table-responsive" style="max-height: 30vh">
                    <table class="table table-bordered border-primary rounded table-hover">
                        <thead class="table-dark">
                            <tr class="align-middle">
                                <th scope="col">Form ID</th>
                                <th scope="col">Donor ID</th>
                                <th scope="col">Donor Type</th>
                                <th scope="col">Essentials</th>
                                <th scope="col">Event</th>
                                <th scope="col">Status</th>
                                <th scope="col">View</th>
                            </tr>
                        </thead>
                        <tbody class="table-group-divider border-primary">
                        <c:forEach items="${EssentialList}" var="essential">
                            <tr>
                                <th scope="row">${essential.getFormId()}</th>
                                <td >${essential.getDonorId()}</td>
                                <td >${essential.getDonorType()}</td>
                                <td >${essential.getEssentialName()}</td>
                                <td >${essential.getEventId()}</td>
                                <td>
                                    <c:if test="${essential.getStatus()==0}">
                                        <c:out value="${'PENDING'}"/> </c:if>
                                    <c:if test="${essential.getStatus()==1}">
                                        <c:out value="${'APPROVED'}"/> </c:if>
                                    <c:if test="${essential.getStatus()==-1}">
                                        <c:out value="${'REJECTED'}"/> </c:if>
                                </td>
                                <td>  
                                    <a href=EditEssentialStatus?formId=${essential.getFormId()}>Edit</a>                    
                                </td>
                            </tr>

                        </c:forEach>
                    </tbody>
                </table>

            </div>

</main>
</html>
