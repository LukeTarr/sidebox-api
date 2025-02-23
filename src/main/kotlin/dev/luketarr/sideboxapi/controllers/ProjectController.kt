package dev.luketarr.sideboxapi.controllers


import dev.luketarr.sideboxapi.dtos.CreateProjectRequestDTO
import dev.luketarr.sideboxapi.dtos.CreateProjectResponseDTO
import dev.luketarr.sideboxapi.dtos.GetProjectResponseDTO
import dev.luketarr.sideboxapi.dtos.UpdateProjectRequestDTO
import dev.luketarr.sideboxapi.services.ProjectService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import dev.luketarr.sideboxapi.dtos.CreateProjectRequestDTO as CreateProjectRequestDTO1

@RestController
@RequestMapping("/api")
@Tag(name = "Projects", description = "Project API")
class ProjectController(
    private val projectService: ProjectService
) {
    private val developmentUserID : Long = 1

    @GetMapping("/projects")
    fun getAllProjects() : String {
        return "Hello World"
    }

    @PostMapping("/project")
    fun createProject(@RequestBody body : CreateProjectRequestDTO) : ResponseEntity<CreateProjectResponseDTO> {
        return ResponseEntity.ok(this.projectService.createProject(body.name, body.description, developmentUserID))
    }

    @GetMapping("/project/{id}")
    fun getProjects(@PathVariable id: String) : ResponseEntity<GetProjectResponseDTO> {
        return ResponseEntity.ok(this.projectService.getProject(id.toLong()))
    }

    @DeleteMapping("/project/{id}")
    fun deleteProject(@PathVariable id: String) : ResponseEntity<Unit> {
        return ResponseEntity.ok(this.projectService.deleteProject(id.toLong(), developmentUserID))
    }

    @PutMapping("/project/{id}")
    fun updateProject(@PathVariable id: String, @RequestBody body: UpdateProjectRequestDTO) : ResponseEntity<CreateProjectResponseDTO> {
        return ResponseEntity.ok(
            this.projectService.updateProject(id.toLong(), developmentUserID, body.name, body.description)
        )
    }

    @GetMapping("/project/test")
    fun test() : ResponseEntity<Unit> {
        return ResponseEntity.ok(
            this.projectService.errorTest()
        )
    }

}