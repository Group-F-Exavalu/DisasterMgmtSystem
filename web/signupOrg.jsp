<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags"%> 
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.104.2">
        <title>Sign up for Organizations</title>

<!--       <link href="css/bootstrap.min.css" rel="stylesheet">

         Custom styles for this template 
        <link href="css/signin_2.css" rel="stylesheet">-->

    </head>
     <style>
        .btn-color{
            background-color: #0e1c36;
            color: #fff;

        }
        .btn-color-cancel{
            background-color: grey;
            color: whitesmoke

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
        
        #titles{
            font-family: cursive;
            
        }
        body {
            background-image: url('https://technext.github.io/givehope/images/img_3.jpg');
        }
    </style>

    <script src="https://code.jquery.com/jquery-3.6.3.js" 
                        integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" 
                crossorigin="anonymous"></script>

    <script>
        function submitForm()
        {
            signupForm.submit();
        }
        function fetchContent(selectedId, targetId)
                {
//            alert("'#"+selectedId.name+"'");
            
                            $.ajax({
                                    url: 'PreSignUpOrg',
                                    data: {
                                            [selectedId]: $("#" + selectedId).val()
                                    },
                                    success: function (responseText) {
//                        alert(responseText);
                                            $("#" + targetId).html(responseText);
                                    }
                            });
            
                }
    </script>

    <body class="text-center">


        <main class="form-signin w-100 m-auto">
            <div class="container-md">
            <div class="row">
            <div class="col-md-6 offset-md-3">
            <div class="card my-5">
            <form action="SignUpOrg" class="card-body cardbody-color p-lg-5" method="Post" id="signupForm">
                <div class="text-center">
                    <img src="images/mainlogo.svg" class="img-fluid profile-image-pic img-thumbnail rounded-circle my-4"
                         width="250px" alt="profile">
                </div>
                <h2 id="titles" class="h3 mb-3 fw-normal">Create Organisation Account</h2>

                <div class="form-floating mb-2">
                    <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" name="emailAddress" >
                    <label for="floatingInput">Email address</label>
                </div>
                <div class="form-floating mb-2">
                    <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password" >
                    <label for="floatingPassword">Password</label>
                </div>
                <div class="form-floating mb-2">
                    <input type="text" class="form-control" id="organisationName" placeholder="organisationName" name="organisationName" >
                    <label for="floatingInput">Organisation Name</label>
                </div>
                
                <div class="form-floating mb-2">
                    <input type="text" class="form-control" id="regnNumber" placeholder="regnNumber" name="regnNumber" >
                    <label for="floatingInput">Organisation Registration Number</label>
                </div>
          
                <div class="form-floating mb-2">

                    <select name="country" class="form-select" id="country" onchange="fetchContent('country', 'state')">
                        <option value="">Select a Country</option>
                        <c:forEach var="country" items="${CountryList}">
                            <option value=${country.getCountry()}<c:if test="${country.getCountry()==Organisation.getCountry()}"> selected </c:if>> ${country.getCountryName()}  </option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-floating mb-2">

                    <select name="state" class="form-select" id="state" onchange="fetchContent('state', 'district')">
                        <option value="">Select a Province</option>

                    </select>
                </div>

                <div class="form-floating mb-2">

                    <select name="district" class="form-select" id="district" >
                        <option value="">Select a District</option>

                    </select>
                </div>

                <div class="checkbox mb-3">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <div display="flex"><button type="submit" class="btn btn-color px-2 mb-1 w-100">Sign Up</button>
                <a href="landingPage.jsp">
                    <button type="button" class="btn btn-color-cancel px-2 mb-1 w-100">Cancel</button>
                </a></div>
                <p class="mt-5 mb-3 text-muted">&copy; 2023-2024</p>
            </form>
                    </div>
                    </div>
                    </div>
                    </div>
        </main>



    </body>
</html>
