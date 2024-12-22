package service

import entity.Lead
import org.springframework.stereotype.Service
import repository.LeadRepository

@Service
class LeadService(private val leadRepository: LeadRepository) {

    fun getAllLeads(): List<Lead> = leadRepository.findAll()

    fun getLeadById(id: Long): Lead = leadRepository.findById(id)
        .orElseThrow { RuntimeException("Lead with id $id not found") }

    fun saveLead(lead: Lead): Lead = leadRepository.save(lead)

    fun updateLeadStatus(id: Long, status: String): Lead {
        val lead = getLeadById(id)
        val updatedLead = lead.copy(status = status)
        return leadRepository.save(updatedLead)
    }

    fun deleteLead(id: Long) {
        if (!leadRepository.existsById(id)) {
            throw RuntimeException("Lead with id $id not found")
        }
        leadRepository.deleteById(id)
    }
}