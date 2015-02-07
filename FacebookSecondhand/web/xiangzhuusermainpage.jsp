<%-- 
    Document   : usermainpage
    Created on : Feb 6, 2015, 9:54:54 PM
    Author     : Scarlett
--%>

<%
   String x="";
   
   System.out.print(session.getAttribute("name"));
   if(session.getAttribute("name")==null){
      response.sendRedirect("index.jsp");
   }
     
//   System.out.print(x.isEmpty());

   else{
   x+=(String)session.getAttribute("name");
   System.out.print(x);
   }
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Scarlett - User Main Page</title>

<link href='http://fonts.googleapis.com/css?family=Cantarell|Oswald' rel='stylesheet' type='text/css'>
<link href="styles.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="nivo/default.css" type="text/css" media="screen" />
<link rel="stylesheet" href="nivo/nivo-slider.css" type="text/css" media="screen" />
<link rel="stylesheet" href="prettyphoto/prettyPhoto.css" type="text/css" media="screen" title="prettyPhoto main stylesheet" charset="utf-8" />

<script type="text/javascript" src="nivo/jquery-1.6.1.min.js"></script>
<script src="prettyphoto/jquery.prettyPhoto.js" type="text/javascript" charset="utf-8"></script>

   <script type="text/javascript">
		$(document).ready(function(){
		//Set opacity on each span to 0%
		$(".rollover").css({'opacity':'0'});
		 
		$('#gallery a.item').hover(
			function() {
				$(this).find('.rollover').stop().fadeTo(500, 1);
			},
			function() {
				$(this).find('.rollover').stop().fadeTo(500, 0);
			}
		)
		});
	</script>
</head>

