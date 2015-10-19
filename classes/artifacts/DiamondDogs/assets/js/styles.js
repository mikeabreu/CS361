$j = jQuery.noConflict();
$j(function () {
    var success = Cookies.get('success');
    if (success === 'true') {
        $j("#wrapper #user-success").css("display", "block");
        Cookies.remove('success');
    }
});