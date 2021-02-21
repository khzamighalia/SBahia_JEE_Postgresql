<%-- 
    Document   : register
    Created on : 17 fév. 2021, 12:01:30
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="style.css">


    </head>
    <body>
        <div class="shadow-sm p-3 mb-5 bg-white formRegister">
        <form class="" action="/SBahia/register-back.jsp" method="get">
            <div class="icon">
            <img src="SBahia.png" class="icon">
            </div>
         <div class="form-group">
 
    <input type="text" class="form-control" id="name" name="name" aria-describedby="emailHelp" placeholder="Enter votre nom ">
  </div>
  <div class="form-group">
    <input type="text" class="form-control" id="username" name="username" aria-describedby="emailHelp" placeholder="Enter un username">
  </div>
  <div class="form-group">
    <input type="password" class="form-control" id="exampleInputPassword1" name="password" placeholder="Password">
  </div>
 
  <button type="submit" class="btn btnRegister"> S'inscrire </button>
  <div class=" loglink">
      <a href="login.jsp"> <p>Avez vous déjà un compte ?</p> </a>
  </div>
</form>
        </div>
    </body>
</html>
