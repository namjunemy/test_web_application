<%@ page import="vo.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<jsp:useBean id="member"
             scope="session"
             class="vo.Member"/>
<html>
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
        <li><a href="/receipt/list?m_no=<%=member.getNo()%>">전자영수증</a></li>
      </ul>
      <form action="/auth/logout" method="get" class="navbar-form navbar-right">
        <button type="submit" class="btn btn-danger">Logout</button>
      </form>
      <form action="/member/info" method="get" class="navbar-form navbar-right">
        <input type="hidden" value="<%=member.getNo()%>" name="m_no">
        <button class="btn btn-primary">
          <% if (member.getId() != null) { %>
          <%=member.getId()%>
          <% } %>
        </button>
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
      <h1 class="page-header">상품리스트</h1>
    </div>
    <!-- /.col-lg-12 -->
  </div>
</div>

<div class="container">
  <div class="row">
  <%
    ArrayList<Product> values = (ArrayList<Product>) request.getAttribute("product");
    for (Product value : values) {
  %>
    <div class="col-sm-6 col-md-4">
      <div class="panel panel-default">
        <div class="panel-heading">
          <%=value.getNo()%>
        </div>
        <!-- /.panel-heading -->
        <div class="panel-body">
          <div class="table-responsive">
            <table class="table table-striped">
              <tr>
                <th nowrap>품번</th>
                <td><%=value.getNo()%>
                </td>
              </tr>
              <tr>
                <th nowrap>품명</th>
                <td><%=value.getName()%>
                </td>
              </tr>
              <tr>
                <th nowrap>사이즈</th>
                <td><%=value.getSize()%>
                </td>
              </tr>
              <tr>
                <th nowrap>가격</th>
                <td><%=value.getPrice()%>
                </td>
              </tr>
              <tr>
                <th nowrap>수량</th>
                <td><%=value.getQuantity()%>
                </td>
              </tr>
              <tr>
                <th nowrap>상품설명</th>
                <td><%=value.getDescription()%>
                </td>
              </tr>
              <tr>
                <th nowrap>===></th>
                <td><a href="/receipt/add?m_no=<%=member.getNo()%>&p_no=<%=value.getNo()%>">구매</a>
                </td>
              </tr>
            </table>
          </div>
        </div>
      </div>
    </div>
    <%} %>
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
