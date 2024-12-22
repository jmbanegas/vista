package controller

import entity.Lead
import org.springframework.web.bind.annotation.*
import service.LeadService

@RestController
@RequestMapping("/leads")
class LeadController(private val leadService: LeadService) {

    @GetMapping
    fun getAllLeads(): List<Lead> = leadService.getAllLeads()

    @GetMapping("/{id}")
    fun getLeadById(@PathVariable id: Long): Lead = leadService.getLeadById(id)

    @PostMapping
    fun saveLead(@RequestBody lead: Lead): Lead = leadService.saveLead(lead)

    @PostMapping("/{id}/set-status")
    fun updateLeadStatus(@PathVariable id: Long, @RequestParam status: String): Lead =
        leadService.updateLeadStatus(id, status)
}