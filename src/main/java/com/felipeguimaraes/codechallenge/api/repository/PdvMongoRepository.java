package com.felipeguimaraes.codechallenge.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.felipeguimaraes.codechallenge.api.bean.Pdv;

@Repository
public interface PdvMongoRepository extends MongoRepository<Pdv, Integer>, PdvMongoRepositoryCustom {

}
