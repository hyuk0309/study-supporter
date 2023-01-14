package com.elvis.studysupporter.infrastructure

import com.elvis.studysupporter.domain.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long>
