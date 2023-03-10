
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
        #header {
            background: white;
        }
    </style>
    <div id="header">
    <div class="container">
        <style>
            a {
/*                background-image: linear-gradient(
                    to right,
                    #8B4000,
                    #8B4000 50%,
                    #000 50%
                    );*/
                background-size: 200% 100%;
                background-position: -100%;
                display: inline-block;
                padding: 5px 0;
                position: relative;
                
                transition: all 0.3s ease-in-out;
            }

            a:before{
                content: '';
                background: #DC582A;
                display: block;
                position: absolute;
                bottom: -3px;
                left: 0;
                width: 0;
                height: 3px;
                transition: all 0.3s ease-in-out;
            }

            a:hover {
                background-position: 0;
            }

            a:hover::before{
                width: 100%;
            }
            .css-border {
/*                border: 4px solid #cddc39;*/
                padding: 2px;
                border-radius: 50%;
/*                border-top-color: #ff5722;
                border-left-color: #ff5722;*/
                width: 45px;
                height: 45px;
            }
/*            ul.nav li a:hover {
                background-color: palevioletred;
                color: white;
            }*/
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
            function loadUserStatus(id){
                $.ajax({
                    url: "Status",
                    data:{
                        userId:id
                    },
                    success: function (response) {
                        //alert(response);
                        window.location.href = 'status.jsp';
                    }
                });
            }
            function loadOrgStatus(id){
                $.ajax({
                    url: "OrgStatus",
                    data:{
                        organisationId:id
                    },
                    success: function (response) {
                        //alert(response);
                        window.location.href = 'status.jsp';
                    }
                });
            }
            function loadGStatus(id){
                //alert(id);
                $.ajax({
                    url: "GUserStatus",
                    data:{
                        email:id
                    },
                    success: function (response) {
                        //alert(response);
                        window.location.href = 'status.jsp';
                    }
                });
            }
        </script>
        <header class="d-flex site-header sticky-lg-top justify-content-around py-3 mb-4 border-bottom" id="menuback">
            <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                <!--<svg class="bi me-2" width="40" height="32"><use xlink:href="images/mainlogo.svg"/></svg>-->
                <img src="images/mainlogo.svg" width="50" height="50"></img>

                <!--<span class="fs-4">Simple header</span>aria-current="page"-->
            </a>
            <% if (request.getSession().getAttribute("Loggedin") == null) {%>
            <ul class="nav nav-pills">
                <li class="nav-item"><a href="landingPage.jsp" class="nav-link px-2 text-black">Home</a></li>
                <li class="nav-item"><a href="login.jsp" class="nav-link px-2 text-black">Donate</a></li>
                <li class="nav-item"><a href="login.jsp" class="nav-link px-2 text-black">Support</a></li>
                <li class="nav-item"><a href="contact.jsp" class="nav-link px-2 text-black">Contacts</a></li>
                <li class="nav-item"><a href="DisplayEvent" class="nav-link px-2 text-black">Events</a></li>
                <li class="nav-item"><a href="login.jsp" class="nav-link px-2 text-black">Login</a></li>
                <li class="nav-item"><a href="signupMain.jsp" class="nav-link px-2 text-black">Sign Up</a></li>
            </ul>
            <%
            } else if (request.getSession().getAttribute("LoggedinStatus").equals("user")) {%>
            <ul class="nav nav-pills">
                <li class="nav-item"><a href="landingPage.jsp" class="nav-link px-2 text-black">Home</a></li>
                <li class="nav-item"><a href="donateMain.jsp" class="nav-link px-2 text-black">Donate</a></li>
                <li class="nav-item"><a href="needSupport.jsp" class="nav-link px-2 text-black">Support</a></li>
                <li class="nav-item"><a href="contact.jsp" class="nav-link px-2 text-black">Contacts</a></li>
                <li class="nav-item"><a href="DisplayEvent" class="nav-link px-2 text-black">Events</a></li>
                <li class="nav-item"><a onclick="loadUserStatus(<c:out value="${User.getUserId()}"/>)" class="nav-link px-2 text-black">Status</a></li>
                <li class="nav-item"><a href="logout.jsp" class="nav-link px-2 text-black">Logout</a></li>
                <li class="nav-item">  </li>
                <li class="nav-item"><a href="profile.jsp"><img class="css-border" src="data:image/png;base64,${User.getImageData()}" /></a></li>
            </ul>
            <%
            } else if (request.getSession().getAttribute("LoggedinStatus").equals("GmailUser")) {%>
            <ul class="nav nav-pills">
                <li class="nav-item"><a href="landingPage.jsp" class="nav-link px-2 text-black">Home</a></li>
                <li class="nav-item"><a href="donateMain.jsp" class="nav-link px-2 text-black">Donate</a></li>
                <li class="nav-item"><a href="needSupport.jsp" class="nav-link px-2 text-black">Support</a></li>
                <li class="nav-item"><a href="contact.jsp" class="nav-link px-2 text-black">Contacts</a></li>
                <li class="nav-item"><a href="DisplayEvent" class="nav-link px-2 text-black">Events</a></li>
                <li class="nav-item"><a onclick="loadGStatus('${GmailUser.getEmail()}')" class="nav-link px-2 text-black">Status</a></li>
                <li class="nav-item"><a href="logout.jsp" class="nav-link px-2 text-black">Logout</a></li>
                <li class="nav-item"><a href="#"><img class="css-border" src="${GmailUser.picture}" /></a></li>
                
            </ul>
            <%
            } else if (request.getSession().getAttribute("LoggedinStatus").equals("org")) {
            %>
            <ul class="nav nav-pills">
                <li class="nav-item"><a href="landingPage.jsp" class="nav-link px-2 text-black">Home</a></li>
                <li class="nav-item"><a href="donateMain.jsp" class="nav-link px-2 text-black">Donate</a></li>
                <li class="nav-item"><a href="needSupport.jsp" class="nav-link px-2 text-black">Support</a></li>
                <li class="nav-item"><a href="contact.jsp" class="nav-link px-2 text-black">Contacts</a></li>
                <li class="nav-item"><a href="DisplayEvent" class="nav-link px-2 text-black">Events</a></li>
                <li class="nav-item"><a onclick="loadOrgStatus(<c:out value="${Organisation.getOrganisationId()}"/>)" class="nav-link px-2 text-black">Status</a></li>
                <li class="nav-item"><a href="logout.jsp" class="nav-link px-2 text-black">Logout</a></li>
                <li class="nav-item"><img class="css-border" src="https://static.thenounproject.com/png/446003-200.png" /></li>
            </ul>
            <%
                }
            %>
        </header>
    </div>
        </div>
<!--        
        <div id="id"></div>-->
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