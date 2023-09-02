package com.demo.converter;


import com.demo.dto.PrefixTypeDto;
import com.demo.entity.PrefixTypeEntity;

public class PrefixConverter {

    public static PrefixTypeDto entityToDto(PrefixTypeEntity entity) {
        return new PrefixTypeDto().builder()
                .id(entity.getId())
                .type(entity.getType())
                .description(entity.getDescription())
                .prefix(entity.getPrefix())
                .build();
    }
}
