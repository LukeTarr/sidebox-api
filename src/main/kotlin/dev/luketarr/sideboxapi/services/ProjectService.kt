package dev.luketarr.sideboxapi.services

import dev.luketarr.sideboxapi.db.models.Project
import dev.luketarr.sideboxapi.db.repository.ProjectRepository
import dev.luketarr.sideboxapi.db.repository.TopicRepository
import dev.luketarr.sideboxapi.db.repository.AppUserRepository
import dev.luketarr.sideboxapi.dtos.CreateProjectResponseDTO
import dev.luketarr.sideboxapi.dtos.GetProjectResponseDTO
import dev.luketarr.sideboxapi.dtos.ResourceNotFoundException
import dev.luketarr.sideboxapi.dtos.UnauthorizedException
import java.time.LocalDateTime
import org.springframework.stereotype.Service

@Service
class ProjectService(
    private val projectRepository: ProjectRepository,
    private val appUserRepository: AppUserRepository,
    private val topicRepository: TopicRepository
) {

    fun getProject(id: Long): GetProjectResponseDTO {
        val project = projectRepository.findById(id)
            .orElse(null)
            ?: throw ResourceNotFoundException("Project not found")


        return GetProjectResponseDTO(
            id,
            project.name,
            project.description,
            project.createdOn.toString(),
            project.updatedOn.toString(),

        )
    }
    fun createProject(name: String, description: String, userId: Long): CreateProjectResponseDTO {
        // TODO: This user code needs to be refactored to use the security context
        val user = appUserRepository.findById(userId)
            .orElse(null)
            ?: throw UnauthorizedException("User not found")

        val project = projectRepository.save(
            Project().apply {
                this.name = name
                this.description = description
                this.appUser = user
            }
        )
        return CreateProjectResponseDTO(project.id)
    }

    fun updateProject(id: Long, userId: Long, name: String?, description: String?): CreateProjectResponseDTO {
        val project = projectRepository.findById(id)
            .orElse(null)
            ?: throw ResourceNotFoundException("Project not found")

        if (project.appUser.id != userId) {
            throw UnauthorizedException("User not authorized")
        }

        project.name = name ?: project.name
        project.description = description ?: project.description
        project.updatedOn = LocalDateTime.now()

        val updatedProject = projectRepository.save(project)

        return CreateProjectResponseDTO(updatedProject.id)
    }

    fun deleteProject(id: Long, userId: Long) {
        val project = projectRepository.findById(id)
            .orElse(null)
            ?: throw ResourceNotFoundException("Project not found")

        if (project.appUser.id != userId) {
            throw UnauthorizedException("User not authorized")
        }

        projectRepository.delete(project)
    }

    fun errorTest(){
        throw ResourceNotFoundException("This is a test")
    }
}