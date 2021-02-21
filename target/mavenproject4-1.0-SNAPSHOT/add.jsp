<%@page import="models.Article"%>
<%@page import="services.SArticleDAO"%>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.DriverManager" %>

<%
     String titre= request.getParameter("titre");
     String prix= request.getParameter("prix");
     int price = Integer.parseInt(prix);
     Article a=new Article("image ajoutée ",titre,price);
     SArticleDAO dao= SArticleDAO.getInstance();
     Article b= dao.ajouterArticle(a);
     ServletContext context= getServletContext();
     RequestDispatcher rd= context.getRequestDispatcher("/defaultServlet");
     rd.forward(request, response);
    
%>

