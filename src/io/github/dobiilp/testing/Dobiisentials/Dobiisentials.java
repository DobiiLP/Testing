package io.github.dobiilp.testing.Dobiisentials;

import io.github.dobiilp.testing.Dobiisentials.commands.CEDobiisentialsHeal;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;



public class Dobiisentials extends JavaPlugin {
  
  public static final String COMMAND_HEAL = "heal";
  Logger logger = getLogger();

  
	@Override
	public void onEnable() {
	  getCommand("heal").setExecutor(new CEDobiisentialsHeal(this));
	  logger.info("Dobiisentials: Successfully registered 1 command executor");
	}
	@Override
	public void onDisable() {
	  logger.info("Disables FirstPlugin ;)");
	}
}