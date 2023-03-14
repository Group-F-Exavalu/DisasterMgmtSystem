<link href="css/bootstrap.min.css" rel="stylesheet">
<div class="card">
    <div class="card-header bg-black"></div>
    <div class="card-body">
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <jsp:include page="menu.jsp"></jsp:include>
            <div id="myForm">
                <div class="container">
                    <!--      <div class="row">
                            <div class="col-xl-12">
                                <i class="far fa-building text-danger fa-6x float-start" hidden></i>
                            </div>
                          </div>-->


                    <div class="row">
                        <div class="col-xl-12">

                            <ul class="list-unstyled float-end">
                                <li style="font-size: 30px; color: orangered;">Chariots of Hope</li>
                                <li>Plot 3, BENGAL ECO INTELLIGENT PARK,</li>
                                <li>Kolkata, West Bengal 700091</li>
                                <li>123-456-789</li>
                                <li>admin@gmail.com</li>
                            </ul>
                        </div>
                    </div>

                    <div class="row text-center">
                        <h3 class="text-uppercase text-center mt-3" style="font-size: 40px;">Transaction Details</h3>
                        <!--<p>Name : ${DonateForm.firstName}</p><br>-->
                    <c:if test='${Organisation!=null}'>
                        <p>Name : ${DonateForm.firstName}</p><br>
                        <p>Registration Number : ${DonateForm.lastName}</p><br>
                        <p>Address : ${DonateForm.address}</p>
                    </c:if>
                    <c:if test='${User!=null}'>
                        <p>Name : ${DonateForm.firstName} ${DonateForm.lastName}</p><br>
                        <p>Phone Number : ${DonateForm.phoneNumber}</p><br>
                        <p>Address : ${DonateForm.address}</p>
                    </c:if>
                    <c:if test='${GmailUser!=null}'>
                        <p>Name : ${DonateForm.given_name} ${DonateForm.family_name}</p><br>
                        <p>Email Address: ${DonateForm.email}</p><br>
                    </c:if>
                    <!--<p>Address : ${DonateForm.address}</p>-->
                </div>

                <div class="row mx-3">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Description of Support Event</th>
                                <th scope="col">Amount Paid</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${DonateForm.eventTopic}</td>
                                <td><span>&#8377;</span> ${DonateForm.amount}</td>
                            </tr>
                            <tr>
                                <td><b>UPI Transaction ID</b></td>
                                <td>${DonateForm.transactionId}</td>
                            </tr>
                        </tbody>
                    </table>

                </div>
                <!--      <div class="row">
                        <div class="col-xl-8">
                          <ul class="list-unstyled float-end me-0">
                            <li><span class="me-3 float-start">Total Amount:</span><i class="fas fa-dollar-sign"></i> 6850,00
                            </li>
                            <li> <span class="me-5">Discount:</span><i class="fas fa-dollar-sign"></i> 500,00</li>
                            <li><span class="float-start" style="margin-right: 35px;">Shippment: </span><i
                                class="fas fa-dollar-sign"></i> 500,00</li>
                          </ul>
                        </div>
                      </div>-->
                <!--<hr>-->
                <div class="row">
                    <div class="col-xl-8" style="margin-left:60px">
                        <p class="float-end"
                           style="font-size: 30px; color: orangered; font-weight: 400;font-family: Arial, Helvetica, sans-serif;">
                            Total:
                            <span>&#8377;</span> ${DonateForm.amount}</p>
                    </div>

                </div>

                <div class="row mt-2 mb-5">

                    <div>
                        <p class="fw-bold">Date: <script>
                            date = new Date().toLocaleDateString();
                            document.write(date);
                            </script><span class="text-muted"></span></p>

                    </div>
                    <p class="fw-bold mt-3">Signature: <img src="image/Signature.jpeg" style="width:128px;height:70px;"></p>
                </div>
            </div>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.9.2/html2pdf.bundle.js"></script>
            <script>
                                      // Function to GeneratePdf
                                        function GeneratePdf() {
                                                const template = this.document.getElementById("myForm");
                                                console.log(template);
                                                console.log(window);
                                                var opt = {
                                                        margin: 0,
                                                        filename: 'Receipt.pdf',
                                                        image: {type: 'jpeg', quality: 1},
                                                        html2canvas: {scale: 2},
                                                        jsPDF: {unit: 'in', format: 'A4', orientation: 'landscape'}
                                                };
                                                html2pdf().from(template).set(opt).save();
                                        }

            </script>

        </div>

        <button onclick= "GeneratePdf()" class="btn btn-color px-2 mb-2 w-100" type="button" id="Pdfbutton">Generate PDF</button>


    </div>
    <div class="card-footer bg-black"></div>
</div>