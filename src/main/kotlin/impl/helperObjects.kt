package impl

import gen.searchQL.*

class WId(private val id: String) : Id {
    override fun getString(): String {
        return id
    }
}

class WName(private val name: String) : Name {
    override fun getString(): String {
        return name
    }
}

class WArchived(private val v: Boolean) : Archived {
    override fun getBool(): Boolean {
        return v
    }
}

class WParam(private val name: String, private val value: String): Param {
    override fun getName(): String {
        return name
    }

    override fun getValue(): String {
        return value
    }
}

class WOption(private val name: String, private val value: String): Option {
    override fun getName(): String {
        return name
    }

    override fun getValue(): String {
        return value
    }
}

class WRule(private val rule: String) : Rule {
    override fun getString(): String {
        return rule
    }
}

class WType(private val t: String): Type {
    override fun getString(): String {
        return t
    }
}