package com.socialcodia.socialmedia.models;

public class ModelUser {
    private int id;
    private String name,email,bio,image;
    private int verified;
    private String token;

    public ModelUser(int id, String name, String email, String bio, String image, int verified, String token) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bio = bio;
        this.image = image;
        this.verified = verified;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getVerified() {
        return verified;
    }

    public void setVerified(int verified) {
        this.verified = verified;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
