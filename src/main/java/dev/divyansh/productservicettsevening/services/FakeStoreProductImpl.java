package dev.divyansh.productservicettsevening.services;

import dev.divyansh.productservicettsevening.clients.FakeStoreClient;
import dev.divyansh.productservicettsevening.dtos.FakeStoreApiProductDto;
import dev.divyansh.productservicettsevening.exceptions.NotFoundException;
import dev.divyansh.productservicettsevening.models.Product;
import dev.divyansh.productservicettsevening.models.Category;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductImpl implements ProductService {
    RestTemplateBuilder restTemplateBuilder;
    FakeStoreClient fakeStoreClient;

    public FakeStoreProductImpl(RestTemplateBuilder restTemplateBuilder, FakeStoreClient fakeStoreClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreClient = fakeStoreClient;
    }
    private Product convertFakeStoreApiProductDtoToProduct(FakeStoreApiProductDto productDto){
        Product product=new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImage());
        Category category=new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setRating(productDto.getRating());
        return product;
    }
    @Override
    public Product getSingleProduct(Long productId) {
        FakeStoreApiProductDto fakeStoreApiProductDto=fakeStoreClient.getSingleProduct(productId).getBody();
        return convertFakeStoreApiProductDtoToProduct(fakeStoreApiProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreApiProductDto [] fakeStoreApiProductDtos=fakeStoreClient.getAllProducts().getBody();
        List<Product> products=new ArrayList<>();
        for(int i=0;i<fakeStoreApiProductDtos.length;i++){
            products.add(convertFakeStoreApiProductDtoToProduct(fakeStoreApiProductDtos[i]));
        }
        return products;

    }

    @Override
    public Product addNewProduct(FakeStoreApiProductDto fakeStoreApiProductDto) {
        FakeStoreApiProductDto fakeStoreApiProductDto1=fakeStoreClient.addNewProduct(fakeStoreApiProductDto).getBody();
        return convertFakeStoreApiProductDtoToProduct(fakeStoreApiProductDto1);
    }

    @Override
    public Product updateProduct(Long productId, FakeStoreApiProductDto fakeStoreApiProductDto) {
        FakeStoreApiProductDto fakeStoreApiProductDto1=fakeStoreClient.updateProduct(productId,fakeStoreApiProductDto).getBody();
        return convertFakeStoreApiProductDtoToProduct(fakeStoreApiProductDto1);
    }

    @Override
    public boolean deleteProduct(Long productId) throws NotFoundException {

        ResponseEntity<FakeStoreApiProductDto> response=fakeStoreClient.deleteProduct(productId);
        if(response.getBody()!=null){
            return true;
        }else{
            throw new NotFoundException("Product with id "+productId+" not found");
        }

    }
}
