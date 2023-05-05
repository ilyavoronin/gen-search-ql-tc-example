package impl

import gen.searchQL.GeneratedObject
import gen.searchQL.objects.*
import java.util.*


class WString(val s: String): StringBuiltIn, WObjectWithMetrics("string") {
    override fun getString(): String {
        return s
    }
}

class WId(private val id: String) : Id, WObject, WObjectWithMetrics("Id") {
    override fun getString(): String {
        return id
    }

    override fun string(): String {
        return "Id($id)"
    }

    override fun equals(other: Any?): Boolean {
        return other is WId && other.id == this.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}

class WName(private val name: String) : Name, WObjectWithMetrics("Name") {
    override fun getString(): String {
        return name
    }

    override fun equals(other: Any?): Boolean {
        return other is WName && other.name == this.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}

class WArchived(private val v: Boolean) : Archived, WObjectWithMetrics("Archived") {
    override fun getBool(): Boolean {
        return v
    }
}

class WParam(private val name: String, private val value: String): Param, WObjectWithMetrics("Id") {
    override fun getName(): WString {
        return WString(name)
    }

    override fun getValue(): WString {
        return WString(value)
    }

    override fun equals(other: Any?): Boolean {
        return other is WParam && other.name == this.name && other.value == this.value
    }

    override fun hashCode(): Int {
        return Objects.hash(name, value)
    }
}

class WOption(private val name: String, private val value: String): Option, WObjectWithMetrics("Option") {
    override fun getName(): WString {
        return WString(name)
    }

    override fun getValue(): WString {
        return WString(value)
    }

    override fun equals(other: Any?): Boolean {
        return other is WOption && other.name == name && other.value == value
    }

    override fun hashCode(): Int {
        return Objects.hash(name, value)
    }
}

class WRule(private val rule: String) : Rule, WObjectWithMetrics("Rule") {
    override fun getString(): String {
        return rule
    }

    override fun equals(other: Any?): Boolean {
        return other is WRule && other.rule == rule
    }

    override fun hashCode(): Int {
        return rule.hashCode()
    }
}

class WType(private val t: String): Type, WObjectWithMetrics("Type") {
    override fun getString(): String {
        return t
    }

    override fun equals(other: Any?): Boolean {
        return other is WType && other.t == t
    }

    override fun hashCode(): Int {
        return t.hashCode()
    }
}