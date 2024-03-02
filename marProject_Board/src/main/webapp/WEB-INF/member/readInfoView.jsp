<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>


<head>
  <!-- Required meta tags -->
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

  <meta name="description" content="" />
  <meta name="author" content="" />
  <link rel="icon" href="${pageContext.request.contextPath}/resources/img/chat.png" />

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous" />


  <title>BLABBER | 회원정보 조회</title>
</head>





<body style="background-color: #fefbe9; ">

  <!--NAVBAR-->
  <header>
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top" style="background-color: #183a1d; font-weight:bold">
      <a class="navbar-brand" href="mainView.do"><img src="${pageContext.request.contextPath}/resources/img/chat.png" alt="logo"
          style="width: 45px" /></a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
        aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a class="nav-link" href="allBoardView.do">전체<span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../board/popularBoardView.html">인기</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../board/bestBoardView.html">베스트</a>
          </li>

          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown"
              aria-haspopup="true" aria-expanded="false">게시판</a>
            <div class="dropdown-menu" aria-labelledby="dropdown01">
              <a class="dropdown-item" href="#">익명게시판</a>
              <a class="dropdown-item" href="#">자유게시판</a>
            </div>
          </li>
        </ul>
        
                           <a href="logout.do">
  <button class="btn btn-sm btn-outline-light" style="background-color: #2a7335; border: none">로그아웃</button>
</a>
        
        
     
      </div>
    </nav>
  </header>



  <!--main-->
  <main style="padding-top: 10rem">

    <!--첫째줄-->
    <div class="container col-lg-11" style="background-color: #fefbe9; padding-bottom:5rem">

      <div class="row">
        <!--첫째줄 첫번째 요소-->
        <div class="col-lg-2" style="padding-right: 10rem">
          <h4 class="display-6" style="color: #183a1d; font-weight: bold;">안녕하세요, ${member.id}님 </h4>
          <table class="table">

            <tr>
              <td> <a href="readInfoView.do" style="color: black;">내 정보</a></td>
            </tr>

            <tr>
              <td><a href="writeForm.do" style="color: black;">글쓰기</a></td>
            </tr>
            <tr>
               <td> <a href="myBoardView.do" style="color: black;">내가 쓴 글</a></td>
            </tr>
            <tr>
              <td>내가 쓴 댓글</td>
            </tr>
          </table>
        </div><!--첫째줄 첫번째 요소-->
        
        <!--첫째줄 두번째 요소-->
        <div class="col-lg-8" style="padding-right: 5rem">

          <h2 class="display-6" style="color: #183a1d; font-weight: bold"> 회원정보 조회 </h2>

          <div style="padding-top: 2rem; padding-bottom: 2rem;">
            <table class="table table-borderless">

              <tr>
                <td style="font-weight: bold; color: #183a1d;">아이디</td>
                <td>${member.id}</td>
              </tr>

              <tr>
                <td style="font-weight: bold; color: #183a1d;">이메일</td>
                <td>${member.email}</td>
              </tr>

              <tr>
                <td style="font-weight: bold; color: #183a1d;">이름</td>
                <td>${member.name}</td>
              </tr>

              <tr>
                <td style="font-weight: bold; color: #183a1d;">확인 질문</td>
                <td>${member.question}</td>
              </tr>

              <tr>
                <td style="font-weight: bold; color: #183a1d;">확인 질문 답</td>
                <td>${member.answer}</td>
              </tr>

            </table>
          </div>

          <div style="text-align: left;">
            <a class="btn btn-lg" onclick='location.href="updateInfoForm.do"' role="button" style="
            background-color: #183a1d;
            border: none;
            color: white;
          ">수정</a>
          &nbsp;
          <a class="btn btn-lg" onclick='location.href="delete.do?id=${member.id}"' role="button" style="
            background-color: #183a1d;
            border: none;
            color: white;
          ">탈퇴</a>
          </div>

        </div><!--첫째줄 두번째 요소-->

      </div><!--첫째줄-->



  </main>


  <!-- 중간부분 -->



  <footer class="col-lg-12"
    style="text-align: center ; padding-top: 10px; padding-bottom: 10px; background-color:#183a1d;">

  </footer>


  <!-- Bootstrap core JavaScript
    ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
    integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
    integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
    integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
    crossorigin="anonymous"></script>
</body>

</html>