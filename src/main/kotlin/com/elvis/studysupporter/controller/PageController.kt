package com.elvis.studysupporter.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class PageController {

    @GetMapping("/")
    fun home() = "home"

    @GetMapping("/select")
    fun select() = "select"
}
