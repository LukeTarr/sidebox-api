package dev.luketarr.sideboxapi.db.repository

import dev.luketarr.sideboxapi.db.models.AppUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AppUserRepository : JpaRepository<AppUser, Long> {
    fun findUserById(id: Long): AppUser?
    fun findByEmail(email: String): AppUser?
}