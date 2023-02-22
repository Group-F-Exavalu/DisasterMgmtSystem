<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.104.2">
        <title>Sign up for Individual User</title>

        <link href="css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

        <meta name="theme-color" content="#712cf9">


        <!-- Custom styles for this template -->
        <link href="css/signin.css" rel="stylesheet">

    </head>
    
     <script src="https://code.jquery.com/jquery-3.6.3.js" 
            integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" 
            crossorigin="anonymous"></script>
    
    <script>
        function submitForm()
        {
            signupForm.submit();
        }
        function fetchContent(selectedId,targetId)
        {
//            alert("'#"+selectedId.name+"'");
            
                $.ajax({
                    url: 'PreSignUp',
                    data: {
                        [selectedId]: $("#"+selectedId).val()
                    },
                    success: function (responseText) {
//                        alert(responseText);
                        $("#"+targetId).html(responseText);
                    }
                });
            
        }
    </script>

    <body class="text-center">


        <main class="form-signin w-100 m-auto">
            <form action="PreSignUp" method="Post" id="signupForm">
                <img class="mb-4" src="images/flower-logo.jpg" alt="" width="200" height="200">
                <h1 class="h3 mb-3 fw-normal">Please provide SignUp Details</h1>

                <div class="form-floating">
                    <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" name="emailAddress" value="${User.getEmailAddress()}">
                    <label for="floatingInput">Email address</label>
                </div>
                <div class="form-floating">
                    <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password" value="${User.getPassword()}">
                    <label for="floatingPassword">Password</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="firstName" placeholder="first name" name="firstName" value="${User.getFirstName()}">
                    <label for="firstName">First Name</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="lastName" placeholder="last name" name="lastName" value="${User.getLastName()}">
                    <label for="firstName">Last Name</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="phoneNumber" placeholder="phone number" name="phoneNumber" value="${User.getPhoneNumber()}">
                    <label for="firstName">Phone Number</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="address" placeholder="address" name="address" value="${User.getAddress()}">
                    <label for="firstName">Address Line 1</label>
                </div>
               

                <div class="form-floating">

                    <select name="country" class="form-select" id="country" onchange="fetchContent('country', 'state')">
                        <option value="">Select a Country</option>
                        <c:forEach var="country" items="${CountryList}">
                            <option value=${country.getCountryCode()}<c:if test="${country.getCountryCode()==User.getCountryCode()}"> selected </c:if>> ${country.getCountryName()}  </option>
                        </c:forEach>
                    </select>
                </div>
                        
                        <div class="form-floating">

                    <select name="state" class="form-select" id="state" onchange="fetchContent('state', 'district')">
                        <option value="">Select a Province</option>
                        
                    </select>
                </div>
                        
                        <div class="form-floating">

                    <select name="district" class="form-select" id="district" >
                        <option value="">Select a District</option>
                        
                    </select>
                </div>

                <div class="checkbox mb-3">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Sign Up</button>
                <a href="landingPage.jsp">
                    <button type="button" class="w-100 btn btn-lg btn-warning">Cancel</button>
                </a>
                <p class="mt-5 mb-3 text-muted">&copy; 2017?2022</p>
            </form>
        </main>



    </body>
</html>
