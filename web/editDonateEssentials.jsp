<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--        <link href="css/header.css" rel="stylesheet">-->

        <title>Edit Essential Donation Status</title>

    </head>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <!<!-- I want to check my session before showing any content to the user -->

    <style>
        .fixTableHead {
            overflow-y: auto;
            height: 200px;
        }
        .fixTableHead thead th {
            position: sticky;
            top: 0;
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th,
        td {
            padding: 8px 15px;
            border: 2px solid #529432;
        }
        th {
            background: #99f;
            border: 2px solid #529432;
        }
    </style>
    <jsp:include page="menu.jsp"></jsp:include>
        <div id="example">
            <script>
                init({
                    title: 'Large data',
                    desc: 'Use `virtualScroll` to enable the virtual scroll to play with large data sets (10000 rows).',
                    links: ['bootstrap-table.min.css'],
                    scripts: ['bootstrap-table.min.js']
                });
            </script>


            <div class="bootstrap-table bootstrap5">
                <div class="fixed-table-toolbar"><div class="bs-bars float-left">

                    </div><div class="columns columns-right btn-group float-right"><div class="keep-open btn-group" title="Columns">
                            <div class="dropdown-menu dropdown-menu-right" style=""><label class="dropdown-item dropdown-item-marker"><input type="checkbox" data-field="id" value="0" checked="checked"> <span>ID</span></label><label class="dropdown-item dropdown-item-marker"><input type="checkbox" data-field="name" value="1" checked="checked"> <span>Item Name</span></label><label class="dropdown-item dropdown-item-marker"><input type="checkbox" data-field="price" value="2" checked="checked"> <span>Item Price</span></label></div></div></div></div>

                

                    <div class="fixTableHead">
                       
                            
                                <table id="example" border="2px solid #529432" >
                                    <thead>
                                        <tr class="backgroud_color">
                                            <th>
                                                Form ID
                                            </th>
                                            <th>
                                                Donor ID
                                            </th>
                                            <th>
                                                Donor Type
                                            </th>
                                            <th>
                                                Essentials
                                            </th>
                                            <th>
                                                Event
                                            </th>
                                            <th>
                                                Status
                                            </th>
                                            <th>
                                                Action
                                            </th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${EssentialList}" var="essential">
                                        <tr>
                                            <td>
                                                ${essential.getFormId()}
                                            </td>
                                            <td >
                                                ${essential.getDonorId()}                    </td>
                                            <td >
                                                ${essential.getDonorType()}                    </td>
                                            <td >
                                                ${essential.getEssentialName()}                    </td>
                                            <td >
                                                ${essential.getEventId()}                    </td>
                                            <td>
                                                
                                                <c:if test="${essential.getStatus()==0}">
                                                    <c:out value="${'PENDING'}"/> 
                                                </c:if>
                                                <c:if test="${essential.getStatus()==1}">
                                                    <c:out value="${'APPROVED'}"/> 
                                                </c:if>
                                            </td>


                                            <td>   <!-- <form action="Edit" method="Post">
                                                   <button class="w-100 btn btn-lg btn-primary" type="submit">Edit</button>
                                               </form> -->

                                                <a href=EditFNOLStatus?fnol_id=${user.getFnol_id()}>
                                                    Edit</a>                    
                                            </td>
                                        </tr>

                                    </c:forEach>
                                </tbody>
                            </table>
                           
                                 </div>
                        </div>
                            </div>
                    </div>
                
           
            <div class="fixed-table-footer" style="display: none;"></div>
       
        <div class="fixed-table-pagination" style="display: none;"></div>
    


<!--            <div class="clearfix"></div>

            <script>
                var $table = $('#table')
                var total = 0

                function getData(number, isAppend) {
                    if (!isAppend) {
                        total = 0
                    }
                    var data = []
                    for (var i = total; i < total + number; i++) {
                        data.push({
                            'id': i,
                            'name': 'Item ' + i,
                            'price': '$' + i
                        })
                    }
                    if (isAppend) {
                        total += number
                    } else {
                        total = number
                    }
                    $('#total').text(total)
                    return data
                }

                function mounted() {
                    $table.bootstrapTable({data: getData(20)})

                    $('#load').click(function () {
                        $table.bootstrapTable('load', getData(10000))
                    })

                    $('#append').click(function () {
                        $table.bootstrapTable('append', getData(10000, true))
                    })
                }
            </script>
        </div>-->

</html>
