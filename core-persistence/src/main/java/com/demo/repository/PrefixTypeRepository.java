package com.demo.repository;

import com.demo.entity.PrefixTypeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrefixTypeRepository extends MongoRepository<PrefixTypeEntity, String> {
    Optional<PrefixTypeEntity> findByPrefix(String prefix);

    Optional<PrefixTypeEntity> findByTypeAndPrefix(String type, String prefix);

}
