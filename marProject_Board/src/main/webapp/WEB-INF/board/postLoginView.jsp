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


  <title>BLABBER</title>
</head>





<body style="background-color: #fefbe9; ">

  <!--NAVBAR-->
  <header>
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top" style="background-color: #f6c453; font-weight:bold">
      <a class="navbar-brand" href="mainView.do"><img src="${pageContext.request.contextPath}/resources/img/chat.png" alt="logo" style="width: 45px" /></a>
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
            <a class="nav-link" href="#">인기</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">베스트</a>
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
  <button class="btn btn-sm btn-outline-light" style="background-color: #cba242; border: none">로그아웃</button>
</a>
      </div>
    </nav>
  </header>



  <!--main-->
  <main style="padding-top: 10rem;">
	<!--0-->
    <div class="container col-lg-11" style="background-color: #fefbe9; padding-bottom:5rem">

      <div class="row">
        <!--첫번째 요소-->
        <div class="col-lg-2" style="padding-right: 10rem">
          <h4 class="display-6" style="color: #f6c453; font-weight: bold;">안녕하세요, ${id}님 </h4>
          <table class="table">

            <tr>
              <td> <a href="readInfoView.do" style="color: black;">내 정보</a></td>
            </tr>

            <tr>
              <td> <a href="writeForm.do" style="color: black;">글쓰기</a></td>
            </tr>
            <tr>
               <td> <a href="myBoardView.do" style="color: black;">내가 쓴 글</a></td>
            </tr>
            <tr>
              <td>내가 쓴 댓글</td>
            </tr>
          </table>
     
          
        </div><!--첫째줄 첫번째 요소-->
        <!--첫째줄 두번째 요소-->
        <div class="col-lg-4" style="padding-right: 5rem">
          <a onclick='location.href="allBoardView.do"' style="text-decoration: none;">
            <h2 class="display-6" style="color: #f6c453; font-weight: bold">📦 전체게시판</h2>
          </a>
          <table class="table table-hover">
            <tbody>
            	<c:forEach var="boardDao" items="${allList}">
              <tr>
                <th scope="row">${boardDao.type}</th>
                <td>
				<a href="readView.do?boardno=${boardDao.boardno}&hits=true" style="color: black">${boardDao.title}</a>
                </td>
                <td>👀${boardDao.hits}</td>
                <td>👍${boardDao.recommends}</td>
              </tr>
              </c:forEach>
            </tbody>
          </table>
          <p>
            <a href="allBoardView.do" class=" btn btn-warning" href="#" role="button" style="
                      background-color: #f6c453;
                      border: none;
                      color: white;
                    " ">전체게시판 더보기 &raquo;</a>
          </p>
        </div><!--0째줄 두번째 요소-->
        <!--0째줄 세번째 요소-->
        <div class=" col-lg-4" style="padding-right: 5rem">
              
        </div><!--0째줄 세번째 요소-->
        <!--0째줄 네번째 요소-->
        <div class="col-lg-2" style="padding-right: 10rem">
          <table class="table">
            
            <tr>
              <td>광고</td>
            </tr>

          </table>
        </div><!--0째줄 첫번째 요소-->
      </div>
    </div><!--0째줄-->




