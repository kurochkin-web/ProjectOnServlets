<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Hello</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <main>
        <section class="section login-section start-section">
            <div class="container container-index">
                <h1 class="page__main-title">
                     Test service
                </h1>
                <p class="page__text">
                    Welcome to the world's best testing portal. This application was developed specifically for JavaRush.
                </p>
                <div class="button-wrapper d-flex">
                    <a href="${pageContext.request.contextPath}/login" class="page__link">Log in</a>
                    <a href="${pageContext.request.contextPath}/registration" class="page__link">Sign in</a>
                </div>
            </div>
        </section>
    </main>
</body>
</html>