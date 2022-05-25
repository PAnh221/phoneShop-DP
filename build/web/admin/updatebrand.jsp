<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="images/fevicon/fevicon.png" type="image/gif" />
<title>ADMIN PAGE</title>
<!-- Bootstrap CSS -->
  <link href="admin/css/bootstrap.min.css" rel="stylesheet">
  <!-- bootstrap theme -->
  <link href="admin/css/bootstrap-theme.css" rel="stylesheet">
  <!--external css-->
  <!-- font icon -->
  <link href="admin/css/elegant-icons-style.css" rel="stylesheet" />
  <link href="admin/css/font-awesome.min.css" rel="stylesheet" />
  <!-- full calendar css-->
  <link href="admin/assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />
  <link href="admin/assets/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet" />
  <!-- easy pie chart-->
  <link href="admin/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen" />
  <!-- owl carousel -->
  <link rel="stylesheet" href="admin/css/owl.carousel.css" type="text/css">
  <link href="admin/css/jquery-jvectormap-1.2.2.css" rel="stylesheet">
  <!-- Custom styles -->
  <link rel="stylesheet" href="admin/css/fullcalendar.css">
  <link href="admin/css/widgets.css" rel="stylesheet">
  <link href="admin/css/style.css" rel="stylesheet">
  <link href="admin/css/style-responsive.css" rel="stylesheet" />
  <link href="admin/css/xcharts.min.css" rel=" stylesheet">
  <link href="admin/css/jquery-ui-1.10.4.min.css" rel="stylesheet">
</head>
<body style="background-color:#dddddd">

	<!-- container section start -->
  <section id="container" class="">
    <!--header start-->
	<jsp:include page="header.jsp"></jsp:include>
    <!--header end-->

    <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <div class="row">
            <div class="col-lg-12" >
            <h4 class="page-header"><i class="fa fa fa-bars"></i>Update Brand Pages</h4>
            <div style="padding:5px; color:red;font-style:italic;">
		       ${errorMessage}
		    </div>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="manageorder?action=show">Home</a></li>
              <li><i class="fa fa-bars"></i><a href="managebrand?action=show">Brand</a></li>
            </ol>
          </div>
        </div>
        
        <!-- page start-->
        <form method="post" action="managebrand?action=confirmupdate">
            <input type="hidden" name="brandId" value="<c:out value="${brandInfo.id}"></c:out>">
		  <div class="form-group row">
		    <label style="font-size: 20px; color:#000000" for="inputBrandName" class="col-sm-2 col-form-label">Brand Name</label>
		    <div class="col-sm-10">
                        <input style="width: 50%" type="text" class="form-control" placeholder="Enter name" value="<c:out value="${brandInfo.name}"></c:out>" name="BrandName">
		    </div>
		  </div>
		  <div class="form-group row">
		    <label style="font-size: 20px; color:#000000" for="inputBrandImage" class="col-sm-2 col-form-label">Image</label>
		    <div class="col-sm-10">
		      <input style="width: 50%" type="text" class="form-control" placeholder="Enter link image" value="<c:out value="${brandInfo.image}"></c:out>" name="BrandImage">
		    </div>
		  </div>
                  <div class="form-group row">
		    <label style="font-size: 20px; color:#000000" for="inputBrandDescription" class="col-sm-2 col-form-label">Description</label>
		    <div class="col-sm-10">
		      <input style="width: 60%" type="text" class="form-control" placeholder="Enter Description" value="<c:out value="${brandInfo.description}"></c:out>" name="BrandDescription">
		    </div>
		  </div>
                <button style="float: right; margin-right: 400px" type="submit" class="btn btn-primary">Confirm</button>
	</form>
        <form method="post" action="managebrand">
            <input type="hidden" name="action" value="cancel">
            <button style="float: right; margin-right: 40px" type="submit" class="btn btn-primary" value="Upload" >Cancel</button>
        </form>		
        <!-- page end-->
        
      </section>
    </section>
    <!--main content end-->
    <div class="text-right">
      
    </div>
  </section>
  <!-- javascripts -->
  <script src="admin/js/jquery.js"></script>
  <script src="admin/js/jquery-ui-1.10.4.min.js"></script>
  <script src="admin/js/jquery-1.8.3.min.js"></script>
  <script type="text/javascript" src="admin/js/jquery-ui-1.9.2.custom.min.js"></script>
  <!-- bootstrap -->
  <script src="admin/js/bootstrap.min.js"></script>
  <!-- nice scroll -->
  <script src="admin/js/jquery.scrollTo.min.js"></script>
  <script src="admin/js/jquery.nicescroll.js" type="text/javascript"></script>
  <!-- charts scripts -->
  <script src="admin/assets/jquery-knob/js/jquery.knob.js"></script>
  <script src="admin/js/jquery.sparkline.js" type="text/javascript"></script>
  <script src="admin/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
  <script src="admin/js/owl.carousel.js"></script>
  <!-- jQuery full calendar -->
  <<script src="admin/js/fullcalendar.min.js"></script>
    <!-- Full Google Calendar - Calendar -->
    <script src="admin/assets/fullcalendar/fullcalendar/fullcalendar.js"></script>
    <!--script for this page only-->
    <script src="admin/js/calendar-custom.js"></script>
    <script src="admin/js/jquery.rateit.min.js"></script>
    <!-- custom select -->
    <script src="admin/js/jquery.customSelect.min.js"></script>
    <script src="admin/assets/chart-master/Chart.js"></script>

    <!--custome script for all page-->
    <script src="admin/js/scripts.js"></script>
    <!-- custom script for this page-->
    <script src="admin/js/sparkline-chart.js"></script>
    <script src="admin/js/easy-pie-chart.js"></script>
    <script src="admin/js/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="admin/js/jquery-jvectormap-world-mill-en.js"></script>
    <script src="admin/js/xcharts.min.js"></script>
    <script src="admin/js/jquery.autosize.min.js"></script>
    <script src="admin/js/jquery.placeholder.min.js"></script>
    <script src="admin/js/gdp-data.js"></script>
    <script src="admin/js/morris.min.js"></script>
    <script src="admin/js/sparklines.js"></script>
    <script src="admin/js/charts.js"></script>
    <script src="admin/js/jquery.slimscroll.min.js"></script>
    <script>
      //knob
      $(function() {
        $(".knob").knob({
          'draw': function() {
            $(this.i).val(this.cv + '%')
          }
        })
      });

      //carousel
      $(document).ready(function() {
        $("#owl-slider").owlCarousel({
          navigation: true,
          slideSpeed: 300,
          paginationSpeed: 400,
          singleItem: true

        });
      });

      //custom select box

      $(function() {
        $('select.styled').customSelect();
      });

      /* ---------- Map ---------- */
      $(function() {
        $('#map').vectorMap({
          map: 'world_mill_en',
          series: {
            regions: [{
              values: gdpData,
              scale: ['#000', '#000'],
              normalizeFunction: 'polynomial'
            }]
          },
          backgroundColor: '#eef3f7',
          onLabelShow: function(e, el, code) {
            el.jsp(el.jsp() + ' (GDP - ' + gdpData[code] + ')');
          }
        });
      });
    </script>

</body>
</html>