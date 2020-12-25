package click.erudosaba.erudo.etwitchalert

import org.bukkit.configuration.file.FileConfiguration

class Config(plg : Main) {

    val plg = plg
    var config : FileConfiguration? = null

    var communityId : Int

    init {
        plg.saveDefaultConfig()
        if(config != null) {
            plg.reloadConfig()
        }

        config = plg.config

        communityId = config!!.getInt("")
    }
}