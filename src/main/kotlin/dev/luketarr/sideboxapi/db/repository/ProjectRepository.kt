package dev.luketarr.sideboxapi.db.repository

import dev.luketarr.sideboxapi.db.models.Project
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProjectRepository : JpaRepository<Project, Long>{
    fun findProjectById(id: Long): Project?
    fun findProjectByName(name: String): Project?
}