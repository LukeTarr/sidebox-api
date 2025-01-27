package dev.luketarr.sideboxapi.db.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Lob
import jakarta.persistence.OneToMany
import java.time.LocalDateTime

@Entity
class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = -1

    @Column(columnDefinition = "TEXT")
    var email: String = ""

    @Column(columnDefinition = "TEXT")
    var password: String = ""

    @Column()
    var createdOn : LocalDateTime = LocalDateTime.now()
    @Column()
    var updatedOn : LocalDateTime = LocalDateTime.now()

    @OneToMany(mappedBy = "appUser")
    var projects: MutableSet<Project> = mutableSetOf()
}