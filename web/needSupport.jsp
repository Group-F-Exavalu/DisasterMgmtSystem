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
        <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/style.css">
        <title>I Need Help</title>

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
                background-image: url('https://demo.themefisher.com/wishfund/images/bg/bg-3.jpg');
            }
        </style>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script>
                      // Function to GeneratePdf
                        function GeneratePdf() {
                                var element = document.getElementById('myForm');
                                html2pdf(element);
                        }
        </script>






        <!-- Custom styles for this template -->
        <!--        <link href="css/bootstrap.min.css" rel="stylesheet" >
                <link href="css/menu_css.css" rel="stylesheet" >
                <link href="css/product.css" rel="stylesheet" >-->
        <!--        <link href="css/signin.css" rel="stylesheet">-->

    </head>
    <style>
        #name{
            font-family: cursive;
        }
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
    <!--    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.2/jspdf.min.js"></script>-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.8.1/html2pdf.bundle.min.js"></script>
    <body class="text-center">
        <jsp:include page="menu.jsp"></jsp:include>
        <c:if test='${SuccessSupport!=null}'>
            <div class="container shadow-lg p-3 mb-5 bg-white rounded" style="padding:50px; background-color: #FBCEB1; width: 400px; border-left-color: #CD5A00">
                <div class="row">
                    
                        <div class="msg msg-success msg-success-text"> <span>&#10004;</span> ${SuccessSupport}</div>
                    
                    
                </div>
            </div>
        </c:if>
        <c:if test='${User!=null}'>
            <div id="body">
                <%--<jsp:include page="menu.jsp"></jsp:include>--%>
                <div id ="success">
                    
                    <main class="form-signin w-50 m-auto">


                        <form action="NeedSupportUser" method="post" id="myForm" class="shadow-lg p-3 mb-5 bg-white rounded">


                            <h1 class="h3 mb-3 fw-normal text-center">I Need Help</h1>

                            <div class="form-floating">
                                <input type="text" class="form-control" id="floatingInput" placeholder="user ID" name="userId" value=${User.userId} readonly>
                                <label for="floatingInput">User ID</label>
                            </div>
                            <div class="form-floating">
                                <input type="text" class="form-control" id="floatingInput" placeholder="event Topic" name="eventTopic">
                                <label for="floatingInput">Support Topic</label>
                            </div>
                            <div class="form-floating">
<!--                                <input type="textarea" class="form-control" id="floatingInput" placeholder="event Details" name="eventDetails">
                                <textarea class="form-control"  placeholder="Your Message" name="eventDetails" type="text" class="txt_3"></textarea>-->
                                <textarea name="eventDetails" class="form-control" id="message" cols="30" rows="4" placeholder="event Details"></textarea>
                                <label for="floatingInput">Please Mention Details</label>
                            </div>

<!--                                <div class="col-md-12">-->
                                    <div class="form-group">
                                        <input type="submit" value="Submit" class="btn btn-primary px-2 mb-2 w-100" id="submitBtn">
                                        <div class="submitting"></div>
                                    </div>
<!--                                </div>-->
                            <!--<button class="btn btn-color px-2 mb-2 w-100" type="submit" id="submitBtn">Submit</button>-->

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


                        <form action="NeedSupportOrg" method="post" id="myForm" class="shadow-lg p-3 mb-5 bg-white rounded">


                            <h1 class="h3 mb-3 fw-normal">I Need Help</h1>

                            <div class="form-floating">
                                <input type="text" class="form-control" id="floatingInput" placeholder="organisation ID" name="userId" value=${Organisation.organisationId} readonly>
                                <label for="floatingInput">Organisation ID</label>
                            </div>
                            <div class="form-floating">
                                <input type="text" class="form-control" id="floatingInput" placeholder="event Topic" name="eventTopic">
                                <label for="floatingInput">Support Topic</label>
                            </div>
                                <div class="form-floating">
                                    <!--                                <input type="textarea" class="form-control" id="floatingInput" placeholder="event Details" name="eventDetails">
                                                                    <textarea class="form-control"  placeholder="Your Message" name="eventDetails" type="text" class="txt_3"></textarea>-->
                                    <textarea name="eventDetails" class="form-control" id="message" cols="30" rows="4" placeholder="event Details"></textarea>
                                    <label for="floatingInput">Please Mention Details</label>
                                </div>

                                <!--                                <div class="col-md-12">-->
                                <div class="form-group">
                                    <input type="submit" value="Submit" class="btn btn-primary px-2 mb-2 w-100" id="submitBtn">
                                    <div class="submitting"></div>
                                </div>
<!--                            <div class="form-floating">
                                <input type="text" class="form-control" id="floatingInput" placeholder="event Details" name="eventDetails">
                                <label for="floatingInput">Please Mention Details</label>
                            </div>

                            <button class="btn btn-color px-2 mb-2 w-100" type="submit" id="submitBtn">Submit</button>-->

                        </form>
                    </main>

                </div>
            </div>
        </c:if>
        <script>
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
        <script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script src="js/jquery.min.js"></script>
        <script src="js/popper.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.validate.min.js"></script>
        <!--<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>-->
        <script src="js/google-map.js"></script>
        <script src="js/main.js"></script>
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
