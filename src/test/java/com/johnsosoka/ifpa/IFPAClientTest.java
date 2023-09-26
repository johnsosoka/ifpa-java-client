package com.johnsosoka.ifpa;

import com.johnsosoka.ifpa.exception.IFPAException;
import com.johnsosoka.ifpa.model.player.PlayerProfileResponse;
import com.johnsosoka.ifpa.utils.IFPATestUtility;
import okhttp3.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Field;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class IFPAClientTest {

    private IFPAClient ifpaClient;
    private OkHttpClient mockClient;
    private Response mockResponse;


    @BeforeEach
    public void setUp() {
        mockClient = mock(OkHttpClient.class);
        mockResponse = mock(Response.class);

        // Initialize IFPAClient with a mock OkHttpClient
        ifpaClient = new IFPAClient("testApiKey");

        try {
            Field clientField = IFPAClient.class.getDeclaredField("client");
            clientField.setAccessible(true);
            clientField.set(ifpaClient, mockClient);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            fail("Failed to set the client using reflection");
        }
    }

    @Test
    public void testGetPlayerProfile() throws IFPAException, IOException, IOException {
        // Prepare mock JSON response
        String mockJsonResponse = IFPATestUtility.readFileFromTestResources("playerProfileResponse200.json");

        // Prepare mock Response
        when(mockResponse.isSuccessful()).thenReturn(true);
        when(mockResponse.body()).thenReturn(ResponseBody.create(mockJsonResponse, MediaType.parse("application/json")));

        // Prepare mock OkHttpClient
        Call mockCall = mock(Call.class);
        when(mockCall.execute()).thenReturn(mockResponse);
        when(mockClient.newCall(any(Request.class))).thenReturn(mockCall);

        // Test getPlayerProfile method
        PlayerProfileResponse playerProfileResponse = ifpaClient.getPlayerProfile("123");

        // Verify the results
        assertEquals("John", playerProfileResponse.getPlayer().getFirstName());

        // Verify that the client was called
        verify(mockClient, times(1)).newCall(any(Request.class));
    }
}