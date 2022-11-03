package com.sparta.ml.ActivityTests_Regular_OrAPITesting.boredAPITestingFramework;

import com.sparta.ml.ActivityTests_Regular_OrAPITesting.boredAPITestingFramework.connection.ConnectionManager;
import com.sparta.ml.ActivityTests_Regular_OrAPITesting.boredAPITestingFramework.injection.Injector;
import com.sparta.ml.ActivityTests_Regular_OrAPITesting.boredAPITestingFramework.dto.ActivityDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActivityAPIFrameworkTests {

    private static ActivityDTO dto;
    private static int statusCode;

    @BeforeAll
    static void initAll() {
        dto = Injector.injectActivityDTO(ConnectionManager.getConnection());
        statusCode = ConnectionManager.getStatusCode();
    }

    @Test
    @DisplayName("Check status code is 200")
    void checkStatusCodeIs200() {
        assertEquals(200, statusCode);
    }

    @Test
    @DisplayName("Check that the server software is Cowboy")
    void CheckThatTheServerSoftwareIsCowboy() {
        assertEquals("Cowboy", ConnectionManager.getHeader("server"));
    }

    @Test
    @DisplayName("Check that the activity is not blank")
    void CheckThatTheActivityIsNotBlank() {
        assertTrue(dto.hasActivity());
    }

    @Test
    @DisplayName("Check that there is at least 1 participant for an Activity")
    void CheckThatThereIsAtLeast1ParticipantForAnActivity() {
        assertTrue(dto.hasPositiveNumberOfParticipants());
    }

    @Test
    @DisplayName("Check that the key is always seven digits")
    void CheckThatTheKeyIsAlwaysSevenDigits() {
        assertTrue(dto.keyHasSevenDigits());
    }


}
