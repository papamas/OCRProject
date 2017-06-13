<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Login page</title>
            <link href="<c:url value='/static/css/bootstrap.min.css' />"  rel="stylesheet" />
            <link href="<c:url value='/static/css/AdminLTE.css' />" rel="stylesheet" />
            <link href="<c:url value='/static/css/skins/_all-skins.min.css'/>" rel="stylesheet" />
            <link type="text/css" href="<c:url value='/static/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet"/> 
        </head>

	<body class="hold-transition login-page">
            <div class="login-box">
      <div class="login-logo">
          <a href="#"><img src="<c:url value='/static/img/logo_bkn_login.png' />" /></a>
      </div><!-- /.login-logo -->
      <div class="login-box-body">               
            <span class="col-xs-offset-4">
                <i class="fa fa-user-secret fa-5x circle-icon2"></i>
           </span>
        
        <br/><br/>
        <c:if test="${param.error != null}">
            <p class="text-center text-bold text-red">Invalid username or password.</p>            
        </c:if>
        <c:if test="${param.error == null}">
            <p class="text-center text-bold text-blue">Sign in to use application</p>            
        </c:if>
        
        <br/>
        <c:url var="loginUrl" value="/login" />		
        <form action="${loginUrl}" method="post">
          <div class="form-group has-feedback">
              <input type="text" name="ssoId" class="form-control" placeholder="Username" required>
            <span class="fa fa-user form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
              <input type="password" name="password" class="form-control" placeholder="Password" required>
            <span class="fa fa-key form-control-feedback"></span>
          </div>
          <div class="row">
            <div class="col-xs-12">
                <button type="submit" class="btn btn-block btn-warning btn-flat">Sign In</button>
            </div><!-- /.col -->
          </div>
          <br/>
        <div class="row"> 
            <div class="col-xs-7">  
                <input type="checkbox" id="rememberme" name="remember-me"><span class="text-info">&nbsp; Remember Me</span>                  
            </div>
            <div class="col-xs-5">
                <a href="#" title="please contact your administrator">Forgot password</a>
            </div>        
        </div>
        <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
		  
        </form>           
      </div><!-- /.login-box-body -->
    </div><!-- /.login-box -->
       
    <script src="<c:url value='/static/js/jQuery-2.1.4.min.js' />" ></script>
    <script src="<c:url value='/static/js/bootstrap.min.js'/>" ></script> 
    </body>
</html>