<body>
<div id="container">
	<!---BEGIN Header--->
	<div id="header">
            
    	<div id="header-logo"><h1>Scarlett - User Main Page</h1></div>
        
        <div id="header-tag"><h2>scarlett.</h2></div>
        <div id="header-social">
            <ul>
                <li>
                
             <a href="#" class="facebook"> Facebook</a>"
               </li>
            </ul>
        </div>
    </div>
    
    <!---BEGIN Slider--->
    <div class="slider-wrapper theme-default">
            <span id="slider-shadow"></span>
            <div id="slider" class="nivoSlider">
                <a href="#"><img src="images/slider/slider-img-1.jpg" alt="" title="#htmlcaption1" /></a>
                <a href="#"><img src="images/slider/slider-img-2.jpg" alt="" title="#htmlcaption2" /></a>
                <a href="#"><img src="images/slider/slider-img-3.jpg" alt="" title="#htmlcaption3" /></a>
            </div>
            <div id="htmlcaption1" class="nivo-html-caption">
                <strong>Pretty Red Dress.</strong>
                Perfect gift for wife or girlfriend.
            </div>
            <div id="htmlcaption2" class="nivo-html-caption">
                <strong>National Backpack.</strong> 
                The lowest price online.
            </div>
            <div id="htmlcaption3" class="nivo-html-caption">
                <strong>Roaster.</strong> 
                Make the breakfast for your family delicate.
            </div>
            
        </div>
        
        <!---BEGIN Portfolio Gallery--->
        <div id="gallery">
            <div id="title-divider"><h3>Second-hand items</h3></div>
            <a href="images/gallery/gallery-full1.jpeg" class="item" rel="prettyPhoto[gallery1]"><span class="rollover"></span><span class="gallery-shadow"></span><img src="images/gallery/gallery-thumb1.jpeg"/></a>
            <a href="images/gallery/gallery-full2.jpg" class="item" rel="prettyPhoto[gallery1]"><span class="rollover"></span><span class="gallery-shadow"></span><img src="images/gallery/gallery-thumb2.jpg"/></a>
            <a href="images/gallery/gallery-full3.jpg" class="item" rel="prettyPhoto[gallery1]"><span class="rollover"></span><span class="gallery-shadow"></span><img src="images/gallery/gallery-thumb3.jpg"/></a>
            <a href="images/gallery/gallery-full4.jpg" class="item" rel="prettyPhoto[gallery1]"><span class="rollover"></span><span class="gallery-shadow"></span><img src="images/gallery/gallery-thumb4.jpg"/></a>
            <a href="images/gallery/gallery-full5.jpg" class="item" rel="prettyPhoto[gallery1]"><span class="rollover"></span><span class="gallery-shadow"></span><img src="images/gallery/gallery-thumb5.png"/></a>
            <a href="images/gallery/gallery-full6.jpg" class="item" rel="prettyPhoto[gallery1]"><span class="rollover"></span><span class="gallery-shadow"></span><img src="images/gallery/gallery-thumb6.jpg"/></a>
            <a href="images/gallery/gallery-full7.jpg" class="item" rel="prettyPhoto[gallery1]"><span class="rollover"></span><span class="gallery-shadow"></span><img src="images/gallery/gallery-thumb7.jpg"/></a>
            <a href="images/gallery/gallery-full8.jpg" class="item" rel="prettyPhoto[gallery1]"><span class="rollover"></span><span class="gallery-shadow"></span><img src="images/gallery/gallery-thumb8.jpg"/></a>
            <a href="images/gallery/gallery-full9.jpg" class="item" rel="prettyPhoto[gallery1]"><span class="rollover"></span><span class="gallery-shadow"></span><img src="images/gallery/gallery-thumb9.jpg"/></a>
            <a href="images/gallery/gallery-full10.jpg" class="item" rel="prettyPhoto[gallery1]"><span class="rollover"></span><span class="gallery-shadow"></span><img src="images/gallery/gallery-thumb10.jpg"/></a>
        </div>
        
        <!---BEGIN About Me--->
        <div id="about">
            <div id="title-sub-divider"><h3>About Me</h3></div>
            <div id="about-col1">
            <div id="about-photo">
            	<span class="about-img-shadow"></span>
            	<img src="images/about-photo.jpg" />
            </div>
            	<ul>
                    
                    <li>
                <%
                System.out.println(request.getSession().getAttribute("link"));
                out.println("<h1><a href=\""+
                        request.getSession().getAttribute("link")+
                        "\" >Facebook</a></h1>"+"<br>");
                out.println("<h1>"+ 
                        request.getSession().getAttribute("email")+
                         "</h1><br>");
                out.println("<h1>"+ 
                        request.getSession().getAttribute("name")+
                         "</h1>");
                
                
                
                
                %>
                    <li>
                </ul>
            </div>
            <div id="about-col2">
           <p> I like to collect varied goods and then share woth people. </p>

<p>Enjoy it! </p>
            </div>
        </div>
        
        <!---BEGIN Contact Form--->
        <div id="contact">
        <div id="title-sub-divider"><h3>Contact</h3></div>
        	<form id="contact-form">
                <input type="text" name="name" id="name" value="Your Name" />
                <input type="text" name="email" id="email" value="Your Email Address" />
                <textarea id="comment"></textarea>
                <input type="submit" value="submit" id="submit" />
            </form>
        </div>
        
        </div>
</div>

    <script type="text/javascript" src="nivo/jquery.nivo.slider.pack.js"></script>
    <script type="text/javascript">
    $(window).load(function() {
        $('#slider').nivoSlider({
			effect:'random', 
            slices:15,  
            animSpeed:500, 
            pauseTime:5000
			});
    });
    </script>
    
    <script type="text/javascript" charset="utf-8">
	$(document).ready(function(){
		$("a[rel^='prettyPhoto']").prettyPhoto({animation_speed:'normal', theme:'dark_rounded', social_tools:false, slideshow:false, autoplay_slideshow: false});
		$(".image a[rel^='prettyPhoto']").prettyPhoto({animation_speed:'normal', theme:'dark_rounded', social_tools:false, slideshow:false, autoplay_slideshow: false});
	});
	</script>
</body>
</html>
