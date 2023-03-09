
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Essentials-Tables</title>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    <style>
     .tableFixHead {
        overflow-y: auto; /* make the table scrollable if height is more than 200 px  */
        height: 300px; /* gives an initial height of 200px to the table */
      }
      .tableFixHead thead th {
        position: sticky; /* make the table heads sticky */
        top: 0px; /* table head will be placed from the top of the table and sticks to it */
      }
      table {
        border-collapse: collapse; /* make the table borders collapse to each other */
        width: 100%;
      }
    </style>
</head>

<body id="page-top">

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    function editVolunteer(url,id,emailId){
        $.ajax({
                url: url,
                data:{
                    emailAddress : emailId
                },
                success: function (responseText) {
                //alert(responseText);
                $('#'+id).html(responseText);
                }
            });
    }
    function editVolunteer(url,id,emailId){
        $.ajax({
                url: url,
                data:{
                    emailAddress : emailId
                },
                success: function (responseText) {
                //alert(responseText);
                $('#'+id).html(responseText);
                }
            });
    }
    function emailVolunteer(url,id,emailId){
        $.ajax({
                url: url,
                data:{
                    emailAddress : emailId
                },
                success: function (responseText) {
                //alert(responseText);
                $('#'+id).html(responseText);
                }
            });
    }
</script>
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Volunteers</h1>
<!--                    <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                        For more information about DataTables, please visit the <a target="_blank"
                            href="https://datatables.net">official DataTables documentation</a>.</p>-->

                    <!-- DataTales Example -->
                  <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Volunteers Data</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive tableFixHead">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>
                                                Volunteer Email ID
                                            </th>
                                            <th>
                                                Volunteer Name
                                            </th>
                                            <th>
                                                Volunteer Aadhar Number
                                            </th>
                                            <th>
                                                Volunteer Phone Number
                                            </th>
                                            <th>
                                                Volunteer Message
                                            </th>

                                            <th>
                                                Status
                                            </th>
                                            <th>
                                                Action
                                            </th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>
                                                Volunteer Email ID
                                            </th>
                                            <th>
                                                Volunteer Name
                                            </th>
                                            <th>
                                                Volunteer Aadhar Number
                                            </th>
                                            <th>
                                                Volunteer Phone Number
                                            </th>
                                            <th>
                                                Volunteer Message
                                            </th>

                                            <th>
                                                Status
                                            </th>
                                            <th>
                                                Action
                                            </th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:if test='${VolunteerList!=null}'>
                                            <c:forEach items='${VolunteerList}' var="volunteer">
                                        <tr>
                                            <td>${volunteer.getEmailAddress()}</td>
                                            <td>${volunteer.getName()}</td>
                                            <td>${volunteer.getAadharNumber()}</td>
                                            <td>${volunteer.getPhoneNumber()}</td>
                                            <td>${volunteer.getMesssage()}</td>
                                            <td><c:if test='${volunteer.getStatus()==0}'>Pending</c:if><c:if test='${volunteer.getStatus()==1}'>Approved</c:if><c:if test='${volunteer.getStatus()==-1}'>Rejected</c:if></td>
                                             <td>  
                                                         <button class="btn-light"><a onclick="editVolunteer('EditVolunteerStatus','edit','${volunteer.getEmailAddress()}')">Edit</a></button><button class="btn-light"><a onclick="emailVolunteer('SendVolunteerStatus','edit','${volunteer.getEmailAddress()}')">Send</a></button>
                                            </td>
                                        </tr>
                                            </c:forEach>
                                        </c:if>
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                
                <!-- /.container-fluid -->
                <div class="container-fluid" id="edit">
<!--                <div class="col-lg-auto mb-4">

                             Illustrations 
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">Illustrations</h6>
                                </div>
                                <div class="card-body">
                                    <div class="text-center">
                                        <img class="img-fluid px-3 px-sm-4 mt-3 mb-4" style="width: 25rem;"
                                            src="img/undraw_posting_photo.svg" alt="...">
                                    </div>
                                    <p>Add some quality, svg illustrations to your project courtesy of <a
                                            target="_blank" rel="nofollow" href="https://undraw.co/">unDraw</a>, a
                                        constantly updated collection of beautiful svg images that you can use
                                        completely free and without attribution!</p>
                                    <a target="_blank" rel="nofollow" href="https://undraw.co/">Browse Illustrations on
                                        unDraw &rarr;</a>
                                </div>
                            </div>

                             Approach 
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
                            </div>

                        </div>-->
                    </div>
                 </div>

                


<!--            </div>
             End of Main Content -->

<!--             Footer 
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2020</span>
                    </div>
                </div>
            </footer>
             End of Footer 

        </div>
         End of Content Wrapper 

    </div>
     End of Page Wrapper 

     Scroll to Top Button
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

     Logout Modal
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>-->
<!--
     Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!--
     Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
<!--
     Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>
<!--
     Page level plugins -->
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>
<!--
     Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>

</body>

</html>