package gen.searchQL

import kotlin.Boolean
import kotlin.Int
import kotlin.String

public interface BoolBuiltIn {
  public fun getBool(): Boolean
}

public interface StringBuiltIn {
  public fun getString(): String
}

public interface IntBuiltIn {
  public fun getInt(): Int
}
