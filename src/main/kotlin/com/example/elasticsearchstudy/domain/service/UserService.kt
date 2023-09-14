package com.example.elasticsearchstudy.domain.service

import com.example.elasticsearchstudy.domain.controller.dto.SaveUserListRequest
import com.example.elasticsearchstudy.domain.controller.dto.SaveUserRequest
import com.example.elasticsearchstudy.domain.controller.dto.UserListResponse
import com.example.elasticsearchstudy.domain.controller.dto.UserResponse
import com.example.elasticsearchstudy.domain.entity.UserDocument
import com.example.elasticsearchstudy.domain.entity.UserEntity
import com.example.elasticsearchstudy.domain.repository.UserElasticsearchRepository
import com.example.elasticsearchstudy.domain.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userElasticsearchRepository: UserElasticsearchRepository,
) {
    @Transactional
    fun saveUser(request: SaveUserListRequest) {
        saveUserEntity(request)
        saveUserDocument()
    }

    private fun saveUserEntity(request: SaveUserListRequest) {
        val userEntity = request.users
            .map {
                UserEntity(
                    name = it.name,
                    age = it.age,
                    description = it.description,
                )
            }.toList()
        userRepository.saveAll(userEntity)
    }

    private fun saveUserDocument() {
        val userDocument = userRepository.findAll()
            .map {
                UserDocument(
                    id = it.id,
                    name = it.name,
                    age = it.age,
                    description = it.description,
                    createdAt = LocalDateTime.now(),
                )
            }.toList()
        userElasticsearchRepository.saveAll(userDocument)
    }

    fun getUserByName(name: String): UserListResponse = userElasticsearchRepository.searchByName(name)

    fun getUserByAge(age: Int): UserListResponse {
        val users = userElasticsearchRepository.findByAge(age)
            .map {
                UserResponse(
                    id = it.id,
                    name = it.name,
                    age = it.age,
                    description = it.description,
                )
            }.toList()

        return UserListResponse(
            users = users
        )
    }
}