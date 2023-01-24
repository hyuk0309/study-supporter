package com.elvis.studysupporter.presenter.api

import com.elvis.studysupporter.presenter.api.dto.AddMemberRequest
import com.elvis.studysupporter.presenter.api.dto.MembersResponse
import com.elvis.studysupporter.domain.MemberService
import com.elvis.studysupporter.domain.dto.MemberResult
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/members")
class MemberController(
    private val memberService: MemberService
) {
    @PostMapping
    fun addMember(@RequestBody addMemberRequest: AddMemberRequest): ResponseEntity<Unit> {
        memberService.createMember(addMemberRequest.nickname)
        return ResponseEntity.ok().build()
    }

    @GetMapping
    fun findMembers() = ResponseEntity.ok(MembersResponse(memberService.findMembers()))

    @GetMapping("/random/select")
    fun selectPresenter() = ResponseEntity.ok(memberService.selectPresenter())

    @DeleteMapping("/{id}")
    fun deleteMember(@PathVariable id: Long): ResponseEntity<Unit> {
        memberService.deleteMember(id)
        return ResponseEntity.ok().build()
    }
}
