package entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "leads")
data class Lead(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(nullable = false)
    val status: String = "new",

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @OneToMany(mappedBy = "lead", cascade = [CascadeType.ALL], orphanRemoval = true)
    val activities: List<Activity> = mutableListOf(),

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    val createdAt: Date = Date()
)
