function show(){
  var x=document.getElementById("project");
  var y=document.getElementById("showBtn");
  if (window.getComputedStyle(x).display === "none") {
    x.style.display = "block";
    y.value="Less";
  }
  else{
    x.style.display="none";
    y.value="More";
  }
}
/*Navigation Bar*/
$(document).on('click','.nav-link', function(event) {
    //sevent.preventDefault();
    /*var naviLinks=document.getElementsByClassName("nav-link");*/
    var target = "#" + this.getAttribute('data-target');
    clickedLink=this.getAttribute('data-target');
    $('html, body').animate({
        scrollTop: $(target).offset().top- $('.navbar').height()
    }, 2000);
    $("#collapsibleNavbar").addClass("collapsing");
    $("#collapsibleNavbar").removeClass("collapsing");
    $("#collapsibleNavbar").removeClass("show");
    /*changeStyle();
    function changeStyle(){
      var linksArr= ["Info","Myself","Experience","Education","Skills"];
      var preLink=document.getElementById("hidden").value;
      var a=linksArr.indexOf(clickedLink);
      var b=document.getElementsByClassName("nav-link");
      console.log(a);
      for (var i = 0; i < linksArr.length; i++) {
        for (var j = 0; j < b.length; j++) {
          if(b[j].getAttribute['data-target']==)
        }
      }
    }*/
});