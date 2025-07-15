package com.afreedshaik30.main.controller;

import com.afreedshaik30.main.dto.GenerateTextRequest;
import com.afreedshaik30.main.service.ArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/anime")
public class ArtController {
    private final ArtService artService;

    @Autowired
    public ArtController(ArtService artService) {
        this.artService = artService;
    }

    @PostMapping(value = "/generate", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getGenerateArtFromImg(@RequestParam("image") MultipartFile image,
                                              @RequestParam("prompt") String prompt)
    {
        try {
            byte[] imgBytes = artService.createArtFromImg(image,prompt);
            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imgBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(value = "/generate-from-text", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateArtFromText(@RequestBody GenerateTextRequest requestDTO){
        try {
           byte[] imgBytes = artService.createArtFromText(requestDTO.getPrompt(), requestDTO.getStyle());
           return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imgBytes);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
