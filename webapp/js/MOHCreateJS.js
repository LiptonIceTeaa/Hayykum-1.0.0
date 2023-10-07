$(document).ready(function() {



	
	// setting min range in dose date
	doseDatePicker.min = new Date().toISOString().split("T")[0];
	// setting min range in dose expiry, it dpednds on dose day
	$(function() {
		$('#doseDatePicker').change(function() {
			var fromDateValue = $(this).val();
			doseExpiryPicker.min = fromDateValue;
		});
	})

	

});