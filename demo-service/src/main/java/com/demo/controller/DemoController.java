package com.demo.controller;

import com.demo.converter.PrefixConverter;
import com.demo.dto.PrefixTypeDto;
import com.demo.model.PrefixTypeModel;
import com.demo.service.DemoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping(value = "/demo")
public class DemoController {

    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("ping")
    public ResponseEntity ping() {
        return ResponseEntity.ok("ping");
    }

    @GetMapping("/{prefix}")
    public ResponseEntity<PrefixTypeDto> getPrefixType(@PathVariable String prefix) {
        PrefixTypeDto prefixTypeDto = PrefixConverter.entityToDto(demoService.findByPrefix(prefix));
        return ResponseEntity.ok(prefixTypeDto);
    }

    @GetMapping("/prefix-type/by-body")
    public ResponseEntity<PrefixTypeDto> getPrefixTypeByBody(@Valid @RequestBody PrefixTypeModel prefixTypeModel) {
        PrefixTypeDto prefixTypeDto = PrefixConverter.entityToDto(demoService.findByPrefixType(prefixTypeModel));
        return ResponseEntity.ok(prefixTypeDto);
    }
}
