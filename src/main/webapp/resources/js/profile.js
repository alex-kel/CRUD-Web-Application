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
        var dataString = $('#update').serialize();
        $.ajax({
            contentType: "application/x-www-form-urlencoded",
            url: 'profile',
            type: 'PUT',
            data: dataString,
            success: function (result) {
                $('.preloader').hide();
                alert("User successfully updated");
                window.location.reload();
            },
            error: function (xhr, status) {
                alert(xhr.responseText)
                $('.preloader').hide();
            }
        });
    });
});