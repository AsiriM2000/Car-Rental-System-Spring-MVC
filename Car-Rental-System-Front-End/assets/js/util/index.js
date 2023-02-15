function test(){
    const uname = document.getElementById('lusername').value;
    localStorage.setItem("UNAME",uname);
    window.location.href=""
    return;
}