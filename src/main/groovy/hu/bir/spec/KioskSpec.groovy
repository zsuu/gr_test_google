package hu.bir.spec

import geb.spock.GebReportingSpec
import hu.bir.spec.pieces.KioskHomePage
import hu.bir.spec.pieces.KioskRegisztraltIdopontosPage
import org.openqa.selenium.Keys

class KioskSpec extends GebReportingSpec {

    static int delay
    
    def "can get to the 'Idopontra erkezett beteg' page"() {
        when:
        to KioskHomePage
        Thread.sleep(delay)

        and: //hover over to expand the menu
        interact {
            moveToElement(idopontraErkezettBeteg.text)
        }
        Thread.sleep(delay)

        then: //first link is for the current manual
        idopontraErkezettBeteg.text().equals("Időpontra érkezett beteg")
        Thread.sleep(delay)

        when:
        idopontraErkezettBeteg.click()
        Thread.sleep(delay)

        then:
        at KioskRegisztraltIdopontosPage
        Thread.sleep(delay)

        when:
        $("body") << "123456"
        $("body") << Keys.ENTER
        Thread.sleep(delay)

        then:
        waitFor { at KioskRegisztraltIdopontosVanIdopontjaPage }
        Thread.sleep(delay)
    }

}