package com.elvis.studysupporter.domain

import com.elvis.studysupporter.domain.dto.MemberResult
import com.elvis.studysupporter.infrastructure.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.random.Random

@Transactional(readOnly = true)
@Service
class MemberService(
    private val memberRepository: MemberRepository
) {
    @Transactional(readOnly = false)
    fun createMember(nickname: String) = memberRepository.save(Member(nickname))

    fun findMembers(): List<MemberResult> {
        val members = memberRepository.findAll()

        return members
            .map { member -> MemberResult(member.id!!, member.nickname) }
    }

    fun selectPresenter(): MemberResult {
        val members = memberRepository.findAll()

        val presenterIndex = Random.nextInt(members.size)
        return MemberResult(members[presenterIndex].id!!, members[presenterIndex].nickname)
    }

    fun deleteMember(id: Long) {
        memberRepository.deleteById(id)
    }
}
