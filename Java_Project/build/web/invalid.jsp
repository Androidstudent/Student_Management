
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <link rel="stylesheet" type="text/css" href="Style/style.css"/>
         <style>
            .border,.rain{
				height: 100px;
				width: 530px
			}
        </style>
    </head>
    <body>
        <div id="header">
            <img src="Style/banner.jpg" width="880px" height="150px">
        </div>
         <div id="menu">
       <ul id="menu">
    
              <li> <a href="<%=request.getContextPath()%>/index.jsp"> Home</a> </li>
    
</ul> 
      
    </div>     
           
        <div id="content">
        <div class="rain">
			<div class="border start">
        <form>
        <h1>Invalid Information!</h1>
        </form>
    </body>
</html>
