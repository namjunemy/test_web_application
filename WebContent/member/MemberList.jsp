<%@page import="java.util.ArrayList" %>
<%@page import="vo.Member" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<head>
  <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
  <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

  <title>Lotte HomeShopping</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
              data-target="#navbar"
              aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/product/list" style="color:red;">LOTTE</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <li><a href="/product/list">Product</a></li>
      </ul>
      <form action="/auth/login" method="get" class="navbar-form navbar-right">
        <button type="submit" class="btn btn-primary">로그인</button>
      </form>
    </div><!--/.navbar-collapse -->
  </div>
</nav>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
  <div class="container">
    <h1>롯데홈쇼핑</h1>
    <p>
    <h3>'One Lotte'를 위해서 계열사의 통합서비스를 위한 반응형 웹 어플리케이션을 개발중입니다.</h3></p>
    <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>
  </div>
</div>

<div class="container">
  <div class="row">
    <div class="col-lg-12">
      <h1 class="page-header">Member List
      </h1>
    </div>
    <!-- /.col-lg-12 -->
  </div>

  <div class="row">
    <div class="col-lg-12">
      <div class="panel panel-default">
        <div class="panel-heading">
          All
        </div>
        <!-- /.panel-heading -->
        <div class="panel-body">
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
              <tr>
                <th nowrap>회원번호</th>
                <th nowrap>ID</th>
                <th nowrap>회원등급</th>
                <th nowrap>이름</th>
                <th nowrap>E-Mail</th>
                <th nowrap>휴대폰</th>
                <th nowrap>가입일</th>
              </tr>
              </thead>
              <tbody>
              <%
                ArrayList<Member> values = (ArrayList<Member>) request.getAttribute("member");
                for (Member value : values) {
              %>
              <tr>
                <td><%=value.getNo()%>
                </td>
                <td><%=value.getId()%>
                </td>
                <td><%=value.getLevel()%>
                </td>
                <td><%=value.getName()%>
                </td>
                <td><%=value.getEmail()%>
                </td>
                <td><%=value.getPhone()%>
                </td>
                <td><%=value.getRegist()%>
                </td>
              </tr>
              <%} %>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<div class="container">
  <footer>
    <p>&copy; Lotte 2017. All rights reserved</p>
  </footer>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>
