<%-- 
    Document   : status
    Created on : 08-Mar-2023, 12:36:44 pm
    Author     : Preyangsee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/header.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Dosis:wght@500&family=Overpass:wght@500&display=swap" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@300&display=swap" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Dosis&family=Overpass:wght@500&display=swap" rel="stylesheet">
        <title>Donation Tracker</title>
    </head>
     <jsp:include page="menu.jsp"></jsp:include>
    <body style="background-color: whitesmoke">
        <div>
           
            <section class="ftco-section">
            <div class="container-fluid">
                <div class="row justify-content-center mb-auto pb-3">
                    <div class="col-lg-10 heading-section ftco-animate text-center"><br>
<!--                        <h2 class="mb-4" style="font-family: 'Dosis', sans-serif;">Track Your Donation</h2>-->
                    <h3 class="mb-4" style="font-family: 'Oswald', sans-serif; color: #DC582A">MONETARY DONATIONS</h3>
                    <c:if test='${MoneyStatus!=null}'>
                        <br>
                        
                        <table class="table table-bordered" style="background-color: white">
                            <thead class="thead" style="background-color: black; color: white;font-family: 'Overpass', sans-serif;">
                                <tr>
                                    <th scope="col">Donation Form ID</th>
                                    <th scope="col">Event Topic</th>
                                    <th scope="col">Amount donated</th>
                                    <th scope="col">Transaction ID</th>
                                    <th scope="col">Status of Transaction</th>
                                </tr>
                            </thead>
                        <c:forEach items='${MoneyStatus}' var="money">
                            <tbody>
                                <tr>
                                    <th scope="row">${money.getFormId()}</th>
                                    <td>${money.getEventName()}</td>
                                    <td><span>&#8377;</span>${money.getAmount()}</td>
                                    <td>${money.getTransactionId()}</td>
                                    <td><c:if test='${money.getStatus().equals("1")}'>
                                            <div style="font-family: 'Oswald', sans-serif; color: #DC582A">Approved</div>
                                    </c:if>
                                    <c:if test='${money.getStatus().equals("0")}'>
                                            <div style="font-family: 'Oswald', sans-serif; color: black">Pending</div>
                                    </c:if>
                                    <c:if test='${money.getStatus().equals("-1")}'>
                                            <div style="font-family: 'Oswald', sans-serif; color: darkred">Rejected</div>
                                    </c:if></td>
                                </tr>
                            </tbody>
                             </c:forEach>
                        </table>
                         
                    </c:if>
                    <c:if test='${MoneyOrgStatus!=null}'>
                        <br>
                        
                        <table class="table table-bordered" style="background-color: white">
                            <thead class="thead" style="background-color: black; color: white;font-family: 'Overpass', sans-serif;">
                                <tr>
                                    <th scope="col">Donation Form ID</th>
                                    <th scope="col">Event Topic</th>
                                    <th scope="col">Amount donated</th>
                                    <th scope="col">Transaction ID</th>
                                    <th scope="col">Status of Transaction</th>
                                </tr>
                            </thead>
                        <c:forEach items='${MoneyOrgStatus}' var="money">
                            <tbody>
                                <tr>
                                    <th scope="row">${money.getFormId()}</th>
                                    <td>${money.getEventName()}</td>
                                    <td><span>&#8377;</span>${money.getAmount()}</td>
                                    <td>${money.getTransactionId()}</td>
                                    <td><c:if test='${money.getStatus().equals("1")}'>
                                            <div style="font-family: 'Oswald', sans-serif; color: #DC582A">Approved</div>
                                    </c:if>
                                    <c:if test='${money.getStatus().equals("0")}'>
                                            <div style="font-family: 'Oswald', sans-serif; color: black">Pending</div>
                                    </c:if>
                                    <c:if test='${money.getStatus().equals("-1")}'>
                                            <div style="font-family: 'Oswald', sans-serif; color: darkred">Rejected</div>
                                    </c:if></td>
                                </tr>
                            </tbody>
                             </c:forEach>
                        </table>
                         
                    </c:if>
                    <c:if test='${MoneyStatus==null && MoneyOrgStatus==null}'>
                        <div style="font-family: 'Oswald', sans-serif; color: #DC582A"> Haven't donated anything yet? Check out our <a href="DisplayEvent" class="text-black">Events.</a>
                    </c:if>
                        <br><hr><br>
                        <h3 class="mb-4" style="font-family: 'Oswald', sans-serif; color: #DC582A">ESSENTIAL DONATIONS</h3>
                    <c:if test='${EssentialStatus!=null}'>
                        <br>
                        
                        <table class="table table-bordered" style="background-color: white">
                            <thead class="thead" style="background-color: black; color: white;font-family: 'Overpass', sans-serif;">
                                <tr>
                                    <th scope="col">Donation Form ID</th>
                                    <th scope="col">Event Topic</th>
                                    <th scope="col">Essentials donated</th>
                                    <!--<th scope="col">Transaction ID</th>-->
                                    <th scope="col">Status</th>
                                </tr>
                            </thead>
                        <c:forEach items='${EssentialStatus}' var="essential">
                            <tbody>
                                <tr>
                                    <th scope="row">${essential.getFormId()}</th>
                                    <td>${essential.getEventName()}</td>
                                    <td>${essential.getEssentialName()}</td>
