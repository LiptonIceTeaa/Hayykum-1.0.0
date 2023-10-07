<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="description" content="">
    <meta name="page_type" content="np-template-header-footer-from-plugin">
    <title>MOH Update</title>
    <link rel="stylesheet" href="../css/nicePage.css" media="screen">
   <link rel="stylesheet" href="../css/MOHUpdate.css" media="screen">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
   <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
   <script src="../js/MOHUpdateJS.js"></script>
   <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="sweetalert2.all.min.js"></script>
    
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
    
    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": ""
}</script>


    <meta name="theme-color" content="#478ac9">
    <meta property="og:title" content="MOH Update">
    <meta property="og:type" content="website">
  </head>
<body class="u-body u-xl-mode"><header class="u-clearfix u-header u-palette-1-dark-1 u-header" id="sec-0eff"><img class="u-image u-image-default u-preserve-proportions u-image-1" src="../images/icon.Png.png" alt="" data-image-width="1200" data-image-height="1200"><nav class="u-dropdown-icon u-menu u-menu-dropdown u-offcanvas u-menu-1">
        
         <%
         response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
        if(session.getAttribute("MOHEmployeeEmail") == null){
        	
        	response.sendRedirect("MOHLogin.jsp");
        }
        
        %>
        
         <script type="text/javascript">

var Msg ='<%=session.getAttribute("getAlertMOHUpdateUserDoesntExist")%>';
var Msg2 ='<%=session.getAttribute("getAlertMOHUpdateUserUpdated")%>';
				

				function alertName() {
					//	alert("method fired");
					if (Msg != "null") {
						//alert("User doesnt exist.\nYou will be directed to create a user.");
						Swal.fire({
						  title: 'User doesnt exist!',
						  icon: 'error',
						  html:
							    'You will be redirected to <b>create user page</b>, '
							    + ' to create a new user.',
						  showDenyButton: true,
						  confirmButtonText: 'Go',
						  denyButtonText: 'Stay here',
						}).then((result) => {
						  /* Read more about isConfirmed, isDenied below */
						  if (result.isConfirmed) {
							  window.location.href = "MOHCreate.jsp";
							  <%session.removeAttribute("getAlertMOHUpdateUserDoesntExist");%>
						  } else if (result.isDenied) {
							 
							  <%session.removeAttribute("getAlertMOHUpdateUserDoesntExist");%>
						  }
						});
					

						
						  <%session.removeAttribute("getAlertMOHUpdateUserDoesntExist");%>
				}

					if (Msg2 != "null") {
						Swal.fire({
							  title: 'User updated !',
							  icon: 'success',
							  html:
								    'Continue updating ? ',
							  showDenyButton: true,
							  confirmButtonText: 'Yes',
							  denyButtonText: 'No',
							}).then((result) => {
							  /* Read more about isConfirmed, isDenied below */
							  if (result.isConfirmed) {
								
								  <%session.removeAttribute("getAlertMOHUpdateUserUpdated");%>
								  
							  } else if (result.isDenied) {
								  window.location.href = "MOHPage.jsp";
								  <%session.removeAttribute("getAlertMOHUpdateUserUpdated");%>
							  }
							});
						 <%session.removeAttribute("getAlertMOHUpdateUserUpdated");%>
			
				}
					  <%session.removeAttribute("getAlertMOHUpdateUserDoesntExist");%>
					  <%session.removeAttribute("getAlertMOHUpdateUserUpdated");%>
				}
				
				
					
				
			</script>

			<script type="text/javascript">
				window.onload = alertName;
			</script>
        
        <div class="menu-collapse" style="font-size: 1rem; letter-spacing: 0px; font-weight: 700;">
          <a class="u-button-style u-custom-border u-custom-border-color u-custom-borders u-custom-left-right-menu-spacing u-custom-padding-bottom u-custom-text-active-color u-custom-text-color u-custom-text-hover-color u-custom-top-bottom-menu-spacing u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="#" style="padding: 4px 6px; font-size: calc(1em + 8px);">
            <svg class="u-svg-link" viewBox="0 0 24 24"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#menu-hamburger"></use></svg>
            <svg class="u-svg-content" version="1.1" id="menu-hamburger" viewBox="0 0 16 16" x="0px" y="0px" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns="http://www.w3.org/2000/svg"><g><rect y="1" width="16" height="2"></rect><rect y="7" width="16" height="2"></rect><rect y="13" width="16" height="2"></rect>
