package com.afreedshaik30.main.service;

import com.afreedshaik30.main.dto.TextToImgRequest;
import com.afreedshaik30.main.fegin_client.StabilityAiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArtService {
    private final StabilityAiClient stabilityAiClient;
    private final String API_KEY;

    @Autowired
    public ArtService(StabilityAiClient stabilityAiClient,
                      @Value("${stability.api.key}") String apiKey) {
        this.stabilityAiClient = stabilityAiClient;
        this.API_KEY = apiKey;
    }

    // 1. Img From Text
    public byte[] createArtFromText(String prompt, String style) {
        String finalPrompt = prompt + ", dramatic lighting, anime cel-shading, ultra-detailed, vibrant colors, 4K resolution.";
        String engineId = "stable-diffusion-v1-6";
        String stylePreset = style.equals("general") ? "anime" : style.replace("_", "-");

        TextToImgRequest requestPayload = new TextToImgRequest(finalPrompt);
        return stabilityAiClient.generateFromText(
                "Bearer " + API_KEY,
                engineId,
                requestPayload
        );
    }

    // 2. Img from Img
    public byte[] createArtFromImg(MultipartFile image, String prompt) {
        String finalPrompt = prompt + ", stunning cinematic lighting, crisp anime linework, ultra-fine detail, vibrant color palette, atmospheric depth, 4K UHD render, masterfully composed scene";

        String engineId = "stable-diffusion-v1-6";
        String stylePreset = "anime";

        return stabilityAiClient.generateFromImg(
                "Bearer " + API_KEY,
                engineId,
                image,
                finalPrompt,
                stylePreset
        );
    }
}
