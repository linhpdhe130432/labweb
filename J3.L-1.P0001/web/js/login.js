/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Validate form post before submit to server
function validateLoginForm() {
    const userName = document.getElementById("username");
    const password = document.getElementById("password");
    const noti = document.getElementById("noti");
    
    var status = false;
    // Check user name and password input. If it is blank, show noti for user
    if (password.value.trim()=="") {
        noti.textContent = "Password can not be blank";
    }
    if (userName.value.trim()=="") {
        noti.textContent = "User name can not be blank";
    }

    // If user name and password is invalid, send to server
    if (password.value.trim()!="" &&userName.value.trim()!="") {
        noti.textContent = "";
        status = true;
    }
    return status;
}
