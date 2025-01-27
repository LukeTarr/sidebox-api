package dev.luketarr.sideboxapi.db.repository

import dev.luketarr.sideboxapi.db.models.Topic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TopicRepository : JpaRepository<Topic, Long> {
    fun findTopicByName(name: String): Topic?
    fun findTopicById(id: Long): Topic?
}