<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="Member Login">
    <meta name="description" content="">
    <meta name="page_type" content="np-template-header-footer-from-plugin">
    <title>Client Login</title>
    <link rel="icon" href="../images/icon.Png.png" type="image/icon type">
    <link href="../css/nicePage.css" rel="stylesheet"  media="screen" type="text/css">
    <link href="../css/clientLogin.css" rel="stylesheet"  media="screen" type="text/css">
    <script class="u-script" type="text/javascript" src="../js/jquery.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="../js/nicePage.js" defer=""></script>
    <meta name="generator" content="Nicepage 4.8.2, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
    
    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": ""
}</script>
    <meta name="theme-color" content="#478ac9">
    <meta property="og:title" content="Client Login">
    <meta property="og:type" content="website">
  
</head>
<body class="u-body u-xl-mode"><header class="u-clearfix u-header u-palette-1-dark-1 u-header" id="sec-0eff"><img class="u-image u-image-default u-preserve-proportions u-image-1" src="../images/icon.Png.png" alt="" data-image-width="1200" data-image-height="1200"><nav class="u-dropdown-icon u-menu u-menu-dropdown u-offcanvas u-menu-1">
       <%
session.setMaxInactiveInterval(5);
%>

<script type="text/javascript">

var Msg ='<%=session.getAttribute("getAlert")%>';
   
 </script> 
 <script type="text/javascript"> window.onload = alertName; </script>
       
       
        <div class="menu-collapse" style="font-size: 1rem; letter-spacing: 0px; font-weight: 700;">
          <a class="u-button-style u-custom-border u-custom-border-color u-custom-borders u-custom-left-right-menu-spacing u-custom-padding-bottom u-custom-text-active-color u-custom-text-color u-custom-text-hover-color u-custom-top-bottom-menu-spacing u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="#" style="padding: 4px 6px; font-size: calc(1em + 8px);">
            <svg class="u-svg-link" viewBox="0 0 24 24"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#menu-hamburger"></use></svg>
            <svg class="u-svg-content" version="1.1" id="menu-hamburger" viewBox="0 0 16 16" x="0px" y="0px" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns="http://www.w3.org/2000/svg"><g><rect y="1" width="16" height="2"></rect><rect y="7" width="16" height="2"></rect><rect y="13" width="16" height="2"></rect>
</g></svg>
          </a>
        </div>
        <div class="u-custom-menu u-nav-container">
          <ul class="u-nav u-spacing-20 u-unstyled u-nav-1"><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-white u-text-hover-white u-text-white" href="../homePage.jsp" style="padding: 10px;">Home</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-white u-text-hover-white u-text-white" href="../MOH/MOHLogin.jsp" style="padding: 10px;">MOH</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-white u-text-hover-white u-text-white" href="../MOI/MOILogin.jsp" style="padding: 10px;">MOI</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-white u-text-hover-white u-text-white" href="../MOFA/MOFALogin.jsp" style="padding: 10px;">MOFA</a>
</li></ul>
        </div>
        <div class="u-custom-menu u-nav-container-collapse">
          <div class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
            <div class="u-inner-container-layout u-sidenav-overflow">
              <div class="u-menu-close"></div>
              <ul class="u-align-center u-nav u-popupmenu-items u-unstyled u-nav-2"><li class="u-nav-item"><a class="u-button-style u-nav-link" href="../homePage.jsp">Home</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link" href="../MOH/MOHLogin.jsp">MOH</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link" href="../MOI/MOILogin.jsp">MOI</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link" href="../MOFA/MOFALogin.jsp">MOFA</a>
</li></ul>
            </div>
          </div>
          <div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
        </div>
      </nav></header>
    <section class="u-clearfix u-gradient u-section-1" id="carousel_0578">
      <div class="u-clearfix u-sheet u-sheet-1">
        <div class="u-align-center u-container-style u-group u-shape-rectangle u-group-1">
          <div class="u-container-layout u-container-layout-1"><span class="u-file-icon u-icon u-text-white u-icon-1"><img src="../images/1.png" alt=""></span>
            <div class="u-form u-login-control u-form-1">
              <form action="../ClientLogin" method="POST" class="u-clearfix u-form-custom-backend u-form-spacing-10 u-form-vertical u-inner-form" source="custom" name="form" style="padding: 0px;">
                <div class="u-form-group u-form-name">
                  <label for="username-a30d" class="u-label u-text-grey-5 u-label-1">Passport</label>
                  <input type="text" required placeholder="Passport Number" id="username-a30d" name="clientPassportNO" class="u-border-2 u-border-grey-10 u-grey-10 u-input u-input-rectangle u-input-1">
                </div>
                <div class="u-form-group u-form-password">
                  <label for="password-a30d" class="u-label u-text-grey-5 u-label-2">Password</label>
                  <input type="password" required placeholder="Enter your Password" id="password-a30d" name="birthDate" class="u-border-2 u-border-grey-10 u-grey-10 u-input u-input-rectangle u-input-2">
                </div>
                
                <div class="u-align-left u-form-group u-form-submit">
                  <input type="submit" value="Login" class="u-active-palette-2-light-2 u-border-none u-btn u-btn-submit u-button-style u-custom-color-1 u-hover-palette-2-light-2 u-text-grey-5 u-btn-1">
                </div>

                
              </form>
            </div>
            
            </div>
        </div>
      </div>
    </section>
    
    
    <footer class="u-align-center u-clearfix u-footer u-palette-1-light-1 u-footer" id="sec-bd66"><div class="u-clearfix u-sheet u-valign-middle u-sheet-1">
        <p class="u-small-text u-text u-text-variant u-text-1">Developed by the Hayyakum Co. Team Members.<br>For Contact: +966567471314 Email:hsalamah@alfaisal.edu
        </p>
      </div></footer>
    
  </body>
</html>