package dto

class ActivityDTO(
    val id: Long? = null,
    val leadId: Long,
    val leadName: String,
    val userId: Long,
    val userName: String,
    val description: String,
    val activityDate: String
)
