package io.iamkrishna73.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductDTO {
    private Long id;
    @NotBlank(message = "product name is required")
    private String name;
    @NotBlank(message = "product description is required")
    private String description;
    @Positive(message = "price can't be negative")
    private BigDecimal price;
    @PositiveOrZero(message = "quantity can't be negative")
    private Integer quantity;
    private String imageUrl;
    private List<CommentDTO> comments;

}
