package com.example.elasticsearchstudy.domain.repository

import com.example.elasticsearchstudy.domain.entity.UserDocument
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface UserElasticsearchRepository : ElasticsearchRepository<UserDocument, Int>, CustomUserSearchRepository {
    fun findByAge(age: Int): List<UserDocument>
}
