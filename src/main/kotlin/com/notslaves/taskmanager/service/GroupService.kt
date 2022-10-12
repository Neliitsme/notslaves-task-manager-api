package com.notslaves.taskmanager.service

import com.notslaves.taskmanager.model.Group
import com.notslaves.taskmanager.repository.GroupRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class GroupService(
    private val mapper: GroupMapper,
    private val repository: GroupRepository
) {

    fun getGroups(): List<String> = repository.findAll().map { it?.name!! }

    @Transactional
    fun findGroup(name: String): Group? = repository.findByName(name)?.let { mapper.entityToModel(it) }

    fun createGroup(group: Group): Group {
        val entity = mapper.modelToEntity(group)
        return mapper.entityToModel(repository.save(entity))
    }

    @Transactional
    fun deleteGroup(name: String) = repository.deleteByName(name)
}