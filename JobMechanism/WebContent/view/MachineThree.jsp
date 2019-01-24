<!DOCTYPE html>
<%@page import="java.util.Date"%>
<html lang="en">
    
<!-- Mirrored from stackbox.left4code.com/index2.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 16 Jan 2019 07:29:51 GMT -->
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <script src="../admin/js/app.js"></script>
        <link rel="stylesheet" href="../admin/css/main.css">
        <title>jobMechanism</title>
        
    </head>
    <body>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
        <div class="top-bar-box pl-0 colored">
            <div class="container">
                <div class="top-bar">
                    <a class="logo-box" href="javascript:;">
                        <img class="logo" src="../admin/images/logo.png" alt="Generic placeholder image">
                        <div class="title">Job<span class="highlight">Mechanism</span></div>
                    </a>
                    <div class="page-info">HOME / PRODUCTS / JOBMECHANISM / MACHINE THREE</div>
                    
                    <div class="mobile-nav-toggle"> <i class="icon mdi mdi-menu" aria-hidden="true"></i> Menu </div>
                    <div class="user-profile">
                        <img class="user-image" src="../admin/images/profile-1.jpg" alt="Generic placeholder image">
                        <div class="info">
                            <div class="user-name">Wiley Gladwyn</div>
                            <div class="user-info">Administrator</div>
                        </div>
                        <div class="user-profile-content">
                            <a href="javascript:;"> <i class="icon mdi mdi-settings" aria-hidden="true"></i> Settings </a>
                            <a href="javascript:;"> <i class="icon mdi mdi-textbox-password" aria-hidden="true"></i> Change Password </a>
                            <a href="javascript:;"> <i class="icon mdi mdi-logout-variant" aria-hidden="true"></i> Logout </a>
                        </div>
                    </div>
                </div>
                <div class="top-nav-box">
                    <ul class="top-nav">
                        <li>
                            <a href="javascript:;"><i class="icon mdi mdi-home" aria-hidden="true"></i> Dashboard</a>
                            
                        </li>
                        <li>
                            <a href="view/AddProduct.jsp"><i class="icon mdi mdi-calendar-blank" aria-hidden="true"></i> Add Products</a>
                            
                        </li>                         
                    </ul>
                </div>
            </div>
        </div>
        <div class="content-wrapper ml-0">
            <div class="report-box-1 mt-115 mt-lg-130 py-50">
                <div class="container">
                <form action="<%= request.getContextPath()%>/AddMachineWork" method="get">
                    <div class="row">
                        <div class="col-12">
                            <lable class="fw-100 fw-lg-120 mb-40 mt-lg-95 mb-lg-55  mx-sm-0 form-control outline light rounded-half-circle">
                             	Machine Three
                             
                            </lable>
                        </div>
                        <div class="col-lg-12 row">
                        	<div class="col-md-4">
                        		<h3 style="color:ghostwhite">Product Name       : </h3>
                        	</div>
                        	<div class="col-md-4">
                        		<h3 style="color:ghostwhite">Product In Time       : </h3>
                        		
                        	</div>
                        	<div class="col-md-4">
                        		<h3 style="color:ghostwhite">Product Out Time       : </h3>
                        		
                        	</div>
                        	
                        </div>
                            <div class="col-lg-12 row">
                        	<div class="col-md-2">
                        		 <select name="ProductId"
												class="form-control"
												data-plugin="select2" data-select2-id="1" tabindex="-1"
												>
                        		<optgroup label="Select Product Name" data-select2-id="58">
													
														<option value="${ProId}"
															data-select2-id="1">${ProName}
														</option>
												</optgroup>
												</select>
                        	</div>
                        	<div class="col-md-5">
                        		<div class="col-md-12 row">
                        		<div class="col-md-4">
                        			<input type="text" name="productInHour" placeholder="hour">
                        		</div>
                        		<div class="col-md-4">
                        			<input type="text" name="productInMin" placeholder="Min">
                        		</div>
                        		<div class="col-md-4">
                        			<input type="text" name="productInSec" placeholder="Sec">
                        		</div>  	
                        	</div>
                        	</div>
                        	<div class="col-md-5">
                        		<div class="col-md-12 row">
                        		<div class="col-md-4">
                        			<input type="text" name="productOutHour" placeholder="hour">
                        		</div>
                        		<div class="col-md-4">
                        			<input type="text" name="productOutMin" placeholder="Min">
                        		</div> 
                        		
                        		<div class="col-md-4">
                        			<input type="text" name="productOutSec" placeholder="Sec">
                        		</div>  	
                        	</div>
                        		
                        	</div>
                        	
                        	
                        </div>
                        </div>
                        <div class="col-lg-12">
                        <div class="float-right">
                        	<input type="submit" value="Work Done">
                        	<input type="hidden" value="m3" name="flag">
                        </div>
                        </div>
                        
                        
                        
                        
                        
                        
                    
                    </form>
                </div>
            </div>
            <div class="container">
                <div class="box-layout">
                    <div class="main-layout">
                        <div class="content-box position-relative fadeInUp animated">
                            
                        
                        </div>
                        
                    </div>
                    
                </div>
            </div>
        </div>
        <script>
			$(document).ready(function() {
				var lineChart = $("#line-chart")
				var lineData = {
					labels: ["02.00", "02.30", "03.00", "03.30", "04.00", "04.30", "02.00", "02.30", "03.00", "02.00", "02.30"],
					datasets: [{
						label: "Visitors Graph",
						borderColor: "#fbd5007a",
						pointRadius: 2,
						borderWidth: 1,
						backgroundColor: "transparent",
						pointBackgroundColor: "#fbd500",
						data: [1, 5, 10, 4, 20, 5, 10, 2, 12, 5, 1]
					},
					{
						label: "Visitors Graph",
						borderColor: "#48527270",
						pointRadius: 2,
						borderWidth: 1,
						backgroundColor: "transparent",
						pointBackgroundColor: "#5b6b98",
						data: [5, 32, 5, 42, 50, 59, 5, 32, 5, 40, 5]
					}]
				};

				var myLineChart = new Chart(lineChart, {
					type: 'line',
					data: lineData,
					options: {
						legend: {
							display: false
						},
						scales: {
							xAxes: [{
								ticks: {
									fontSize: '11',
									fontColor: '#969da5'
								},
								gridLines: {
									color: '#f6f8fd',
									zeroLineColor: '#f6f8fd'
								}
							}],
							yAxes: [{
					e			gridLines: {
									color: '#f6f8fd',
									zeroLineColor: '#f6f8fd'
								},
								ticks: {
									fontSize: '11',
									fontColor: '#969da5'
								}
							}]
						}
					}
				})
			})
		</script>
    </body>

<!-- Mirrored from stackbox.left4code.com/index2.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 16 Jan 2019 07:29:51 GMT -->
</html>