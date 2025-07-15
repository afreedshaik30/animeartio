package com.afreedshaik30.main.fegin_client;

import com.afreedshaik30.main.dto.TextToImgRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(
        name = "stabilityAiClient",
        url = "${stability.api.base-url}",
        configuration = com.afreedshaik30.main.config.FeginConfig.class
)
public interface StabilityAiClient {

    // 1. Text to Image
    @PostMapping(
            value = "/v1/generation/{engine_id}/text-to-image",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            headers = {"Accept=image/png"}
    )
    public byte[] generateFromText(
            @RequestHeader("Authorization") String authHeader,
            @PathVariable("engine_id") String engineId,
            @RequestBody TextToImgRequest requestBody
    );

    // 2. Img from Img
    @PostMapping(
            value = "/v1/generation/{engine_id}/image-to-image",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            headers = {"Accept=image/png"}
    )
    public  byte[] generateFromImg(
            @RequestHeader("Authorization") String authHeader,
            @PathVariable("engine_id") String engineId,
            @RequestPart("init_image") MultipartFile initImg,
            @RequestPart("text_prompts[0][text]") String textPrompt,
            @RequestPart("style_preset") String stylePreset
   );

}
