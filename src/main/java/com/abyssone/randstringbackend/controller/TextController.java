package com.abyssone.randstringbackend.controller;

import com.abyssone.randstringbackend.dto.TextRequest;
import com.abyssone.randstringbackend.dto.TextResponse;
import com.abyssone.randstringbackend.service.TextService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/text")
public class TextController {

    private final TextService textService;

    @GetMapping("/random")
    public ResponseEntity<TextResponse> getRandomText() {
        TextResponse randomText = textService.getRandomText();
        return ResponseEntity.ok(randomText);
    }

    @PostMapping()
    public ResponseEntity<TextResponse> saveText(@RequestBody TextRequest request) {
        TextResponse saved = textService.saveText(request);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{textId}")
    public ResponseEntity<TextResponse> getText(@PathVariable Long textId) {
        TextResponse text = textService.getText(textId);
        return ResponseEntity.ok(text);
    }
}
