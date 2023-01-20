package com.elvis.studysupporter.controller

import com.elvis.studysupporter.controller.dto.AddMemberRequest
import com.elvis.studysupporter.controller.dto.MembersResponse
import com.elvis.studysupporter.domain.MemberService
import com.elvis.studysupporter.domain.dto.MemberResult
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/members")
class MemberController(
    private val memberService: MemberService
) {
    @PostMapping
    fun addMember(@RequestBody addMemberRequest: AddMemberRequest) {
        memberService.createMember(addMemberRequest.nickname)
    }

    @GetMapping
    fun findMembers(): ResponseEntity<MembersResponse<MemberResult>> {
        val members = memberService.findMembers()
        return ResponseEntity.ok(MembersResponse(members))
    }
}
