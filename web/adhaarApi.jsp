<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/menu_css.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="css/product.css" rel="stylesheet">
        <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
        <title>Aadhar API</title>
    </head>
    
    <body>
 
    
    
    
<br>
                   <div class="table-body ms-auto" style="width:50%;"  >
                        <table id="table-id" class="table table-bordered table-hover" style="margin-left:  -50%;">
                            <thead>
                  <tr>
                                <th scope = "col">
                                  id
                                </th>
                                <th scope = "col">
                                   city
                                </th>
                                <th scope = "col">
                                    name 
                                </th>
                                <th scope = "col">
                                  gender
                                </th>
                                 <th scope = "col">
                                    voterId
                                </th>
                                <th scope = "col">
                                   dateOfBirth
                                </th>
                                <th scope = "col">
                                    aadharNumber 
                                </th>
                                <th scope = "col">
                                  drivingLicence
                                </th>
                                
                               

                            </tr>
                        </thead>
                        <tbody>
                       
                             <c:set var = "APIUser"  value="${APIUsers}"/>
                               <tr>
                                    <td>
                                        ${APIUser.getId()}
                                    </td>
                                    <td>
                                        ${APIUser.getCity()}
                                    </td>
                                    <td>
                                        ${APIUser.getName()}
                                    </td>
                                    <td>
                                        ${APIUser.getGender()}
                                    </td>
                                    <td>
                                        ${APIUser.getVoterId()}
                                    </td>
                                    <td>
                                        ${APIUser.getDateOfBirth()}
                                    </td>
                                    <td>
                                        ${APIUser.getAadharNumber()}
                                    </td>
                                    <td>
                                        ${APIUser.getDrivingLicence()}
                                    </td>
                                    
                                    
                                   </tr>
                            

                     </tbody>
                    </table>
             </div>

</body>
</html>

