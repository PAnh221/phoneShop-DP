<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="admin/img/favicon.png">
<title>ADMIN PAGE</title>
<!-- Bootstrap CSS -->
  <link href="admin/css/bootstrap.min.css" rel="stylesheet">
  <!-- bootstrap theme -->
  <link href="admin/css/bootstrap-theme.css" rel="stylesheet">
  <!--external css-->
  <!-- font icon -->
  <link href="admin/css/elegant-icons-style.css" rel="stylesheet" />
  <link href="admin/css/font-awesome.min.css" rel="stylesheet" />
  <!-- Custom styles -->
  <link href="admin/css/style.css" rel="stylesheet">
  <link href="admin/css/style-responsive.css" rel="stylesheet" />
</head>
<body>

	<aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu">
          <li class="sub-menu">
            <a href="manageorder" class="">
                          <i class="icon_document_alt"></i>
                          <span>ORDER LIST</span>
                      </a>
          </li>
          <li class="sub-menu">
            <a href="managebrand?action=show" class="">
                          <i class="icon_document_alt"></i>
                          <span>BRAND LIST</span>
                       
                      </a>
          </li>
          <li class="sub-menu">
            <a href="" class="">
                          <i class="icon_desktop"></i>
                          <span>Thêm sản phẩm</span>
                          
                      </a>
          </li>
          <li class="sub-menu">
            <a href="CategoryForward" class="">
                          <i class="icon_document_alt"></i>
                          <span>Danh sách danh mục</span>
                       
                      </a>
          </li>
          <li class="sub-menu">
            <a href="InsertCategory" class="">
                          <i class="icon_desktop"></i>
                          <span>Thêm danh mục</span>
                          
                      </a>
          </li>
          <li class="sub-menu">
            <a href="OrderForward" class="">
                          <i class="icon_document_alt"></i>
                          <span>Hóa đơn</span>
                       
                      </a>
          </li>
        </ul>
        <!-- sidebar menu end-->
      </div>
    </aside>
    <!--sidebar end-->

</body>
</html>