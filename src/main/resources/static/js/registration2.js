$(function () {

    $("#signup_btn").click(function () {
        $("#signup_btn").hide();


        let name = $("#name").val();
        let surname = $("#surname").val();
        let username = $("#username").val();
        let email = $("#email").val();
        let password = $("#password").val();

        $.get("login.html", { name: name, surname: surname, username: username, email: email, password: password})
            //Тут нужен POST или GET?
            .done(function ( data ) {
                if (data == "success") {
                    window.location = "login.html";
                } else  {
                    // $("#signup_message").text("Invalid Username or Password! Try Again.");
                    $("#signup_btn").show();
                }

            });
    });

});

function sendRegistrationRequest() {
    let request = new XMLHttpRequest();
    request.open("GET", "/login", true);
    request.addEventListener("load", function () {
        console.log(request);
    });
    let csrfToken = document.getElementsByName('_csrf_value')[0].getAttribute('content');
    req.setRequestHeader("X-CSRF-Token", csrfToken);
    json = {'name': "name",'surname': "surname", 'username': "username", 'email': "email", 'password': "password", };
    req.send(JSON.stringify(json));

}

const form = {
    name: document.getElementById('name'),
    surname: document.getElementById('surname'),
    username: document.getElementById('username'),
    email: document.getElementById('email'),
    password: document.getElementById('password'),
    signup: document.getElementById('signup_btn')

};
form.signup.addEventListener('click', () => {
console.log('button pressed!');
});