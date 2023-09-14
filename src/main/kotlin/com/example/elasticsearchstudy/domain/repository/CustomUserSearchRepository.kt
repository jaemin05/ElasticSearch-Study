package com.example.elasticsearchstudy.domain.repository

import com.example.elasticsearchstudy.domain.controller.dto.UserListResponse

interface CustomUserSearchRepository {
    fun searchByName(name: String): UserListResponse
}
