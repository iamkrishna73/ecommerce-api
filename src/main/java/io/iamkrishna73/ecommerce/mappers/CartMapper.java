package io.iamkrishna73.ecommerce.mappers;

import io.iamkrishna73.ecommerce.dto.CartDTO;
import io.iamkrishna73.ecommerce.dto.CartItemDTO;
import io.iamkrishna73.ecommerce.entity.Cart;
import io.iamkrishna73.ecommerce.entity.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);
    @Mapping(target = "userId", source = "user.id")
    CartDTO toDto(Cart cart);
    @Mapping(target = "user.id", source = "userId")
    Cart toEntity(CartDTO cartDTO);
    @Mapping(target = "productId", source = "product.id")
    CartItemDTO toDto(CartItem cartItem);
    @Mapping(target = "product.id", source = "productId")
    CartItem toEntity(CartItemDTO cartItemDTO);
}
