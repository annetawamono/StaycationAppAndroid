package com.example.staycationappandroid;

import java.util.ArrayList;

public class Accommodation {
    String title;
    ArrayList<String> image;
    Double lat;
    Double longitude;
    String city;
    String country;
    String locationDescription;
    String description;
    String type;
    String owner;
    String profile;
    Double price;
    ArrayList<String> amenities;
    Double rating;
    String availableStart;
    String availableEnd;

    public Accommodation() { }

    public Accommodation(String title, ArrayList<String> image, Double lat, Double longitude, String city, String country, String locationDescription, String description, String type, String owner, String profile, Double price, ArrayList<String> amenities, Long rating, String availableStart, String availableEnd) {
        this.title = title;
        this.image = image;
        this.lat = lat;
        this.longitude = longitude;
        this.city = city;
        this.country = country;
        this.locationDescription = locationDescription;
        this.description = description;
        this.type = type;
        this.owner = owner;
        this.profile = profile;
        this.price = price;
        this.amenities = amenities;
        this.rating = rating;
        this.availableStart = availableStart;
        this.availableEnd = availableEnd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getImage() {
        return image;
    }

    public void setImage(ArrayList<String> image) {
        this.image = image;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ArrayList<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(ArrayList<String> amenities) {
        this.amenities = amenities;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getAvailableStart() {
        return availableStart;
    }

    public void setAvailableStart(String availableStart) {
        this.availableStart = availableStart;
    }

    public String getAvailableEnd() {
        return availableEnd;
    }

    public void setAvailableEnd(String availableEnd) {
        this.availableEnd = availableEnd;
    }
}
