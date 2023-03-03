<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="css/profilecss.css" rel="stylesheet">
<!------ Include the above in your HEAD tag ---------->
<head>
    <title>User Profile</title>
</head>
<jsp:include page="menu.jsp"></jsp:include>
    <div id="ultimate">
        <div class="container emp-profile shadow-lg p-3 mb-5 bg-white rounded">
            <form action="SaveUser" method="post" id="saveuser">
                <div class="row">
                    <div class="col-md-4">
                        <div class="profile-img">
                            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS52y5aInsxSm31CvHOFHWujqUx_wWTS9iM6s7BAm21oEN_RiGoog" alt=""/>
                            <div class="file btn btn-lg btn-primary">
                                Change Photo
                                <input type="file" name="file"/>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="profile-head">
                            <h5>
                            ${User.firstName} ${User.lastName}
                        </h5>
                        <!--                                    <h6>
                                                                Web Developer and Designer
                                                            </h6>-->
                        <p class="proile-rating">RANKINGS : <span>8/10</span></p>
                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">About</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Timeline</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-2">
                    <!--                        <input type="submit" class="profile-edit-btn" name="btnAddMore" value="Edit Profile"/>-->
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div class="profile-work">
                        <!--                            <p>WORK LINK</p>
                                                    <a href="">Website Link</a><br/>
                                                    <a href="">Bootsnipp Profile</a><br/>
                                                    <a href="">Bootply Profile</a>
                                                    <p>SKILLS</p>
                                                    <a href="">Web Designer</a><br/>
                                                    <a href="">Web Developer</a><br/>
                                                    <a href="">WordPress</a><br/>-->

                    </div>
                </div>

                <script>
                    function loadNewContent(url, id, ) {
                        //                    document.getElementById("MENU").style.display = 'none';
                        saveuser.submit();
                        $.ajax({
                            url: url,
                            success: function (response) {
                                $('#' + id).html(response);
                            }
                        });
                    }
                </script>

                <div class="col-md-8">
                    <div class="tab-content profile-tab" id="myTabContent">
                        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                            <div class="row">
                                <div class="col-md-6">
                                    <label>User ID</label>
                                </div>
                                <input type="text" class="col-md-6" id="floatingInput" name="userId" value="${User.getUserId()}" readonly> 
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>First Name</label>
                                </div>
                                <input type="text" class="col-md-6" id="floatingInput" placeholder="name" name="firstName" value="${User.getFirstName()}"> 
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Last Name</label>
                                </div>
                                <input type="text" class="col-md-6" id="floatingInput" placeholder="name" name="lastName" value="${User.getLastName()}"> 
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Email</label>
                                </div>
                                <input type="text" class="col-md-6" id="floatingInput" placeholder="example@gmail.com" name="emailAddress" value="${User.getEmailAddress()}" readonly> 
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Gender</label>
                                </div>
                                <input type="text" class="col-md-6" id="floatingInput" placeholder="Gender" name="gender" value="${User.getGender()}"> 
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Phone</label>
                                </div>
                                <input type="text" class="col-md-6" id="floatingInput" placeholder="Phone Number" name="phoneNumber" value="${User.getPhoneNumber()}"> 
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Address</label>
                                </div>
                                <input type="text" class="col-md-6" id="floatingInput" placeholder="Address" name="address" value="${User.getAddress()}"> 
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Country</label>
                                </div>
                                <input type="text" class="col-md-6" id="floatingInput" placeholder="Country" name="country" value="${User.getCountry()}" readonly> 
                            </div>
                            <button class="w-25 btn btn-md btn-primary" type="button" onclick="loadNewContent('ShowUser', 'ultimate')">Save</button> 
                        </div>
                        <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Experience</label>
                                </div>
                                <div class="col-md-6">
                                    <p>Expert</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Hourly Rate</label>
                                </div>
                                <div class="col-md-6">
                                    <p>10$/hr</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Total Projects</label>
                                </div>
                                <div class="col-md-6">
                                    <p>230</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>English Level</label>
                                </div>
                                <div class="col-md-6">
                                    <p>Expert</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Availability</label>
                                </div>
                                <div class="col-md-6">
                                    <p>6 months</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <label>Your Bio</label><br/>
                                    <p>Your detail description</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </form>           
    </div>
</div>