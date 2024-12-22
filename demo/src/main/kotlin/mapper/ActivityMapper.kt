package mapper

import dto.ActivityDTO
import dto.LeadDTO
import dto.UserDTO
import entity.Activity
import java.text.SimpleDateFormat

object ActivityMapper {
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    fun toDTO(activity: Activity): ActivityDTO = ActivityDTO(
        id = activity.id,
        leadId = activity.lead.id,
        leadName = activity.lead.name,
        userId = activity.user.id,
        userName = activity.user.username,
        description = activity.description,
        activityDate = dateFormat.format(activity.activityDate)
    )

    fun toEntity(dto: ActivityDTO): Activity = Activity(
        id = dto.id ?: 0,
        lead = LeadMapper.toEntity(LeadDTO(id = dto.leadId, name = dto.leadName, email = "", userId = 0, userName = "", createdAt = dateFormat.format(activityDate = ""))),
        user = UserMapper.toEntity(UserDTO(id = dto.userId, username = dto.userName, roleId = 0, roleName = "")),
        description = dto.description,
        activityDate = dateFormat.parse(dto.activityDate)
    )
}