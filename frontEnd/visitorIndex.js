var ticketNumber;


function checkUserNameAndPassword(){
    var userName = document.getElementById("username").value;
    var pass = document.getElementById("pwd").value;
    console.log('i am ajax call');
    $.ajax({
        url: 'http://localhost:8040/zoho/webapi/visitor/search-user-account',
        type: 'POST',
        data : {
            userName : userName,
            password : pass
        },
        success: function (data) {
            if(data.result === true){       
                alert("LogIn Successfully");
                window.location = "visitorIndex.html";
            }else{
                alert("userName or Pasword Incorrect")
            }
        }
        , error: function (jqXHR, textStatus, err) { 
            alert('text status ' + textStatus + ', err ' + err);
        }
    });
}

function checkWallet(){       

    $.ajax({
        url: 'http://localhost:8040/zoho/webapi/visitor/search-visitor/'+ticketNumber,
        type: 'POST',
        data : {ticketNumber : ticket},
        success: function (data) {
            var wallet = data.wallet;
            alert('Your Wallet is = ' + wallet);
        }
        , error: function (jqXHR, textStatus, err) { 
            alert('text status ' + textStatus + ', err ' + err);
        }
    });
}

function rechargeWallet(){

}

function showRide(){

    $.ajax({
        url: 'http://localhost:8040/zoho/webapi/ride',
        type: 'GET',
        success: function (data) {
        console.log(data);
        for (var i = 0; i < data.length; i += 1) {
            $("#table").append("<tr>"+'<td>' + data[i].start_time + "</td>"+'<td>'+ data[i].end_time +"</td>"+'<td>' + data[i].is_allow_child + "</td>"+'<td>'+data[i].is_allow_adult+"</td>"+ '<td>' + data[i].is_allow_senior + "</td>" + '<td>' + data[i].per_ride_amount + "</td>"+"</tr>");
        }
            alert('Success!')
        }
        , error: function (jqXHR, textStatus, err) { 
            alert('text status ' + textStatus + ', err ' + err);
        }
    });
}

function conformBooking(){

}
