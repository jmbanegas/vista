package service

import entity.Activity
import org.springframework.stereotype.Service
import repository.ActivityRepository

@Service
class ActivityService(private val activityRepository: ActivityRepository) {

    fun getAllActivities(): List<Activity> = activityRepository.findAll()

    fun getActivityById(id: Long): Activity = activityRepository.findById(id)
        .orElseThrow { RuntimeException("Activity with id $id not found") }

    fun getActivitiesByLeadId(leadId: Long): List<Activity> = activityRepository.findByLeadId(leadId)

    fun saveActivity(activity: Activity): Activity = activityRepository.save(activity)
}