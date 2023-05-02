package impl

import gen.searchQL.objects.BuildConf
import teamCity.objects.TCBuildConf

class WBuildConf(override val buildConf: TCBuildConf): WCommonBuildConf(), BuildConf {
}