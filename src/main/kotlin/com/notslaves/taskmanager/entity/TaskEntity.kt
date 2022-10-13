package com.notslaves.taskmanager.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "tasks")
class TaskEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    var id: Int? = null

    @Column(name = "name")
    var name: String? = null

    @Lob
    @Column(name = "description")
    var description: String? = null

    @ManyToOne()
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    var status: TaskStatusEntity? = null

    @ManyToOne(cascade = [CascadeType.REMOVE])
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    var user: UserEntity? = null
}