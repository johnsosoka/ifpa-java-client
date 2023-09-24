package com.johnsosoka.ifpa;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.johnsosoka.ifpa.exception.IFPAException;
import com.johnsosoka.ifpa.exception.IFPAWebException;
import com.johnsosoka.ifpa.interceptor.ApiKeyInterceptor;
import com.johnsosoka.ifpa.model.PlayerProfileResponse;
import com.johnsosoka.ifpa.model.PlayerTournamentResponse;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

import static com.johnsosoka.ifpa.constants.Constants.*;

public class IFPAClient {

    private static OkHttpClient client;
    private static ObjectMapper objectMapper;

    public IFPAClient(String apiKey) {
        client = new OkHttpClient.Builder()
                .addInterceptor(new ApiKeyInterceptor(apiKey))
                .build();
        objectMapper = new ObjectMapper();
    }

    public PlayerTournamentResponse getPlayerTournaments(String playerId) throws IFPAException {
        String url = BASE_API_URL + PLAYER + PATH_SEPARATOR + playerId + RESULTS;
        return httpGET(url, PlayerTournamentResponse.class);
    }

    public PlayerProfileResponse getPlayerProfile(String playerId) throws IFPAException {
        String url = BASE_API_URL + PLAYER + PATH_SEPARATOR + playerId;
        return httpGET(url, PlayerProfileResponse.class);
    }

    public <T> T httpGET(String url, Class<T> clazz) throws IFPAException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        T responseObj = null;

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                responseObj = objectMapper.readValue(responseBody, clazz);
            } else {
                throw new IFPAWebException(response.code());
            }
        } catch (IOException e) {
            throw new IFPAWebException(e);
        }

        return responseObj;
    }

}
