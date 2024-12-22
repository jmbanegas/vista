package mapper

import dto.UserDTO
import entity.User

object UserMapper {
    fun toDTO(user: User): UserDTO {
        val dto = UserDTO()
        dto.setId(user.getId())
        dto.setUsername(user.getUsername())
        dto.setRoleName(user.getRole().getName())
        return dto
    }

    fun toEntity(dto: UserDTO): User {
        val user = User()
        user.setId(dto.getId())
        user.setUsername(dto.getUsername())
        // Nota: la relación Role debe ser manejada por el servicio
        return user
    }
}