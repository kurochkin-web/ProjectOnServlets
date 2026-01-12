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

                                 <!-- Заголовок -->
                                <div class="content-wrapper__topic-title d-flex accordion-header">
                                    <h3 class="topic__name">
                                        ${category.name}
                                    </h3>
                                    <span class="topic__arrow">&#5125;</span>
                                </div>

                                <!-- Контент (по умолчанию скрыт) -->
                                <div class="accordion-content">
                                    <p class="page__text topic__text">
                                        ${category.description}
                                    </p>
                                    
                                    <ul class="topic__list">
                                        <c:forEach var="test" items="${tests}">
                                            <c:if test="${test.categoryId == category.id}">
                                                <li class="topic__item">
                                                    <a href="${pageContext.request.contextPath}/secure/test?id=${test.id}" class="topic__link">${test.name}</a>
                                                </li>
                                            </c:if>
                                        </c:forEach>
                                    </ul>
                                </div>
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
<script type="text/javascript">

    const accordionItems = document.querySelectorAll('.home-page__content-wrapper');

    if (accordionItems.length > 0) {
        const firstItem = accordionItems[0];
        const firstContent = firstItem.querySelector('.accordion-content');

        firstItem.classList.add('active');
        firstContent.style.height = firstContent.scrollHeight + 'px';
    }

    accordionItems.forEach(item => {

    const content = item.querySelector('.accordion-content');

    item.addEventListener('click', () => {

    const isActive = item.classList.contains('active');

    // закрываем все
    accordionItems.forEach(i => {
      i.classList.remove('active');
      i.querySelector('.accordion-content').style.height = '0px';
    });

    // если кликнули не по активному — открываем
    if (!isActive) {
      item.classList.add('active');
      content.style.height = content.scrollHeight + 'px';
    }

  });
});

</script>
</html>