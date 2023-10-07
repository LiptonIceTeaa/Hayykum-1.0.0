$(document).ready(function() {




	// ajax to get full name
	$.ajax({
		method: "GET",
		url: "../clientPage",
		data: {},
	}).success(function(data) {



		var array = data.split(',');
		var fname = array[0];
		var lname = array[1];
		var gender = array[2];
		var nationality = array[3];
		var birthDate = array[4];
		var dosesNO = array[5];

		//alert(fname + " " + lname + " " + gender + " " + nationality + " " + birthDate + " " + dosesNO);

		$('#fullName').html(fname + " " + lname);
		$('#nationality').html(nationality);
		$('#gender').html(gender);
		$('#birthDate').html(birthDate);
		$('#dosesNO').html(dosesNO);
	})
		.error(function() {
			//do error handling stuff
		});

	/************************************************************************* */
	$("#changePasswordBttn").click(function(e) {
		var oldPassword = $('#oldPassword').val();
		var newPassword = $('#newPassword').val();

		if (oldPassword === "" || oldPassword === "") {
			alert("Password fields cant be empty");
		} else {
			// ajax to get full name
			$.ajax({
				method: "GET",
				url: "../changeUserPassword",
				data: { oldPassword: oldPassword, newPassword: newPassword },
			}).success(function(data) {

				if (data === "sucess") {

					Swal.fire({
						title: 'Password Updated',
						icon: 'info',
						confirmButtonText: 'Ok',
					}).then((result) => {
						window.location.replace("userProfile.jsp");
						
					});


				}else{
					Swal.fire({
						title: 'Invalid old password',
						icon: 'info',
						confirmButtonText: 'Ok',
					}).then((result) => {
						/* Read more about isConfirmed, isDenied below */
						
					});
					
				}


			})
				.error(function() {
					//do error handling stuff
				});




		}



	});












});