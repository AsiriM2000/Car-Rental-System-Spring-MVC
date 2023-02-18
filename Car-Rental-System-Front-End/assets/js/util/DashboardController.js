$("#home").click(function () {
    $("#dashboardContent").css("display","inline")
    $("#customerContent").css("display","none")
    $("#itemContent").css("display","none")
    $("#driverContent").css("display","none")
    $("#orderDetailContent").css("display","none")
});

$("#customer").click(function () {
    $("#dashboardContent").css("display","none")
    $("#customerContent").css("display","flex")
    $("#itemContent").css("display","none")
    $("#driverContent").css("display","none")
    $("#orderDetailContent").css("display","none")
});

$("#item").click(function () {
    $("#dashboardContent").css("display","none")
    $("#customerContent").css("display","none")
    $("#itemContent").css("display","flex")
    $("#driverContent").css("display","none")
    $("#orderDetailContent").css("display","none");
});

$("#driver").click(function () {
    $("#dashboardContent").css("display","none")
    $("#customerContent").css("display","none")
    $("#itemContent").css("display","none")
    $("#driverContent").css("display","flex")
    $("#orderDetailContent").css("display","none");
});

$("#order-Detail").click(function () {
    $("#dashboardContent").css("display","none")
    $("#customerContent").css("display","none")
    $("#itemContent").css("display","none")
    $("#driverContent").css("display","none")
    $("#orderDetailContent").css("display","flex");
});

