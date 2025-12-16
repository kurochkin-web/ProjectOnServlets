/*'use strict'*/

const accordionItems = document.querySelectorAll('.home-page__content-wrapper'),
      accordionArrow = document.querySelectorAll('.accordion-content');

  accordionItems.forEach(function(item, n) {

    item.addEventListener('click', function() {

      if(!item.parentNode.classList.contains('active')){
        for (let i = 0; i < accordionItems.length; i++) {
          accordionItems[i].parentNode.classList.remove('active');
        };
        item.parentNode.classList.add('active');
      };
    });
  });