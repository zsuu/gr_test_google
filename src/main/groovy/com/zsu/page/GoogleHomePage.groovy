package com.zsu.page

import geb.Page

class GoogleHomePage extends Page {

    static at = { title == "Google" }

    static content = {
        searchText             { $("input", type: "text") }
        magnifierButton        { $("button", name: "btnG") }
        searchButton           { $("input", type: "submit", name: "btnK") }
        feelingLuckyButton     { $("input", type: "submit", name: "btnI") }
    }
}
