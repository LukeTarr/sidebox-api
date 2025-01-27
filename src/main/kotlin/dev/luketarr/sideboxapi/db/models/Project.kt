package dev.luketarr.sideboxapi.db.models

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = -1

    @Column(columnDefinition = "TEXT")
    var name: String = ""

    @Column(columnDefinition = "TEXT")
    var description: String = ""

    @Column()
    var createdOn : LocalDateTime = LocalDateTime.now()

    @Column()
    var updatedOn : LocalDateTime = LocalDateTime.now()

    @ManyToOne
    var appUser: AppUser = AppUser()

    @ManyToMany
    @JoinTable(
        name = "project_topic",
        joinColumns = [JoinColumn(name = "project_id")],
        inverseJoinColumns = [JoinColumn(name = "topic_id")]
    )
    var topics: MutableSet<Topic> = mutableSetOf()

}