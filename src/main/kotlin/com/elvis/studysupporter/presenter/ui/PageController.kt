package com.elvis.studysupporter.presenter.ui

import com.elvis.studysupporter.presenter.api.MemberController
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class PageController(
    private val memberController: MemberController
) {

    @GetMapping("/")
    fun home() = "home"

    @GetMapping("/select")
    fun select(model: Model): String {
        val result = memberController.findMembers()
        model.addAttribute("members", result.body!!.data)

        return "select"
    }
}
