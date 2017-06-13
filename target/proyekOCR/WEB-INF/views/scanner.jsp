<%-- 
    Document   : scanner
    Created on : Apr 3, 2017, 8:53:27 PM
    Author     : Nur Muhamad
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="<c:url value='/static/css/bootstrap.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/static/font-awesome/css/font-awesome.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/static/css/AdminLTE.css' />" />
    <link rel="stylesheet" href="<c:url value='/static/css/skins/_all-skins.min.css' />" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="hold-transition skin-purple layout-top-nav">
    <div class="wrapper">

      <%@include  file="topHeader.jsp" %>
      <!-- Full Width Column -->
      <div class="content-wrapper">
        <div class="container">
          <!-- Content Header (Page header) -->
          <section class="content-header">
            <h1>
              OCR Project
              <small>Version 1.0</small>
            </h1>
            <ol class="breadcrumb">
              <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
              <li><a href="#">Scaner</a></li>
              <li class="active">Interface</li>
            </ol>
          </section>

          <!-- Main content -->
          <section class="content">
            <div class="callout callout-info">
              <h4>Tip!</h4>
              <p>Add the layout-top-nav class to the body tag to get this layout. This feature can also be used with a sidebar! So use this class if you want to remove the custom dropdown menus from the navbar and use regular links instead.</p>
            </div>
            <div class="box box-primary">
                <div class="box-header with-border">
                  <h3 class="box-title">Scanner Applet Interface</h3>
                </div><!-- /.box-header -->
                <!-- form start -->                
                <applet code="com.proyekOCR.applet.Scanner" name="Scanner" 
                    archive="<c:url value="static/scanner.jar"/>"  width=100%  height=100% >
                    <param name="token" value="${pageContext.session.id}">
                </applet>         
            </div><!-- /.box -->
          </section><!-- /.content -->
        </div><!-- /.container -->
      </div><!-- /.content-wrapper -->      
     <%@include file="footerAll.jsp" %>  
    
    </body>
</html>