</g></svg>
          </a>
        </div>
        <div class="u-custom-menu u-nav-container">
          
        </div>
        <div class="u-custom-menu u-nav-container-collapse">
          <div class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
            <div class="u-inner-container-layout u-sidenav-overflow">
              <div class="u-menu-close"></div>
              
            </div>
          </div>
          <div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
        </div>
      </nav></header>
    <section class="u-align-center u-clearfix u-typography-Normal--Introduction u-section-1" src="" id="carousel_8b49">
      <div class="u-clearfix u-sheet u-sheet-1">
        <img class="u-image u-image-default u-preserve-proportions u-image-1" src="../images/MOHlogo1-12.jpg" alt="" data-image-width="232" data-image-height="217">
        <div class="u-form u-form-1">
          <form action="../MOHUpdateRecord" method="POST" class="u-clearfix u-form-spacing-15 u-form-vertical u-inner-form" style="padding: 15px" source="email">
            <div class="u-form-group u-label-top u-form-group-1">
              <label for="passportInput" class="u-label">Passport No.</label>
              <input type="text" id="passportInput"  name="passportNO" class="u-border-1 u-border-grey-30 u-input u-input-rectangle" required="required">
            </div>
            <div class="u-form-group u-form-select u-label-top u-form-group-2">
              <label for="dropDoenMenu" class="u-label">Update Item</label>
              <div class="u-form-select-wrapper">
                <select id="dropDoenMenu" name="changeType" class="u-border-1 u-border-grey-30 u-input u-input-rectangle">
                  <option value="fname">Name</option>
                  <option value="nationality">Nationality</option>
                  <option value="doseNumber">Dose</option>
                </select>
                <svg xmlns="http://www.w3.org/2000/svg" width="14" height="12" version="1" class="u-caret"><path fill="currentColor" d="M4 8L0 4h8z"></path></svg>
              </div>
            </div>
            <div class="u-form-group u-label-top u-form-group-3">
              <label for="oldValField" class="u-label">Previously Value:</label>
              <input type="text" disabled placeholder="*Applicable for dose number only" id="oldValField" name="previousValue" class="u-border-1 u-border-grey-30 u-input u-input-rectangle" required="required">
            </div>	
            <div class="u-form-group u-label-top u-form-group-4">
              <label for="text-ef66" class="u-label">New Value:</label>
              <input type="text" placeholder="" id="text-ef66" name="newValue" class="u-border-1 u-border-grey-30 u-input u-input-rectangle" required="required">
            </div>
            <div class="u-align-left u-form-group u-form-submit">
              <input type="submit" value="Update Record" class="u-btn u-btn-submit u-button-style">
            </div>
          </form>
        </div>
        <div class="u-list u-list-1">
          <div class="u-repeater u-repeater-1"></div>
        </div>
        <span class="u-file-icon u-icon u-rotate-180 u-text-grey-50 u-icon-1" data-page-id="99841084">
        <a href="MOHPage.jsp">
        <img src="../images/11.png" alt="">
        </a>
      </div>
    </section>
    <footer class="u-align-center u-clearfix u-footer u-palette-1-light-1 u-footer" id="sec-bd66"><div class="u-clearfix u-sheet u-valign-middle u-sheet-1">
        <p class="u-small-text u-text u-text-variant u-text-1">Developed by the Hayyakum Co. Team Members.<br>For Contact: +966567471314 Email:hsalamah@alfaisal.edu
        </p>
      </div>
    <section class="u-backlink u-clearfix u-grey-80">
      <a class="u-link" href="https://nicepage.com/templates" target="_blank">
        <span>Template</span>
      </a>
      <p class="u-text">
        <span>created with</span>
      </p>
      <a class="u-link" href="" target="_blank">
        <span>Website Builder Software</span>
      </a>. 
    </section>
    </footer>
  </body>
</html>