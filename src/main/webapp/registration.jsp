<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Registration</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">>
</head>
<body>
    <main>
        <section class="section start-section registration-section">
            <div class="container">
                <div class="page__wrapper page__wrapper-registration d-flex">
                    <div class="page__wrapper-box">
                        <h1 class="page__main-title">
                            Registration
                        </h1>
                        <p class="page__text">
                            for the test service developed by Artem Kurochkin on behalf of Java Rush
                        </p>
                    </div>
                    <div class="page__wrapper-box box-form">
                        <h2 class="form__title form__title-registation">
                            Registration
                        </h2>

                         <!-- Error massage -->
                        <c:if test="${not empty errorMessage}">
                            <span class="errorMessage">
                                ${errorMessage}
                            </span>
                        </c:if>

                        <form action="registration" method="post" class="form">
                            <div class="form__group">
                                <input type="text" name="login" required class="form__input form__input-registration">
                                <label class="form__label-registration">Your login</label>
                            </div>
                            <div class="form__group">
                                <input type="password" name="password" required class="form__input form__input-registration">
                                <label class="form__label-registration">Your password</label>
                            </div>
                            <button type="submit" class="btn registration-btn">Registration</button>
                        </form>
                        <p class="login-box__support-text">
                           If you have an account, you can 
                            <a href="login.jsp" class="box__link box__link-registration">log in</a>.
                        </p>
                    </div>
                </div>
            </div>
        </section>
    </main>
</body>
</html>