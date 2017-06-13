<%-- 
    Document   : topHeader
    Created on : Apr 1, 2017, 4:41:32 PM
    Author     : Nur Muhamad
--%>
<header class="main-header">
        <nav class="navbar navbar-static-top">
          <div class="container">
            <c:url var="homeUrl" value="/home" />           
            <div class="navbar-header">
              <a href="${homeUrl}" class="navbar-brand"><b>Admin</b>OCR</a>
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
                <i class="fa fa-bars"></i>
              </button>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse pull-left" id="navbar-collapse">
              <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">File &nbsp;<span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                    <c:url var="newUserUrl" value="/newuser" />  
                    <li><a href="${newUserUrl}"> <i class="fa fa-user-plus"></i> New User</a></li>
                    <li class="divider"></li>
                    <c:url var="listTemplateUrl" value="/listTemplate" />                
                    <li><a href="${listTemplateUrl}"><i class="fa fa-magic"></i>Template</a> </li> 
                    <li class="divider"></li>
                    <c:url var="listKeyInstansiUrl" value="/listKeyInstansi" />                
                    <li><a href="${listKeyInstansiUrl}"><i class="fa fa-key"></i>Keyword Instansi</a> </li>
                    <li class="divider"></li>
                    <c:url var="listKeyDokumenUrl" value="/listKeyDokumen" />                
                    <li><a href="${listKeyDokumenUrl}"><i class="fa fa-inbox"></i>Keyword Dokumen</a> </li> 
                  </ul>
                </li>
                <li class="active"><a href="${listKeyDokumenUrl}" title="List of keyword jenis dokumen"><i class="fa fa-envelope-o"></i><span class="sr-only">(current)</span></a></li>
                <li><a href="${listKeyInstansiUrl}" title="List of keyword instansi"><i class="fa fa-flag-o"></i></a></li>                
              </ul>
                <c:url var="listUserUrl" value="/list" />    
                <div class="navbar-custom-menu">
                    <ul class="nav navbar-nav">
                      <!-- Messages: style can be found in dropdown.less-->
                      <li class="dropdown messages-menu">
                        <!-- Menu toggle button -->
                        <a href="${listUserUrl}" title="List of users">
                          <i class="fa fa-users"></i>                      
                        </a>
                      </li>
                    </ul>
                </div>
                <c:url var="scannerUrl" value="/scanner" />    
                <div class="navbar-custom-menu">
                    <ul class="nav navbar-nav">
                      <!-- Messages: style can be found in dropdown.less-->
                      <li class="dropdown messages-menu">
                        <!-- Menu toggle button -->
                        <a href="${scannerUrl}" title="Scanner Interface">
                          <i class="fa fa-file-image-o"></i>                      
                        </a>
                      </li>
                    </ul>
                </div>  
                <c:url var="fileBucketUrl" value="/listFileBucket" />    
                <div class="navbar-custom-menu">
                    <ul class="nav navbar-nav">
                      <!-- Messages: style can be found in dropdown.less-->
                      <li class="dropdown messages-menu">
                        <!-- Menu toggle button -->
                        <a href="${fileBucketUrl}" title="List File Bucket">
                          <i class="fa fa-folder-open"></i>                      
                        </a>
                      </li>
                    </ul>
                </div>
                <c:url var="laporanUrl" value="/laporan/" />    
                <div class="navbar-custom-menu">
                    <ul class="nav navbar-nav">
                      <!-- Messages: style can be found in dropdown.less-->
                      <li class="dropdown messages-menu">
                        <!-- Menu toggle button -->
                        <a href="${laporanUrl}" title="Laporan">
                          <i class="fa fa-bar-chart"></i>                      
                        </a>
                      </li>
                    </ul>
                </div>                           
            </div><!-- /.navbar-collapse -->        
            <!-- Navbar Right Menu -->
              <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                  <!-- Messages: style can be found in dropdown.less-->
                  <li class="dropdown messages-menu">
                    <!-- Menu toggle button -->
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                      <i class="fa fa-envelope-o"></i>
                      <span class="label label-success">4</span>
                    </a>
                    <ul class="dropdown-menu">
                      <li class="header">You have 4 messages</li>
                      <li>
                        <!-- inner menu: contains the messages -->
                        <ul class="menu">
                          <li><!-- start message -->
                            <a href="#">
                              <div class="pull-left">
                                <!-- User Image -->
                                <img src="<c:url value='/static/img/avatar5.png'/>"  class="img-circle" alt="User Image">
                              </div>
                              <!-- Message title and timestamp -->
                              <h4>
                                Support Team
                                <small><i class="fa fa-clock-o"></i> 5 mins</small>
                              </h4>
                              <!-- The message -->
                              <p>Why not buy a new awesome theme?</p>
                            </a>
                          </li><!-- end message -->
                        </ul><!-- /.menu -->
                      </li>
                      <li class="footer"><a href="#">See All Messages</a></li>
                    </ul>
                  </li><!-- /.messages-menu -->

                  <!-- Notifications Menu -->
                  <li class="dropdown notifications-menu">
                    <!-- Menu toggle button -->
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                      <i class="fa fa-bell-o"></i>
                      <span class="label label-warning">10</span>
                    </a>
                    <ul class="dropdown-menu">
                      <li class="header">You have 10 notifications</li>
                      <li>
                        <!-- Inner Menu: contains the notifications -->
                        <ul class="menu">
                          <li><!-- start notification -->
                            <a href="#">
                              <i class="fa fa-users text-aqua"></i> 5 new members joined today
                            </a>
                          </li><!-- end notification -->
                        </ul>
                      </li>
                      <li class="footer"><a href="#">View all</a></li>
                    </ul>
                  </li>
                  <!-- Tasks Menu -->
                  <li class="dropdown tasks-menu">
                    <!-- Menu Toggle Button -->
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                      <i class="fa fa-flag-o"></i>
                      <span class="label label-danger">9</span>
                    </a>
                    <ul class="dropdown-menu">
                      <li class="header">You have 9 tasks</li>
                      <li>
                        <!-- Inner menu: contains the tasks -->
                        <ul class="menu">
                          <li><!-- Task item -->
                            <a href="#">
                              <!-- Task title and progress text -->
                              <h3>
                                Design some buttons
                                <small class="pull-right">20%</small>
                              </h3>
                              <!-- The progress bar -->
                              <div class="progress xs">
                                <!-- Change the css width attribute to simulate progress -->
                                <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                  <span class="sr-only">20% Complete</span>
                                </div>
                              </div>
                            </a>
                          </li><!-- end task item -->
                        </ul>
                      </li>
                      <li class="footer">
                        <a href="#">View all tasks</a>
                      </li>
                    </ul>
                  </li>
                  <!-- User Account Menu -->
                  <li class="dropdown user user-menu">
                    <!-- Menu Toggle Button -->
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                      <!-- The user image in the navbar-->
                      <img src="<c:url value='/static/img/avatar5.png'/>" class="user-image" alt="User Image">
                      <!-- hidden-xs hides the username on small devices so only the image appears. -->
                      <span class="hidden-xs">Alexander Pierce</span>
                    </a>
                    <ul class="dropdown-menu">
                      <!-- The user image in the menu -->
                      <li class="user-header">
                        <img src="<c:url value='/static/img/avatar5.png'/>" class="img-circle" alt="User Image">
                        <p>
                          Alexander Pierce - Web Developer
                          <small>Member since Nov. 2012</small>
                        </p>
                      </li>
                      <!-- Menu Body -->
                      <li class="user-body">
                        <div class="col-xs-4 text-center">
                          <a href="#">Followers</a>
                        </div>
                        <div class="col-xs-4 text-center">
                          <a href="#">Sales</a>
                        </div>
                        <div class="col-xs-4 text-center">
                          <a href="#">Friends</a>
                        </div>
                      </li>
                      <!-- Menu Footer-->
                      <li class="user-footer">
                        <div class="pull-left">
                          <a href="#" class="btn btn-default btn-flat">Profile</a>
                        </div>
                        <c:url var="logoutUrl" value="/logout" />	  
                        <div class="pull-right">
                          <a href="${logoutUrl}" class="btn btn-default btn-flat">Sign out</a>
                        </div>
                      </li>
                    </ul>
                  </li>
                </ul>
              </div><!-- /.navbar-custom-menu -->
          </div><!-- /.container-fluid -->
        </nav>
      </header>
