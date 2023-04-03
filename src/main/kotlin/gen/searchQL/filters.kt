package gen.searchQL

import kotlin.collections.List

public interface Archived : BoolBuiltIn

public interface ArtifactDependency : BoolBuiltIn {
  public fun getRules(resolved: ResolvedMod): List<Rule>
}

public interface SnapshotDependency : BoolBuiltIn {
  public fun getOption(): List<Option>
}

public interface Enabled : BoolBuiltIn

public interface Clean : BoolBuiltIn
