$(document).ready(function() {
  $("#totalPasien").hide();
  $("#kapasitasPoli").hide();
  $("#rujukanByStatus").hide();
  $.get("/rawat-jalan/poli/pasien/total-pasien", function(data) {
    for (var key in data) {
      if (data.hasOwnProperty(key)) {
        console.log(key + " -> " + data[key]);
      }
    }
    var totalPasien = new Chart($("#totalPasien"), {
      type: "pie",
      data: {
        labels: ["Semua Pasien", "Pasien Rawat Jalan"],
        datasets: [
          {
            data: [data.total, data.inRawatJalan],
            backgroundColor: "rgba(255, 99, 132, 0.2)"
          }
        ]
      }
    });
    $("#totalPasienLoader").hide();
    $("#totalPasien").show();
  });
  $.get("/rawat-jalan/poli/jadwal/kapasitas-poli", function(data) {
    var dataArr = [];
    var label = [];
    for (var key in data) {
      if (data.hasOwnProperty(key)) {
        console.log(key + " -> " + data[key]);
        label.push(key);
        dataArr.push(data[key]);
      }
    }
    var kapasitasPoli = new Chart($("#kapasitasPoli"), {
      type: "pie",
      data: {
        labels: label,
        datasets: [
          {
            data: dataArr,
            backgroundColor: [
              "rgba(255, 99, 132, 0.2)",
              "rgba(54, 162, 235, 0.2)",
              "rgba(255, 206, 86, 0.2)",
              "rgba(75, 192, 192, 0.2)",
              "rgba(153, 102, 255, 0.2)",
              "rgba(255, 159, 64, 0.2)"
            ],
            borderColor: [
              "rgba(255,99,132,1)",
              "rgba(54, 162, 235, 1)",
              "rgba(255, 206, 86, 1)",
              "rgba(75, 192, 192, 1)",
              "rgba(153, 102, 255, 1)",
              "rgba(255, 159, 64, 1)"
            ],
            borderWidth: 1
          }
        ]
      }
    });
    $("#kapasitasPoliLoader").hide();
    $("#kapasitasPoli").show();
  });
  $.get("/rawat-jalan/poli/pasien/rujukan-by-status", function(data) {
    var dataArr = [];
    var label = [];
    for (var key in data) {
      if (data.hasOwnProperty(key)) {
        console.log(key + " -> " + data[key]);
        label.push(key);
        dataArr.push(data[key]);
      }
    }
    var rujukanByStatus = new Chart($("#rujukanByStatus"), {
      type: "pie",
      data: {
        labels: label,
        datasets: [
          {
            data: dataArr,
            backgroundColor: [
              "rgba(255, 99, 132, 0.2)",
              "rgba(54, 162, 235, 0.2)",
              "rgba(255, 206, 86, 0.2)",
              "rgba(75, 192, 192, 0.2)",
              "rgba(153, 102, 255, 0.2)",
              "rgba(255, 159, 64, 0.2)"
            ],
            borderColor: [
              "rgba(255,99,132,1)",
              "rgba(54, 162, 235, 1)",
              "rgba(255, 206, 86, 1)",
              "rgba(75, 192, 192, 1)",
              "rgba(153, 102, 255, 1)",
              "rgba(255, 159, 64, 1)"
            ],
            borderWidth: 1
          }
        ]
      }
    });
    $("#rujukanByStatusLoader").hide();
    $("#rujukanByStatus").show();
  });
  $("#dashboard").show();
});
