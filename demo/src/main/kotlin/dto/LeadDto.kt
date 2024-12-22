package dto

class LeadDTO(
    val id: Long? = null,
    val name: String,
    val email: String,
    val status: String = "new",
    val userId: Long,
    val userName: String,
    val createdAt: String
)