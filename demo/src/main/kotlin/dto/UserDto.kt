package dto

class UserDTO(
    val id: Long? = null,
    val username: String,
    val roleId: Long,
    val roleName: String
)