<%-- 
    Document   : frontOffice
    Created on : 17 fév. 2021, 21:25:31
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.DriverManager" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" /> 
<link rel="stylesheet" href="style.css">
</head>
<body>

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-10">
               <img class="menu-icon" src="SBahia.png" />  
            </div>
            <div class="col-md-2">
                <h4> Bonjour,   ${name}   <a href="LogoutServlet"> <i class="fas fa-sign-out-alt"></i> </a></h4>
            </div>
          
            
        </div>
    </div>
  
<div class="container-fluid ">
    <div class="row cnt1" >
     <form class="form-inline my-2 my-lg-0 searchForm" action="" method="get" > 
           <input class="form-control mr-sm-2 inputSearch" type="text" name="motcle" placeholder="Enter un mot cle">
           <button class="btn btn-secondary my-2 my-sm-0 btnSearch" type="submit"> Chercher </button> 
        </form>
    </div>
    
</div>
    <div class="container">
        <div class="row cntrow">
        <c:forEach items="${modelAcc.produits}" var="p" >
        <div class="col-md-4" style="margin-top: 50px">
            <div class="imgprod">
<i class="emptyheart far fa-heart"></i>            </div>
        <div class="cnt2" style="width: 72%">
            <h4> ${p.titre} <span class="span"> ${p.vote} <i class="heartt fas fa-heart"></i> </span> </h4>
                      <h4 class="price"> ${p.prix} Dhs </h4>
        </div>
        </div>
        </c:forEach>  
    </div>
                </div>
            <div class="cnt5">
                    <p>Entez votre email pour recevoir les nouveautés</p>
                    <form class="form-inline my-2 my-lg-0" action="" method="get" > 
           <input class="form-control mr-sm-2 inputSearch" type="text" name="motcle" placeholder="Enter un mot cle">
           <button class="btn btn-secondary my-2 my-sm-0 btnSearch" type="submit"> S'inscrire </button> 
        </form>
            </div>

                 </body>
</html>
