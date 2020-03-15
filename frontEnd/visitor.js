
function validation() {
    
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var contact = document.getElementById("contact").value;
    var gender;
    // Regular Expression For Email
    var emailReg = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    // Conditions
    if (name != '' && email != '' && contact != '') {
    if (email.match(emailReg)) {
    if (document.getElementById("male").checked || document.getElementById("female").checked) {
        if(document.getElementById("male").checked){
            gender = document.getElementById("male").value;
        }else{
            gender = document.getElementById("female").value;
        }
    if(document.getElementById("category") != ""){
    if (contact.length == 10) {
    sendDataToServer(name, email, contact, gender, document.getElementById("category").value, document.getElementById("pwd").value);
    alert("All type of validation has done on OnSubmit event.");
    return true;
     
    } else {
    alert("The Contact No. must be at least 10 digit long!");
    return false;
    }
    }else{
        alert("You must select category.....!");
        return false;
    }    
   
    } else {
    alert("You must select gender.....!");
    return false;
    }
    } else {
    alert("Invalid Email Address...!!!");
    return false;
    }
    } else {
    alert("All fields are required.....!");
    return false;
    }
  }

function sendDataToServer(name, email, contact, gender, category, password){
   
    var visitor = {
        name : name,
        email : email,
        contact : contact,
        gender : gender,
        category : category,
        password : password
    };

    $.ajax({
        url: 'http://localhost:8040/zoho/webapi/visitor',
        type: 'POST',
        data : visitor,
        success: function (data) {
            alert('Successfully data inserted!')
        }
        , error: function (jqXHR, textStatus, err) { 
            alert('text status ' + textStatus + ', err ' + err);
        }
    });
}  


 
