object Id: string

object Name: string

filter Archived: bool

object Type: string

source object Project {
	id: Id [source]
	name: Name [source]
	feature: Feature [many]
	vcs_root: VcsRoot [many, rev]
	archived: Archived
    ref project: Project [many, rev]
    build_conf: BuildConf [many, rev]
    template: Template [many, rev]
}

interface CommonBuildConf {
	id: Id [source]
	name: Name [source]
	trigger: Trigger [many] (withInherited)
	step: Step [many, rev] (withInherited)
	param: Param [many] (withInherited, resolved)
	dep: Dependency [many]
	vcs_entry: VcsRootEntry [many]
	feature: Feature [many]
}

source object BuildConf: CommonBuildConf

filter Dependency->CommonBuildConf {
	artifact: ArtifactDependency [many]
	snapshot: SnapshotDependency
}

filter ArtifactDependency : bool {
	rules: Rule [many] (resolved)
}

filter SnapshotDependency : bool {
    option: Option [many]
}

source object Template {
	ref inheritedBy: BuildConf [rev, many]
	id: Id [source]
	name: Name [source]
	trigger: Trigger [many]
	step: Step [many, rev]
	param: Param [many] (resolved)
	dep: Dependency [many]
	vcs_entry: VcsRootEntry [many]
	feature: Feature [many]
}

object Trigger {
	type: Type
}

interface CommonVcsRoot {
	id: Id
	name: Name
	param: Param [many] (resolved)
	type: Type
}

source object VcsRoot: CommonVcsRoot

object VcsRootEntry: CommonVcsRoot  {
	rules: Rule [many]
}

object Step {
	type: Type
}

object Feature {
	type: Type
}

filter Enabled: bool

object Param {
	name: string
	value: string
} `{name} = {value}`

object Option {
	name: string
	value: string
} `{name} = {value}`

object Rule: string

filter Clean: bool

modifier resolved : bool(false)

modifier withInherited : bool(false)
