package ingeniance.supermarche.ingenianceDemo.rest;

import ingeniance.supermarche.ingenianceDemo.Dto.ProductDto;
import ingeniance.supermarche.ingenianceDemo.mapper.SupermarketMapper;
import ingeniance.supermarche.ingenianceDemo.service.ProductService;
import ingeniance.supermarche.ingenianceDemo.service.impl.ExcelImportService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles HTTP requests for Product operations.
 */

@RestController
@RequestMapping("/api/products")
public class ProductRest {

    @Autowired
    ProductService productService;

    @Autowired
    ExcelImportService excelImportService;

    SupermarketMapper supermarketMapper = Mappers.getMapper(SupermarketMapper.class);

    @RequestMapping(value = "/newProduct", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity<ProductDto> newProduct(@RequestBody ProductDto productDto) throws Exception {
        if (null != productDto) {
            try {
                productService.persist(supermarketMapper.productDtoToProduct(productDto)).get();
                return new ResponseEntity(productDto, HttpStatus.OK);
            } catch (Exception e) {
                throw new Exception(e);
            }
        } else {
            return new ResponseEntity(productDto, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/deleteProduct", produces = "application/json", method = RequestMethod.DELETE)
    public ResponseEntity deleteProduct(@RequestParam Long idProduct) throws Exception {
        if (idProduct != 0) {
            try {
                productService.deleteById(idProduct);
                return new ResponseEntity(HttpStatus.ACCEPTED);
            } catch (Exception e) {
                throw new Exception(e);
            }
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/getProductById", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<ProductDto> findById(@RequestParam Long idProduct) throws Exception {
        if (idProduct != 0) {
            try {
                ProductDto productDto = supermarketMapper.productToProductDto(
                        productService.findById(idProduct).get());
                return new ResponseEntity(HttpStatus.OK);
            } catch (Exception e) {
                throw new Exception(e);
            }
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/getAllProduct", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<List<ProductDto>> findAll() throws Exception {
        List<ProductDto> productDtos = new ArrayList<>();
        try {
            return ResponseEntity.ok(productService.findAll().get().stream()
                    .map(product -> supermarketMapper.productToProductDto(product))
                    .collect(Collectors.toList()));
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
