<%-- 
    Document   : usermainpage
    Created on : Feb 6, 2015, 9:54:54 PM
    Author     : Scarlett
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Add Item Page</title>

<link href="styles.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="nivo/jquery-1.6.1.min.js"></script>
<script src="prettyphoto/jquery.prettyPhoto.js" type="text/javascript" charset="utf-8"></script>
 
</head>

<body>   
        <!---BEGIN Contact Form--->
        <div id="contact">
            <div id="title-sub-divider"><h3 style="width:330px">Add the stuff you want to sell</h3></div>
        	<form id="contact-form">
                <input type="text" name="name" value="Item Name" style="width:250px"/>
                <input type="text" name="email"  value="Description" style="width:300px"/>
                <input type="text" name="email"  value="Price" style="width:300px"/>
                <input type="text" name="email"  value="Image" style="width:300px"/>
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
