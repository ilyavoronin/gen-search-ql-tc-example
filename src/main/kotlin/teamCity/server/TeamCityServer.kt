package teamCity.server

import teamCity.objects.*

class TeamCityServer(cntProjects: Int) {

    val projects: HashMap<String, TCProject> = HashMap()
    val projectByName: HashMap<String, TCProject> = HashMap()
    val buildConfs: HashMap<String, TCBuildConf> = HashMap()
    val buildConfByName: HashMap<String, TCBuildConf> = HashMap()
    val vcsRoots: HashMap<String, TCVcsRoot> = HashMap()
    val vcsRootByName: HashMap<String, TCVcsRoot> = HashMap()
    val templates: HashMap<String, TCTemplate> = HashMap()
    val templateByName: HashMap<String, TCTemplate> = HashMap()

    private val idsMap = mutableMapOf<String, Int>()

    val pCntBuildConfs = 10
    val pCntTemplates = 10
    val pCntVcsRoots = 2
    val pCntFeatures = 3
    val cntSubprojects = 3
    val maxDepth = 3

    val cCntTriggers = 3
    val cCntParams = 10

    init {
        for (i in 0..cntProjects) {
            genProject(0, null)
        }

        projects["project50"]!!.features.add(TCFeature(genIntId("feature"),"unique_type"))
    }

    fun genProject(depth: Int, parentId: String?): TCProject {
        val projectId = genId("project")
        val bcs = (0 until pCntBuildConfs).map {
            genBuildConf(projectId)
        }
        val templates = (0 until pCntTemplates).map {
            genTemplate(projectId)
        }

        val vcsRoots = (0 until pCntVcsRoots).map {
            genVcsRoot(projectId, "p")
        }

        val subprojects = if (depth < maxDepth) {
            (0 until cntSubprojects).map {
                genProject(depth + 1, projectId)
            }
        } else {
            listOf()
        }

        val features = (0 until pCntFeatures).map {
            TCFeature(genIntId("feature"), "feature1")
        }


        val newProject = TCProject(
            projectId,
            parentId,
            projectId.capitalize(),
            bcs, templates,
            vcsRoots,
            subprojects,
            features.toMutableList(),
            projectId.endsWith("5")
        )
        projects[projectId] = newProject
        projectByName[newProject.name] = newProject

        return newProject
    }

    fun genId(prefix: String): String {
        val id = genIntId(prefix)
        return "$prefix$id"
    }

    fun genIntId(prefix: String): Int {
        if (!idsMap.containsKey(prefix)) {
            idsMap[prefix] = 0
        }
        val id = idsMap[prefix]
        idsMap[prefix] = idsMap[prefix]!! + 1
        return id!!
    }

    fun genBuildConf(parentId: String): TCBuildConf {
        val confId = genId("conf")

        val triggers = (0 until cCntTriggers).map {
            TCTrigger(genIntId("feature"), if (confId.last() in listOf('2', '4', '6', '8', '0'))  {
                "scheduled"
            } else {
                "vcs"
            })
        }

        val steps = (0 until cCntTriggers).map {
            TCStep(genIntId("step"), if (confId.last() in listOf('2', '4', '6', '8', '0')) {
                "golang"
            } else {
                "cmake"
            })
        }

        val params = (0 until cCntParams).map { i ->
            TCParam("${confId}_name$i","${confId}_val$i")
        }

        val vcsRoots = (0 until pCntVcsRoots).map { i ->
            genVcsRoot(confId, "c")
        }

        val features = (0 until pCntFeatures).map { i ->
            TCFeature(genIntId("feature"), if (confId.last() in listOf('2', '4', '6', '8', '0')) {
                "feature1"
            } else {
                "feature2"
            })
        }

        val newConf = TCBuildConf(
            confId,
            parentId,
            confId.capitalize(),
            triggers,
            steps,
            params,
            mapOf(),
            mapOf(),
            vcsRoots,
            features
        )

        buildConfs[confId] = newConf
        buildConfByName[newConf.name] = newConf

        return newConf
    }

    fun genTemplate(parentId: String): TCTemplate {
        val templateId = genId("temp")

        val triggers = (0 until cCntTriggers).map {
            TCTrigger(genIntId("trigger"), if (templateId.last() in listOf('2', '4', '6', '8', '0'))  {
                "scheduled"
            } else {
                "vcs"
            })
        }

        val steps = (0 until cCntTriggers).map {
            TCStep(genIntId("step"), if (templateId.last() in listOf('2', '4', '6', '8', '0')) {
                "golang"
            } else {
                "cmake"
            })
        }

        val params = (0 until cCntParams).map { i ->
            TCParam("${templateId}_name$i","${templateId}_val$i")
        }

        val vcsRoots = (0 until pCntVcsRoots).map { i ->
            genVcsRoot(templateId, "c")
        }

        val features = (0 until pCntFeatures).map { i ->
            TCFeature(genIntId("feature"), if (templateId.last() in listOf('2', '4', '6', '8', '0')) {
                "feature1"
            } else {
                "feature2"
            })
        }

        val newTemp = TCTemplate(templateId, parentId, templateId.capitalize(), triggers, steps, params, mapOf(), mapOf(), vcsRoots, features)

        templates[templateId] = newTemp
        templateByName[newTemp.name] = newTemp

        return newTemp
    }

    fun genVcsRoot(parentId: String, type: String): TCVcsRoot {
        val vcsId = genId("vcs")

        val newVcs = TCVcsRoot(vcsId, parentId, type, vcsId.capitalize(), listOf(), "git", listOf("rule1", "rule2"))

        vcsRoots[vcsId] = newVcs
        vcsRootByName[newVcs.name] = newVcs

        return newVcs
    }
}