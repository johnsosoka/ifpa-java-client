package com.johnsosoka.ifpa.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.johnsosoka.ifpa.exception.IFPAException;
import com.johnsosoka.ifpa.exception.IFPAWebException;
import com.johnsosoka.ifpa.interceptor.ApiKeyInterceptor;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

public class BaseApiClient {

    private static OkHttpClient client;
    private static ObjectMapper objectMapper;

    public BaseApiClient(String apiKey) {
        client = new OkHttpClient.Builder()
                .addInterceptor(new ApiKeyInterceptor(apiKey))
                .build();
        objectMapper = new ObjectMapper();
    }


    protected  <T> T httpGET(String url, Class<T> clazz) throws IFPAException {
        return httpGET(url, clazz, null);
    }

    protected <T> T httpGET(String url, Class<T> clazz, Map<String, String> headers) throws IFPAException {
        return httpGET(url, clazz, headers, null);
    }


    protected <T> T httpGET(String url, Class<T> clazz, Map<String, String> headers, Map<String, String> queryParams) throws IFPAException {
        HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();

        // Add query parameters if they are not null
        if (queryParams != null) {
            for (Map.Entry<String, String> param : queryParams.entrySet()) {
                httpBuilder.addQueryParameter(param.getKey(), param.getValue());
            }
        }

        Request.Builder requestBuilder = new Request.Builder()
                .url(httpBuilder.build());

        // Add headers if they are not null
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                requestBuilder.addHeader(entry.getKey(), entry.getValue());
            }
        }

        Request request = requestBuilder.build();

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
