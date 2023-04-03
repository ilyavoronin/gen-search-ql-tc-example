package impl

import gen.searchQL.VcsRoot
import teamCity.objects.TCVcsRoot

class WVcsRoot(override val vcsRoot: TCVcsRoot) : WCommonVcsRoot(), VcsRoot {}