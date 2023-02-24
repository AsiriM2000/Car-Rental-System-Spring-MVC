$("#email").focus();

const cusEmailRegEx = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
const cusNameRegEx = /^[A-z ]{5,20}$/;
const cusAddressRegEx = /^[0-9/A-z. ,]{7,}$/;
const cusNicRegEx = /^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$/;
const cusLicenseRegEx = /^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$/;
const cusContactRegEx = /^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$/;
const cusPasswordRegEx = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/;


let customerValidations = [];
customerValidations.push({reg: cusEmailRegEx, field: $('#email'),error:'Customer Email Pattern is Wrong : asiri@gmail.com'});
customerValidations.push({reg: cusNameRegEx, field: $('#name'),error:'Customer Name Pattern is Wrong : A-z'});
customerValidations.push({reg: cusAddressRegEx, field: $('#address'),error:'Customer Address Pattern is Wrong : A-z 0-9 ,/'});
customerValidations.push({reg: cusNicRegEx, field: $('#nicNum'),error:'Customer Nic Pattern is Wrong : 0-9 ,/'});
customerValidations.push({reg: cusLicenseRegEx, field: $('#drivingNum'),error:'Customer License Pattern is Wrong : 0-9 ,/'});
customerValidations.push({reg: cusContactRegEx, field: $('#contact'),error:'Customer Contact Pattern is Wrong : 0-9 ,/'});
customerValidations.push({reg: cusPasswordRegEx, field: $('#password'),error:'Customer Password Pattern is Wrong : A-Z a-z 0-9 ,/'});


$("#email,#name,#address,#nicNum,#drivingNum,#contact,#password").on('keydown', function (event) {
    if (event.key == "Tab") {
        event.preventDefault();
    }
});


$("#email,#name,#address,#nicNum,#drivingNum,#contact,#password").on('keyup', function (event) {
    checkValidity();
});

$("#email,#name,#address,#nicNum,#drivingNum,#contact,#password").on('blur', function (event) {
    checkValidity();
});

function checkValidity() {
    let errorCount=0;
    for (let validation of customerValidations) {
        if (check(validation.reg,validation.field)) {
            textSuccess(validation.field,"");
        } else {
            errorCount=errorCount+1;
            setTextError(validation.field,validation.error);
        }
    }
    setButtonState(errorCount);
}

$("#email").on('keydown', function (event) {
    if (event.key == "Enter" && check(cusEmailRegEx, $("#email"))) {
        $("#name").focus();
    } else {
        focusText($("#email"));
    }
});


$("#name").on('keydown', function (event) {
    if (event.key == "Enter" && check(cusNameRegEx, $("#name"))) {
        focusText($("#address"));
    }
});


$("#address").on('keydown', function (event) {
    if (event.key == "Enter" && check(cusAddressRegEx, $("#address"))) {
        focusText($("#nicNum"));
    }
});

$("#nicNum").on('keydown', function (event) {
    if (event.key == "Enter" && check(cusNicRegEx, $("#nicNum"))) {
        focusText($("#drivingNum"));
    }
});

$("#drivingNum").on('keydown', function (event) {
    if (event.key == "Enter" && check(cusLicenseRegEx, $("#drivingNum"))) {
        focusText($("#contact"));
    }
});

$("#contact").on('keydown', function (event) {
    if (event.key == "Enter" && check(cusContactRegEx, $("#contact"))) {
        focusText($("#password"));
    }
});

$("#password").on('keydown', function (event) {
    if (event.key == "Enter" && check(cusContactRegEx, $("#password"))) {
        focusText($("#signupBtn"));
    }
});

function check(regex, txtField) {
    let inputValue = txtField.val();
    return regex.test(inputValue) ? true : false;
}

function setTextError(txtField,error) {
    if (txtField.val().length <= 0) {
        defaultText(txtField,"");
    } else {
        txtField.css('border', '2px solid red');
        txtField.parent().children('span').text(error);
    }
}

function textSuccess(txtField,error) {
    if (txtField.val().length <= 0) {
        defaultText(txtField,"");
    } else {
        txtField.css('border', '2px solid green');
        txtField.parent().children('span').text(error);
    }
}

function defaultText(txtField,error) {
    txtField.css("border", "1px solid #ced4da");
    txtField.parent().children('span').text(error);
}

function focusText(txtField) {
    txtField.focus();
}

function setButtonState(value){
    if (value>0){
        $("#signupBtn").attr('disabled',true);
    }else{
        $("#signupBtn").attr('disabled',false);
    }
}