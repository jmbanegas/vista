package service

import entity.Role
import org.springframework.stereotype.Service
import repository.RoleRepository

@Service
class RoleService(private val roleRepository: RoleRepository) {

    fun getAllRoles(): List<Role> = roleRepository.findAll()

    fun getRoleById(id: Long): Role = roleRepository.findById(id)
        .orElseThrow { RuntimeException("Role with id $id not found") }

    fun saveRole(role: Role): Role = roleRepository.save(role)

    fun deleteRole(id: Long) {
        if (!roleRepository.existsById(id)) {
            throw RuntimeException("Role with id $id not found")
        }
        roleRepository.deleteById(id)
    }
}