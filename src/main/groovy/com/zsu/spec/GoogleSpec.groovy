package com.zsu.spec

import com.zsu.page.GoogleHelloResultPage
import com.zsu.page.GoogleHomePage
import geb.spock.GebReportingSpec

class GoogleSpec extends GebReportingSpec {

    static int delay

    def "can search on google"() {
        given:
        to GoogleHomePage
        Thread.sleep(delay)

        when:
        searchText = "hello"
        Thread.sleep(delay)

        then:
        searchButton.displayed == false
        feelingLuckyButton.displayed == false
        magnifierButton.displayed == true

        and:
        magnifierButton.click()
        Thread.sleep(delay)

        then:
        waitFor { at GoogleHelloResultPage }
        Thread.sleep(delay)
    }

}