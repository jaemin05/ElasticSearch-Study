package com.example.elasticsearchstudy.domain.entity

import javax.persistence.*

@Entity
@Table(name = "tbl_user")
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val name: String,

    val age: Int,

    val description: String,
)
