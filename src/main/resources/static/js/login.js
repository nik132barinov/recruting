$(document).ready(function () {
    $(".email-signup").hide();
    $("#signup-box-link").click(function () {
        $(".email-login").fadeOut(100);
        $(".email-signup").delay(100).fadeIn(100);
        $("#login-box-link").removeClass("active");
        $("#signup-box-link").addClass("active");
    });
    $("#login-box-link").click(function () {
        $(".email-signup").fadeOut(100);
        $(".email-login").delay(100).fadeIn(100);
        $("#signup-box-link").removeClass("active");
        $("#login-box-link").addClass("active");
    });
});

let username = $("#username").val();
let password = $("#password").val();

function sendLoginRequest() {
    let req = new XMLHttpRequest();
    req.open("POST", "/login", true);
    req.addEventListener("load", function () {
        console.log(req);
    });
    let csrfToken = document.getElementsByName('_csrf_value')[0].getAttribute('content');
    req.setRequestHeader("X-CSRF-Token", csrfToken);
    json = {'login': "login", 'password': "password", 'email': "email"};
    req.send(JSON.stringify(json));
}

//todo: применить jquery к реквесту// ajax


// let testLogin = false;
// let testPassword = false;
// let testEmail = false;
//
// document.addEventListener('DOMContentLoaded', function () {
//     let ev = {
//         id: "toLogin"
//     };
//     ev.id = "toLogin";
// changeForm(ev);
//
// let loginForm = document.getElementById("loginForm");
// let regForm = document.getElementById("regForm");
//
// loginForm.addEventListener("keydown", function (event) {
//     if (event.keyCode === 13) {
//         doLogin();
//     }
// });
//
// regForm.addEventListener("keydown", function (event) {
//     if (event.keyCode === 13) {
//         doReg();
//     }
// });
//
//
// regForm.getElementsByTagName('input')[0].oninput = function () {
//     let login = regForm.getElementsByTagName('input')[0].value;
//     if (!(login.length >= 6 && login.length <= 45 && /^[a-zA-Z0-9][a-zA-Z0-9\-_]{5,}$/.test(login))) {
//         document.getElementById('reg_failed_login1').style.display = "block";
//         regForm.getElementsByTagName('input')[0].style.border = ".5px solid red";
//         testLogin = false;
//     } else {
//         document.getElementById('reg_failed_login1').style.display = "none";
//         regForm.getElementsByTagName('input')[0].style.border = "none";
//         testLogin = true;
//     }
// };
//
// regForm.getElementsByTagName('input')[1].oninput = function () {
//     let password = regForm.getElementsByTagName('input')[1].value;
//     if (!(password.length >= 6 && /^.*?$/.test(password))) {
//         document.getElementById('reg_failed_password1').style.display = "block";
//         regForm.getElementsByTagName('input')[1].style.border = ".5px solid red";
//         testPassword = false;
//     } else {
//         document.getElementById('reg_failed_password1').style.display = "none";
//         regForm.getElementsByTagName('input')[1].style.border = "none";
//         testPassword = true;
//     }
// };
//
// regForm.getElementsByTagName('input')[2].oninput = function () {
//     let email = regForm.getElementsByTagName('input')[2].value;
//     if (!(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email))) {
//         document.getElementById('reg_failed_email1').style.display = "block";
//         regForm.getElementsByTagName('input')[2].style.border = ".5px solid red";
//         testEmail = false;
//     } else {
//         document.getElementById('reg_failed_email1').style.display = "none";
//         regForm.getElementsByTagName('input')[2].style.border = "none";
//         testEmail = true;
//     }
// };
//
// if (window.location.search.indexOf("?login") !== -1){
//     let el = document.createElement("div");
//     el.setAttribute("id", "toLogin");
//     changeForm(el);
// }
// });
//
// function changeForm(ev) {
//     if (ev.id === "toLogin") {
//         document.getElementById('loginForm').style.display = 'block';
//         document.getElementById('regForm').style.display = 'none';
//     }
//     if (ev.id === "toRegistration") {
//         document.getElementById('loginForm').style.display = 'none';
//         document.getElementById('regForm').style.display = 'block';
//     }
// }
//
// function doReg() {
//     let form = document.getElementById('regForm');
//     let login = form.getElementsByTagName('input')[0].value;
//     let password = form.getElementsByTagName('input')[1].value;
//     let email = form.getElementsByTagName('input')[2].value;
//     let gender = form.getElementsByClassName('gender');
//     gender = gender[0].getElementsByTagName('input')[0].checked;
//
//     let rules = form.getElementsByClassName('gender innerGender');
//     rules = rules[0].getElementsByTagName('input')[0].checked;
//
//     if (testLogin && testPassword && testEmail) {
//         let reg = new XMLHttpRequest();
//         reg.open("POST", "/reg", true);
//         reg.addEventListener("load", function () {
//             if (reg.status === 200) {
//                 window.location.replace("/");
//             } else  { //if (reg.status === 400)
//                 let text = reg.responseText;
//                 text = JSON.parse(text);
//                 text = text.message;
//                 if (text === "Bad Login" || text === "Login already in use") {
//                     document.getElementById('reg_failed_login2').style.display = "block";
//                     form.getElementsByTagName('input')[0].style.border = ".5px solid red";
//                 } else {
//                     document.getElementById('reg_failed_login2').style.display = "none";
//                     form.getElementsByTagName('input')[0].style.border = "none";
//                 }
//                 if (text === "Bad Password") {
//                     document.getElementById('reg_failed_password2').style.display = "block";
//                     form.getElementsByTagName('input')[1].style.border = ".5px solid red";
//                 } else {
//                     document.getElementById('reg_failed_password2').style.display = "none";
//                     form.getElementsByTagName('input')[1].style.border = "none";
//                 }
//                 if (text === "Bad Email" || text === "Email already in use") {
//                     document.getElementById('reg_failed_email2').style.display = "block";
//                     form.getElementsByTagName('input')[2].style.border = ".5px solid red";
//                 } else {
//                     document.getElementById('reg_failed_email2').style.display = "none";
//                     form.getElementsByTagName('input')[2].style.border = "none";
//                 }
//                 if (text === "Bad Gender") {
//                     document.getElementById('reg_failed_gender2').style.display = "block";
//                     form.getElementsByClassName('gender')[0].style.border = ".5px solid red";
//                 } else {
//                     document.getElementById('reg_failed_gender2').style.display = "none";
//                     form.getElementsByClassName('gender')[0].style.border = "none";
//                 }
//                 if (text === "You must accept rules") {
//                     document.getElementById('reg_failed_rules2').style.display = "block";
//                     form.getElementsByClassName('gender')[1].style.border = ".5px solid red";
//                 } else {
//                     document.getElementById('reg_failed_rules2').style.display = "none";
//                     form.getElementsByClassName('gender')[1].style.border = "none";
//                 }
//                 wrongDoReg(form);
//             }
//         });
//         let csrfToken = document.getElementsByName('_csrf_value')[0].getAttribute('content');
//         reg.setRequestHeader("X-CSRF-Token", csrfToken);
//         json = {'login': login, 'password': password, 'email': email, 'gender': gender, 'rules': rules};
//         myJson = JSON.stringify(json);
//         reg.send(myJson);
//     } else {
//         event = new Event("input");
//         form.getElementsByTagName('input')[0].dispatchEvent(event);
//
//         event = new Event("input");
//         form.getElementsByTagName('input')[1].dispatchEvent(event);
//
//         event = new Event("input");
//         form.getElementsByTagName('input')[2].dispatchEvent(event);
//         wrongDoReg(form);
//     }
// }
//
// function doLogin() {
//     let form = document.getElementById('loginForm');
//     let login = form.getElementsByTagName('input')[0].value;
//     let password = form.getElementsByTagName('input')[1].value;
//     let remember = form.getElementsByTagName('input')[2].checked;
//
//     if (login.length > 0 && password.length > 0) {
//         let reg = new XMLHttpRequest();
//         reg.open("POST", "/login", true);
//         reg.addEventListener("load", function () {
//             if (reg.status === 200) {
//                 window.location.replace("/");
//             } else {
//                 wrongDoLogin(form);
//             }
//         });
//         let csrfToken = document.getElementsByName('_csrf_value')[0].getAttribute('content');
//         reg.setRequestHeader("X-CSRF-Token", csrfToken);
//         json = {'login': login, 'password': password, 'remember': remember};
//         myJson = JSON.stringify(json);
//         reg.send(myJson);
//     } else {
//         wrongDoLogin(form);
//     }
// }
//
// function wrongDoLogin(form) {
//     form.getElementsByClassName('button')[0].style.borderTop = "1px solid red";
//     form.getElementsByClassName('button')[0].style.borderBottom = "1px solid red";
//     form.getElementsByTagName('input')[0].style.border = ".5px solid red";
//     form.getElementsByTagName('input')[1].style.border = ".5px solid red";
//     document.getElementById('login_failed').style.display = "block";
// }
//
// function wrongDoReg(form) {
//     form.getElementsByClassName('button')[0].style.borderTop = "1px solid red";
//     form.getElementsByClassName('button')[0].style.borderBottom = "1px solid red";
// }

