<%-- 
    Document   : listTemplate
    Created on : Apr 1, 2017, 7:18:21 PM
    Author     : Nur Muhamad
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
              <li><a href="#">proyek ocr</a></li>
              <li class="active">list template</li>
            </ol>
          </section>

          <!-- Main content -->
          <section class="content">
            <div class="callout callout-info">
              <h4>Tip!</h4>
              <p>Berikut adalah list file yang telah di scan, analisa dan di posting ke server dms silahkan klik update status untuk merubah status file</p>
            </div>
            
            <div class="row">
            <div class="col-xs-12">
              <div class="box">
                <div class="box-header">
                  <h3 class="box-title">List of file bucket</h3>
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
                    <table class="table table-hover" style=" font-size: 11px">
                    <tr>
                      <th>Original File</th>  
                      <th>Analisis File</th>
                      <th>DMS File</th>
                      <th>Instansi</th>
                      <th>Jenis Doc</th>
                      <th>NIP</th>
                      <th>Status</th>
                      <th>Created Date</th>
                      <th>Updated Date</th>
                      <th>Action</th>
                    </tr> 
                    <c:forEach items="${fileBucketList}" var="fileBucket">                    
                    <tr>
                        <td>${fileBucket.originalFile}</td>  
                        <td>${fileBucket.analisFile}</td>
						<td>
                        <c:if test="${not empty fileBucket.dmsFile}">
                            <a href="<c:url value='/getContent-${fileBucket.dmsFile}' />">${fileBucket.dmsFile}</a>
                        </c:if>
                        </td>
                        <td>${fileBucket.instansi}</td>
                        <td>${fileBucket.jenisDoc}</td>
                        <td>${fileBucket.nip}</td>                      
                        <td>
						<c:choose>
                            <c:when test="${fileBucket.status == 1}"><span class="label label-warning">IMA</span></c:when>
                            <c:when test="${fileBucket.status == 2}"><span class="label label-primary">DMS</span></c:when>
                            <c:when test="${fileBucket.status == 3}"><span class="label label-danger">SAPK</span></c:when>
                            <c:otherwise><span class="label label-success">NEW</span></c:otherwise>
                        </c:choose>
                        </td>						
                      <td>${fileBucket.createdDate}</td>
                      <td>${fileBucket.updateDate}</td>
                      <td>
                        <c:if test="${fileBucket.status == 2}">    
                          <a href="<c:url value='/update-statusBucket-${fileBucket.id}' />" title="update status">
                                <i class="fa fa-pencil text-blue"></i></a>
                         </c:if>
                        </td>
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
