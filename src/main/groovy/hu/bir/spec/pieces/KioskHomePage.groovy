package hu.bir.spec.pieces

import geb.Page

class KioskHomePage extends Page {

    static at = { title == "BIR Kiosk" }

    static content = {
        ambulansBeteg           { module TileModule, $(".tile", 0) }
        ujBeteg                 { module TileModule, $(".tile", 1) }
        regisztraltBeteg        { module TileModule, $(".tile", 2) }
        idopontraErkezettBeteg  { module TileModule, $(".tile", 3) }
    }
}
