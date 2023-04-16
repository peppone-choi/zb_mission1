
let lat;
let lnt;

navigator.geolocation.getCurrentPosition(function(pos) {
    console.log(pos);
    lat = pos.coords.latitude;
    lnt = pos.coords.longitude;
});

function getPosition() {
    $(".lat").attr("value", lat);
    $(".lnt").attr("value", lnt);
}
