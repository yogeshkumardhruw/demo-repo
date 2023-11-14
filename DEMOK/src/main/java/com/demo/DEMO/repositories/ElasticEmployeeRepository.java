package com.demo.DEMO.repositories;

import com.demo.DEMO.entity.Employee2;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticEmployeeRepository extends ElasticsearchRepository<Employee2, Long> {
}
