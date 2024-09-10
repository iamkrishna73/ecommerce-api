package io.iamkrishna73.ecommerce.mappers;

import io.iamkrishna73.ecommerce.dto.OrderDTO;
import io.iamkrishna73.ecommerce.dto.OrderItemDTO;
import io.iamkrishna73.ecommerce.entity.Order;
import io.iamkrishna73.ecommerce.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(target = "userId", source = "user.id")
    OrderDTO toDto(Order order);
    @Mapping(target = "user.id", source = "userId")
    Order toEntity(OrderDTO orderDTO);
    List<OrderDTO> toDTOs(List<Order> orders);
    List<Order> toEntities(List<OrderDTO> orderDTOS);
    @Mapping(target = "productId", source = "product.id")
    OrderItemDTO toDto(OrderItem orderItem);
    @Mapping(target = "product.id", source = "productId")
    OrderItem toEntity(OrderItemDTO orderItemDTO);

    List<OrderItemDTO> toOrderItemDTOs(List<OrderItem> orderItem);
    List<OrderItem> toOrderItemEntities(List<OrderItemDTO> orderItemDTO);

}
