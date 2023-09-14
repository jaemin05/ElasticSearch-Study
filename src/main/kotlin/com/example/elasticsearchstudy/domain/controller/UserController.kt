package com.example.elasticsearchstudy.domain.controller

import com.example.elasticsearchstudy.domain.controller.dto.SaveUserListRequest
import com.example.elasticsearchstudy.domain.controller.dto.SaveUserRequest
import com.example.elasticsearchstudy.domain.controller.dto.UserListResponse
import com.example.elasticsearchstudy.domain.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/user")
@RestController
class UserController(
    private val userService: UserService,
) {
    @PostMapping
    fun saveUser(@Valid @RequestBody request: SaveUserListRequest) = userService.saveUser(request)

    @GetMapping("/name/{name}")
    fun getUserByName(@PathVariable name: String):UserListResponse = userService.getUserByName(name)

    @GetMapping("/age/{age}")
    fun getUserByAge(@PathVariable age: Int):UserListResponse = userService.getUserByAge(age)
}
