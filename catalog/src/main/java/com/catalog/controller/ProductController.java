import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import java.util.stream.Collectors;

@GetMapping("/getproductByPriceRange")
public List<Product> getProductByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
    List<Product> allProducts = prodrepo.findAll();
    return allProducts.stream()
             .filter(product -> product.getPrice() >= minPrice && product.getPrice() <= maxPrice)
             .collect(Collectors.toList());
}