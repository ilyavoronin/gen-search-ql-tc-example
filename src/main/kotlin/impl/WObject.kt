package impl

import teamCity.server.tcServer

interface WObject {
    fun string(): String
}

abstract class WObjectWithMetrics(_name: String) {
    init {
        tcServer.objCreated(_name)
    }
}