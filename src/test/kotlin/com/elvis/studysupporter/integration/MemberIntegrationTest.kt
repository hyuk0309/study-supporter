package com.elvis.studysupporter.integration

import com.elvis.studysupporter.controller.dto.AddMemberRequest
import com.elvis.studysupporter.infrastructure.MemberRepository
import com.fasterxml.jackson.databind.ObjectMapper
import io.kotest.core.spec.style.BehaviorSpec
import org.hamcrest.Matchers.`is`
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
internal class MemberIntegrationTest(
    private val mockMvc: MockMvc,
    private val mapper: ObjectMapper,
    private val memberRepository: MemberRepository
) : BehaviorSpec() {
    init {
        afterTest {
            memberRepository.deleteAllInBatch()
        }

        given("call member add API") {
            val nickname = "hello"

            When("happy case") {
                val result = mockMvc.post("/members") {
                    contentType = MediaType.APPLICATION_JSON
                    content = mapper.writeValueAsString(AddMemberRequest(nickname))
                }

                then("response 200 status code") {
                    result.andExpect {
                        status { isOk() }
                    }
                }
            }

            When("empty request body") {
                val result = mockMvc.post("/members") {
                    contentType = MediaType.APPLICATION_JSON
                }

                then("response 400 status code") {
                    result.andExpect {
                        status { is4xxClientError() }
                    }
                }
            }
        }

        given("call find members API") {

            addMember()

            When("happy case") {
                val result = mockMvc.get("/members") {
                    accept = MediaType.APPLICATION_JSON
                }

                then("response 200 status code") {
                    result.andExpect {
                        status { isOk() }
                        jsonPath("$.data.length()", `is`(1))
                    }.andDo {
                        print()
                    }
                }
            }
        }
    }

    private fun addMember() {
        mockMvc.post("/members") {
            contentType = MediaType.APPLICATION_JSON
            content = mapper.writeValueAsString(AddMemberRequest("hi"))
        }.andExpect {
            status { isOk() }
        }
    }
}