<%--     <!--첫째줄-->
    <div class="container col-lg-11" style="background-color: #fefbe9; padding-bottom:5rem">

      <div class="row">
        <!--첫번째 요소-->
        <div class="col-lg-2" style="padding-right: 10rem">
          <table class="table">
             <tr>
              <td>광고</td>
            </tr>
          </table>
        </div><!--첫째줄 첫번째 요소-->
        <!--첫째줄 두번째 요소-->
        <div class="col-lg-4" style="padding-right: 5rem">
          <a href="popularBoardView.html" style="text-decoration: none;">
            <h2 class="display-6" style="color: #f6c453; font-weight: bold">🔥 인기게시판</h2>
          </a>
          <table class="table table-hover">
            <tbody>
            	<c:forEach var="boardDao" items="${popularList}">
              <tr>
                <th scope="row">${boardDao.type}</th>
                <td>
				${boardDao.title}
                </td>
                <td>👀${boardDao.hits}</td>
                <td>👍${boardDao.recommends}</td>
              </tr>
              </c:forEach>
            </tbody>
          </table>
          <p>
            <a href="popularBoardView.html" class=" btn btn-warning" href="#" role="button" style="
                      background-color: #f6c453;
                      border: none;
                      color: white;
                    " ">인기게시판 더보기 &raquo;</a>
          </p>
        </div><!--첫째줄 두번째 요소-->
        <!--첫째줄 세번째 요소-->
        <div class=" col-lg-4" style="padding-right: 5rem">
              <a href="bestBoardView.html" style="text-decoration: none;">
                <h2 class="display-6" style="color: #f6c453; font-weight: bold">👑 베스트게시판</h2>
              </a>
              <table class="table table-hover">
            <tbody>
            	<c:forEach var="boardDao" items="${bestList}">
              <tr>
                <th scope="row">${boardDao.type}</th>
                <td>
				${boardDao.title}
                </td>
                <td>👀${boardDao.hits}</td>
                <td>👍${boardDao.recommends}</td>
              </tr>
              </c:forEach>
            </tbody>
          </table>
              <p>
                <a href="bestBoardView.html" class="btn btn-warning" href="#" role="button" style="
                      background-color: #f6c453;
                      border: none;
                      color: white;
                    ">베스트게시판 더보기 &raquo;</a>
              </p>
        </div><!--첫째줄 세번째 요소-->
        <!--첫째줄 네번째 요소-->
        <div class="col-lg-2" style="padding-right: 10rem">
          <table class="table">
            
            <tr>
              <td>광고</td>
            </tr>

          </table>
        </div><!--첫째줄 첫번째 요소-->
      </div>
    </div><!--첫째줄--> --%>


<%--     <!--둘째줄-->
    <div class="container col-lg-11" style="background-color: #fefbe9; padding-bottom:5rem">

      <div class="row">
        <!--둘째줄 첫번째 요소-->
        <div class="col-lg-2" style="padding-right: 10rem">
          <table class="table">
             <tr>
              <td>광고</td>
            </tr>
          </table>
        </div><!--둘째줄 첫번째 요소-->
        <!--둘째줄 두번째 요소-->
        <div class="col-lg-4" style="padding-right: 5rem">
          <h2 class="display-6" style="color: #183a1d; font-weight: bold">🥸 익명게시판</h2>
               <table class="table table-hover">
            <tbody>
            	<c:forEach var="boardDao" items="${anonymousList}">
              <tr>
                <td>${boardDao.title}</td>
                <td>👀${boardDao.hits}</td>
                <td>👍${boardDao.recommends}</td>
              </tr>
              </c:forEach>
            </tbody>
          </table>
          <p>
            <a class="btn btn-warning" href="#" role="button" style="
                          background-color: #183a1d;
                          border: none;
                          color: white;
                        ">익명게시판 더보기 &raquo;</a>
          </p>
        </div><!--둘째줄 두번째 요소-->
        <!--둘째줄 세번째 요소-->
        <div class="col-lg-4" style="padding-right: 5rem">
          <h2 class="display-6" style="color: #183a1d; font-weight: bold">🤪 자유게시판</h2>
               <table class="table table-hover">
            <tbody>
            	<c:forEach var="boardDao" items="${freeList}">
              <tr>
 	            <td>${boardDao.memberno}</td>
                <td>${boardDao.title}</td>
                <td>👀${boardDao.hits}</td>
                <td>👍${boardDao.recommends}</td>
              </tr>
              </c:forEach>
            </tbody>
          </table>
          <p>
            <a class="btn btn-warning" href="#" role="button" style="
                          background-color: #183a1d;
                          border: none;
                          color: white;
                        ">자유게시판 더보기 &raquo;</a>
          </p>
        </div><!--둘째줄 세번째 요소-->
        <!--둘째줄 네번째 요소-->
        <div class="col-lg-2" style="padding-right: 10rem">
          <table class="table">
            <tr>
              <td>광고</td>
            </tr>

          </table>
        </div><!--둘째줄 첫번째 요소-->
      </div>
    </div><!--둘째줄-->
 --%>

  </main>




  <footer class="col-lg-12"
    style="text-align: center ; padding-top: 10px; padding-bottom: 10px; background-color:#f6c453;">

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