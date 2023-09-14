package com.example.elasticsearchstudy.domain.controller.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class SaveUserListRequest @JsonCreator constructor(
    @JsonProperty("users") val users: List<SaveUserRequest>
)

data class SaveUserRequest @JsonCreator constructor(
    @JsonProperty("name") val name: String,
    @JsonProperty("age") val age: Int,
    @JsonProperty("description") val description: String,
)