//######################################################################################################

// function validateForm() {
//     let firstPassword = document
//     let secondPassword = document.myForm.passwordTwo.value;
//     let emailID = document.myForm.email.value;
//     let alphaNumeric = /^[\w ]+$/;
//     let letters = /^[A-Za-z]+$/;
//     let atEmail = emailID.indexOf("@");
//     let dotEmail = emailID.lastIndexOf(".");
//     let phone = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
//
//     if(!alphaNumeric.test(document.myForm.userName.value)) {
//         alert( "Please enter letters and numbers only!" );
//         document.myForm.userName.focus() ;
//         return false;
//     }
//
//     if(firstPassword.value.length < 8) {
//         alert( "Password must be at least 8 characters" );
//         document.myForm.passwordOne.focus() ;
//         return false;
//     }
//
//     if(document.myForm.firstPassword.value !== document.myForm.secondPassword.value ) {
//         alert( "Password must match!" );
//         document.myForm.passwordTwo.focus() ;
//         return false;
//     }
//
//     if(!letters.match(document.myForm.firstName.value)) {
//         alert( "Your first name should only contain letters!" );
//         document.myForm.firstName.focus() ;
//         return false;
//     }
//
//     if(!letters.match(document.myForm.lastName.value)) {
//         alert( "Your last name should only contain letters!" );
//         document.myForm.lastName.focus() ;
//         return false;
//     }
//
//     if (atEmail < 1 || ( dotEmail - atEmail < 2 )) {
//         alert("Please enter valid email address format: xxx@xxx.xxx");
//         document.myForm.email.focus() ;
//         return false;
//     }
//
//     if(phonenumber.value.match(phone)) {
//         alert( "Please enter valid phone number format:(xxx) xxx-xxxx" );
//         document.myForm.phonenumber.focus() ;
//         return false;
//     }
//
//     if((document.myForm.signUpNewletter[0].checked === false) &&(document.myForm.signUpNewletter[1].checked === false )) {
//         alert( "Please check yes or no!" );
//         document.myForm.signUpNewsletter.focus() ;
//         return false;
//     }
//
//     return true;
//
// }
//
// if (isset($_POST['username']) && isset($_POST['password'])) {
//
// }