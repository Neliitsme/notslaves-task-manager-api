package com.notslaves.taskmanager.service

import com.notslaves.taskmanager.entity.GroupEntity
import com.notslaves.taskmanager.model.Group
import org.springframework.stereotype.Component

@Component
class GroupMapper(
    private val studentMapper: StudentMapper
) {

    fun modelToEntity(model: Group): GroupEntity {
        val entity = GroupEntity()
        entity.name = model.name
        entity.students = model.students?.map { studentMapper.modelToEntity(it) }
        return entity
    }

    fun entityToModel(entity: GroupEntity): Group = Group(
        entity.name!!,
        entity.students?.map { studentMapper.entityToModel(it) } ?: listOf()
    )
}