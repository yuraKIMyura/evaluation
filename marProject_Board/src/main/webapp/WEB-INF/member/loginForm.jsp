<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>


<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="icon" href="${pageContext.request.contextPath}/resources/img/chat.png" />

  <title>BLABBER | 로그인 </title>

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous" />

  <!-- Custom styles for this template -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/loginForm.css" type="text/css">
  
  
</head>

<body class="text-center">
  <div class="background" style="background-image: url('resources/img/back.gif')">
    <form class="form-signin" action="login.do" method="post">
      <img class="mb-4" src="${pageContext.request.contextPath}/resources/img/chat.png" alt="logo" width="150" height="150">
      <h1 class="h3 mb-3 font-weight-bold" style="padding-bottom: 2rem">BLABBER</h1>

      <label for="inputId" class="sr-only">아이디</label>
      <input type="text" class="form-control" placeholder="아이디 " name="id" required>
      

      <label for="inputEmail" class="sr-only">이메일</label>
      <input type="email" class="form-control" placeholder="이메일" name="email" required>
	  

      <div class="checkbox mb-3" style="padding-top: 1rem; padding-bottom: 0.5rem">
        <label style="font-size: small;">
          <input type="checkbox" value="remember-me"> 로그인 정보 기억하기
        </label>
      </div>
      
      <button class="btn btn-md btn-primary btn-block" type="submit"
        style="background-color:#f6c453; border: none; font-size: large;">로그인</button>

	  </form>
    
		<div style="padding-top: 2rem; padding-bottom: 2rem">
		  <form action="joinForm.do" method="post">
		    <button type="submit" style="border: none; background: none; padding: 0; font-weight: bold; color: #b38e39; cursor: pointer;">
		      회원가입
		    </button>
		  </form>
		</div>

  </div>



</body>

</html>