<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <link rel="stylesheet" href="../resources/css/style.css">
    <!-- ${pageContext.request.contextPath}/resources/css/ -->
</head>
<body>
    <main>
        <header class="header">
            <div class="container">
                <nav class="header-navigation">
                    <ul class="header-navigation__list d-flex">
                        <li class="header-navigation__item">
                            <a href="#" class="header-navigation__link">Home</a>
                        </li>
                        <li class="header-navigation__item">
                            <a href="#" class="header-navigation__link">User</a>
                        </li>
                    </ul>
                    <ul class="header-hamburger__list">
                        <li class="header-hamburger__item">
                            <a href="#" class="header-hamburger__link">History testing</a>
                        </li>
                        <li class="header-hamburger__item">
                            <a href="#" class="header-hamburger__link">Admin</a>
                        </li>
                        <li class="header-hamburger__item">
                            <a href="#" class="header-hamburger__link">Log out</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </header>
        <section class="section main-section">
            <div class="container">
                <div class="home-page__title-wrapper">
                    <h1 class="page__main-title">
                        Test service
                    </h1>
                    <p class="page__text">
                        Select a category
                    </p>
                </div>

                <c:choose>
                <c:when test="${not empty categories}">
                    <div class="categories-list">
                        <c:forEach var="category" items="${categories}">

                            <div class="home-page__content-wrapper">
                                <div class="content-wrapper__topic-title d-flex">
                                    <h3 class="topic__name">
                                        ${category.name}
                                    </h3>
                                    <span class="topic__arrow">&xvee;</span>
                                </div>
                                <p class="page__text topic__text">
                                    ${category.description}
                                </p>
                                <ul class="topic__list">
                                    <li class="topic__item">
                                        <a href="#" class="topic__link">Test 1</a>
                                    </li>
                                    <li class="topic__item">
                                        <a href="#" class="topic__link">Test 2</a>
                                    </li>
                                </ul>
                            </div>
                        </c:forEach>
                    </div>
                </c:when>
                <c:otherwise>
                    <p>Категории не найдены</p>
                </c:otherwise>
                </c:choose>


            </div>
        </section>
    </main>
</body>
</html>