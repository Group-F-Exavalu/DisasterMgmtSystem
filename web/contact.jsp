<!doctype html>
<html lang="en">
<head>
<title>Contact Form 02</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<jsp:include page="menu.jsp"></jsp:include>
<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style.css">

<script nonce="3ae46f7e-62da-41ad-aa5f-8ed9d229703e">(function(w,d){!function(f,g,h,i){f[h]=f[h]||{};f[h].executed=[];f.zaraz={deferred:[],listeners:[]};f.zaraz.q=[];f.zaraz._f=function(j){return function(){var k=Array.prototype.slice.call(arguments);f.zaraz.q.push({m:j,a:k})}};for(const l of["track","set","debug"])f.zaraz[l]=f.zaraz._f(l);f.zaraz.init=()=>{var m=g.getElementsByTagName(i)[0],n=g.createElement(i),o=g.getElementsByTagName("title")[0];o&&(f[h].t=g.getElementsByTagName("title")[0].text);f[h].x=Math.random();f[h].w=f.screen.width;f[h].h=f.screen.height;f[h].j=f.innerHeight;f[h].e=f.innerWidth;f[h].l=f.location.href;f[h].r=g.referrer;f[h].k=f.screen.colorDepth;f[h].n=g.characterSet;f[h].o=(new Date).getTimezoneOffset();if(f.dataLayer)for(const s of Object.entries(Object.entries(dataLayer).reduce(((t,u)=>({...t[1],...u[1]})))))zaraz.set(s[0],s[1],{scope:"page"});f[h].q=[];for(;f.zaraz.q.length;){const v=f.zaraz.q.shift();f[h].q.push(v)}n.defer=!0;for(const w of[localStorage,sessionStorage])Object.keys(w||{}).filter((y=>y.startsWith("_zaraz_"))).forEach((x=>{try{f[h]["z_"+x.slice(7)]=JSON.parse(w.getItem(x))}catch{f[h]["z_"+x.slice(7)]=w.getItem(x)}}));n.referrerPolicy="origin";n.src="/cdn-cgi/zaraz/s.js?z="+btoa(encodeURIComponent(JSON.stringify(f[h])));m.parentNode.insertBefore(n,m)};["complete","interactive"].includes(g.readyState)?zaraz.init():f.addEventListener("DOMContentLoaded",zaraz.init)}(w,d,"zarazData","script");})(window,document);</script></head>
<body style="background-image: url(https://www.pexels.com/photo/food-and-drinks-inside-the-carton-box-6590920/)">
<section class="ftco-section">
<div class="container shadow-lg p-3 mb-5 bg-white rounded">
<div class="row justify-content-center">
<div class="col-md-12">
<div class="wrapper">
<div class="row no-gutters">
<div class="col-lg-8 col-md-7 order-md-last d-flex align-items-stretch">
<div class="contact-wrap w-100 p-md-5 p-4">
<h3 class="mb-4">Contact Chariots Of Hope</h3>
<div id="form-message-warning" class="mb-4"></div>
<!--<div id="form-message-success" class="mb-4">
Your message was sent, thank you!
</div>-->
<form id="contactForm" name="contactForm" class="contactForm" action="https://formspree.io/f/xoqzdzav" method="post">
<div class="row">
<div class="col-md-6">
<div class="form-group">
<label class="label" for="name">Full Name</label>
<input type="text" class="form-control" name="name" id="name" placeholder="Name">
</div>
</div>
<div class="col-md-6">
<div class="form-group">
<label class="label" for="email">Email Address</label>
<input type="email" class="form-control" name="emailAddress" id="email" placeholder="Email">
</div>
</div>
<div class="col-md-12">
<div class="form-group">
<label class="label" for="subject">Subject</label>
<input type="text" class="form-control" name="subject" id="subject" placeholder="Subject">
</div>
</div>
<div class="col-md-12">
<div class="form-group">
<label class="label" for="#">Message</label>
<textarea name="message" class="form-control" id="message" cols="30" rows="4" placeholder="Message"></textarea>
</div>
</div>
<div class="col-md-12">
<div class="form-group">
<input type="submit" value="Send Message" class="btn btn-primary">
<div class="submitting"></div>
</div>
</div>
</div>
</form>
</div>
</div>
<div class="col-lg-4 col-md-5 d-flex align-items-stretch">
<div class="info-wrap bg-primary w-100 p-md-5 p-4">
<h3>Let's get in touch</h3>
<p class="mb-4 text-white">We're open for any suggestions or just to have a chat!</p>
<div class="dbox w-100 d-flex align-items-start">
<div class="icon d-flex align-items-center justify-content-center">
<span class="fa fa-map-marker"></span>
</div>
<div class="text pl-3 text-white">
    <p><span style="color: black">Address:</span> Plot 3, BENGAL ECO INTELLIGENT PARK, Unit No: C, 6th Floor, EM Block, Sector V, Kolkata, West Bengal 700091</p>
</div>
</div>
<div class="dbox w-100 d-flex align-items-center">
<div class="icon d-flex align-items-center justify-content-center">
<span class="fa fa-phone"></span>
</div>
<div class="text pl-3 text-white">
<p><span style="color: black">Phone:</span> +917824573892</p>
</div>
</div>
<div class="dbox w-100 d-flex align-items-center">
<div class="icon d-flex align-items-center justify-content-center">
<span class="fa fa-paper-plane"></span>
</div>
<div class="text pl-3 text-white">
<p><span style="color: black">Email:</span> admin1@gmail.com</p>
</div>
</div>
<div class="dbox w-100 d-flex align-items-center">
<div class="icon d-flex align-items-center justify-content-center">
<span class="fa fa-globe"></span>
</div>
<div class="text pl-3 text-white">
<p><span style="color: black">Website:</span> yoursite.com </p>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</section>
<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script src="js/jquery.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/main.js"></script>
<script defer src="https://static.cloudflareinsights.com/beacon.min.js/vaafb692b2aea4879b33c060e79fe94621666317369993" integrity="sha512-0ahDYl866UMhKuYcW078ScMalXqtFJggm7TmlUtp0UlD4eQk0Ixfnm5ykXKvGJNFjLMoortdseTfsRT8oCfgGA==" data-cf-beacon='{"rayId":"7a0fe7c43dc68fb6","token":"cd0b4b3a733644fc843ef0b185f98241","version":"2023.2.0","si":100}' crossorigin="anonymous"></script>
</body>
</html>


