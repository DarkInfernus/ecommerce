package dev.divyansh.productservicettsevening.services;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;


public class RestClientService {

    private RestTemplate restTemplate;

    public RestClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T, R> ResponseEntity<R> makeRequest(String url, HttpMethod method, @Nullable T requestBody, Class<R> responseType, Map<String, String> urlVariables) {
        HttpEntity<T> requestEntity = new HttpEntity<>(requestBody);
        return restTemplate.exchange(url, method, requestEntity, responseType, urlVariables);
    }
}
