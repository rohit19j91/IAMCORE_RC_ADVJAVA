/**
 * Owner: Rohit Chauhan
 * Date:20-MAY-2017
 * Function: To ensure that the search text box is not empty in Listusers.jsp
 */

function checksearch(form) {
    if (document.forms.SearchName.name.value == "") {
        alert("Please type in something");
        document.forms.SearchName.name.focus();
        return false;
    }
}