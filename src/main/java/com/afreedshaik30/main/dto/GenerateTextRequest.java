package com.afreedshaik30.main.dto;

import lombok.Data;

@Data
public class GenerateTextRequest {
    private String prompt;
    private String style;
}
