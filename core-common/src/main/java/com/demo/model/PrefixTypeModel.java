package com.demo.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PrefixTypeModel {
    @NotBlank(message = "type is mandatory")
    private String type;
    @NotBlank(message = "prefix is mandatory")
    private String prefix;
}
