package io.github.dobiilp.testing.Dobiisentials.commands;

import io.github.dobiilp.testing.Dobiisentials.Dobiisentials;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CEDobiisentialsHeal implements CommandExecutor {
  
  private Logger logger;
  
  public CEDobiisentialsHeal(Dobiisentials plugin) { logger = plugin.getLogger(); }

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!cmd.getName().equalsIgnoreCase(Dobiisentials.COMMAND_HEAL)) { return false; }

    if (sender instanceof Player) {
      commandHealFromPlayer((Player)sender, cmd, args);
    } else {
      commandHealFromConsole(sender, cmd, args);
    }
    
    return true;
  }
  
  
  
  private void commandHealFromPlayer(Player player, Command cmd, String[] args) {
    if (!(player.hasPermission("dobiisentials.heal"))) {
      player.sendMessage(ChatColor.RED + "You don't have the permission to run this command!");
      return;
    }
    
    if (args.length < 1) {
      player.sendMessage(ChatColor.GREEN + "You healed yourself!");
      player.setHealth(20);
      return;
    }
    
    if (args.length > 1) {
      player.sendMessage(ChatColor.RED + "Pleae check your arguments! You can just specify one player to heal.");
      return;
    }
    
    Player player2 = Bukkit.getPlayer(args[0]);
    if (null == player2) {
      player.sendMessage(ChatColor.RED + "Player '" + args[0] + "' is not online now!");
      return;
    }
    
    player2.sendMessage(ChatColor.GREEN + "You have been healed by " + player.getName());
    player2.setHealth(20);
  }
  
  private void commandHealFromConsole(CommandSender sender, Command cmd, String[] args) {
    if (args.length < 1 || args.length > 1) {
      logger.warning(ChatColor.RED + "Check your arguments! This command needs a player specified to heal!");
      return;
    }
    Player player2 = Bukkit.getPlayer(args[0]);
    if (null == player2) {
      logger.warning(ChatColor.RED + "Player '" + args[0] + "' is not online now!");
      return;
    }
    player2.sendMessage(ChatColor.GREEN + "You have been healed using the console!");
    player2.setHealth(20);
  }

}
