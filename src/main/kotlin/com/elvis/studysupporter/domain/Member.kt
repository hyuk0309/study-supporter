package com.elvis.studysupporter.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Member(
    nickname: String
) {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    var id: Long? = null

    var nickname = nickname
        protected set
}