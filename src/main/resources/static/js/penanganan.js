$(document).ready(function() {
	 $('#datatable').DataTable();
	$("#inputLab").hide();
	  $("#inputObat").hide();
  $("#input_jenis_penanganan").change(function() {
    // jQuery
    var selectedVal = $(this)
      .find(":selected")
      .val();
    if (selectedVal === "obat") {
      $("#inputObat").show();
      $("#inputLab").hide();
    } else {
      $("#inputObat").hide();
      $("#inputLab").show();
    }
  });
});
