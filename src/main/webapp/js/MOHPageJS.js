$(document).ready(function() {


	$("#dropDownViewProfile").click(function(e) {
		//alert("asdsa");
		Swal.fire({
			title: 'Confirm account',
			html:
				'<br><input type="password" id="swal-input2" placeholder="Password ..." class="form-control">',
			showCancelButton: true,
			confirmButtonText: 'Confirm',
			showLoaderOnConfirm: true,
			preConfirm: (login) => {
				return fetch(`//api.github.com/users/${login}`)
					.then(response => {
						if (!response.ok) {
							throw new Error(response.statusText)
						}
						return response.json()
					})
					.catch(error => {
						Swal.showValidationMessage(
							`Request failed: ${error}`
						)
					})
			},
			allowOutsideClick: () => !Swal.isLoading()
		}).then((result) => {
			if (result.isConfirmed) {
				
				var email = $('#emailHolder').text();
				var password = $('#swal-input2').val();
				var ministry = "Ministry Of Health";

				$.ajax({
					type: "GET",
					url: "../MOHLogin",
					data: { passportNO: password },
					success: function(rooms) {
						if(rooms === "valid"){
						Swal.fire({
							icon: 'info',
							title: `Employee profile`,
							html: '<b>Username:</b> ' + email
								+ '<br><b>Password:</b>' + password
								+ '<br><b>Ministry:</b>' + ministry
						});
						}else{
							Swal.fire({
							icon: 'error',
							title: `Invalid password !`	
							
						});
						}
					}
				});

			}
		})


	});

});