package dev.divyansh.productservicettsevening.clients;

import dev.divyansh.productservicettsevening.dtos.FakeStoreApiProductDto;
import dev.divyansh.productservicettsevening.exceptions.NotFoundException;
import dev.divyansh.productservicettsevening.services.RestClientService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
@Component
public class FakeStoreClient {
    private RestTemplateBuilder restTemplateBuilder;
    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    public ResponseEntity<FakeStoreApiProductDto> getSingleProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreApiProductDto> response=restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreApiProductDto.class,productId);
        return response;
    }
    public ResponseEntity<FakeStoreApiProductDto[]> getAllProducts() {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreApiProductDto[]> response=restTemplate.getForEntity("https://fakestoreapi.com/products",FakeStoreApiProductDto[].class);
        return response;


    }
    public ResponseEntity<FakeStoreApiProductDto> addNewProduct(FakeStoreApiProductDto fakeStoreApiProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreApiProductDto> response=restTemplate.postForEntity("https://fakestoreapi.com/products",fakeStoreApiProductDto,FakeStoreApiProductDto.class);
        return response;
    }
    public ResponseEntity<FakeStoreApiProductDto> updateProduct(Long productId, FakeStoreApiProductDto fakeStoreApiProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RestClientService restClientService=new RestClientService(restTemplate);
        HashMap<String,String> urlVariables=new HashMap<>();
        urlVariables.put("id",productId.toString());
        ResponseEntity<FakeStoreApiProductDto> response=restClientService.makeRequest("https://fakestoreapi.com/products/{id}", HttpMethod.PUT,fakeStoreApiProductDto,FakeStoreApiProductDto.class,urlVariables);
        return response;
    }
    public ResponseEntity<FakeStoreApiProductDto> deleteProduct(Long productId) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RestClientService restClientService=new RestClientService(restTemplate);
        HashMap<String,String> urlVariables=new HashMap<>();
        urlVariables.put("id",productId.toString());
        ResponseEntity<FakeStoreApiProductDto> response=restClientService.makeRequest("https://fakestoreapi.com/products/{id}", HttpMethod.DELETE,null,FakeStoreApiProductDto.class,urlVariables);
        return response;

    }

}

