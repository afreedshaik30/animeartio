package com.afreedshaik30.main.dto;

import java.util.List;
import java.util.Map;

public class TextToImgRequest {
    private List<Map<String, String>> text_prompts;
    private int cfg_scale = 7;
    private int height = 512;
    private int width = 512;
    private int samples = 1;
    private int steps = 30;

    public TextToImgRequest(String prompt) {
        this.text_prompts = List.of(Map.of("text", prompt));
    }

    // Getters and setters
    public List<Map<String, String>> getText_prompts() {
        return text_prompts;
    }

    public void setText_prompts(List<Map<String, String>> text_prompts) {
        this.text_prompts = text_prompts;
    }

    public int getCfg_scale() {
        return cfg_scale;
    }

    public void setCfg_scale(int cfg_scale) {
        this.cfg_scale = cfg_scale;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getSamples() {
        return samples;
    }

    public void setSamples(int samples) {
        this.samples = samples;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }
}
