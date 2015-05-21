$(document).ready(function () {
    $('#delete').submit(function (event) {
        event.preventDefault();
        var confirmed = confirm("Are you sure?");
        if (!confirmed) {
            return;
        }
        $('.preloader').show();
        $.ajax({
            url: 'profile',
            type: 'DELETE',
            success: function (result) {
                $('.preloader').hide();
                alert("User successfully deleted");
                window.location.reload();
            },
            error: function (xhr, status) {
                if (xhr.status == 504) {
                    alert(xhr.responseText);
                    $('.preloader').hide();
                }
            }
        });
    });

    $('#update').submit(function (event) {
        event.preventDefault();
        $('.preloader').show();
        var login = $("#login").val();
        var password = $("#password").val();
        var firstName = $("#firstName").val();
        var lastName = $("#lastName").val();
        $.ajax({
            contentType: "application/json",
            url: 'profile',
            type: 'PUT',
            dataType: "json",
            data: JSON.stringify({
                "login": login,
                "password": password,
                "firstName": firstName,
                "lastName": lastName
            }),
            complete: function (xhr, status) {
                alert(xhr.responseText)
                $('.preloader').hide();
                window.location.reload();
            }
        });
    });
});