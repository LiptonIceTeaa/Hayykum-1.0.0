<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<meta name="description" content="">
<meta name="page_type" content="np-template-header-footer-from-plugin">
<title>MOH Add Dose</title>
<link rel="stylesheet" href="../css/nicePage.css" media="screen">
<link rel="stylesheet" href="../css/MOHAddDose.css" media="screen">
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="sweetalert2.all.min.js"></script>
<meta name="generator" content="Nicepage 4.8.2, nicepage.com">
<link id="u-theme-google-font" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">


<script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": ""
}</script>
<meta name="theme-color" content="#478ac9">
<meta property="og:title" content="MOH Add Dose">
<meta property="og:type" content="website">
</head>
<body class="u-body u-xl-mode">

<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

			if (session.getAttribute("MOHEmployeeEmail") == null) {

				response.sendRedirect("MOHLogin.jsp");
			}
			%>
			<script type="text/javascript">

var Msg ='<%=session.getAttribute("getAlertMOHAddDose")%>';
var Msg2 ='<%=session.getAttribute("getAlertMOHAddDoseSucess")%>';
var Msg3 ='<%=session.getAttribute("getAlertMOHAddDoseAlreadyExists")%>';

var clientPassportNO = '<%=session.getAttribute("clientPassportNOAutoFill")%>';

				

				function alertName() {
					
					
					document.getElementById('text-67b9').value="";
					
					 if(clientPassportNO != "null"){ 	
						// alert(clientPassportNO);
						 
						document.getElementById('text-67b9').value=clientPassportNO	;
						<%session.removeAttribute("clientPassportNOAutoFill");%>	
						//	alert("after removal: "+clientPassportNO);
					}  
					 <%session.removeAttribute("clientPassportNOAutoFill");%>
					
					if (Msg != "null") {
						//alert("User doesnt exist.\nYou will be directed to create a user.");
						Swal.fire({
						  title: 'Passport does not exist!',
						  icon: 'error',
						  html:
							    'You will be redirected to <b>create user</b>, ' +
							    'with the entered passport number ',
						  showDenyButton: true,
						  confirmButtonText: 'Go',
						  denyButtonText: 'Stay here',
						}).then((result) => {
						  /* Read more about isConfirmed, isDenied below */
						  if (result.isConfirmed) {
							  window.location.href = "MOHCreate.jsp";
							  <%session.removeAttribute("getAlertMOHAddDose");%>
						  } else if (result.isDenied) {
							  window.location.href = "MOHAddDose.jsp";
							  <%session.removeAttribute("getAlertMOHAddDose");%>
						  }
						});
					

						
						  <%session.removeAttribute("getAlertMOHAddDose");%>
				}

					if (Msg2 != "null") {
						Swal.fire({
							  title: 'Dose added!',
							  icon: 'success',
							  html:
								    'Add another dose ? ',
							  showDenyButton: true,
							  confirmButtonText: 'Yes',
							  denyButtonText: 'No',
							}).then((result) => {
							  /* Read more about isConfirmed, isDenied below */
							  if (result.isConfirmed) {
								  window.location.href = "MOHAddDose.jsp";
								  <%session.removeAttribute("getAlertMOHAddDoseSucess");%>
								  <%session.removeAttribute("getAlertMOHAddDose");%>
							  } else if (result.isDenied) {
								  window.location.href = "MOHPage.jsp";
								  <%session.removeAttribute("getAlertMOHAddDoseSucess");%>
							  }
							});
						 <%session.removeAttribute("getAlertMOHAddDoseSucess");%>
			
				}
					<%session.removeAttribute("clientPassportNOAutoFill");%>	
					<%session.removeAttribute("getAlertMOHAddDoseSucess");%>
					  <%session.removeAttribute("getAlertMOHAddDose");%>
					  
					  
					  if (Msg3 != "null") {
							Swal.fire({
							  title: 'Invalid Dose Nmber !',
							  icon: 'error',
							  html:
								    'Dose number is a duplicate or cant be less/greter >1 than latest dose.',
							  confirmButtonText: 'Ok',
							}).then((result) => {
							  /* Read more about isConfirmed, isDenied below */
							  if (result.isConfirmed) {
								  <%session.removeAttribute("getAlertMOHAddDoseAlreadyExists");%>
							  }
							});
						

							<%session.removeAttribute("clientPassportNOAutoFills");%>
							  <%session.removeAttribute("getAlertMOHAddDoseAlreadyExists");%>
							  <%session.removeAttribute("clientPassportNOAutoFill");%>
					}
				}
				
			</script>

			<script type="text/javascript">
				window.onload = alertName;
			</script>
	<header class="u-clearfix u-header u-palette-1-dark-1 u-header"
		id="sec-0eff">
		<img class="u-image u-image-default u-preserve-proportions u-image-1"
			src="../images/icon.Png.png" alt="" data-image-width="1200"
			data-image-height="1200">
		<nav
			class="u-dropdown-icon u-menu u-menu-dropdown u-offcanvas u-menu-1">

			


			<div class="menu-collapse"
				style="font-size: 1rem; letter-spacing: 0px; font-weight: 700;">
				<a
					class="u-button-style u-custom-border u-custom-border-color u-custom-borders u-custom-left-right-menu-spacing u-custom-padding-bottom u-custom-text-active-color u-custom-text-color u-custom-text-hover-color u-custom-top-bottom-menu-spacing u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base"
					href="#" style="padding: 4px 6px; font-size: calc(1em + 8px);">
					<svg class="u-svg-link" viewBox="0 0 24 24">
						<use xmlns:xlink="http://www.w3.org/1999/xlink"
							xlink:href="#menu-hamburger"></use></svg> <svg class="u-svg-content"
						version="1.1" id="menu-hamburger" viewBox="0 0 16 16" x="0px"
						y="0px" xmlns:xlink="http://www.w3.org/1999/xlink"
						xmlns="http://www.w3.org/2000/svg">
						<g>
						<rect y="1" width="16" height="2"></rect>
						<rect y="7" width="16" height="2"></rect>
						<rect y="13" width="16" height="2"></rect>
