$(document).ajaxSend(function (event, xhr, options) {
    xhr.setRequestHeader("user_token", localStorage.getItem("token"));
});

$(document).ajaxError(function (event, xhr, options, exc) {
    if (xhr.status == 401) {
        localStorage.removeItem('id');
        localStorage.removeItem('token');
        location.href = "login.html";
    }
})