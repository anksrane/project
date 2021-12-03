let hamburger=document.querySelector('.hamburger');
let mobileNav=document.querySelector('.nav-list');
const openMenu=function(){mobileNav.classList.toggle('open');};
function addRequiredClass(){
    if(window.innerWidth<769){
        document.body.classList.add('mobile');
    }
    else{
        document.body.classList.remove('mobile');
        mobileNav.classList.remove('open')
    }
}
window.onload=addRequiredClass;
window.addEventListener('resize', function(){
    addRequiredClass();
})

/*To Hide Show usig Hamburger */
hamburger.addEventListener('click',openMenu);
let links = document.querySelectorAll('.nav-link');
links.forEach(el=>{
    el.addEventListener('click',openMenu);
});

/*To Create Counter Effect*/
var windowHeight=window.innerHeight;
var counters=document.querySelectorAll('.counter-no');
function init(){
    var windowHeight=window.innerHeight;
}
function runCounter(){
    counters.forEach(counter=>{
        var updateCount=()=>{
            var target=+counter.getAttribute('data-target');
            var speed=target;
            var count=+counter.innerText;
            var inc=target/speed;
    
            if(count<target){
                counter.innerText=count+inc;
                setTimeout(updateCount,150)
            }else{
                let a=Math.round(target);
                count.innerText=target;
            }
        }
        updateCount();
    });
}
/*To Run Counter Effect Only Once Scroll to that Position */
function checkPosition(){
    for (var i = 0; i < counters.length; i++) {
        var element = counters[i];
        var positionFromTop = counters[i].getBoundingClientRect().top;
  
        if (positionFromTop - windowHeight <= 0) {
            runCounter();
        }
      }
}
window.addEventListener('scroll', checkPosition);
window.addEventListener('resize', init);

