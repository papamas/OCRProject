<%-- 
    Document   : home
    Created on : Apr 1, 2017, 9:15:21 AM
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
        <%@include file="topHeader.jsp" %>
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
              <li><a href="#">proyek ocr</a></li>
              <li class="active">list keywords jenis dokumen </li>
            </ol>
          </section>

          <!-- Main content -->
          <section class="content">
            <div class="callout callout-info">
              <h4>Tip!</h4>
              <p>Aplikasi Inteligen Image Analisis akan mencoba untuk mengenali jenis dokumen  
                  kepegawaian (Case Sensitive) berdasarkan daftar keyword  yang ada dibawah ini</div>
              <div class="row">
            <div class="col-xs-12">
              <div class="box">
                <div class="box-header">
                  <h3 class="box-title">List of keywords jenis dokumen</h3>
                  <div class="box-tools">
                    <div class="input-group" style="width: 150px;">
                      <input type="text" name="table_search" class="form-control input-sm pull-right" placeholder="Search">
                      <div class="input-group-btn">
                        <button class="btn btn-sm btn-default"><i class="fa fa-search"></i></button>
                      </div>
                    </div>
                  </div>
                </div><!-- /.box-header -->
                <div class="box-body table-responsive no-padding">
                  <table class="table table-hover">
                    <tr>
                        <th>Nama SK</th>
                        <th>Alias</th>
                        <th>Keyword</th>
                        <c:url var="newKeyDokumenUrl" value="/newKeyDokumen" />           
                      <th><a href="${newKeyDokumenUrl}" title="new Keyword Jenis Dokumen"><i class="fa fa-plus-circle fa-2x text-green"></i></a></th> 
                    </tr>
                    <c:forEach items="${keywords}" var="keyword">
                    <tr>
                        <td>${keyword.jenisSK.namaSK}</td>
                        <td>${keyword.jenisSK.alias}</td>
                        <td>${keyword.namaKeyword}</td>
                        <td><a href="<c:url value='/edit-keyDokumen-${keyword.id}' />" title="edit">
                                <i class="fa fa-pencil text-blue"></i></a>&nbsp;
                            <a href="<c:url value='/delete-keyDokumen-${keyword.id}' />" title="remove">
                                <i class="fa fa-remove text-red"></i></a></td>   		
                    </tr>
                    </c:forEach>                   
                  </table>
                </div><!-- /.box-body -->
              </div><!-- /.box -->
            </div>
          </div>

            </section><!-- /.content -->
        </div><!-- /.container -->
      </div><!-- /.content-wrapper -->      
      <%@include file="footerAll.jsp" %>
      
  </body>
</html>
