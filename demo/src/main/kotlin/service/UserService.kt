package service

import entity.User
import org.springframework.stereotype.Service
import repository.UserRepository

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): List<User> = userRepository.findAll()

    fun getUserById(id: Long): User = userRepository.findById(id)
        .orElseThrow { RuntimeException("User with id $id not found") }

    fun saveUser(user: User): User = userRepository.save(user)

    fun deleteUser(id: Long) {
        if (!userRepository.existsById(id)) {
            throw RuntimeException("User with id $id not found")
        }
        userRepository.deleteById(id)
    }
}