<!DOCTYPE html>
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
        <div class="top-bar-box pl-0 colored">
            <div class="container">
                <div class="top-bar">
                    <a class="logo-box" href="javascript:;">
                        <img class="logo" src="../admin/images/logo.png" alt="Generic placeholder image">
                        <div class="title">Job<span class="highlight">Mechanism</span></div>
                    </a>
                    <div class="page-info">HOME / PRODUCTS / AddProduct</div>
                    
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
                    <div class="row">
                    <form action="<%= request.getContextPath() %>/ProductController" method="post">
                        <div class="col-lg-12">
                        	<div class="clo-md-4">
                        	<lable style="color:ghostwhite">Product Name                         :</lable>
                        	<input type="text"  name="productName" >
                        	<input type="submit" value="Add Product">
                        	<input type="hidden" value="AddProduct" name="flag">
                        	</div>
          				</div>
          				</form>
          				
          				
          				</div>
          </div>
          </div>
          </div>
          </body>
          </html>
          				
          