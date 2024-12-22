package controller

import entity.Activity
import org.springframework.web.bind.annotation.*
import service.ActivityService

@RestController
@RequestMapping("/activities")
class ActivityController(private val activityService: ActivityService) {

    @GetMapping
    fun getAllActivities(): List<Activity> = activityService.getAllActivities()

    @GetMapping("/{id}")
    fun getActivityById(@PathVariable id: Long): Activity = activityService.getActivityById(id)

    @GetMapping("/leads/{leadId}")
    fun getActivitiesByLeadId(@PathVariable leadId: Long): List<Activity> =
        activityService.getActivitiesByLeadId(leadId)

    @PostMapping
    fun saveActivity(@RequestBody activity: Activity): Activity = activityService.saveActivity(activity)
}