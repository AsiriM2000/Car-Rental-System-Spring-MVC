window.addEventListener('load',()=>{
    const param  = (new URL(document.location)).searchParams;
    const uname = param.get('lusername');

    document.getElementById('emailLoad').innerHTML = uname;

})