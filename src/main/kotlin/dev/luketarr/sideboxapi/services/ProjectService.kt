package dev.luketarr.sideboxapi.services

import dev.luketarr.sideboxapi.db.models.Project
import dev.luketarr.sideboxapi.db.repository.ProjectRepository
import dev.luketarr.sideboxapi.db.repository.TopicRepository
import dev.luketarr.sideboxapi.db.repository.AppUserRepository
import dev.luketarr.sideboxapi.dtos.CreateProjectResponseDTO
import dev.luketarr.sideboxapi.dtos.GetProjectResponseDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class ProjectService(
    private val projectRepository: ProjectRepository,
    private val appUserRepository: AppUserRepository,
    private val topicRepository: TopicRepository
) {

    fun getProject(id: Long): ResponseEntity<GetProjectResponseDTO> {
        val project = projectRepository.findById(id)
            .orElse(null)
            ?: return ResponseEntity.status(HttpStatus.NOT_FOUND).build()


        return ResponseEntity.ok(GetProjectResponseDTO().apply {
            this.id = project.id
            this.name = project.name
            this.description = project.description
            this.createdOn = project.createdOn.toString()
            this.updatedOn = project.updatedOn.toString()
        })
    }
    fun createProject(name: String, description: String, userId: Long): ResponseEntity<CreateProjectResponseDTO> {
        // TODO: This user code needs to be refactored to use the security context
        val user = appUserRepository.findById(userId)
            .orElse(null)
            ?: return ResponseEntity.status(HttpStatus.NOT_FOUND).build()

        val project = projectRepository.save(
            Project().apply {
                this.name = name
                this.description = description
                this.appUser = user
            }
        )
        return ResponseEntity.ok(CreateProjectResponseDTO(project.id))
    }
}