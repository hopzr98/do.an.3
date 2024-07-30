$(document).ready(function(){
    var currentSlideIndex = 0;
    var slideCount = $(".panel").length;
    var isAnimating = false;

    function showSlide(index) {
        $(".panel").fadeOut("slow");
        $(".panel").eq(index).fadeIn("slow")
    }

    function nextSlide() {
        currentSlideIndex++;
        if (currentSlideIndex >= slideCount) {
            currentSlideIndex = 0;
        }
        showSlide(currentSlideIndex);
    }

    function previousSlide() {
        currentSlideIndex--;
        if (currentSlideIndex < 0) {
            currentSlideIndex = slideCount - 1;
        }
        showSlide(currentSlideIndex);
    }

    $("#flip").click(function(){
        if (!isAnimating) {
            previousSlide();
        }
    });

    $("#flop").click(function(){
        if (!isAnimating) {
            nextSlide();
        }
    });

    setInterval(function() {
        if (!isAnimating) {
            nextSlide();
        }
    }, 4000);

    $('.uu li').click(function(){
        var index = $(this).index();
        if(index !== currentSlideIndex){
            showSlide(index);
            currentSlideIndex = index;
            // $(this).css("background-color: black")
        }
    });
});
// $(document).ready(function() {
//     setInterval(function() {
//         var firstItem = $('.container-promotion .goods:first');
//         $('.container-promotion').append(firstItem);
//     }, 5000);
//     });
$(document).ready(function() {
    var previousScroll = $(window).scrollTop();

    $(window).scroll(function() {
        var currentScroll = $(this).scrollTop();

        if (currentScroll > previousScroll) {
            $('.header').addClass('scrolled');
        } else {
            $('.header').removeClass('scrolled');
        }
        setTimeout(function() {
                $('.header').removeClass('scrolled');
        }, 300);
        previousScroll = currentScroll;
    });
});
//Menu con
$(document).ready(function() {
    $('.has-submenu').hover(
        function() {
            $(this).find('.submenu').css('display', 'block');
        },
        function() {
            $(this).find('.submenu').css('display', 'none');
        }
    );
});
$(document).ready(function() {
    $('.chose-memory').click(function() {
      $('.check-radio-memory').prop('checked', false);
      $(this).find('.check-radio-memory').prop('checked', true);
    });
    $('.chose-color').click(function() {
        $('.check-radio-color').prop('checked', false);
        $(this).find('.check-radio-color').prop('checked', true);
      });
  });
