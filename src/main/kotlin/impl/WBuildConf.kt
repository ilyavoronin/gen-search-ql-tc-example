package impl

import gen.searchQL.BuildConf
import teamCity.objects.TCBuildConf

class WBuildConf(override val buildConf: TCBuildConf): WCommonBuildConf(), BuildConf {
}