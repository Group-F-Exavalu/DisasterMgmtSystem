<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--        <link href="css/header.css" rel="stylesheet">-->
        <link rel="stylesheet" href="css/all.min.css">
        <link rel="stylesheet" href="css/reset-min.css">
        <link rel="stylesheet" href="css/algolia-min.css">
        <link rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="css/docs.min.css">
        <link rel="stylesheet" href="css/index.css">
        <title>Edit Monetary Donation Status</title>
    </head>

    <jsp:include page="menu.jsp"></jsp:include>

        <main id="Target" class="px-4 py-2">
            <div id="myMsg"></div>
            <div class="pt-2 table-responsive" style="max-height: 30vh">
                <table class="table table-bordered border-primary rounded table-hover">
                    <thead class="table-dark">
                        <tr class="align-middle">
                            <th scope="col">Form ID</th>
                            <th scope="col">Donor ID</th>
                            <th scope="col">Donor Type</th>
                            <th scope="col">Amount( in Rs.)</th>
                            <th scope="col">Event</th>
                            <th scope="col">Status</th>
                            <th scope="col">View</th>
                        </tr>
                    </thead>
                    <tbody class="table-group-divider border-primary">
                    <c:forEach var="moneyList" items="${MoneyList}">
                        <tr>
                            <th scope="row">${moneyList.getFormId()}</th>
                            <td>${moneyList.getDonorId()}</td>
                            <td>${moneyList.getDonorType()}</td>
                            <td>${moneyList.getAmount()}</td>
                            <td>${moneyList.getEventId()}</td>
                            <td>
                                <c:if test="${moneyList.getStatus()==0}">
                                    <c:out value="${'PENDING'}"/> </c:if>
                                <c:if test="${moneyList.getStatus()==1}">
                                    <c:out value="${'APPROVED'}"/> </c:if>
                                <c:if test="${moneyList.getStatus()==-1}">
                                    <c:out value="${'REJECTED'}"/> </c:if>
                            </td>
                            <td>
                               <a href="EditMoneyStatus?formId=${moneyList.getFormId()}">Edit</a> 
                            </td>
                            </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div style="display: grid; grid-template-columns: repeat(2, 1fr); grid-auto-rows: 50vh;" class="d-none gap-2 my-2" id="verificationBox">
            <div id="moneyDetails" class="text-bg-light p-5 d-flex flex-column justify-content-center">

            </div>
            <div class="d-flex flex-column gap-2 text-bg-dark p-2">
                <div id="insuranceDetails" class="text-bg-light overflow-scroll p-2 flex-grow-1 flex-shrink-0" style="flex-basis: 50%">

                </div>
                <div id="dmvDetails" class="text-bg-light overflow-scroll p-2 flex-shrink-1">

                </div>
            </div>
        </div>

    </main>
</html>