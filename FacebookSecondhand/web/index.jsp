<!DOCTYPE html>



<html>
    <head>
        <title>FaceBook SecondHand Extension</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
   
        <form action="#" method="get">
                    <table>
                            <tr>
                                    <td>UserName:</td>
                                    <td><input type="text" name="username" value="" /></td>
                            </tr>
                            <tr>
                                    <td>Password:</td>
                                    <td><input type="password" name="password" value="" /></td>
                            </tr>
                            <tr>
                                    <td colspan="2">
                                            <input type="submit" name="submit" value="login" />
                                            <input type="reset" name="reset" value="cacel" />
                                    </td>
                            </tr>
                    </table>
        </form>
        

    </body>
</html> 

 <script>
      window.fbAsyncInit = function() {
        FB.init({
          appId      : 'your-app-id',
          xfbml      : true,
          version    : 'v2.1'
        });
      };

      (function(d, s, id){
         var js, fjs = d.getElementsByTagName(s)[0];
         if (d.getElementById(id)) {return;}
         js = d.createElement(s); js.id = id;
         js.src = "//connect.facebook.net/en_US/sdk.js";
         fjs.parentNode.insertBefore(js, fjs);
       }(document, 'script', 'facebook-jssdk'));
    </script>
        