<!--                                    <td></td>-->
                                    <td><c:if test='${essential.getStatus().equals("1")}'>
                                            <div style="font-family: 'Oswald', sans-serif; color: #DC582A">Approved</div>
                                    </c:if>
                                    <c:if test='${essential.getStatus().equals("0")}'>
                                            <div style="font-family: 'Oswald', sans-serif; color: black">Pending</div>
                                    </c:if>
                                    <c:if test='${essential.getStatus().equals("-1")}'>
                                            <div style="font-family: 'Oswald', sans-serif; color: darkred">Rejected</div>
                                    </c:if></td>
                                </tr>
                            </tbody>
                             </c:forEach>
                        </table>
                    </c:if>
                    <c:if test='${EssentialOrgStatus!=null}'>
                        <br>
                        
                        <table class="table table-bordered" style="background-color: white">
                            <thead class="thead" style="background-color: black; color: white;font-family: 'Overpass', sans-serif;">
                                <tr>
                                    <th scope="col">Donation Form ID</th>
                                    <th scope="col">Event Topic</th>
                                    <th scope="col">Essentials donated</th>
                                    <!--<th scope="col">Transaction ID</th>-->
                                    <th scope="col">Status</th>
                                </tr>
                            </thead>
                        <c:forEach items='${EssentialOrgStatus}' var="essential">
                            <tbody>
                                <tr>
                                    <th scope="row">${essential.getFormId()}</th>
                                    <td>${essential.getEventName()}</td>
                                    <td>${essential.getEssentialName()}</td>
<!--                                    <td></td>-->
                                    <td><c:if test='${essential.getStatus().equals("1")}'>
                                            <div style="font-family: 'Oswald', sans-serif; color: #DC582A">Approved</div>
                                    </c:if>
                                    <c:if test='${essential.getStatus().equals("0")}'>
                                            <div style="font-family: 'Oswald', sans-serif; color: black">Pending</div>
                                    </c:if>
                                    <c:if test='${essential.getStatus().equals("-1")}'>
                                            <div style="font-family: 'Oswald', sans-serif; color: darkred">Rejected</div>
                                    </c:if></td>
                                </tr>
                            </tbody>
                             </c:forEach>
                        </table>
                    </c:if>
                       <c:if test='${EssentialStatus==null && EssentialOrgStatus==null}'>
                        <div style="font-family: 'Oswald', sans-serif; color: #DC582A"> Haven't donated anything yet? Check out our <a href="DisplayEvent" class="text-black">Events.</a>
                    </c:if>
                    </div>
                </div>
            </div>
            </section>
        </div>
    </body>
</html>
