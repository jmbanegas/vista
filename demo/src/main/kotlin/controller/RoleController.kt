package controller

import dto.RoleDTO
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/roles")
class RoleController(private val roleService: RoleService) {
    @get:GetMapping
    val allRoles: List<RoleDTO?>?
        get() = roleService.allRoles

    @GetMapping("/{id}")
    fun getRoleById(@PathVariable id: Long?): RoleDTO? {
        return roleService.getRoleById(id)
    }

    @PostMapping
    fun saveRole(@RequestBody roleDTO: RoleDTO?): RoleDTO? {
        return roleService.saveRole(roleDTO)
    }

    @DeleteMapping("/{id}")
    fun deleteRole(@PathVariable id: Long?) {
        roleService.deleteRole(id)
    }
}