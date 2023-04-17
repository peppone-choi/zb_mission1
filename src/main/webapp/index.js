let lat;
let lnt;

$(function() {
    fnInit();
});



function fnInit(){
    var cookieidlat = get_cookie("latCookie");
    var cookieidlnt = get_cookie("lntCookie");
    console.log(cookieidlnt + "" + cookieidlat);
    if(cookieidlnt != ""){
        $(".lat").attr("value", cookieidlat);
        $(".lnt").attr("value", cookieidlnt);
    }
}




navigator.geolocation.getCurrentPosition(function(pos) {
    console.log(pos);
    lat = pos.coords.latitude;
    lnt = pos.coords.longitude;
});

function getPosition() {
    deleteCookie('name');
    $(".lat").attr("value", lat);
    $(".lnt").attr("value", lnt);
    setInstantCookie("latCookie", lat);
    setInstantCookie("lntCookie", lnt);
}


function setInstantCookie(name, value){
    document.cookie = name + "=" + value;
}

function get_cookie(name) {
    var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
    return value? value[2] : null;
}

var deleteCookie = function(name) {
    document.cookie = name + '=; expires=Thu, 01 Jan 1999 00:00:10 GMT;';
}