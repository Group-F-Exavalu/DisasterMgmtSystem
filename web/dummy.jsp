<%-- 
    Document   : dummy
    Created on : Mar 8, 2023, 6:06:22 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="SendGmail" method="post">
            <div class="form-group">
                <label for="exampleInputEmail1">Email address</label>
                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="email">
                
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Subject</label>
                <input type="text" class="form-control" id="subjectId" placeholder="subject" name="subject">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Message</label>
                <input type="text" class="form-control" id="messageId" placeholder="message" name="message">
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="exampleCheck1">
                <label class="form-check-label" for="exampleCheck1">Check me out</label>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </body>
</html>
