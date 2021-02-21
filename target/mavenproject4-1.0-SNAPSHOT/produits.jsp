<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.DriverManager" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" /> 

<link rel="stylesheet" href="style.css">

    </head>
    <body>
        <nav class="navbar navbar-expand-lg "> <a class="navbar-brand" href="#" data-abc="true"><img src="SBahia.png"></a> <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
    <div class="collapse navbar-collapse" id="navbarColor02">
        <ul class="navbar-nav mr-auto" >
            <form class="form-inline my-2 my-lg-0" action="chercher.do" method="get" style="margin-left: 250px" > 
            
           <input class="form-control mr-sm-2" type="text" name="motcle" placeholder="Enter un mot cle">
           <button class="btn btnSearch2 my-2 my-sm-0" type="submit"> Chercher </button> 
        </form>
        
        </ul>
        
    </div>
                            <p> Bonjour,   ${name}   <a href="LogoutServlet"> <i class="fas logouticon fa-sign-out-alt"></i> </a></p>

</nav>
       
    
 <div class="container-fluid bg-light">
     <div class="row mx-md-n5">
         <div class="col-md-12 px-md-5">
          <a href='addForm.jsp'> <button type="button" class="btn btnAdd float-right"> + Ajouter un article </button></a>
     </div>
         </div>
     <div class="container">
         <center>
           <table class="table col-md-8 px-md-5">
              <tr>
                  <th scope="col"> Image </th>
                  <th scope="col"> Titre </th>
                  <th scope="col"> Prix</th>
                  <th scope="col"> Vote</th>
                  <th> Action </th>
              </tr>
              <c:forEach items="${model.produits}" var="p" >
                  <tr>
                      <td>  <img src="${p.img}" /></td>
                      <td> ${p.titre}</td>
                      <td> ${p.prix} </td>
                      <td> ${p.vote} </td>
                      <td><a href='updateForm.jsp?u=${p.id}'><button type="button" class="btn btnUD"><i  class="fas fa-pen"></i></button>
</a><a href='delete.jsp?d=${p.id}'>  <button type="button" class="btn btnUD"><i class="fas fa-trash-alt"></i></button></a></td>

                  </tr>
              </c:forEach>
          </table> 
             </center>
 </div>
 </div>
 </body>
</html>
