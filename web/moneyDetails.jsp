<%-- 
    Document   : moneyDetails
    Created on : 28-Feb-2023, 9:45:38 am
    Author     : Ayshik Palit
--%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

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
<!--    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">-->

    <script src="https://code.jquery.com/jquery-3.6.3.js" 
                        integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" 
                crossorigin="anonymous"></script>
<script>
        function approveStatus(id){
            //alert("hello" + id);

            $.ajax({
                url: "ApproveMoney",
                data:{
                    formId : id
                },
                success: function (responseText) {
                //alert(responseText);
               $.getScript('dashboard.jsp', function () {          
                    displayFunds();  
                });  
            document.getElementById("display-body").style.display='none';
                $("#Target").html(responseText);
                }
            });
        }
        function rejectStatus(id){
            //alert("hello" + id);
            $.ajax({
                url: "RejectMoney",
                data:{
                    formId : id
                },
                success: function (responseText) {
    $.getScript('dashboard.jsp', function () {          
                    displayFunds();  
                });  
            document.getElementById("display-body").style.display='none';
                //alert(responseText);
                //document.getElementById("display-body").style.display='none';
//                $.getScript('menuUnderwriter.jsp', function () {          
//      loadFNOLDetails();  
//});  
//            document.getElementById("display-body").style.display='none';
               $("#Target").html(responseText);
                }
            });
        }
</script>

<script type="text/javascript">
        function getInsuranceDetails(url, id, aadharNumber) {
//                    document.getElementById("MENU").style.display = 'none';
            $.ajax({
                url: url,
                data: {
                    aadharNumber : aadharNumber
                },
                success: function (response) {
                    $('#' + id).html(response);
                }
            });
        }
    </script>
    
     
<div id="Target">
<!--<div class="d-flex flex-column gap-2 mb-3">
    <span>Form ID : ${MoneyForm.getFormId()}</span>
    <span>Donor ID : ${MoneyForm.getDonorId()}</span>
    <span>Donor Type : ${MoneyForm.getDonorType()}</span>
    <span>Amount (in Rs) : ${MoneyForm.getAmount()}</span>
    <span>Event ID : ${MoneyForm.getEventId()}</span>
</div>
<div class="gap-3 column-gap-4" style="display: grid; grid-template-columns: repeat(2, 1fr)">
    <button type="button" class="btn btn-primary w-100" onclick="getInsuranceDetails()">
        Check API Validity
    </button>
    <button type="button" class="btn btn-primary w-100" onclick="getDMVDetails()">
        Check API Validity
    </button>

    <form action="ApproveMoney" method="post">
        <button class="btn btn-lg btn-primary" type="submit">Approve</button>
    </form>
    <form action="RejectMoney" method="post">
        <button class="btn btn-lg btn-primary" type="submit">Reject</button>
    </form>
    <button type="button" class="btn btn-success w-100" onclick="approveStatus(<c:out value='${MoneyForm.getFormId()}'/>)">
        Approve
    </button>
    <button type="button" class="btn btn-danger w-100" onclick="rejectStatus(<c:out value='${MoneyForm.getFormId()}'/>)">
        Reject
    </button>
</div>-->

        <div class="col-lg-auto mb-4">

                            
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">Funds Details</h6>
                                </div>
                                <div class="card-body">
<!--                                    <div class="text-center">
                                        <img class="img-fluid px-3 px-sm-4 mt-3 mb-4" style="width: 25rem;"
                                            src="img/undraw_posting_photo.svg" alt="...">
                                    </div>-->
                                   <p><span>Form ID : ${MoneyForm.getFormId()}</span><br>
                                   <span>Donor ID :  ${MoneyForm.getDonorId()}</span><br>
                                   <span>Donor Type : ${MoneyForm.getDonorType()}</span><br>
                                   <span>Amount ($) : ${MoneyForm.getAmount()}</span><br>
                                   <span>Event ID : ${MoneyForm.getEventId()}</span><br>
                                   <span>Aadhar Number : ${Aadhar}</span></p>
                                
                                    <button type="button" class="btn btn-primary w-100" onclick="getInsuranceDetails('trial','api','${Aadhar}')">
                                        Check Aadhar Validity
                                    </button>
                                   <div class="gap-3 column-gap-4" style="display: grid; grid-template-columns: repeat(2, 1fr)">
                                <button type="button" class="btn btn-success w-100" onclick="approveStatus(<c:out value='${MoneyForm.getFormId()}'/>)">
                                    Approve
                                </button>
                                <button type="button" class="btn btn-danger w-100" onclick="rejectStatus(<c:out value='${MoneyForm.getFormId()}'/>)">
                                    Reject
                                </button>
                                </div>
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
                         <div id="api"></div>           
</div>
                                    