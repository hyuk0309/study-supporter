package com.elvis.studysupporter.domain

import com.elvis.studysupporter.domain.dto.MemberDto
import com.elvis.studysupporter.infrastructure.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class MemberService(
    private val memberRepository: MemberRepository
) {
    fun createMember(nickname: String) = memberRepository.save(Member(nickname))

    fun findMembers(): List<MemberDto> {
        val members = memberRepository.findAll()

        return members
            .map { member -> MemberDto(member.id!!, member.nickname) }
    }
}
