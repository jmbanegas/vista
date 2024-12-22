package entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "activities")
data class Activity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "lead_id", nullable = false)
    val lead: Lead,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @Column(nullable = false)
    val description: String,

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "activity_date", nullable = false)
    val activityDate: Date = Date()
)