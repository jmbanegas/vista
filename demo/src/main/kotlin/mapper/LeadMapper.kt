package mapper

import dto.LeadDTO
import dto.UserDTO
import entity.Lead
import java.text.SimpleDateFormat

object LeadMapper {
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    fun toDTO(lead: Lead): LeadDTO = LeadDTO(
        id = lead.id,
        name = lead.name,
        email = lead.email,
        status = lead.status,
        userId = lead.user.id,
        userName = lead.user.username,
        createdAt = dateFormat.format(lead.createdAt)
    )

    fun toEntity(dto: LeadDTO): Lead = Lead(
        id = dto.id ?: 0,
        name = dto.name,
        email = dto.email,
        status = dto.status,
        user = UserMapper.toEntity(UserDTO(id = dto.userId, username = dto.userName, roleId = 0, roleName = "")),
        activities = mutableListOf(),
        createdAt = dateFormat.parse(dto.createdAt)
    )
}