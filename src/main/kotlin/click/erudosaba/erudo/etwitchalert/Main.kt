package click.erudosaba.erudo.etwitchalert

import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {

    private val pluginName = "eTwitchAlert"

    override fun onDisable() {
        logger.info("Disabled $pluginName")
    }

    override fun onEnable() {
        logger.info("Enabled $pluginName")

        var config = Config(this)

        var scheduler = AlertScheduler(this)
    }
}