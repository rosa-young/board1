<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Board</title>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="/resources/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="/resources/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                 <a class="navbar-brand" href="list">Spring Web Project</a>
            </div>
            	

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse collapse">
                    <ul class="nav" id="side-menu">
                        <li>
	            			<a href="list"><i class="fa fa-pagelines"></i> 첫페이지로 이동</a>
	            		</li> 
	                    <li>
	            			<a href="register"><i class="fa fa-edit fa-fw"></i> 글쓰기</a>
	            		</li>       		
	            		
	            		 <li>
	            		 	<a href="list"><i class="fa fa-search"></i> 검색범위를 선택해주세요.</a>
	            		 </li>
	            		 <li> 
                         <form action="/board/list" method="get">
                          	<select class="form-control" name="type">
                          		<option value="T" <c:if test='${pagemaker.cri.type=="T"}'>selected</c:if>>제목</option>
                          		<option value="C" <c:if test='${pagemaker.cri.type=="C"}'>selected</c:if>>내용</option>
                          		<option value="W" <c:if test='${pagemaker.cri.type=="W"}'>selected</c:if>>작성자</option>
                          		<option value="TC" <c:if test='${pagemaker.cri.type=="TC"}'>selected</c:if>>제목 or 내용</option>
                          		<option value="TW" <c:if test='${pagemaker.cri.type=="TW"}'>selected</c:if>>제목 or 작성자</option>
                          		<option value="CW" <c:if test='${pagemaker.cri.type=="CW"}'>selected</c:if>>내용 or 작성자</option>
                          		<option value="TCW" <c:if test='${pagemaker.cri.type=="TWC"}'>selected</c:if>>제목 or 내용 or 작성자</option>                          		
                          	</select><br>
                          	<li>
	            		 	<a href="list"><i class="fa fa-pencil"></i> 검색어를 입력해주세요.</a>
	            		 	</li>
                          	<input class="form-control" type="text" name="keyword" id="keyword" value="${pageMaker.cri.keyword}">
                          	<input type="submit" class="btn btn-default" value="검색" id="search">
                          </form>
                        </li>
	            		
	            		<li>
	            			<a href="list"><i class="fa fa-database fa-fw"></i> Board total posts ${pageMaker.total}</a>
	            		</li>
                          
                          
                        
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>