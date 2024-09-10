package io.iamkrishna73.ecommerce.mappers;

import io.iamkrishna73.ecommerce.dto.CommentDTO;
import io.iamkrishna73.ecommerce.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentMapper INSTSNCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(target = "userId", source = "user.id")
    CommentDTO toDto(Comment comment);

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "product", ignore = true)
    Comment toEntity(CommentDTO commentDTO);
}

