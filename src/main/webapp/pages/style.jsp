<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Report Appiction</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">

   <style>
    body {
        background-color: #f8f9fa;
        font-family: 'Arial', sans-serif;
    }

    .container {
        margin-top: 30px;
    }

    h3 {
        color: #007bff;
    }

    table {
        margin-top: 20px;
        width: 100%;
        border-collapse: collapse;
    }

    th, td {
        text-align: center;
        padding: 10px;
        border: 1px solid #dee2e6;
    }

    .table-striped tbody tr:nth-of-type(odd) {
        background-color: #f1f3f5;
    }
    
    .opration{
    
     margin-top: 30px;
     text-align: center;
        padding: 10px;
        
    }

    hr {
        border-top: 1px solid #dee2e6;
        margin-top: 30px;
        margin-bottom: 30px;
    }

    .export-link {
        margin-top: 20px;
        text-align: center;
    }

    .export-link a {
        text-decoration: none;
        color: #fff;
        background-color: #007bff;
        padding: 10px 15px;
        border-radius: 5px;
        transition: background-color 0.3s;
    }

    .export-link a:hover {
        background-color: #0056b3;
    }

    .btn-container {
        display: flex;
        justify-content: center;
        margin-top: 20px;
    }

    .btn-container .btn {
        margin: 0 10px;
    }
</style>

</head>
<body>

<div class="container text-center">
    <h3 class="pb-3 pt-3">Report Application</h3>
</div>

<form:form action="search" modelAttribute="search" method="POST">
        <table>
        
    <tr>
    
    <td>Plan Name:</td>
    
    <td>
    <form:select path = "planName">
    <form:option value ="">-Select-</form:option>
    <form:options items = "${names}"/>
    </form:select>
    </td>
    
    
    <td>Plan Status:</td>
    <td>
    <form:select path = "planStatus">
    <form:option value ="">-Select-</form:option>
    <form:options items = "${status}"/>
    </form:select>
    </td>
    
    <td>Gender:</td>
    <td>
    <form:select path = "gender">
    <form:option value ="">-Select-</form:option>
   <form:option value ="">Male</form:option>
    <form:option value ="">Fe-Male</form:option>
    </form:select>
    </td>
    
     
  
   <td>Start Date:</td> 
    <td> <form:input path = "startDate" type = "date"
    /> </td>
 
  
   
   <td>End Date:</td>
    <td> <form:input path = "endDate" type = "date"
    /> </td>
 
    
   
   </tr>
  
      
    
    </table>
    
    <div  class = "opration">
     <a href="/" class="btn btn-secondary">Reset</a>

   
   <input type = "submit" value ="Search" 
    class ="btn btn-primary"/>  
    </div>

</form:form>

<hr/>

<table class="table table-striped">
       <thead>
    <tr>
    <th>Sr.No</th>
     <th>Holder Name</th>
     <th>Gender</th>
      <th>Plan Name</th>
       <th>Plan Status</th>
       <th>Start Date</th>
       <th>End Date</th>   
        <th>Benefit Amount</th>     
    
    </tr>  
    </thead>
    <tbody>
    <c:forEach items = "${plans}" var ="plan" varStatus ="index">
    <tr>
    <td>${index.count} </td>
    <td>${plan.citizenName} </td>
    <td>${plan.gender} </td>
    <td>${plan.planName} </td>
    <td>${plan.planStatus} </td>
    <td>${plan.planStartDate} </td>
    <td>${plan.planEndDate} </td>
    <td>${plan.benifitAmt} </td>
    </tr>
   
   <tr> 
    </c:forEach>
    <c:if test ="${empty plans}">
   <td colspan ="8" style ="text-align: centre"> No Records found</td> </c:if>
    <tr>
    
    
    </tbody>   
    
</table>

<hr/>

<!-- Export links -->
<div class="export-link">
   
   <p class ="text-success">${msg}</p>
    <a href="excel">Export to Excel</a> 
    

     <a href="pdf">Export to PDF</a>
</div>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>

</body>
</html>
