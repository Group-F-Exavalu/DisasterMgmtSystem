
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Aadhar Number Check</title>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
<!--    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">-->

    <script src="https://code.jquery.com/jquery-3.6.3.js" 
                        integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" 
                crossorigin="anonymous"></script>
    <body>
 
    
   <div class="col-lg-auto mb-4">
<c:set var = "APIUser"  value="${APIUsers}"/>
                            
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">Aadhar Details</h6>
                                </div>
                                <div class="card-body">
<!--                                    <div class="text-center">
                                        <img class="img-fluid px-3 px-sm-4 mt-3 mb-4" style="width: 25rem;"
                                            src="img/undraw_posting_photo.svg" alt="...">
                                    </div>-->
                                   <p><span>User ID :  ${APIUser.getId()}</span><br>
                                   <span>Aadhar City : ${APIUser.getCity()}</span><br>
                                   <span>Aadhar Name  : ${APIUser.getName()}</span><br>
                                   <span>Aadhar Gender :  ${APIUser.getGender()}</span><br>
                                   <span>Voter Id :  ${APIUser.getVoterId()}</span><br>
                                   <span>Aadhar Date Of Birth :  ${APIUser.getDateOfBirth()}</span><br>
                                   <span>Aadhar Number :  ${APIUser.getAadharNumber()}</span><br><!-- comment -->
                                   <span>Driving License : ${APIUser.getDrivingLicence()}</span></p><br>
                                
                                </div>
                            </div>
                              
                               
<!--                             Approach 
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">Development Approach</h6>
                                </div>
                                <div class="card-body">
                                    <p>SB Admin 2 makes extensive use of Bootstrap 4 utility classes in order to reduce
                                        CSS bloat and poor page performance. Custom CSS classes are used to create
                                        custom components and custom utility classes.</p>
                                    <p class="mb-0">Before working with this theme, you should become familiar with the
                                        Bootstrap framework, especially the utility classes.</p>
                                </div>
                            </div>-->

                        </div>

</body>
</html>

