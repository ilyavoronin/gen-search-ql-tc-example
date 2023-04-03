package gen.searchQL

import kotlin.collections.List

public interface Id : StringBuiltIn

public interface Name : StringBuiltIn

public interface Type : StringBuiltIn

public interface Project {
  public fun getId(): Id

  public fun getName(): Name

  public fun getFeature(): List<Feature>

  public fun getVcs_root(): List<VcsRoot>

  public fun getArchived(): Archived

  public fun getProject(): List<Project>

  public fun getBuild_conf(): List<BuildConf>

  public fun getTemplate(): List<Template>
}

public interface BuildConf : CommonBuildConf

public interface Dependency : CommonBuildConf {
  public fun getArtifact(): List<ArtifactDependency>

  public fun getSnapshot(): SnapshotDependency
}

public interface Template {
  public fun getInheritedBy(): List<BuildConf>

  public fun getId(): Id

  public fun getName(): Name

  public fun getTrigger(): List<Trigger>

  public fun getStep(): List<Step>

  public fun getParam(resolved: ResolvedMod): List<Param>

  public fun getDep(): List<Dependency>

  public fun getVcs_entry(): List<VcsRootEntry>

  public fun getFeature(): List<Feature>
}

public interface Trigger {
  public fun getType(): Type
}

public interface VcsRoot : CommonVcsRoot

public interface VcsRootEntry : CommonVcsRoot {
  public fun getRules(): List<Rule>
}

public interface Step {
  public fun getType(): Type
}

public interface Feature {
  public fun getType(): Type
}

public interface Param {
  public fun getName(): String

  public fun getValue(): String
}

public interface Option {
  public fun getName(): String

  public fun getValue(): String
}

public interface Rule : StringBuiltIn
