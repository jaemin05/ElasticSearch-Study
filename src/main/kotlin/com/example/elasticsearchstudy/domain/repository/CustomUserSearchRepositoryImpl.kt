package com.example.elasticsearchstudy.domain.repository

import com.example.elasticsearchstudy.domain.controller.dto.UserListResponse
import com.example.elasticsearchstudy.domain.controller.dto.UserResponse
import com.example.elasticsearchstudy.domain.entity.UserDocument
import com.example.elasticsearchstudy.domain.entity.UserEntity
import org.springframework.data.elasticsearch.core.ElasticsearchOperations
import org.springframework.data.elasticsearch.core.query.Criteria
import org.springframework.data.elasticsearch.core.query.CriteriaQuery
import org.springframework.stereotype.Component

    @Component
    class CustomUserSearchRepositoryImpl(
        private val elasticsearchOperations: ElasticsearchOperations
    ): CustomUserSearchRepository {
        override fun searchByName(name: String): UserListResponse {
            val criteria = Criteria.where("name").contains(name)
            val query = CriteriaQuery(criteria)
            val search = elasticsearchOperations.search(query, UserDocument::class.java)
            val users = search.map {
                UserResponse(
                    id = it.content.id,
                    name = it.content.name,
                    age = it.content.age,
                    description = it.content.description,
                )
            }.toList()

            return UserListResponse(users)
        }
    }