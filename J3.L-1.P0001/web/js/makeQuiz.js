/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// Validate Make form before submit to server
function validateMakeQuizForm() {
    const noti = document.getElementById("noti");
    const question = document.getElementById("question");
    const txtareaOption1 = document.getElementById("option1TextArea");
    const txtareaOption2 = document.getElementById("option2TextArea");
    const txtareaOption3 = document.getElementById("option3TextArea");
    const txtareaOption4 = document.getElementById("option4TextArea");
    const checkOption1 = document.getElementById("option1");
    const checkOption2 = document.getElementById("option2");
    const checkOption3 = document.getElementById("option3");
    const checkOption4 = document.getElementById("option4");
    
    var status = true;
    // If this page having success noti, remove this noti before new add
    const successNoti = document.getElementById("success-noti");
    if (successNoti!=null) {
        successNoti.textContent="";
    }
    // User must select at least one correct answer; if no answer is selected, show error noti
    if (!checkOption1.checked&&!checkOption2.checked&&!checkOption3.checked&&!checkOption4.checked) {
        noti.textContent = "You must select at least one correct answer";
        status = false;
    }

    // User can not check all options is true answer
    if (checkOption1.checked&&checkOption2.checked&&checkOption3.checked&&checkOption4.checked) {
        noti.textContent = "You must not select all options";
        status = false;
    }
    // All text area of options can not be blank, If user donot enter value, show error noti 
    if (txtareaOption4.value.trim()=="") {
        status = false;
        noti.textContent = "Option 4 can not be blank";
        
    }
    if (txtareaOption3.value.trim()=="") {
        status = false;
        noti.textContent = "Option 3 can not be blank";
        
    }
    if (txtareaOption2.value.trim()=="") {
        status = false;
        noti.textContent = "Option 2 can not be blank";
    
    }
    if (txtareaOption1.value.trim()=="") {
        status = false;
        noti.textContent = "Option 1 can not be blank";
        
    }

    // Question content can not be blank, if user do not enter value, show error noti
    if (question.value.trim()=="") {
        status = false;
        noti.textContent = "Question content can not be blank";
        
    }
    
    return status;
}