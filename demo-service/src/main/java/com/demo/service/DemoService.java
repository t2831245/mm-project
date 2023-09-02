package com.demo.service;

import com.demo.entity.PrefixTypeEntity;
import com.demo.exception.ReasonType;
import com.demo.exception.ResourceType;
import com.demo.exception.MyException;
import com.demo.model.PrefixTypeModel;
import org.springframework.stereotype.Service;
import com.demo.repository.PrefixTypeRepository;

@Service
public class DemoService {

    private final PrefixTypeRepository prefixTypeRepository;

    public DemoService(PrefixTypeRepository prefixTypeRepository) {
        this.prefixTypeRepository = prefixTypeRepository;
    }

    public PrefixTypeEntity findByPrefix(String prefix) {
        return prefixTypeRepository.findByPrefix(prefix)
                .orElseThrow(() -> new MyException(ResourceType.PREFIX_TYPE, ReasonType.NOT_FOUND));
    }

    public PrefixTypeEntity findByPrefixType(PrefixTypeModel prefixTypeModel) {
        return prefixTypeRepository.findByTypeAndPrefix(prefixTypeModel.getType(), prefixTypeModel.getPrefix())
                .orElseThrow(() -> new MyException("prefix not found"));
    }
}
