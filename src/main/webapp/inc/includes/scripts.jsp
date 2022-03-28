
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Pr�t � partir?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">�</span>
                    </button>
                </div>
                <div class="modal-body">S�lectionnez "Deconnexion" ci-dessous si vous �tes pr�t � mettre fin � votre session en cours.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="logout">Deconnexion</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="/BC/inc/vendor/jquery/jquery.min.js"></script>
    <script src="/BC/inc/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="/BC/inc/vendor/bootstrap/js/bootstrap.bundle.js.map"></script>
	<script src="/BC/inc/vendor/bootstrap/js/bootstrap.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="/BC/inc/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/BC/inc/js/sb-admin-2.js"></script>
    <!-- Page level plugins -->
    <script src="/BC/inc/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="/BC/inc/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="/BC/inc/js/demo/datatables-demo.js"></script>
    

    <!-- Page level plugins -->
    <script src="/BC/inc/vendor/chart.js/Chart.min.js"></script>
	<script src="/BC/inc/vendor/chart.js/Chart.js"></script>
    <!-- Page level custom scripts -->
    <script>
 // Set new default font family and font color to mimic Bootstrap's default styling
    Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
    Chart.defaults.global.defaultFontColor = '#858796';

    function number_format(number, decimals, dec_point, thousands_sep) {
      // *     example: number_format(1234.56, 2, ',', ' ');
      // *     return: '1 234,56'
      number = (number + '').replace(',', '').replace(' ', '');
      var n = !isFinite(+number) ? 0 : +number,
        prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
        sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
        dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
        s = '',
        toFixedFix = function(n, prec) {
          var k = Math.pow(10, prec);
          return '' + Math.round(n * k) / k;
        };
      // Fix for IE parseFloat(0.55).toFixed(0) = 0;
      s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
      if (s[0].length > 3) {
        s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
      }
      if ((s[1] || '').length < prec) {
        s[1] = s[1] || '';
        s[1] += new Array(prec - s[1].length + 1).join('0');
      }
      return s.join(dec);
    }

    // Area Chart Example
    var ctx = document.getElementById("myAreaChart");
    var myLineChart = new Chart(ctx, {
      type: 'line',
      data: {
        labels: ["${sessionScope.dates[5]}", "${sessionScope.dates[4]}", "${sessionScope.dates[3]}",
    			"${sessionScope.dates[2]}", "${sessionScope.dates[1]}", "${sessionScope.dates[0]}"],
        datasets: [{
          label: "Revenus",
          lineTension: 0.3,
          backgroundColor: "rgba(78, 115, 223, 0.05)",
          borderColor: "rgba(78, 115, 223, 1)",
          pointRadius: 3,
          pointBackgroundColor: "rgba(78, 115, 223, 1)",
          pointBorderColor: "rgba(78, 115, 223, 1)",
          pointHoverRadius: 3,
          pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
          pointHoverBorderColor: "rgba(78, 115, 223, 1)",
          pointHitRadius: 10,
          pointBorderWidth: 2,
          data: [${sessionScope.valeurs[5]}, ${sessionScope.valeurs[4]}, ${sessionScope.valeurs[3]},
    			${sessionScope.valeurs[2]}, ${sessionScope.valeurs[1]}, ${sessionScope.valeurs[0]}] ,
        }],
      },
      options: {
        maintainAspectRatio: false,
        layout: {
          padding: {
            left: 10,
            right: 25,
            top: 25,
            bottom: 0
          }
        },
        scales: {
          xAxes: [{
            time: {
              unit: 'date'
            },
            gridLines: {
              display: false,
              drawBorder: false
            },
            ticks: {
              maxTicksLimit: 7
            }
          }],
          yAxes: [{
            ticks: {
              maxTicksLimit: 5,
              padding: 10,
              // Include a dollar sign in the ticks
              callback: function(value, index, values) {
                return number_format(value) + 'DH';
              }
            },
            gridLines: {
              color: "rgb(234, 236, 244)",
              zeroLineColor: "rgb(234, 236, 244)",
              drawBorder: false,
              borderDash: [2],
              zeroLineBorderDash: [2]
            }
          }],
        },
        legend: {
          display: false
        },
        tooltips: {
          backgroundColor: "rgb(255,255,255)",
          bodyFontColor: "#858796",
          titleMarginBottom: 10,
          titleFontColor: '#6e707e',
          titleFontSize: 14,
          borderColor: '#dddfeb',
          borderWidth: 1,
          xPadding: 15,
          yPadding: 15,
          displayColors: false,
          intersect: false,
          mode: 'index',
          caretPadding: 10,
          callbacks: {
            label: function(tooltipItem, chart) {
              var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
              return datasetLabel + ': ' + number_format(tooltipItem.yLabel) + 'DH';
            }
          }
        }
      }
    });

    </script>



    <script>
	 	// Set new default font family and font color to mimic Bootstrap's default styling
	    Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	    Chart.defaults.global.defaultFontColor = '#858796';
	
	    // Pie Chart Example
	    var ctx = document.getElementById("myPieChart");
	    var myPieChart = new Chart(ctx, {
	      type: 'doughnut',
	      data: {
	        labels: ["Cr�dits", "Ventes"],
	        datasets: [{
	          data: [${sessionScope.totalCredits}, ${sessionScope.totalVentes}],
	          backgroundColor: ['#DB6B97', '#BAABDA'],
	          hoverBackgroundColor: ['#F56FAD', '#EB92BE'],
	          hoverBorderColor: "rgba(234, 236, 244, 1)",
	        }],
	      },
	      options: {
	        maintainAspectRatio: false,
	        tooltips: {
	          backgroundColor: "rgb(255,255,255)",
	          bodyFontColor: "#858796",
	          borderColor: '#dddfeb',
	          borderWidth: 1,
	          xPadding: 15,
	          yPadding: 15,
	          displayColors: false,
	          caretPadding: 10,
	        },
	        legend: {
	          display: false
	        },
	        cutoutPercentage: 80,
	      },
	    });

    </script>
    
    
    