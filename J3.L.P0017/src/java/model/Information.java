/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DuongDT
 */
public class Information {
    private String aboutMe;
    private String sortDes;
    private String imgDes;

    public Information() {
        
    }
    
    public Information(String aboutMe, String sortDes, String imgDes) {
        this.aboutMe = aboutMe;
        this.sortDes = sortDes;
        this.imgDes = imgDes;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public String getSortDes() {
        return sortDes;
    }

    public String getImgDes() {
        return imgDes;
    }
    
    
}

