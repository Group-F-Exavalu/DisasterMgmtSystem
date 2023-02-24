<!DOCTYPE html>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.8.1/html2pdf.bundle.min.js"></script>
<html>
    <head>
        <style>
            form {
                max-width: 400px;
                margin: auto;
                padding: 20px;
                background-color: #f5f5f5;
                border: 1px solid #ddd;
                border-radius: 5px;
            }

            label {
                display: block;
                font-weight: bold;
                margin-bottom: 10px;
            }

            input, select {
                display: block;
                width: 95%;
                padding: 10px;
                margin-bottom: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
            }

            button {
                display: block;
                margin: 0 auto;
                padding: 10px 20px;
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            button:hover {
                opacity: 0.8;
            }
            
            body {
                background-image: url('https://themewagon.github.io/fundraiser/images/img_3.jpg');
            }
        </style>
        <style>
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
        <script>
                      // Function to GeneratePdf
            function GeneratePdf() {
                var element = document.getElementById('myForm');
                html2pdf(element);
            }
        </script>
    </head>
    <body>
        <div class="row">

        <div class="col-lg-6">
            <form action="DonateEssentialUser" method="post" id="myForm">
                <h1 class="h3 mb-3 fw-normal">Donation of Essentials</h1>
                <label for="name">User Id</label>
                <input type="text" id="userId" name="donorId" value=${User.userId} readonly>

                <label for="name">First Name</label>
                <input type="text" id="firstName" name="firstName" value=${User.firstName} readonly>

                <label for="name">Last Name</label>
                <input type="text" id="lastName" name="lastName" value=${User.lastName} readonly>

                <label for="name">Phone Number</label>
                <input type="text" id="phoneNumber" name="phoneNumber" value=${User.phoneNumber} readonly>

                <label for="name"> Address </label>
                <input type="text" id="address" name="address" value=${User.address} readonly>

                <div class="form-floating">
                        
                            <select name="eventId" class="form-select" id="eventId" required>
                                <option value="">Select an event</option>
                            <c:forEach var="event" items="${EventList}">
                                <option value=${event.eventId}> ${event.eventTopic}  </option>
                            </c:forEach>
                        </select>
                        <label for="floatingInput">Event</label>
                </div>
                <label for="name"> Essential Name </label>
                <input type="text" id="essential" placeholder = "Clothes, Food, Drinks.." name="essentialName">
                
                <div>
                <button onclick= "GeneratePdf()" class="btn btn-color px-2 mb-2 w-100" type="button" id="button">Generate PDF</button>
                    </div>

                    <button class="btn btn-color px-2 mb-2 w-100" type="submit" id="submitBtn">Submit</button>
            </form>
        </div>
        <div class="col">
            <div>
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3684.1041310182027!2d88.42524581492503!3d22.575208385181504!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3a02750014d7f12f%3A0xba88c52b0fa7f529!2sExavalu!5e0!3m2!1sen!2sin!4v1677215996378!5m2!1sen!2sin" width="600" height="800" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                </div>
        </div>
                        </div>
    </body>
</html>
