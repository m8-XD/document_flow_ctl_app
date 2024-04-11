
package com.docflow.data.es.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.docflow.data.db.entity.Document;

@Repository
public interface ElasticRepository extends ElasticsearchRepository<Document, String> {

}
