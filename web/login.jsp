
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <title>Sign in</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!--Custom styles for this template--> 
        <link href="css/signin_2.css" rel="stylesheet">
        <!--<link href="css/logincss.css" rel="stylesheet">-->
        <!--<link href="css/menu_css.css" rel="stylesheet">-->
        <meta name="google-signin-client_id" content="223541131739-eerfpk0khhegn7c1vc8f74203pvmk34f.apps.googleusercontent.com">
        <script src="https://accounts.google.com/gsi/client" async defer></script>
    </head>
    <body>
        <style>
            body {
                background-image: url('https://th.bing.com/th/id/R.e511273e60580ac9b7523a52683165d7?rik=GaFLlDZj1xRB7w&riu=http%3a%2f%2fclipart-library.com%2fimage_gallery%2fn1611328.jpg&ehk=DDpgtdN5LnHne%2blhUcRd6cY17FqPQd88WWT2mLp%2bfWA%3d&risl=&pid=ImgRaw&r=0');
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

            a{
                text-decoration: none;
            }
        </style>
        <%@taglib prefix="s" uri="/struts-tags"%> 

        <div class="container-md" >
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="card my-5">

                        <form class="card-body cardbody-color p-lg-5" action="Login" method="Post">

                            <div class="text-center">
                                <img src="images/mainlogo.svg" class="img-fluid profile-image-pic img-thumbnail rounded-circle my-4"
                                     width="250px" alt="profile">
                            </div>
                             <c:if test= "${ErrorMsg!=null}" >
      <div class="alert alert-danger" role="alert">
          <c:out value  = "${ErrorMsg}" />
          </div>
              </c:if>

                            <div class="mb-3">
                                <input type="email" class="form-control" id="emailAddress" name="emailAddress" aria-describedby="emailHelp"
                                       placeholder="name@example.com">
                            </div>
                            <div class="mb-3">
                                <input type="password" name = "password" class="form-control" id="password" placeholder="password">
                            </div>
                            <a href="#" class="text-dark fw-bold"></a>
                            <button type="submit" class="btn btn-color px-5 mb-5 w-100">Login</button>
                            <!--<button type="submit" class="btn btn-color px-5 mb-5 w-100">Sign Up</button>-->
                            <div class="text-center">
                                <div id="g_id_onload"
                                          data-client_id="223541131739-eerfpk0khhegn7c1vc8f74203pvmk34f.apps.googleusercontent.com"
                                          data-context="signin"
                                          data-ux_mode="popup"
                                          data-callback="handleCredentialResponse"
                                          data-auto_prompt="false">

                                </div>
                                 <div class="g_id_signin"
                                           data-type="standard"
                                           data-shape="pill"
                                           data-theme="outline"
                                           data-text="signin_with"
                                           data-size="large"
                                       data-logo_alignment="left">
                                </div>
                            </div>
                            <div id="emailHelp" class="form-text text-center mb-5 text-dark">Not
                                Registered? <a href="signupMain.jsp" class="text-dark fw-bold"> Create an
                                    Account</a>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
        <form class="card-body cardbody-color p-lg-5" action="GmailLogin" method="Post" id="GmailForm" hidden >
            <div class="mb-3">
                <input type="text" class="form-control" id="ID" name="sub" aria-describedby="emailHelp"
                       placeholder="name@example.com">
            </div>
            <div class="mb-3">
                <input type="text" name = "email" class="form-control" id="email" placeholder="password">
            </div>
            <div class="mb-3">
                <input type="text" name = "given_name" class="form-control" id="firstName" placeholder="password">
            </div>
            <div class="mb-3">
                <input type="text" name = "family_name" class="form-control" id="lastName" placeholder="password">
            </div>
            <div class="mb-3">
                <input type="text" name = "picture" class="form-control" id="picture" placeholder="password">
            </div>
            <!--<button type="submit" class="btn btn-color px-5 mb-5 w-100">Gmail Login</button>-->
        </form>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script>
                            function handleCredentialResponse(response) {
                                    const responsePayLoad = decodeJwtResponse(response.credential);
                console.log(responsePayLoad);
                var ID = responsePayLoad.sub;
                var Name = responsePayLoad.name;                
                var FirstName = responsePayLoad.given_name;
                var LastName = responsePayLoad.family_name;
                var Picture = responsePayLoad.picture;
                var email = responsePayLoad.email;
                document.getElementById("ID").value = ID;
                document.getElementById("email").value = email;
                document.getElementById("firstName").value = FirstName;
                document.getElementById("lastName").value = LastName;
                document.getElementById("picture").value = Picture;
                GmailForm.submit();

//                $.ajax({
//                                    type: "POST",
//                                    url: "GmailLogin",
//                                    data: responsePayLoad,
////                    success: function (data) {
////                        // redirect to the JSP page
////                        window.location.href = "GmailLogin";
////                    }
////                                    success: function (response) {
////                                        alert(response);
////                                        console.log(response);
////                                        $('#gmailLogin').html(response);
////                                    }
//                });


                                    console.log("ID: " + ID);
                                    console.log("Name: " + Name);
                                    console.log("Given Name: " + FirstName);
                console.log("family Name: " + LastName);
                console.log("Image URL: " + Picture);
                console.log("Email: " + email);
                            }                            
        </script>
        <script>
            function decodeJwtResponse(data) {
                                    var tokens = data.split(".");
                                    return JSON.parse(atob(tokens[1]));
                            }
        </script>

        <!--<div class="login-page">
          <div class="form">
            <form class="register-form">
              <img class="mb-4" src="images/logo.svg" alt="" width="250" height="200">
              <input type="text" placeholder="name"/>
              <input type="password" placeholder="password"/>
              <input type="text" placeholder="email address"/>
              <button>create</button>
              <p class="message">Already registered? <a href="#">Sign In</a></p>
            </form>
            <form class="login-form">
              <input type="text" placeholder="username"/>
              <input type="password" placeholder="password"/>
              <button>login</button>
              <p class="message">Not registered? <a href="#">Create an account</a></p>
            </form>
          </div>
        </div>-->
        <!--    <body class="text-center">
        
        
                <main class="form-signin w-100 m-auto">
                    <form action="Login" method="post">
                        <img class="mb-4" src="images/logo.svg" alt="" width="250" height="200">
                        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
                        
                        <h3 class="alert-danger">
                            
                        </h3>-->

        <c:if test='${ErrorMsg}'> ${ErrorMsg}</c:if>
        <c:if test='${SuccessMsg}'> ${SuccessMsg}</c:if>

        <!--                <div class="form-floating">
                            <input name="email" type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
                            <label for="floatingInput">Email address</label>
                        </div>
                        <div class="form-floating">
                            <input name="password" type="password" class="form-control" id="floatingPassword" placeholder="Password">
                            <label for="floatingPassword">Password</label>
                        </div>
        
                        <div class="checkbox mb-3">
                            <label>
                                <input type="checkbox" value="remember-me"> Remember me
                            </label>
                        </div>
                        <button class="w-100 btn btn-lg btn-primary" style="background-color: #8B0000; border: none" type="submit">Sign in</button>
                                    
                        <a href="PreSignUp" class = "w-36 p-3" style="color: #8B0000" type="submit"> New Account? Sign Up </a>
                        </form>
                        <p class="mt-5 mb-3 text-muted">&copy; 2017?2022</p>
        
                </main>
        
        
            </body>-->
        <div id="gmailLogin"></div>
    </body>
</html>
