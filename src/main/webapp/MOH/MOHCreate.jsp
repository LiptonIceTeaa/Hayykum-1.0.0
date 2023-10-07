<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="description" content="">
    <meta name="page_type" content="np-template-header-footer-from-plugin">
    <title>MOH Create</title>
    <link rel="stylesheet" href="../css/nicePage.css" media="screen">
    <link rel="stylesheet" href="../css/MOHCreate.css" media="screen">
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="sweetalert2.all.min.js"></script>
    <meta name="generator" content="Nicepage 4.8.2, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
   <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
  
	<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
   <script src="../js/MOHCreateJS.js"></script>
    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": ""
}</script>
    <meta name="theme-color" content="#478ac9">
    <meta property="og:title" content="MOH Create">
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

var Msg ='<%=session.getAttribute("getAlertMOHCreateUserExists")%>';
var Msg2 ='<%=session.getAttribute("getAlertMOHCreateUserAdded")%>';


				

				function alertName() {
					if (Msg != "null") {
						//alert("User doesnt exist.\nYou will be directed to create a user.");
						Swal.fire({
						  title: 'User already exists!',
						  icon: 'error',
						  html:
							    'You will be redirected to <b>add dose page</b>, ' +
							    'with the entered passport number ',
						  showDenyButton: true,
						  confirmButtonText: 'Go',
						  denyButtonText: 'Stay here',
						}).then((result) => {
						  /* Read more about isConfirmed, isDenied below */
						  if (result.isConfirmed) {
							  <%session.removeAttribute("getAlertMOHCreateUserExists");%>
							  window.location.replace("MOHAddDose.jsp");
							 
							 /*  window.location.href = "MOHAddDose.jsp";	 */
						  } else if (result.isDenied) {
							  window.location.replace = "MOHCreate.jsp";
							  <%session.removeAttribute("getAlertMOHCreateUserExists");%>
						  }
						});
					

						
						  <%session.removeAttribute("getAlertMOHCreateUserExists");%>
				}

					if (Msg2 != "null") {
						Swal.fire({
							  title: 'User added!',
							  icon: 'success',
							  html:
								    'Add another user ? ',
							  showDenyButton: true,
							  confirmButtonText: 'Yes',
							  denyButtonText: 'No',
							}).then((result) => {
							  /* Read more about isConfirmed, isDenied below */
							  if (result.isConfirmed) {
								  window.location.href = "MOHCreate.jsp";
								  <%session.removeAttribute("getAlertMOHCreateUserAdded");%>
								  
							  } else if (result.isDenied) {
								  window.location.href = "MOHPage.jsp";
								  <%session.removeAttribute("getAlertMOHCreateUserAdded");%>
							  }
							});
						 <%session.removeAttribute("getAlertMOHCreateUserAdded");%>
			
				}
					  <%session.removeAttribute("getAlertMOHCreateUserAdded");%>
					  <%session.removeAttribute("getAlertMOHCreateUserExists");%>
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
    <section class="u-align-center u-clearfix u-typography-Normal--Introduction u-section-1" id="carousel_8b49">
      <div class="u-clearfix u-sheet u-sheet-1">
        <img class="u-image u-image-default u-preserve-proportions u-image-1" src="../images/MOHlogo1-12.jpg" alt="" data-image-width="232" data-image-height="217">
        <div class="u-form u-form-1">
          <form action="../MOHCreate" method="POST" class="u-clearfix u-form-spacing-15 u-form-vertical u-inner-form" style="padding: 15px">
            <div class="u-form-group u-form-name u-label-top">
              <label for="name-558c" class="u-label">First Name</label>
              <input type="text" placeholder="First name ..." id="name-558c" name="fname" class="u-border-1 u-border-grey-30 u-input u-input-rectangle" required>
            </div>
            <div class="u-form-group u-label-top u-form-group-2">
              <label for="text-a9b4" class="u-label">Last Name</label>
              <input type="text" placeholder="Last name ..." id="text-a9b4" name="lname" class="u-border-1 u-border-grey-30 u-input u-input-rectangle">
            </div>
            <div class="u-form-group u-label-top u-form-group-3">
              <label for="text-67b9" class="u-label">Passport No.</label>
              <input type="text" placeholder="Passport number ..." id="text-67b9" name="passportNO" class="u-border-1 u-border-grey-30 u-input u-input-rectangle" required="required">
            </div>
             <div class="u-form-group u-label-top u-form-group-9">
              <label for="text-d9d3" class="u-label">Nationality</label>
              <select id="text-d9d3" name="nationality" class="u-border-1 u-border-grey-30 u-input u-input-rectangle" required="required">
              		 <option value="" disabled selected>Select your option</option>
              		<option value="Afganistan">Afghanistan</option>
   <option value="Albania">Albania</option>
   <option value="Algeria">Algeria</option>
   <option value="American Samoa">American Samoa</option>
   <option value="Andorra">Andorra</option>
   <option value="Angola">Angola</option>
   <option value="Anguilla">Anguilla</option>
   <option value="Antigua & Barbuda">Antigud and Barbuda</option>
   <option value="Argentina">Argentina</option>
   <option value="Armenia">Armenia</option>
   <option value="Aruba">Aruba</option>
   <option value="Australia">Australia</option>
   <option value="Austria">Austria</option>
   <option value="Azerbaijan">Azerbaijan</option>
   <option value="Bahamas">Bahamas</option>
   <option value="Bahrain">Bahrain</option>
   <option value="Bangladesh">Bangladesh</option>
   <option value="Barbados">Barbados</option>
   <option value="Belarus">Belarus</option>
   <option value="Belgium">Belgium</option>
   <option value="Belize">Belize</option>
   <option value="Benin">Benin</option>
   <option value="Bermuda">Bermuda</option>
   <option value="Bhutan">Bhutan</option>
   <option value="Bolivia">Bolivia</option>
   <option value="Bonaire">Bonaire</option>
   <option value="Bosnia & Herzegovina">Bosnia and Herzegovina</option>
   <option value="Botswana">Botswana</option>
   <option value="Brazil">Brazil</option>
   <option value="British Indian Ocean Ter">British Indian Ocean Ter</option>
   <option value="Brunei">Brunei</option>
   <option value="Bulgaria">Bulgaria</option>
   <option value="Burkina Faso">Burkina Faso</option>
   <option value="Burundi">Burundi</option>
   <option value="Cambodia">Cambodia</option>
   <option value="Cameroon">Cameroon</option>
   <option value="Canada">Canada</option>
   <option value="Canary Islands">Canary Islands</option>
   <option value="Cape Verde">Cape Verde</option>
   <option value="Cayman Islands">Cayman Islands</option>
   <option value="Central African Republic">Central African Republic</option>
   <option value="Chad">Chad</option>
   <option value="Channel Islands">Channel Islands</option>
   <option value="Chile">Chile</option>
   <option value="China">China</option>
   <option value="Christmas Island">Christmas Island</option>
   <option value="Cocos Island">Cocos Island</option>
   <option value="Colombia">Colombia</option>
   <option value="Comoros">Comoros</option>
   <option value="Congo">Congo</option>
   <option value="Cook Islands">Cook Islands</option>
   <option value="Costa Rica">Costa Rica</option>
   <option value="Cote DIvoire">Cote DIvoire</option>
   <option value="Croatia">Croatia</option>
   <option value="Cuba">Cuba</option>
   <option value="Curaco">Curacao</option>
   <option value="Cyprus">Cyprus</option>
   <option value="Czech Republic">Czech Republic</option>
   <option value="Denmark">Denmark</option>
   <option value="Djibouti">Djibouti</option>
   <option value="Dominica">Dominica</option>
   <option value="Dominican Republic">Dominican Republic</option>
   <option value="East Timor">East Timor</option>
   <option value="Ecuador">Ecuador</option>
   <option value="Egypt">Egypt</option>
   <option value="El Salvador">El Salvador</option>
   <option value="Equatorial Guinea">Equatorial Guinea</option>
   <option value="Eritrea">Eritrea</option>
   <option value="Estonia">Estonia</option>
   <option value="Ethiopia">Ethiopia</option>
   <option value="Falkland Islands">Falkland Islands</option>
   <option value="Faroe Islands">Faroe Islands</option>
   <option value="Fiji">Fiji</option>
   <option value="Finland">Finland</option>
   <option value="France">France</option>
   <option value="French Guiana">French Guiana</option>
   <option value="French Polynesia">French Polynesia</option>
   <option value="French Southern Ter">French Southern Ter</option>
   <option value="Gabon">Gabon</option>
   <option value="Gambia">Gambia</option>
   <option value="Georgia">Georgia</option>
   <option value="Germany">Germany</option>
   <option value="Ghana">Ghana</option>
   <option value="Gibraltar">Gibraltar</option>
   <option value="Great Britain">Great Britain</option>
   <option value="Greece">Greece</option>
   <option value="Greenland">Greenland</option>
   <option value="Grenada">Grenada</option>
   <option value="Guadeloupe">Guadeloupe</option>
   <option value="Guam">Guam</option>
   <option value="Guatemala">Guatemala</option>
   <option value="Guinea">Guinea</option>
   <option value="Guyana">Guyana</option>
   <option value="Haiti">Haiti</option>
   <option value="Hawaii">Hawaii</option>
   <option value="Honduras">Honduras</option>
   <option value="Hong Kong">Hong Kong</option>
   <option value="Hungary">Hungary</option>
   <option value="Iceland">Iceland</option>
   <option value="Indonesia">Indonesia</option>
   <option value="India">India</option>
   <option value="Iran">Iran</option>
   <option value="Iraq">Iraq</option>
   <option value="Ireland">Ireland</option>
   <option value="Isle of Man">Isle of Man</option>
   <option value="Israel">Israel</option>
   <option value="Italy">Italy</option>
   <option value="Jamaica">Jamaica</option>
   <option value="Japan">Japan</option>
   <option value="Jordan">Jordan</option>
   <option value="Kazakhstan">Kazakhstan</option>
   <option value="Kenya">Kenya</option>
   <option value="Kiribati">Kiribati</option>
   <option value="Korea North">Korea North</option>
   <option value="Korea Sout">Korea South</option>
   <option value="Kuwait">Kuwait</option>
   <option value="Kyrgyzstan">Kyrgyzstan</option>
   <option value="Laos">Laos</option>
   <option value="Latvia">Latvia</option>
   <option value="Lebanon">Lebanon</option>
   <option value="Lesotho">Lesotho</option>
   <option value="Liberia">Liberia</option>
   <option value="Libya">Libya</option>
   <option value="Liechtenstein">Liechtenstein</option>
   <option value="Lithuania">Lithuania</option>
   <option value="Luxembourg">Luxembourg</option>
   <option value="Macau">Macau</option>
   <option value="Macedonia">Macedonia</option>
   <option value="Madagascar">Madagascar</option>
   <option value="Malaysia">Malaysia</option>
   <option value="Malawi">Malawi</option>
   <option value="Maldives">Maldives</option>
   <option value="Mali">Mali</option>
   <option value="Malta">Malta</option>
   <option value="Marshall Islands">Marshall Islands</option>
   <option value="Martinique">Martinique</option>
   <option value="Mauritania">Mauritania</option>
   <option value="Mauritius">Mauritius</option>
   <option value="Mayotte">Mayotte</option>
   <option value="Mexico">Mexico</option>
   <option value="Midway Islands">Midway Islands</option>
   <option value="Moldova">Moldova</option>
   <option value="Monaco">Monaco</option>
   <option value="Mongolia">Mongolia</option>
   <option value="Montserrat">Montserrat</option>
   <option value="Morocco">Morocco</option>
   <option value="Mozambique">Mozambique</option>
   <option value="Myanmar">Myanmar</option>
   <option value="Nambia">Nambia</option>
   <option value="Nauru">Nauru</option>
   <option value="Nepal">Nepal</option>
   <option value="Netherland Antilles">Netherland Antilles</option>
   <option value="Netherlands">Netherlands (Holland, Europe)</option>
   <option value="Nevis">Nevis</option>
   <option value="New Caledonia">New Caledonia</option>
   <option value="New Zealand">New Zealand</option>
   <option value="Nicaragua">Nicaragua</option>
   <option value="Niger">Niger</option>
   <option value="Nigeria">Nigeria</option>
   <option value="Niue">Niue</option>
   <option value="Norfolk Island">Norfolk Island</option>
   <option value="Norway">Norway</option>
   <option value="Oman">Oman</option>
   <option value="Pakistan">Pakistan</option>
   <option value="Palau Island">Palau Island</option>
   <option value="Palestine">Palestine</option>
   <option value="Panama">Panama</option>
   <option value="Papua New Guinea">Papua New Guinea</option>
   <option value="Paraguay">Paraguay</option>
   <option value="Peru">Peru</option>
   <option value="Phillipines">Philippines</option>
   <option value="Pitcairn Island">Pitcairn Island</option>
   <option value="Poland">Poland</option>
   <option value="Portugal">Portugal</option>
   <option value="Puerto Rico">Puerto Rico</option>
   <option value="Qatar">Qatar</option>
   <option value="Republic of Montenegro">Republic of Montenegro</option>
   <option value="Republic of Serbia">Republic of Serbia</option>
   <option value="Reunion">Reunion</option>
   <option value="Romania">Romania</option>
   <option value="Russia">Russia</option>
   <option value="Rwanda">Rwanda</option>
   <option value="St Barthelemy">St Barthelemy</option>
   <option value="St Eustatius">St Eustatius</option>
   <option value="St Helena">St Helena</option>
   <option value="St Kitts-Nevis">St Kitts-Nevis</option>
   <option value="St Lucia">St Lucia</option>
   <option value="St Maarten">St Maarten</option>
   <option value="St Pierre & Miquelon">St Pierre and Miquelon</option>
   <option value="St Vincent & Grenadines">St Vincent and Grenadines</option>
   <option value="Saipan">Saipan</option>
   <option value="Samoa">Samoa</option>
   <option value="Samoa American">Samoa American</option>
   <option value="San Marino">San Marino</option>
   <option value="Sao Tome & Principe">Sao Tome and Principe</option>
   <option value="Saudi Arabia">Saudi Arabia</option>
   <option value="Senegal">Senegal</option>
   <option value="Seychelles">Seychelles</option>
   <option value="Sierra Leone">Sierra Leone</option>
   <option value="Singapore">Singapore</option>
   <option value="Slovakia">Slovakia</option>
   <option value="Slovenia">Slovenia</option>
   <option value="Solomon Islands">Solomon Islands</option>
   <option value="Somalia">Somalia</option>
   <option value="South Africa">South Africa</option>
   <option value="Spain">Spain</option>
   <option value="Sri Lanka">Sri Lanka</option>
   <option value="Sudan">Sudan</option>
   <option value="Suriname">Suriname</option>
   <option value="Swaziland">Swaziland</option>
   <option value="Sweden">Sweden</option>
   <option value="Switzerland">Switzerland</option>
   <option value="Syria">Syria</option>
   <option value="Tahiti">Tahiti</option>
   <option value="Taiwan">Taiwan</option>
   <option value="Tajikistan">Tajikistan</option>
   <option value="Tanzania">Tanzania</option>
   <option value="Thailand">Thailand</option>
   <option value="Togo">Togo</option>
   <option value="Tokelau">Tokelau</option>
   <option value="Tonga">Tonga</option>
   <option value="Trinidad & Tobago">Trinidad and Tobago</option>
   <option value="Tunisia">Tunisia</option>
   <option value="Turkey">Turkey</option>
   <option value="Turkmenistan">Turkmenistan</option>
   <option value="Turks & Caicos Is">Turks and Caicos Is</option>
   <option value="Tuvalu">Tuvalu</option>
   <option value="Uganda">Uganda</option>
   <option value="United Kingdom">United Kingdom</option>
   <option value="Ukraine">Ukraine</option>
   <option value="United Arab Erimates">United Arab Emirates</option>
   <option value="United States of America">United States of America</option>
   <option value="Uraguay">Uruguay</option>
   <option value="Uzbekistan">Uzbekistan</option>
   <option value="Vanuatu">Vanuatu</option>
   <option value="Vatican City State">Vatican City State</option>
   <option value="Venezuela">Venezuela</option>
   <option value="Vietnam">Vietnam</option>
   <option value="Virgin Islands (Brit)">Virgin Islands (Brit)</option>
   <option value="Virgin Islands (USA)">Virgin Islands (USA)</option>
   <option value="Wake Island">Wake Island</option>
   <option value="Wallis & Futana Is">Wallis and Futana Is</option>
   <option value="Yemen">Yemen</option>
   <option value="Zaire">Zaire</option>
   <option value="Zambia">Zambia</option>
   <option value="Zimbabwe">Zimbabwe</option>
              
              </select>
            </div>    
            <div class="u-form-group u-form-select u-label-top u-form-group-5">
              <label for="select-f6b1" class="u-label">Gender</label>
              <div class="u-form-select-wrapper">
                <select id="select-f6b1" name="gender" class="u-border-1 u-border-grey-30 u-input u-input-rectangle">
                  <option value="Male">Male</option>
                  <option value="Female">Female</option>
                </select>
                <svg xmlns="http://www.w3.org/2000/svg" width="14" height="12" version="1" class="u-caret"><path fill="currentColor" d="M4 8L0 4h8z"></path></svg>
              </div>
            </div>
            <div class="u-form-group u-label-top u-form-group-6">
              <label for="birthDatePicker" class="u-label">BirthDate</label>
              <input type="date" placeholder="" id="birthDatePicker" name="birthDate" class="u-border-1 u-border-grey-30 u-input u-input-rectangle">
            </div>
            <div class="u-form-group u-label-top u-form-group-7">
              <label for="text-a0d9" class="u-label">Dose Type</label>
              <select id="text-a0d9" name="doseType" class="u-border-1 u-border-grey-30 u-input u-input-rectangle" required="required">
				   <option value="" disabled selected>Select your option</option>
				  <option value="Oxford Astrazeneca">Oxford Astrazenica</option>
                  <option value="Pfizer">Pfizer</option>
                  <option value="Moderna">Moderna</option>           
            </select>
            </div>
            <div class="u-form-group u-label-top u-form-group-8">
              <label for="doseDatePicker" class="u-label" onchange="handler(event);">Dose Date</label>
              <input type="date" placeholder="" id="doseDatePicker" name="doseDate" class="u-border-1 u-border-grey-30 u-input u-input-rectangle">
            </div>
            <div class="u-form-group u-form-select u-label-top u-form-group-4">
              <label for="select-1674" class="u-label">Dose location</label>
              <div class="u-form-select-wrapper">
                <select id="select-1674" name="doseLocation" class="u-border-1 u-border-grey-30 u-input u-input-rectangle" required="required">
                   <option value="" disabled selected>Select your option</option>
                  <option value="Saudi Arabia">Saudi Arabia</option>
                  <option value="Kuwait">Kuwait</option>
                  <option value="Bahrain">Bahrain</option>
                  <option value="Oman">Oman</option>
                  <option value="Qatar">Qatar</option>
                  <option value="United Arab Emirates">United Arab Emirates</option>
                </select>
                <svg xmlns="http://www.w3.org/2000/svg" width="14" height="12" version="1" class="u-caret"><path fill="currentColor" d="M4 8L0 4h8z"></path></svg>
              </div>
            </div>
            <div class="u-form-group u-label-top u-form-group-10">
              <label for="doseExpiryPicker" class="u-label">Dose Expiry Date</label>
              <input type="date" placeholder="" id="doseExpiryPicker" name="doseExpiry" class="u-border-1 u-border-grey-30 u-input u-input-rectangle">
            </div>
            <div class="u-form-group u-label-top u-form-group-11">
              <label for="text-4caa" class="u-label">Dose Number</label>
              <input type="number" value="1" placeholder="Dose number" id="text-4caa" name="doseNumber" class="u-border-1 u-border-grey-30 u-input u-input-rectangle">
            </div>
            
            <div class="u-form-group u-form-submit">
              <input type="submit" value="Register" class="u-border-none u-btn u-btn-submit u-button-style u-custom-color-2 u-btn-1">
            </div>
            
          </form>
        </div>
        <div class="u-rotation-parent u-rotation-parent-1">
        <span class="u-file-icon u-icon u-rotate-180 u-text-grey-50 u-icon-1" data-page-id="99841084">
        <a href="MOHPage.jsp">
        <img src="../images/11.png" alt="">
        </a>
        </span>
        </div>
        <div class="u-list u-list-1">
          <div class="u-repeater u-repeater-1"></div>
        </div>
      </div>
    </section>
    
    
    <footer class="u-align-center u-clearfix u-footer u-palette-1-light-1 u-footer" id="sec-bd66"><div class="u-clearfix u-sheet u-valign-middle u-sheet-1">
        <p class="u-small-text u-text u-text-variant u-text-1">Developed by the Hayyakum Co. Team Members.<br>For Contact: +966567471314 Email:hsalamah@alfaisal.edu
        </p>
      </div></footer>
   
  </body>
</html>