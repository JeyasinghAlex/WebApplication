function myFunction(){

    $.ajax({
        url: 'http://localhost:8040/zoho/webapi/ride',
        type: 'GET',
        success: function (data) {
        console.log(data);
           for(var i = 0; i < data.length; i++){
               $('#dropdown').append('<option value = ' + data[i].rideName + '>' + data[i].rideName + '</option');
           }
            alert('Success!')
        }
        , error: function (jqXHR, textStatus, err) { 
            alert('text status ' + textStatus + ', err ' + err);
        }
    });
}

function validation(){
    var start_time = parseInt(document.getElementById("start").value);
    var end_time = parseInt(document.getElementById("end").value);
    var ride_amount = parseInt(document.getElementById("amount").value);
    var is_allow_child;
    var is_allow_adult;
    var is_allow_senior;
    console.log(is_allow_senior + is_allow_child+ is_allow_adult);
    if(document.getElementById("dropdown").value != ""){
    if(!isNaN(start_time) && !isNaN(end_time) && !isNaN(ride_amount)){
    if(document.getElementById("cyes").checked || document.getElementById("cno").checked && document.getElementById("ayes").checked || document.getElementById("ano").checked
    && document.getElementById("syes").checked || document.getElementById("sno").checked){
        if(document.getElementById("cyes").checked){
            is_allow_child = document.getElementById("cyes").value;
        }else{
            is_allow_child = document.getElementById("cno").value;
        }
        if(document.getElementById("ayes").checked){
            is_allow_adult = document.getElementById("ayes").value;
        }else{
            is_allow_adult = document.getElementById("ano").value;
        }
        if(document.getElementById("syes").checked){
            is_allow_senior = document.getElementById("syes").value;
        }else{
            is_allow_senior = document.getElementById("sno").value;
        }
    if(start_time < end_time ){
    sendDataToServer(document.getElementById("dropdown").value, start_time, end_time, is_allow_child, is_allow_adult, is_allow_senior, ride_amount);
    alert("All type of validation has done on OnSubmit event.");
    return true;
    }else{
    alert("Start time must be less then End time")
    return false;
    }
    }else{
    alert("You must select Allow child or adult or senior");
    return false;
     }
     }else{
    alert("Time field data is requied --!");
     return false;
    }
    }else{
    alert("You must select Ride --!")
    return false;
    }
    
}


function sendDataToServer(selected_ride, start_time, end_time, is_allow_child, is_allow_adult, is_allow_senior, ride_amount){
    var ride = {
        selected_ride : selected_ride,
        start_time : start_time,
        end_time : end_time,
        is_allow_child : is_allow_child,
        is_allow_adult : is_allow_adult,
        is_allow_senior : is_allow_senior,
        ride_amount : ride_amount
    };
    $.ajax({
        url: 'http://localhost:8040/zoho/webapi/ride/ride-configuration',
        type: 'POST',
        data : ride,
        success: function (data) {
            alert('Successfully data inserted!')
        }
        , error: function (jqXHR, textStatus, err) { 
            alert('text status ' + textStatus + ', err ' + err);
        }
    });
}


