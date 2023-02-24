<%-- 
    Document   : donateMain
    Created on : Feb 22, 2023, 7:03:20 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Donation</title>
    </head>
    <body>

        <jsp:include page="menu.jsp"></jsp:include>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script type="text/javascript">
            function loadNewContent(url, id, ) {
                //                    document.getElementById("MENU").style.display = 'none';
                $.ajax({
                    url: url,
                    success: function (response) {
                        $('#' + id).html(response);
                    }
                });
            }
        </script>
        <div >
        <c:if test="${user!=null}">
            <div class="btn-group-vertical">
                <button  type="button" onclick="loadNewContent('DonateMoney', 'fetchDetails')">Donate Money</button>
                <button  type="button" onclick="loadNewContent('DonateEssentials', 'fetchDetails')">Donate Essentials</button>
            </div></c:if>
        <c:if test="${organisation!=null}">
            <div class="btn-group-vertical">
                <button  type="button" onclick="loadNewContent('DonateMoney', 'fetchDetails')">Donate Money</button>
                <button  type="button" onclick="loadNewContent('DonateEssentials', 'fetchDetails')">Donate Essentials</button>
            </div></c:if>
        </div>
        <style>
            .btn-group-vertical {
                padding-left: 30%;
                display: inline;
                align-items: center;
                justify-content: center;
                align-items: center;
                flex-direction:column;
                height:100vh;
            }/* .btn-group button {   */

            .btn-group-vertical button {
                background-color: teal;
                /* Black background */
                border: 1px solid rgb(239, 240, 239);
                /*  border */
                color: white;
                /* White text */
                padding: 10px 24px 24px 30px;
                /* Some padding top right bottom left */
                cursor: pointer;
                /* Pointer/hand icon */
                width: 50%;
                max-width:300px; /* set a maximum width if you fancy */
                /* Set a width if needed */
                display: inline;
                /* Make the buttons appear below each other */
                font-weight: bold;
                font-size: 14px;
                text-transform: uppercase;
                margin-bottom: 50px;
            }

            .btn-group button:not(:last-child) {
                border-bottom: none;
                /* Prevent double borders */
            }/* Add a background color on hover */


            /* .btn-group button:hover { */

            .btn-group-vertical button:hover {
                background-color: palevioletred;
                color: white;
            }
        </style>
        <div id="fetchDetails"></div>
    </body>
</html>
