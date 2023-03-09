<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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


<script>
//   $("sendGmail").on("submit", function () {
//            var dataString = $(this).serialize();
//            //alert(dataString);
//             $.ajax({
//                type: "POST",
//                url: "SendGmail",
//                data: dataString,
//                success: function (responseText) {
//                                alert(responseText);
//                               $.getScript('dashboard.jsp', function () {
//                    displayVolunteers();
//                });
//                document.getElementById("display-body").style.display = 'none';
//                                $("#Target").html(responseText);
//                            }
//            });
////            e.preventDefault();
//        });
    
//    function sendGmail() {
//                    //alert("hello" + id);
//                var dataString = $(this).serialize();
////        gmailSubmit.submit();
//                    $.ajax({
//                            url: "SendGmail",
//                            data: dataString,
//                            success: function (responseText) {
//                                alert(responseText);
//                               $.getScript('dashboard.jsp', function () {
//                    displayVolunteers();
//                });
//                document.getElementById("display-body").style.display = 'none';
//                                $("#Target").html(responseText);
//                            }
//                    });
//            }
</script>

<div id="Target">           
    <div class="col-lg-auto">
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Send Mail to ${VolunteerForm.getName()}</h6>
            </div>
            <div class="card-body">
                <p>
                    <span>Volunteer Name : ${VolunteerForm.getName()}</span><br>
                    <span>Aadhar Number : ${VolunteerForm.getAadharNumber()}</span>
                <form action="SendGmail" method="post" id="sendGmail">
                    <div class="form-group" id="gmailSubmit">
                        <label for="floatingInput">Email Address </label> <input type="email" class="form-control" id="email" placeholder="name@example.com" name="email" value="${VolunteerForm.getEmailAddress()}" readonly ><br>
                        <label for="floatingInput">Mail Subject </label> <input type="text" class="form-control"id="subject" placeholder="Enter Subject of Your Mail" name="subject"><br>
                        <label for="floatingInput">Mail Details </label> <br> <textarea id="message" placeholder="Enter Your Message" name="message" rows="5" cols="126"></textarea>
                        <!--<input type="textarea" class="form-control"id="message" placeholder="Enter Your Message" name="message"><br>-->
                    </div>

                        <button type="submit" class="btn btn-primary w-100">
                        Send Mail To ${VolunteerForm.getName()}
                    </button>
                </form>

            </div>
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



