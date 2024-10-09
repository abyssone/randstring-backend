package com.abyssone.randstringbackend.service;

import com.abyssone.randstringbackend.client.FishService;
import com.abyssone.randstringbackend.dto.TextRequest;
import com.abyssone.randstringbackend.dto.TextResponse;
import com.abyssone.randstringbackend.entity.Text;
import com.abyssone.randstringbackend.mapper.TextMapper;
import com.abyssone.randstringbackend.repository.TextRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TextService {

    private final TextRepository textRepository;
    private final TextMapper textMapper;
    private final FishService fishService;

    public TextResponse getRandomText() {
        String randomText = fishService.getRandomText();
        log.info("Generated text: {}", randomText);

        return TextResponse.builder().text(randomText).build();
    }

    public TextResponse saveText(TextRequest request) {
        Text newText = textMapper.requestToEntity(request);
        Text savedText = textRepository.save(newText);
        return textMapper.entityToResponse(savedText);
    }

    public TextResponse getText(Long id) {
        Optional<Text> text = textRepository.findById(id);
        if (text.isPresent()) {
            return textMapper.entityToResponse(text.get());
        } else {
            log.error("Не найден текст с id={}", id);
            return null;
        }
    }
}
