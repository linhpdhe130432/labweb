/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
    // Function: Show detail image when user click on image card.
   
    // Get list of all images in slide.
    const image= document.querySelectorAll(".image-slide");
    // Get list of all images card
    const imageCard = document.querySelectorAll(".image-card");
    
    // In the firs time access gallery page, the first image on slide will be display
    display(0);
    
    //With any image card element, add event on click. 
    imageCard.forEach(addEventForCard);
    
    function addEventForCard(item, index) {
        item.addEventListener("click",function () {
            display(index);
        });
    }
    // Hiden all images in slide.
    function hideImage() {
        for (let j=0;j<image.length;j++) {
            // If status of image is display, hiden it.
            if (image[j].classList.contains("display-image")) {
                image[j].classList.remove("display-image");
                image[j].classList.add("hiden-image");
            }
        }
    }
    //Display an image into slide  
    function display (imageIndex)  {
        hideImage();
        image[imageIndex].classList.remove("hiden-image");
        image[imageIndex].classList.add("display-image");
    }

    

    
    