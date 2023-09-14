package com.example.elasticsearchstudy.domain.repository

import com.example.elasticsearchstudy.domain.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Int>
