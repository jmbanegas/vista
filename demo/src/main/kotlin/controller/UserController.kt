package controller

import dto.UserDTO
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {
    @get:GetMapping
    val allUsers: List<UserDTO?>?
        get() = userService.allUsers

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long?): UserDTO? {
        return userService.getUserById(id)
    }

    @PostMapping
    fun saveUser(@RequestBody userDTO: UserDTO?): UserDTO? {
        return userService.saveUser(userDTO)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long?) {
        userService.deleteUser(id)
    }
}