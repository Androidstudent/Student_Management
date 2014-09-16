
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
        <script>
            function fillDdl()
            {
                
            }
		$(function(){
		  var $form_inputs =   $('form input');
		  var $rainbow_and_border = $('.rain, .border');
		  /* Used to provide loping animations in fallback mode */
		 /* $form_inputs.bind('focus', function(){
		  	$rainbow_and_border.addClass('end').removeClass('unfocus start');
		  });
		  $form_inputs.bind('blur', function(){
		  	$rainbow_and_border.addClass('unfocus start').removeClass('end');
		  });*/
		  $form_inputs.first().delay(800).queue(function() {
			$(this).focus();
		  });
		});
	</script>
        <link rel="stylesheet" type="text/css" href="Style/style.css"/>
        <style>
        .border,.rain{
				height: 270px;
				width: 240px
			}
        </style>
        
	</head>
        <title>Home</title>
    </head>
    <body id="home">
        
        <div id="header">
            <img src="Style/banner.jpg" width="880px" height="150px">
        </div>
        
     <div id="menu">
    
         <h1>Welcome , Lambton Student Management System.</h1>
        
    </div>     
        
    <div id="content">
    
        <div id="content-left">	
            <div class="rain">
			<div class="border start">
                            
       <form name="studentInsert" action="<%=request.getContextPath()%>/LogInServlet" method="post">
           <div style="margin-left:1%;text-align:center;font-weight:bold">Login</div>
           <label>Username:</label>  
           <input type="text" name="userName" id="userName" required />
           <label>Password:</label>  
            <input type="password" name="password" id="password" required/>
           <input type="submit" style="outline:none; width:105px" name="submit" value="submit"/>
        </form>
                       </div>
                </div>
        </div>
            <div id="content-right"> 
                <p style="width: 450px" style="text-align: justify"> 
                       Lambton College is in its 47th year and in that time the College has gained worldwide 
                       recognition as a specialized institution. Lambton currently has its main campus in Sarnia, 
                       the Fire & Public Safety  Centre of Excellence just outside city limits and an Employment 
                       and Learning Centre in Petrolia. We also have multiple campuses located in China.<br/>
                       In the past 46 years, the College has been working hard to provide even more to its 3,600+ 
                       full-time and 6,500 part-time students. The College continues to grow every year by offering 
                       new programs, new research opportunities and improved lab and classroom facilities. 
                </p>
             </div>
        </div>
           <div id="footer">
               <p style="text-align: center">  All Rights Reserved. Copyrights 2014 | Developed By: Banana Software Inc. </p>
           </div>
           
    </body>
</html>
