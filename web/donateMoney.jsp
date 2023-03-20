<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.108.0">
        <title>Donate Money</title>

        <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/sign-in/">




        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--        <link href="css/header.css" rel="stylesheet">-->
        <!--        <link rel="stylesheet" href="css/all.min.css">
                <link rel="stylesheet" href="css/reset-min.css">
                <link rel="stylesheet" href="css/algolia-min.css">
                <link rel="stylesheet" href="css/header.css">
                <link rel="stylesheet" href="css/docs.min.css">
                <link rel="stylesheet" href="css/index.css">-->

        <!-- Favicons -->
        <link rel="apple-touch-icon" href="/docs/5.3/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
        <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
        <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
        <link rel="manifest" href="/docs/5.3/assets/img/favicons/manifest.json">
        <link rel="mask-icon" href="/docs/5.3/assets/img/favicons/safari-pinned-tab.svg" color="#712cf9">
        <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon.ico">
        <meta name="theme-color" content="#712cf9">
        <style>
            form {
                max-width: 400px;
                margin: auto;
                padding: 20px;
                background-color: #f5f5f5;
                border: 1px solid #ddd;
                border-radius: 5px;
            }

            label {
                display: block;
                font-weight: bold;
                margin-bottom: 10px;
            }

            input, select {
                display: block;
                width: 95%;
                padding: 10px;
                margin-bottom: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
            }

            button {
                display: block;
                margin: 0 auto;
                padding: 10px 20px;
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            button:hover {
                opacity: 0.8;
            }
            body {
                background-image: url('https://demo.w3layouts.com/demos_new/template_demo/12-03-2018/relief-demo_Free/1550522509/web/images/banner4.jpg');
            }
        </style>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script>
            ��������� // Function to GeneratePdf
            ����������� function GeneratePdf() {
                ��������������� var element = document.getElementById('myForm');
                ��������������� html2pdf(element);
            ����������� }
        </script>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>




        <!-- Custom styles for this template -->
        <!--        <link href="css/bootstrap.min.css" rel="stylesheet" >
                <link href="css/menu_css.css" rel="stylesheet" >
                <link href="css/product.css" rel="stylesheet" >-->
        <!--        <link href="css/signin.css" rel="stylesheet">-->

    </head>
    <style>
        .btn-color{
            background-color: #0e1c36;
            color: #fff;

        }

        .profile-image-pic{
            height: 200px;
            width: 200px;
            object-fit: cover;
        }

        .cardbody-color{
            background-color: whitesmoke;
        }
        .btn:hover {
            background-color: #CD5A00;
            color: white;
        }

        a{
            text-decoration: none;
        }
    </style>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.8.1/html2pdf.bundle.min.js"></script>
    <body class="text-center">
        <c:if test='${User!=null}'>
            <div id="body">
                <%--<jsp:include page="menu.jsp"></jsp:include>--%>
                <div id ="success">
                    <main class="form-signin w-50 m-auto">


                        <form action="DonateMoneyUser" method="post" id="myForm" class="shadow-lg p-3 mb-5 bg-white rounded">


                            <h1 class="h3 mb-3 fw-normal text-center">Monetary Donation</h1>
                            <input type="text" class="form-control" id="floatingInput" placeholder="Donor Type" name="donorType" value="1" hidden>
                            <div class="form-floating">
                                <input type="text" class="form-control" id="floatingInput" placeholder="user ID" name="donorId" value=${User.userId} readonly>
                                <label for="floatingInput">User ID</label>
                            </div>
                            <div class="form-floating">
                                <input type="text" class="form-control" id="floatingInput" placeholder="first name" name="firstName" value=${User.firstName} readonly>
                                <label for="floatingInput">First Name</label>
                            </div>
                            <div class="form-floating">
                                <input type="text" class="form-control" id="floatingInput" placeholder="last name" name="lastName" value=${User.lastName} readonly>
                                <label for="floatingInput">Last Name</label>
                            </div>

                            <div class="form-floating">
                                <input type="text" class="form-control" id="floatingInput" placeholder="phone Number" name="phoneNumber" value=${User.phoneNumber} readonly>
                                <label for="floatingInput">Phone Number</label>
                            </div>
                            <div class="form-floating">
                                <input type="text" class="form-control" id="floatingInput" placeholder="address" name="address" value=${User.address} readonly>
                                <label for="floatingInput">Address</label>
                            </div>
                            <div class="form-floating">
                                <input type="text" class="form-control" id="floatingInput" placeholder="amount" name="amount" required>
                                <label for="floatingInput">Amount</label>
                            </div>

                            <div class="form-floating">

                                <select name="eventId" class="form-select" id="eventId" required>
                                    <option value="">Select an event</option>
                                    <c:forEach var="event" items="${EventList}">
                                        <option value=${event.eventId}> ${event.eventTopic}  </option>
                                    </c:forEach>
                                </select>
                                <label for="floatingInput">Event</label>
                                <button type="button" class="btn btn-light btn-outline-black px-2 mb-2 w-100" data-toggle="modal" data-target="#exampleModal">Scan QR Code</button>
                                <div class="form-floating">
                                    <input type="text" class="form-control" id="floatingInput" placeholder="transaction Id" name="transactionId" required>
                                    <label for="floatingInput">UPI Transaction ID (Enter after scanning QR)</label>
                                </div>
                                <!--<button onclick= "GeneratePdf()" class="btn btn-color px-2 mb-2 w-100" type="button" id="button">Generate PDF</button>-->
                            </div>

                            <button class="btn btn-color px-2 mb-2 w-100" type="submit" id="submitBtn">Submit</button>
                            

                            <div class="modal fade" id="exampleModal" tabindex="-1"role="dialog" aria-labelledby="exampleModalLabel"aria-hidden="true">
                                <div class="modal-body">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <button type="button" class="close btn btn-light btn-outline-black px-2 mb-2 w-100"
                                                    data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">
                                                    Close QR Code
                                                </span>
                                            </button>
                                            <img src="images/QRCode.jpeg" />
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </form>

                    </main>

                </div>
            </div>
        </c:if>
        <c:if test='${Organisation!=null}'>
            <div id="body">
                <%--<jsp:include page="menu.jsp"></jsp:include>--%>
                <div id ="success">
                    <main class="form-signin w-50 m-auto">


                        <form action="DonateMoneyOrg" method="post" id="myForm" class="shadow-lg p-3 mb-5 bg-white rounded">


                            <h1 class="h3 mb-3 fw-normal text-center">Monetary Donation</h1>

                            <div class="form-floating">
                                <input type="text" class="form-control" id="floatingInput" placeholder="Organisation ID" name="donorId" value=${Organisation.organisationId} readonly>
                                <label for="floatingInput">Organisation ID</label>
                            </div>
                            <div class="form-floating">
                                <input type="text" class="form-control" id="floatingInput" placeholder="Organisation Name" name="firstName" value=${Organisation.organisationName} readonly>
                                <label for="floatingInput">Organisation Name</label>
                            </div>
                            <div class="form-floating">
                                <input type="text" class="form-control" id="floatingInput" placeholder="last name" name="lastName" value=${Organisation.regnNumber} readonly>
                                <label for="floatingInput">Registration Number</label>
                            </div>

                            <!--                    <div class="form-floating">
                                                    <input type="text" class="form-control" id="floatingInput" placeholder="phone Number" name="phoneNumber" value=${User.phoneNumber} readonly>
                                                    <label for="floatingInput">Phone Number</label>
                                                </div>-->
                            <div class="form-floating">
                                <input type="text" class="form-control" id="floatingInput" placeholder="Address" name="address" value="${Organisation.districtName} , ${Organisation.stateName} , ${Organisation.countryName}" readonly>
                                <label for="floatingInput">Address</label>
                            </div>
                            <div class="form-floating">
                                <input type="text" class="form-control" id="floatingInput" placeholder="amount" name="amount" required>
                                <label for="floatingInput">Amount</label>
                            </div>
                            <div class="form-floating">

                                <select name="eventId" class="form-select" id="eventId" required>
                                    <option value="">Select an event</option>
                                    <c:forEach var="event" items="${EventList}">
                                        <option value=${event.eventId}> ${event.eventTopic}  </option>
                                    </c:forEach>
                                </select>
                                <label for="floatingInput">Event</label>
                                <div class="form-floating">
                                    <input type="text" class="form-control" id="floatingInput" placeholder="transaction Id" name="transactionId" required>
                                    <label for="floatingInput">Transaction ID (Enter after scanning QR)</label>
                                </div>
                                <button type="button" class="btn btn-light btn-outline-black px-2 mb-2 w-100" data-toggle="modal" data-target="#exampleModal">Scan QR Code</button>
                                <!--<button onclick= "GeneratePdf()" class="btn btn-color px-2 mb-2 w-100" type="button" id="button">Generate PDF</button>-->

                                <button class="btn btn-color px-2 mb-2 w-100" type="submit" id="submitBtn">Submit</button>
                                <!--<button type="button" class="btn btn-primary"data-toggle="modal" data-target="#exampleModal">click to scan</button>-->

                                <div class="modal fade" id="exampleModal" tabindex="-1"role="dialog" aria-labelledby="exampleModalLabel"aria-hidden="true">
                                    <div class="modal-body">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <button type="button" class="close btn btn-light btn-outline-black px-2 mb-2 w-100"
                                                        data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">
                                                        close
                                                    </span>
                                                </button>
                                                <img src="images/QRCode.jpeg" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </form>
                    </main>

                </div>
            </div>
        </c:if>

        <c:if test='${GmailUser!=null}'>
            <div id="body">
                <%--<jsp:include page="menu.jsp"></jsp:include>--%>
                <div id ="success">
                    <main class="form-signin w-50 m-auto">


                        <form action="DonateMoneyUser" method="post" id="myForm" class="shadow-lg p-3 mb-5 bg-white rounded">


                            <h1 class="h3 mb-3 fw-normal text-center">Monetary Donation</h1>
                            <input type="text" class="form-control" id="floatingInput" placeholder="Donor Type" name="donorType" value="3" hidden>
                            <div class="form-floating">
                                <input type="text" class="form-control" id="floatingInput" name="donorId" placeholder="ID" value=${GmailUser.sub} hidden>
                            </div>

                            <div class="form-floating">
                                <input type="text" class="form-control" id="floatingInput" placeholder="Organisation ID" name="email" value=${GmailUser.email} readonly>
                                <label for="floatingInput">Email ID</label>
                            </div>
                            <div class="form-floating">
                                <input type="text" class="form-control" id="floatingInput" placeholder="Organisation Name" name="given_name" value=${GmailUser.given_name} readonly>
                                <label for="floatingInput">First Name</label>
                            </div>
                            <div class="form-floating">
                                <input type="text" class="form-control" id="floatingInput" placeholder="last name" name="family_name" value=${GmailUser.family_name} readonly>
                                <label for="floatingInput">Last Number</label>
                            </div>

                            <!--                    <div class="form-floating">
                                                    <input type="text" class="form-control" id="floatingInput" placeholder="phone Number" name="phoneNumber" value=${User.phoneNumber} readonly>
                                                    <label for="floatingInput">Phone Number</label>
                                                </div>-->
                            <!--                                                                            <div class="form-floating">
                                                                                                            <input type="text" class="form-control" id="floatingInput" placeholder="Address" name="address" value=${Organisation.district} readonly>
                                                                                                            <label for="floatingInput">Address</label>
                                                                                                        </div>-->
                            <div class="form-floating">
                                <input type="text" class="form-control" id="floatingInput" placeholder="amount" name="amount" required>
                                <label for="floatingInput">Amount</label>
                            </div>
                            <div class="form-floating">

                                <select name="eventId" class="form-select" id="eventId" required>
                                    <option value="">Select an event</option>
                                    <c:forEach var="event" items="${EventList}">
                                        <option value=${event.eventId}> ${event.eventTopic}  </option>
                                    </c:forEach>
                                </select>
                                <label for="floatingInput">Event</label>
                                <button type="button" class="btn btn-light btn-outline-black px-2 mb-2 w-100" data-toggle="modal" data-target="#exampleModal">Scan QR Code</button>
                                <div class="form-floating">
                                    <input type="text" class="form-control" id="floatingInput" placeholder="Transaction ID" name="transactionId" required>
                                    <label for="floatingInput">Transaction ID (Enter after scanning QR)</label>
                                </div>
                                <!--<button onclick= "GeneratePdf()" class="btn btn-color px-2 mb-2 w-100" type="button" id="button">Generate PDF</button>-->
                            </div>

                            <button class="btn btn-color px-2 mb-2 w-100" type="submit" id="submitBtn">Submit</button>
                            <!--<button type="button" class="btn btn-primary"data-toggle="modal" data-target="#exampleModal">click to scan</button>-->

                            <div class="modal fade" id="exampleModal" tabindex="-1"role="dialog" aria-labelledby="exampleModalLabel"aria-hidden="true">
                                <div class="modal-body">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <button type="button" class="close btn btn-light btn-outline-black px-2 mb-2 w-100"
                                                    data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">
                                                    close
                                                </span>
                                            </button>
                                            <img src="images/QRCode.jpeg" />
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </form>
                    </main>

                </div>
            </div>
        </c:if>
        <!--        <script>
                    var button = document.getElementById("button");
                    button.addEventListener("click", function () {
                        var doc = new jsPDF("p", "mm", [300, 300]);
                        var makePDF = document.querySelector("#myForm");
                        var formContent = makePDF.innerHTML;
        
                        // fromHTML Method
                        doc.fromHTML(formContent);
                        doc.save("output.pdf");
                    });
                </script>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <!--        <script>
                    // Get the form and submit button elements
                    var form = document.getElementById("myForm");
                    var submitBtn = document.getElementById("submitBtn");
                    var responseDiv = document.getElementById("responseDiv");
        
                    // Add a click event listener to the submit button
                    submitBtn.addEventListener("click", function (event) {
                        document.getElementById("body").style.display = 'none';
                        // Prevent the default form submission behavior
                        event.preventDefault();
        
                        // Create a new XMLHttpRequest object
                        var xhr = new XMLHttpRequest();
        
                        // Set the request method and URL
                        xhr.open("POST", "AddEmployee", true);
        
                        // Set the request headers (if needed)
        //                xhr.setRequestHeader("Content-Type", "application/json");
        
                        // Set the callback function to handle the response
                        xhr.onreadystatechange = function () {
                            if (xhr.readyState === 4 && xhr.status === 200) {
                                // Do something with the response (if needed)
                                console.log(xhr.responseText);
                                responseDiv.innerHTML = xhr.responseText;
        //                        document.body.innerHTML = xhr.responseText;
                            }
                        };
        
                        // Get the form data and send the request
                        var formData = new FormData(form);
                        xhr.send(formData);
                    });
                </script>-->

        <div id="responseDiv" ></div>


    </body>
</html>