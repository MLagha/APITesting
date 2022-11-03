package com.sparta.ml.ActivityTests_Regular_OrAPITesting.boredAPITestingFramework.injection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.ml.ActivityTests_Regular_OrAPITesting.boredAPITestingFramework.dto.ActivityDTO;

import java.io.IOException;
import java.net.URL;

public class Injector {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static ActivityDTO injectActivityDTO(String path) {
        ActivityDTO dto = new ActivityDTO();

        try {
            dto = mapper.readValue(new URL(path), ActivityDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dto;
    }
}
