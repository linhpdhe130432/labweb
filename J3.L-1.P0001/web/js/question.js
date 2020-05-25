/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Function: Calculate time remaining and submit when timeup

// Display clock count down and when time remain equal 0, go to result server
function countdown(timeRemain) {
    // Function to loop count down clock and display after every second, equal 1000 milisecond
    setInterval(function () {   
        const timeShow = document.getElementById("time");
        // one minute = 1000* 60(second) = 60.000 milisecond.
        const minutes = Math.floor((timeRemain / (1000 * 60)));
        const seconds = Math.floor((timeRemain % (1000 * 60)) / 1000);
        // Make sure seconds having format mm:ss
        var minutesInformat = "";
        var secondInformat = "";
        if (minutes < 10) {
            minutesInformat = "0"+minutes;
        } else {
            minutesInformat = ""+minutes;
        }
        
        if (seconds < 10) {
            secondInformat = "0"+seconds;
        } else {
            secondInformat = ""+seconds;
        }
        
        timeShow.textContent = minutesInformat + ":" + secondInformat;
        
        // If time remain for test < or equal 0, submit to server to calculate result
        if (timeRemain <= 0) {
            // Stop loop function by go to result server to calculate
            timeShow.textContent = "Time is up";
            window.location.href = "result";
        }
        // After each milisecon, minus 1000 milisecond in time remain
        timeRemain = timeRemain-1000;
    }, 1000)

    
   
}


