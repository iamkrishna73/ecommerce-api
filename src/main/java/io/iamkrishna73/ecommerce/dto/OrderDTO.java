package io.iamkrishna73.ecommerce.dto;

import io.iamkrishna73.ecommerce.entity.OrderStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private Long userId;
    @NotBlank(message = "Address is required")
    private String address;
    @NotBlank(message = "PhoneNumber  is required")
    private String phoneNumber;
    private OrderStatus orderStatus;
    private LocalDateTime createdAt;
    private List<OrderItemDTO> orderItems;

}
