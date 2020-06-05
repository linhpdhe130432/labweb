/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author DuongDT
 */
public class Gallery {
    private int galleryCode;
    private String nameGallery;
    private String description;
    private String descriptionImage;
    private List<String> imageList;

    public Gallery() {
    }

    public Gallery(int galleryCode, String nameGallery) {
        this.galleryCode = galleryCode;
        this.nameGallery = nameGallery;
    }
    
    
    
    // contructor to get infomation of gallery, not neccessary to get all image in gallery
    public Gallery(int galleryCode, String nameGallery, String description, String descriptionImage) {
        this.galleryCode = galleryCode;
        this.nameGallery = nameGallery;
        this.description = description;
        this.descriptionImage = descriptionImage;
    }
    
    public Gallery(int galleryCode, String nameGallery, String description, String descriptionImage, List<String> imageList) {
        this.galleryCode = galleryCode;
        this.nameGallery = nameGallery;
        this.description = description;
        this.descriptionImage = descriptionImage;
        this.imageList = imageList;
    }

    public int getGalleryCode() {
        return galleryCode;
    }

    public String getNameGallery() {
        return nameGallery;
    }

    public String getDescription() {
            return description;
    }

    public String getDescriptionImage() {
        return descriptionImage;
    }

    public List<String> getImageList() {
        return imageList;
    }
    
    
}
