<!DOCTYPE html>
<html lang="en">
<head>
<!-- basic -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- mobile metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<!-- site metas -->
<title>B.A.D Shop</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">
<!-- site icons -->
<link rel="icon" href="images/fevicon/fevicon.png" type="image/gif" />
<!-- bootstrap css -->
<link rel="stylesheet" href="css/bootstrap.min.css" />
<!-- Site css -->
<link rel="stylesheet" href="css/style.css" />
<!-- responsive css -->
<link rel="stylesheet" href="css/responsive.css" />
<!-- colors css -->
<link rel="stylesheet" href="css/colors1.css" />
<!-- custom css -->
<link rel="stylesheet" href="css/custom.css" />
<!-- wow Animation css -->
<link rel="stylesheet" href="css/animate.css" />
<!-- zoom effect -->
<link rel='stylesheet' href='css/hizoom.css'>
<!-- end zoom effect -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
      <![endif]-->
</head>
<body id="default_theme" class="it_serv_shopping_cart shopping-cart">
<!-- loader -->
<div class="bg_load"> <img class="loader_animation" src="images/loaders/loader_1.png" alt="#" /> </div>
<!-- end loader -->
<!-- header --><%@include file="header.jsp" %>
<!-- end header -->
<!-- inner page banner -->
<div id="inner_banner" class="section inner_banner_section">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="full">
          <div class="title-holder">
            <div class="title-holder-cell text-left">
              <h1 class="page-title">Shopping Cart</h1>
              <ol class="breadcrumb">
                <li><a href="home">Home</a></li>
                <li class="active">Shopping Cart</li>
              </ol>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- end inner page banner -->
<div class="section padding_layout_1 Shopping_cart_section">
  <div class="container">
    <div class="row">
      <div class="col-sm-12 col-md-12">
        <div class="product-table">
          <table class="table">
            <thead>
              <tr>
                <th>Product</th>
                <th>Quantity</th>
                <th class="text-center">Price</th>
                <th class="text-center">Total</th>
                <th> </th>
              </tr>
            </thead>
            <tbody>
              <tr>
                  <c:forEach var="item" items="${listcart}">
                    <form method="get" action="cart">
                        <input type="hidden" name="action" value="update">
                        <input type="hidden" name="proid" value="${item.cartPK.getProid()}">
                        <td class="col-sm-8 col-md-6"><div class="media"> <a class="thumbnail pull-left" href="#"> <img class="media-object" src="${item.image}" alt="#"></a>
                            <div class="media-body">
                              <h4 class="media-heading"><a href="#">${item.proname}</a></h4>
                          </div></td>
                        <td class="col-sm-1 col-md-1" style="text-align: center"><input class="form-control" min="1" max="${maxitem}" name="quantity" value="${item.amount}" type="number">
                        </td>
                        <td class="col-sm-1 col-md-1 text-center"><p class="price_table">${item.getPriceCurrencyFormat()}</p></td>
                        <td class="col-sm-1 col-md-1 text-center"><p class="price_table">${item.getTotalCurrencyFormat()}</p></td>
                        <td class="col-sm-1 col-md-1"><button type="submit" class="bt_main">Update</button></td>
                    </form>
                    <form method="get" action="cart">
                        <input type="hidden" name="action" value="remove">
                        <input type="hidden" name="proid" value="${item.cartPK.getProid()}">
                        <td class="col-sm-1 col-md-1"><button type="submit" class="bt_main"><i class="fa fa-trash"></i> Remove</button></td>
                    </form>
              </tr>
                </c:forEach>
            </tbody>
          </table>
          <table class="table">
            <tbody>
              <tr class="cart-form">
                <td class="actions"><div class="coupon">
                    <input name="coupon_code" class="input-text" id="coupon_code" placeholder="Coupon code" type="text">
                    <input class="button" name="apply_coupon" value="Apply coupon" type="submit">
                  </div>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
        <div class="shopping-cart-cart">
          <table>
            <tbody>
              <tr class="head-table">
                <td><h5>Cart Totals</h5></td>
                <td class="text-right"></td>
              </tr>
              <tr>
                <td><h4>Subtotal</h4></td>
                <td class="text-right"><h4>${sum}</h4></td>
              </tr>
              <tr>
                <td><h5>Estimated shipping</h5></td>
                <td class="text-right"><h4>Free</h4></td>
              </tr>
              <tr>
                <td><h3>Total</h3></td>
                <td class="text-right"><h4>${sum}</h4></td>
              </tr>
              <tr>                  
                <td><button type="button" onclick="location.href='it_shop';" class="button">Continue Shopping</button></td>
                <td><button type="button" onclick="location.href='invoice?action=checkout';" class="button">Checkout</button></td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- footer -->
<%@include file="footer.jsp" %>
<!-- end footer -->
<!-- js section -->
<script defer src="js/jquery.min.js"></script>
<script defer src="js/bootstrap.min.js"></script>
<!-- menu js -->
<script defer src="js/menumaker.js"></script>
<!-- wow animation -->
<script defer src="js/wow.js"></script>
<!-- custom js -->
<script defer src="js/custom.js"></script>

<!-- zoom effect -->
<script defer src='js/hizoom.js'></script>
<script defer>
        $('.hi1').hiZoom({
            width: 300,
            position: 'right'
        });
        $('.hi2').hiZoom({
            width: 400,
            position: 'right'
        });
    </script>
</body>
</html>
