<!DOCTYPE html>
<html>
  <head>
    <title>Contact Us</title>
    <style>
    form {
  display: flex;
  flex-direction: column;
  width: 40%;
  margin: auto;
}


label, input, textarea {
  margin-bottom: 10px;
}

input[type="text"], input[type="email"], textarea {
  padding: 10px;
  border: none;
  border-radius: 5px;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
}

button[type="submit"] {
  padding: 10px;
  border: none;
  border-radius: 5px;
  background-color: #008CBA;
  color: #fff;
  font-weight: bold;
  cursor: pointer;
}

button[type="submit"]:hover {
  background-color: #005b80;
}

    </style>
  </head>
  <body>
<div class="container">

      
      <form action="https://formspree.io/f/xoqzdzav" method="post">
          <h1>Contact Us</h1>
          <div><!-- comment --><p>Please drop us a feedback.</p> </div>
      
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" required>

  <label for="email">Email:</label>
  <input type="email" id="email" name="emailAddress" required>

  
  <label for="subject">Subject:</label>
  <input type="text" id="subject" name="subject" required>

  <label for="message">Message:</label>
  <textarea id="message" name="message" required></textarea>

  <button type="submit" value="Send Message" >Send Message</button>
</form>

</div>
     
   
  </body>
</html>


