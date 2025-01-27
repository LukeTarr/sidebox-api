package dev.luketarr.sideboxapi.db.models

import jakarta.persistence.*

@Entity
class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = -1

    @Column(columnDefinition = "TEXT")
    var name: String = ""

    @ManyToMany(mappedBy = "topics")
    var projects: MutableSet<Project> = mutableSetOf()
}