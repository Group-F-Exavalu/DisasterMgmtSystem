<!DOCTYPE html>
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
	</style>
</head>
<body>
     <jsp:include page="menu.jsp"></jsp:include>
        
	 <form action="" method="post">
            <h1 class="h3 mb-3 fw-normal">Form for Need Support</h1>
		<label for="name">User Id</label>
                <input type="text" class="form-control" id="userId" name="userId" required>

		<label for="name">First Name</label>
		<input type="text" class="form-control" id="firstName" name="firstName" required>
                
                <label for="name">Last Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" required>
                
                <label for="name">Phone Number</label>
                <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" required>

		<label for="event">Select a Support</label>
                
                <div class="form-floating">
                    <select name="gender" class="form-select" id="support" required>
                        <option value="" hidden>Select a support</option>
                        <option value="MonetaryHelp"> Monetary Help  </option>
                        <option value="EssentialHelp"> Essentials Help  </option>
                        <option value="Others"> Others  </option>
                    </select>
                </div>              
                
<!--		<div class="form-floating">
                    <c:set var="deptList" value="${DonateService.getInstance().getEventTopics()}">
                    </c:set><select name="eventId" class="form-select" id="eventId" required>
                        <option value="">Select a support</option>
                        <c:forEach var="event" items="${eventList}">
                            <option value=${event.eventId}> ${event.eventTopic}  </option>
                        </c:forEach>
                    </select>
                </div>-->
                
                <label for="name"> Describe your problem </label>
<!--                <input type="text" id="essential" name="essential"> -->
                <textarea id="support" name="essential" rows="5" cols="40"></textarea>
                
                <button class="w-100 btn btn-lg btn-primary" type="button" id="submitBtn">Submit</button>
	</form>
</body>
</html>
