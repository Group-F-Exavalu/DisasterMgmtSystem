<!DOCTYPE html>
<html>

    <head>
        <title>Google Auth Demo</title>

        <meta name="google-signin-client_id" content="223541131739-eerfpk0khhegn7c1vc8f74203pvmk34f.apps.googleusercontent.com">
        <script src="https://accounts.google.com/gsi/client" async defer></script>
        <script src="https://smtpjs.com/v3/smtp.js"></script>

        <script type="text/javascript">
            function sendEmail() {
                Email.send({
                    Host: "smtp.gmail.com",
                    Username: "www.nghosal@gmail.com",
                    Password: "uluwnofjtlrecetw",
                    To: 'www.nghosal@gmail.com',
                    From: "www.nghosal@gmail.com",
                    Subject: "Sending Email using javascript",
                    Body: "Well that was easy!!",
                })
                        .then(function (message) {
                            alert("mail sent successfully");
                        });
            }
        </script>
    </head>
    <body>
        <div id="g_id_onload"
                  data-client_id="223541131739-eerfpk0khhegn7c1vc8f74203pvmk34f.apps.googleusercontent.com"
                  data-context="signin"
                  data-ux_mode="popup"
                  data-callback="handleCredentialResponse"
                  data-auto_prompt="false">

        </div>
         <div class="g_id_signin"
                   data-type="standard"
                   data-shape="pill"
                   data-theme="outline"
                   data-text="signin_with"
                   data-size="large"
               data-logo_alignment="left">

        </div>
        <script>
                            function handleCredentialResponse(response) {
                                    const responsePayLoad = decodeJwtResponse(response.credential);
                console.log(responsePayLoad);
                                    console.log("ID: " + responsePayLoad.sub);
                                    console.log("Name: " + responsePayLoad.name);
                                    console.log("Given Name: " + responsePayLoad.given_name);
                console.log("family Name: " + responsePayLoad.family_name);
                console.log("Image URL: " + responsePayLoad.picture);
                console.log("Email: " + responsePayLoad.email);
                            }                            
        </script>
        <script>
            function decodeJwtResponse(data) {
                                    var tokens = data.split(".");
                                    return JSON.parse(atob(tokens[1]));
                            }
        </script>
        <form method="post">
            <input type="button" value="Send Email" 
                   onclick="sendEmail()" />
        </form>
    </body>
</html>