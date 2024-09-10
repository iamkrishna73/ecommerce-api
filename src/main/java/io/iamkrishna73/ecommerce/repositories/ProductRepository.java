package io.iamkrishna73.ecommerce.repositories;

import io.iamkrishna73.ecommerce.dto.ProductListDTO;
import io.iamkrishna73.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Repository interface for Product entity, extending JpaRepository for basic CRUD and pagination.
 *
 * Custom query to fetch specific fields (id, name, description, price, quantity, image)
 * and map them to ProductListDTO to optimize performance by avoiding unnecessary data fetch.
 *
 * Uses JPQL constructor expression to map results and returns paginated data via Page<ProductListDTO>.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT new io.iamkrishna73.ecommerce.dto.ProductListDTO(p.id, p.name, p.description, p.price, p.quantity, p.image) FROM Product p")
    Page<ProductListDTO> findAllWithoutComments(Pageable pageable);

}

