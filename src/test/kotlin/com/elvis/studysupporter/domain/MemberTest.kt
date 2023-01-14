package com.elvis.studysupporter.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Assertions.*

internal class MemberTest: StringSpec({
    "맴버 생성 성공" {
        val member = Member("hello")

        member shouldNotBe null
    }
})