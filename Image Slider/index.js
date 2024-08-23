//IMAGE SLIDER

const slides = document.querySelectorAll(".slides img");
const navDots = document.querySelectorAll(".slider-nav a");
let slideIndex = 0;
let intervalId = null;

document.addEventListener("DOMContentLoaded",initializeSilder);

function initializeSilder(){
    if(slides.length>0){
    slides[slideIndex].classList.add("displaySlide");
    navDots[slideIndex].classList.add("active");
    startAutoSlide();

    navDots.forEach((dot, index) =>{
        dot.addEventListener("click",() => {
            showSlide(index);
            resetInterval();
        });
    });
    }
}
function startAutoSlide(){
    intervalId = setInterval(nextSlide, 5000);
}
function resetInterval(){
    clearInterval(intervalId);
    startAutoSlide();
}
function showSlide(index){
    if(index>=slides.length){
        slideIndex = 0;
    }
    else if(index < 0){
        slideIndex = slides.length - 1 ;
    } 
    else{
        slideIndex = index ;
    }

    slides.forEach(slide => {
        slide.classList.remove("displaySlide");
    });
    navDots.forEach(dot => {
        dot.classList.remove("active");
    });

    slides[slideIndex].classList.add("displaySlide");
    navDots[slideIndex].classList.add("active");
}

function prevSlide(){
    slideIndex--;
    showSlide(slideIndex);
    resetInterval();
}

function nextSlide(){
    slideIndex++;
    showSlide(slideIndex);
    // resetInterval();
}