</g></svg>
				</a>
			</div>
			<div class="u-custom-menu u-nav-container"></div>
			<div class="u-custom-menu u-nav-container-collapse">
				<div
					class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
					<div class="u-inner-container-layout u-sidenav-overflow"></div>
					<div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
				</div>
			</div>
		</nav>
	</header>
	<section
		class="u-align-center u-clearfix u-typography-Normal--Introduction u-section-1"
		src="" id="carousel_8b49">
		<div class="u-clearfix u-sheet u-sheet-1">
			<img class="u-image u-image-default u-preserve-proportions u-image-1"
				src="../images/MOHlogo1-12.jpg" alt="" data-image-width="232"
				data-image-height="217">
			<div class="u-form u-form-1">
				<form action="../MOHAddVaccine" method="POST"
					class="u-clearfix u-form-spacing-15 u-form-vertical u-inner-form"
					style="padding: 15px" source="email">
					<div class="u-form-group u-label-top u-form-group-1">
						<label for="text-67b9" class="u-label">Passport No.</label> <input
							type="text" id="text-67b9" name="passportNO"
							class="u-border-1 u-border-grey-30 u-input u-input-rectangle"
							required>
					</div>
					<div class="u-form-group u-label-top u-form-group-2">
						<label for="text-a0d9" class="u-label">Dose Type</label> <select
							placeholder="" id="text-a0d9" name="doseType"
							class="u-border-1 u-border-grey-30 u-input u-input-rectangle"
							required>
							<option value="" disabled selected>Select your option</option>
							<option value="Oxford Astrazeneca">Oxford Astrazenica</option>
							<option value="Pfizer">Pfizer</option>
							<option value="Moderna">Moderna</option>
						</select>
					</div>
					<div class="u-form-group u-label-top u-form-group-3">
						<label for="text-bb47" class="u-label">Dose Date</label> <input
							type="date" placeholder="" id="text-bb47" name="doseDate"
							class="u-border-1 u-border-grey-30 u-input u-input-rectangle"
							required>

					</div>
					<div class="u-form-group u-label-top u-form-group-4">
						<label for="text-d9d3" class="u-label">Dose Location</label> <select
							placeholder="" id="text-d9d3" name="doseLocation"
							class="u-border-1 u-border-grey-30 u-input u-input-rectangle"
							required>
							<option value="" disabled selected>Select your option</option>
							<option value="Saudi Arabia">Saudi Arabia</option>
							<option value="Kuwait">Kuwait</option>
							<option value="Bahrain">Bahrain</option>
							<option value="Oman">Oman</option>
							<option value="Qatar">Qatar</option>
							<option value="United Arab Emirates">United Arab
								Emirates</option>
						</select>
					</div>
					<div class="u-form-group u-label-top u-form-group-5">
						<label for="text-6940" class="u-label">Dose Expiry Date</label> <input
							type="date" placeholder="" id="text-6940" name="doseExpiry"
							class="u-border-1 u-border-grey-30 u-input u-input-rectangle"
							required>
					</div>
					<div class="u-form-group u-label-top u-form-group-6">
						<label for="text-8d3b" class="u-label">Dose Number</label> <input
							type="number" placeholder="" id="text-8d3b" name="doseNumber"
							class="u-border-1 u-border-grey-30 u-input u-input-rectangle"
							required>
					</div>
					<div class="u-form-group u-form-submit">
						<input type="submit" value="Add dose"
							class="u-border-none u-btn u-btn-submit u-button-style u-custom-color-2 u-btn-1">
					</div>
				</form>
			</div>
			<div></div>
			<div class="u-rotation-parent u-rotation-parent-1">
				<span
					class="u-file-icon u-icon u-rotate-180 u-text-grey-50 u-icon-1"
					data-page-id="99841084"> <a href="MOHPage.jsp"> <img
						src="../images/11.png" alt="">
				</a>
				</span>
			</div>
			<div class="u-list u-list-1">
				<div class="u-repeater u-repeater-1"></div>
			</div>
		</div>
	</section>


	<footer
		class="u-align-center u-clearfix u-footer u-palette-1-light-1 u-footer"
		id="sec-bd66">
		<div class="u-clearfix u-sheet u-valign-middle u-sheet-1">
			<p class="u-small-text u-text u-text-variant u-text-1">
				Developed by the Hayyakum Co. Team Members.<br>For Contact:
				+966567471314 Email:hsalamah@alfaisal.edu
			</p>
		</div>
	</footer>
	
</body>
</html>