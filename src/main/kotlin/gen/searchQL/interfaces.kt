package gen.searchQL

import kotlin.collections.List

public interface CommonBuildConf {
  public fun getId(): Id

  public fun getName(): Name

  public fun getTrigger(withinherited: WithInheritedMod): List<Trigger>

  public fun getStep(withinherited: WithInheritedMod): List<Step>

  public fun getParam(withinherited: WithInheritedMod, resolved: ResolvedMod): List<Param>

  public fun getDep(): List<Dependency>

  public fun getVcs_entry(): List<VcsRootEntry>

  public fun getFeature(): List<Feature>
}

public interface CommonVcsRoot {
  public fun getId(): Id

  public fun getName(): Name

  public fun getParam(resolved: ResolvedMod): List<Param>

  public fun getType(): Type
}
