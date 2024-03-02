<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="icon" href="${pageContext.request.contextPath}/resources/img/chat.png" />

  <title>BLABBER | 회원가입 </title>

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous" />

  <!-- Custom styles for this template -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/joinMemberForm.css" type="text/css">
</head>

<body class="text-center">
  <div class="background">

    <h1 class="h2 mb-3 font-weight-bold" style="padding-bottom: 2rem">만나서 반가워요!</h1>

    <form class="form-signin" action="join.do" method="post">

      <img class="mb-4" src="${pageContext.request.contextPath}/resources/img/chat.png" alt="logo" width="150" height="150">
      <h1 class="h4 mb-3 font-weight-bold" style="padding-bottom: 2rem">BLABBER</h1>

      <div class="form-group">
        <label>아이디
          <input type="text" class="form-control" placeholder="아이디" name="id" required></label>
      </div>

      <div class="form-group">
        <label>이메일
          <input type="email" class="form-control" placeholder="이메일" name="email" required></label>
      </div>

      <div class="form-group">
        <label>이름
          <input type="text" class="form-control" placeholder="이름" name="name" required></label>
      </div>


      <div class="form-group">
        <label>본인 확인 질문
          <input type="text" class="form-control" placeholder="본인 확인 질문" name="question" required></label>
      </div>

      <div class="form-group">
        <label>본인 확인 질문 답
          <input type="text" class="form-control" placeholder="본인 확인 질문 답" name="answer" required></label>
      </div>

      <div style="padding-top:2rem">
        <button class="btn btn-md btn-primary btn-block" type="submit"
          style="background-color:#f6c453; border: none; font-size: large;">회원가입</button>
      </div>
    </form>
  </div>
</body>

</html>