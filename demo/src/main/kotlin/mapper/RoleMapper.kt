package mapper

import dto.RoleDTO
import dto.UserDTO
import entity.Role
import entity.User

object RoleMapper {
    fun toDTO(role: Role): RoleDTO = RoleDTO(
        id = role.id,
        name = role.name
    )

    fun toEntity(dto: RoleDTO): Role = Role(
        id = dto.id ?: 0,
        name = dto.name
    )
}