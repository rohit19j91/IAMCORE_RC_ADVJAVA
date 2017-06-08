/**
 * Owner: Rohit Chauhan
 * Date:21-MAY-2017
 * Function: To ensure that the username and password are not empty in login.jsp
 */
function check(form) {
    if (document.forms.loginForm.email.value == "") {
        alert("Please input username");
        document.forms.loginForm.email.focus();
        return false;
    } else if (document.forms.loginForm.inputPassword.value == "") {
        alert("Please input passwprd");
        document.forms.loginForm.pwd.focus();
        return false;
    }
}

/**
 * Owner: Rohit Chauhan
 * Date:21-MAY-2017
 * Function: To ensure that all the fields on the register page are not empty in register.jsp
 */
function checkr(form) {
    if (document.forms.loginForm.email.value == "") {
        alert("Please input email");
        document.forms.loginForm.email.focus();
        return false;
    } else if (document.forms.loginForm.inputPassword.value == "") {
        alert("Please input passwprd");
        document.forms.loginForm.pwd.focus();
        return false;
    } else if (document.forms.loginForm.rinputPassword.value != document.forms.loginForm.inputPassword.value){
        alert("Please confirm passwprd");
        document.forms.loginForm.pwd.focus();
        return false;
    } else if (document.forms.loginForm.name.value == "") {
    alert("Please input username");
    document.forms.loginForm.inputName.focus();
    return false;
}
    else if (document.forms.loginForm.Street.value == "") {
        alert("Please input Street");
        document.forms.loginForm.street.focus();
        return false;
    }
    else if (document.forms.loginForm.City.value == "") {
        alert("Please input City");
        document.forms.loginForm.city.focus();
        return false;
    }
    else if (document.forms.loginForm.Country.value == "") {
        alert("Please input Country");
        document.forms.loginForm.country.focus();
        return false;
    }
    else if (document.forms.loginForm.Zipcode.value == "") {
        alert("Please input Zipcode");
        document.forms.loginForm.zipcode.focus();
        return false;
    }
}