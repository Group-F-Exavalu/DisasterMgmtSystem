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
        <title>Sign up for Individual User</title>

<!--        <link href="css/bootstrap.min.css" rel="stylesheet">

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
        .btn:hover {
                background-color: #CD5A00;
                color: white;
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
/*        #titles{
            font-family: cursive;
            
        }*/
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
//                     alert(selectedId);
            
                            $.ajax({
                                    url: 'PreSignUp',
                                    data: {
                                            [selectedId]: $("#" + selectedId).val()
                                    },
                                    success: function (responseText) {
                                    console.log(responseText);
//                                    alert(responseText);
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
               
            <form action="SignUpUser" class="card-body cardbody-color p-lg-5 mb-2" method="Post" id="signupForm">
                <div class="text-center">
                    <img src="images/mainlogo.svg" class="img-fluid profile-image-pic img-thumbnail rounded-circle my-4"
                         width="250px" alt="profile">
                </div>
                <h1 id="titles" class="h3 mb-3 fw-normal text-center">Create User Account</h1>

                <div class="form-floating mb-2">
                    
                    <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" name="emailAddress" >
                    <label for="floatingInput">Email Address</label>
                </div>
                <div class="form-floating mb-2">
                    
                    <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password" >
                    <label for="floatingInput">Password</label>
                </div>
                <div class="form-floating mb-2">
                     
                    <input type="text" class="form-control" id="firstName" placeholder="first name" name="firstName" >
                   <label for="floatingInput">First Name</label>
                </div>
                <div class="form-floating mb-2">
                    
                    <input type="text" class="form-control" id="lastName" placeholder="last name" name="lastName" >
                    <label for="floatingInput">Last Name</label>
                </div>
                <div class="form-floating mb-2">
                    <input type="text" class="form-control" id="phoneNumber" placeholder="phone number" name="phoneNumber" >
                    <label for="floatingInput">Phone Number</label>
                </div>
                <div class="form-floating mb-2">

                    <select name="gender"  class="form-select mb-2" id="gender" required>

                        <option value="Male">Male</option>  
                        <option value="Female">Female</option> 
                        <option value="Other">Other</option> 
                    </select>
                    <label for="floatingInput">Gender</label>

                </div>

<!--                <div class="form-floating mb-2">
                    <c:set var="idList" value="${RegistrationService.getInstance().getGovtProof()}"></c:set>
                        <select name="govtProof" class="form-select" id="govtProof" required>
                            <option value="">Select a Govt ID Card</option>
                        <c:forEach var="govt" items="${idList}">
                            <option value=${govt.govtProof}> ${govt.docName}  </option>
                        </c:forEach>
                    </select>
                    <label for="floatingInput">Govt ID Proof</label>
                </div>-->
                  <div class="form-floating mb-2">

                    <select name="govtProof"  class="form-select mb-2" id="govtProof" required>

                        <option value="1">Aadhar Card</option>  
                        <option value="2">Driving License</option> 
                        <option value="3">Voter Card</option> 
                    </select>
                    <label for="floatingInput">Govt ID Proof</label>

                </div>  

                <div class="form-floating mb-2">
                    <input type="text" class="form-control" id="govtId" placeholder="govtId" name="govtId" >
                    <label for="floatingInput">Govt. ID Card Number</label>
                </div>

                <div class="form-floating mb-2">
                    <input type="text" class="form-control" id="address" placeholder="address" name="address" >
                    <label for="floatingInput">Address Line 1</label>
                </div>


                <div class="form-floating mb-2">

                    <select name="country" class="form-select" id="country" onchange="fetchContent('country', 'state')">
                        <option value="">Select a Country</option>
                        <c:forEach items="${CountryList}" var="country" >
                            <option value=${country.getCountry()}> ${country.getCountryName()}  </option>
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
                    <div display="flex"><button type="submit" class="btn btn-color px-2 mb-1 w-100" id="button">Sign Up</button>
<!--                <a href="landingPage.jsp">
                    <button type="button" class="btn btn-color-cancel px-2 mb-1 w-100">Cancel</button>
                </a></div>-->
                    <div id="emailHelp" class="form-text text-center mb-5 text-dark">Not Interested? <a href="landingPage.jsp" class="text-dark fw-bold"> Cancel</a>
                            </div>
                <p class="mt-5 mb-3 text-muted text-center">&copy; 2023-2024</p>
            </form>
                    </div>
                    </div>
                    </div>
                    </div>
        </main>



    </body>
</html>
