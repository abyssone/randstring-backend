package com.abyssone.randstringbackend.client;

import com.abyssone.randstringbackend.client.dto.FishResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FishService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiKey = "zasjCgH2JktPaLQuiW3EOg==No94gEfjbHk8O5Ez";

    public String getRandomText() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Api-Key", apiKey);

        HttpEntity<Void> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<FishResponse> response = restTemplate
                .exchange("https://api.api-ninjas.com/v1/randomword", HttpMethod.GET, httpEntity, FishResponse.class);

        FishResponse body = response.getBody();

        return body.getError() == null ? body.getWord().get(0) : body.getError();
    }
}
