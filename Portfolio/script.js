"use strict";
//Change Nav Link Style
const navLinks = document.querySelector(".nav-list");
const navHeight = document.querySelector(".nav-wrapper").clientHeight;
navLinks.addEventListener("click", function (e) {
  const clicked = e.target.closest(".nav-link");
  console.log(clicked.href);
  const tempArray = clicked.href.split("#");
  const finalKey = tempArray[1];
  console.log(finalKey);
  let element = document.getElementById(finalKey);
  console.log(element);
  var rect = element.getBoundingClientRect().top;
  console.log(rect);
  console.log("Navbar Height", navHeight);
  window.scrollTo(rect + navHeight + navHeight, 0);
  //Remove active class
  if (clicked) {
    navLink.forEach(function (t) {
      t.classList.remove("active");
    });
    clicked.classList.add("active");
  }
});

//SmoothScrolling

//Navbar Responsive
let hamburger = document.querySelector(".hamburger");
let mobileNav = document.querySelector(".nav-list");
const navLink = document.querySelectorAll(".nav-link");
const openMenu = function () {
  mobileNav.classList.toggle("open");
};

function addRequiredClass() {
  if (window.innerWidth < 769) {
    document.body.classList.add("mobile");
  } else {
    document.body.classList.remove("mobile");
    mobileNav.classList.remove("open");
  }
}
window.onload = addRequiredClass;
window.addEventListener("resize", function () {
  addRequiredClass();
});

/*To Hide Show usig Hamburger */
hamburger.addEventListener("click", openMenu);
let links = document.querySelectorAll("a");
links.forEach((el) => {
  el.addEventListener("click", openMenu);
});

//Modal Data Object
const jobs = [
  {
    id: "here",
    logo: "img/here.jpg",
    companyName: "Here Technologies Pvt. Ltd.",
    location: "Airoli, Mumbai",
    designation: "Spatial Data Specialist",
    dateOfJoin: "June 2019",
    dateOfLeaving: "Present",
    yearOfExperience: "3 Years",
    role: [
      "Responsible for analysing and editing Geo-Spatial Data points in Highly Automated Driving (HAD) project",
      "Creating and maintaining an internal team performance dashboard",
      "Working with agile methodologies practices including Agile, Scrum using tools such as JIRA and Confluence",
      "Maintained high discipline and norm adherence, coordinated with superiors of Quality teams, and provided innovative suggestions to improve operational functioning of the internal team",
      "Part of DEO Developer Community from January 2021",
      "Created highly responsive user interfaces ensuring best experience on various screen sizes",
      "Maintained Validations using Java based Code",
    ],
  },
  {
    id: "techflux",
    logo: "img/techflux.jfif",
    companyName: "Techflux (a Division of Renam Technologies pvt. ltd.)",
    location: "Vashi, Mumbai",
    designation: "Software Developer",
    dateOfJoin: "January 2018",
    dateOfLeaving: "July 2018",
    yearOfExperience: "6 months",
    role: [
      "Webapp Development on “Bubble.is” Platform. Customizing those using Web Technologies (HTML, CSS, JavaScript)",
      "Converted designs & wireframes to high quality UI code",
      "Planning and Conceptualizing product",
    ],
  },
  {
    id: "abhaytech",
    logo: "img/abhay.png",
    companyName: "Abhay Tech Solutions LLP",
    location: "Marol, Mumbai",
    designation: "Internship Trainee",
    dateOfJoin: "July 2017",
    dateOfLeaving: "September 2017",
    yearOfExperience: "3 months",
    role: ["Designed UML Structure for Existing and Future Project"],
  },
];
//Show Data in Modal
var modal = document.getElementById("myModal");
var span = document.getElementsByClassName("close")[0];
// When the user clicks on the button, open the modal
const moreDetails = document.querySelectorAll(".buttons");
const card = document.querySelector(".cards");
const companyInfo = document.querySelector(".company-info");
const descriptionList = document.querySelector(".description");
card.addEventListener("click", function (e) {
  const searchKey = e.target.closest(".primary");
  console.log(searchKey.name);
  //Display comapny info
  let companyDetails = jobs.find((o) => o.id === searchKey.name);
  companyInfo.innerHTML = "";
  //create html element
  const html = `
  <div class="info-container company-info">
    <div class="left">
      <img class="round" src="${companyDetails.logo}" alt="user" />
    </div>
    <div class="right">
      <h2>${companyDetails.companyName}, ${companyDetails.location}</h2>
      <h5>${companyDetails.designation}</h5>
      <h6>${companyDetails.dateOfJoin} to ${companyDetails.dateOfLeaving} (${companyDetails.yearOfExperience})</h6>
    </div>
  </div>`;
  companyInfo.insertAdjacentHTML("afterbegin", html);

  //Display job description
  var roleLength = companyDetails.role.length;
  descriptionList.innerHTML = "";
  for (let i = 0; i < roleLength; i++) {
    var li = document.createElement("li");
    li.innerHTML = companyDetails.role[i];
    descriptionList.appendChild(li);
  }

  modal.style.display = "block";
});
span.onclick = function () {
  modal.style.display = "none";
};
window.onclick = function (event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
};

//Tabbed Component
const btns = document.querySelectorAll(".btn__tab");
const btnsTab = document.querySelector(".btn__tab-container");
const eduTabs = document.querySelectorAll(".education-content");
btnsTab.addEventListener("click", function (e) {
  const clicked = e.target.closest(".btn__tab");
  if (clicked) {
    //Remove active class
    btns.forEach(function (t) {
      t.classList.remove("btn__tab-active");
    });
    eduTabs.forEach(function (t) {
      t.classList.remove("education-content--active");
    });
    clicked.classList.add("btn__tab-active");
    document
      .querySelector(`.education-content-${clicked.dataset.tab}`)
      .classList.add("education-content--active");
  }
});

//Skills Animation
(function () {
  var SkillsBar = function (bars) {
    this.bars = document.querySelectorAll(bars);
    if (this.bars.length > 0) {
      this.init();
    }
  };

  SkillsBar.prototype = {
    init: function () {
      var self = this;
      self.index = -1;
      self.timer = setTimeout(function () {
        self.action();
      }, 500);
    },
    select: function (n) {
      var self = this,
        bar = self.bars[n];

      if (bar) {
        var width = bar.parentNode.dataset.percent;

        bar.style.width = width;
        bar.parentNode.classList.add("complete");
      }
    },
    action: function () {
      var self = this;
      self.index++;
      if (self.index == self.bars.length) {
        clearTimeout(self.timer);
      } else {
        self.select(self.index);
      }

      setTimeout(function () {
        self.action();
      }, 500);
    },
  };

  window.SkillsBar = SkillsBar;
})();

(function () {
  document.addEventListener("DOMContentLoaded", function () {
    var skills = new SkillsBar(".skillbar-bar");
  });
})();
