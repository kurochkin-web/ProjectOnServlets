document.addEventListener("DOMContentLoaded", () => {

    const items = document.querySelectorAll(".home-page__content-wrapper");

    items.forEach(item => {
        const header = item.querySelector(".accordion-header");

        header.addEventListener("click", () => {

            // если кликнули уже открытую — просто закроем
            const isActive = item.classList.contains("active");

            // закрываем все
            items.forEach(i => i.classList.remove("active"));

            // если была закрыта — открываем
            if (!isActive) {
                item.classList.add("active");
            }
        });
    });

});