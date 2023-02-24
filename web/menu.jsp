
<!doctype html>
<html lang="en">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <title>Disaster Management</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <meta name="theme-color" content="#712cf9">

        <!-- Custom styles for this template -->
        <link href="css/header.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Playfair Display' rel='stylesheet'>
        <!--<link href="css/carousel.css" rel="stylesheet">-->
    </head>
    <style>
        #menuback{
            background-color: white;
        }
    </style>
    <div class="container">
        <style>
            ul.nav li a:hover {
                background-color: palevioletred;
                color: white;
            }
        </style>
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
        <header class="d-flex site-header sticky-lg-top justify-content-around py-3 mb-4 border-bottom" id="menuback">
            <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                <!--<svg class="bi me-2" width="40" height="32"><use xlink:href="images/mainlogo.svg"/></svg>-->
                <img src="images/mainlogo.svg" width="50" height="50"></img>
                <!--<span class="fs-4">Simple header</span>-->
            </a>
            <% if (request.getSession().getAttribute("Loggedin") == null) {%>
            <ul class="nav nav-pills">
                <li class="nav-item"><a href="landingPage.jsp" class="nav-link active" aria-current="page" >Home</a></li>
                <li class="nav-item"><a href="login.jsp" class="nav-link px-2 text-black">Donate</a></li>
                <li class="nav-item"><a href="login.jsp" class="nav-link px-2 text-black">Support</a></li>
                <li class="nav-item"><a href="#" class="nav-link px-2 text-black">Contact</a></li>
                <li class="nav-item"><a href="#" class="nav-link px-2 text-black">Events</a></li>
                <li class="nav-item"><a href="login.jsp" class="nav-link px-2 text-black">Login</a></li>
                <li class="nav-item"><a href="signupMain.jsp" class="nav-link px-2 text-black">Sign Up</a></li>
            </ul>
            <%
            } else if (request.getSession().getAttribute("LoggedinStatus").equals("user")) {%>
            <ul class="nav nav-pills">
                <li class="nav-item"><a href="#" class="nav-link active" aria-current="page" >Home</a></li>
                <li class="nav-item"><a href="donateMain.jsp" class="nav-link px-2 text-black">Donate</a></li>
                <li class="nav-item"><a href="needSupport.jsp" class="nav-link px-2 text-black">Support</a></li>
                <li class="nav-item"><a href="#" class="nav-link px-2 text-black">Contacts</a></li>
                <li class="nav-item"><a href="#" class="nav-link px-2 text-black">Events</a></li>
                <li class="nav-item"><a href="logout.jsp" class="nav-link px-2 text-black">Logout</a></li>
            </ul>
            <%
            } else if (request.getSession().getAttribute("LoggedinStatus").equals("org")) {%>
            %>
            <ul class="nav nav-pills">
                <li class="nav-item"><a href="#" class="nav-link active" aria-current="page" >Home</a></li>
                <li class="nav-item"><a href="donateMain.jsp" class="nav-link px-2 text-black">Donate</a></li>
                <li class="nav-item"><a href="needSupport.jsp" class="nav-link px-2 text-black">Support</a></li>
                <li class="nav-item"><a href="#" class="nav-link px-2 text-black">Contacts</a></li>
                <li class="nav-item"><a href="#" class="nav-link px-2 text-black">Events</a></li>
                <li class="nav-item"><a href="logout.jsp" class="nav-link px-2 text-black">Logout</a></li>
            </ul>
            <%
                }
            %>
        </header>
    </div>
    <!--    <header class="p-3 text-bg-light">
            <div class="container">
                <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                    <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                        <img src="images/mainlogo.svg" width="75" height="75"></img>
                    </a>
    
                    <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                        <li><a href="#" class="nav-link px-2 text-black">Home</a></li>
                        <li><a href="#" class="nav-link px-2 text-white">Features</a></li>
                        <li><a href="#" class="nav-link px-2 text-white">Pricing</a></li>
                        <li><a href="#" class="nav-link px-2 text-white">FAQs</a></li>
                        <li><a href="#" class="nav-link px-2 text-white">About</a></li>
                    </ul>
    
                    <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
                        <input type="search" class="form-control form-control-dark text-bg-dark" placeholder="Search..." aria-label="Search">
                    </form>
    
                    <div class="text-end">
    <% if (request.getSession().getAttribute("Loggedin") == null) {%>

    <a href="login.jsp">
        <button type="button" class="btn btn-outline-light me-2" >Login</button>
    </a>
    <a href="signup.jsp">
        <button type="button" class="btn btn-warning">Sign-up</button>
    </a>
    <%
    } else {%>

    <a href="Logout">
        <button type="button" class="btn btn-outline-light me-2" >Log Out</button>
    </a>
    <%
        }
    %>


</div>
</div>
</div>
</header>-->