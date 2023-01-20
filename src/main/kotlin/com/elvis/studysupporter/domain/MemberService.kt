package com.elvis.studysupporter.domain

import com.elvis.studysupporter.domain.dto.MemberResult
import com.elvis.studysupporter.infrastructure.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class MemberService(
    private val memberRepository: MemberRepository
) {
    fun createMember(nickname: String) = memberRepository.save(Member(nickname))

    fun findMembers(): List<MemberResult> {
        val members = memberRepository.findAll()

        return members
            .map { member -> MemberResult(member.id!!, member.nickname) }
    }
}
