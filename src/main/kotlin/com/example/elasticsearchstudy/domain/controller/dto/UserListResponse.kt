package com.example.elasticsearchstudy.domain.controller.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class UserListResponse @JsonCreator constructor(
    @JsonProperty("users") val users: List<UserResponse>
)

data class UserResponse(
    @JsonProperty("id") val id: Int,
    @JsonProperty("name") val name: String,
    @JsonProperty("age") val age: Int,
    @JsonProperty("description") val description: String,
)
