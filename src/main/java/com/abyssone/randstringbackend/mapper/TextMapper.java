package com.abyssone.randstringbackend.mapper;

import com.abyssone.randstringbackend.dto.TextRequest;
import com.abyssone.randstringbackend.dto.TextResponse;
import com.abyssone.randstringbackend.entity.Text;
import org.springframework.stereotype.Component;

@Component
public class TextMapper {

    public TextResponse entityToResponse(Text entity) {
        return TextResponse.builder()
                .id(entity.getId())
                .text(entity.getText())
                .build();
    }

    public Text requestToEntity(TextRequest request) {
        Text text = new Text();
        text.setText(request.getText());

        return text;
    }
}
