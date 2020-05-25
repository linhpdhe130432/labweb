/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Fuction to active page number
// Get list of all number of page
    const pages= document.querySelectorAll(".pagination");
    
    // Get all params in URL
    const searchParams = new URLSearchParams(window.location.search);
    // Get value of pageNumber in URL
    const pageNumber = searchParams.get('pageNumber');
    
    // If pageNumber does not exist, server will set pageNumber equal 1. Therefore, active page 1
    if (!pageNumber) {
        document.getElementById("1-page").classList.add("active");
    } 
    // If pageNumber does not a number, server will set pageNumber equal 1. Therefore, active page 1
    else if (!pageNumber.match(/^\d+$/)) {
        document.getElementById("1-page").classList.add("active");
    } 
    // In other cases, active page equals pageNumber params in URL 
    else {
         document.getElementById(pageNumber+"-page").classList.add("active");
    }

