package com.example.android2hm1.data.model;

public class BoardModel {
    private  String animation;
    private  String description;
    private  String buttonText;

    public  String getAnimation() {
        return animation;
    }

    public String getDescription() {
        return description;
    }

    public String getButtonText() {
        return buttonText;
    }

    public BoardModel(String animation, String description, String buttonText) {
        this.animation = animation;
        this.description = description;
        this.buttonText = buttonText;
    }
}
