package com.github.seplugins.customyml;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin{
	
	/* 
	 	Example class that uses the Custom YML File utility by @SE Plugins.
	 	This example may be updated as more flexible features are included.
	 */
	
	// Create an object to the CustomYML class to access its methods.
	public CustomYML fileClass = new CustomYML(this);
	public void onEnable(){
		
		// I created a normal config file below to show that this is 100% compatible with more than 1 config file.
		getConfig().options().copyDefaults(true);
		saveConfig();
		getCommand("addme").setExecutor(this);
	}
	
	public void onDisable(){
		
		// Save the file before server stops to ensure there is no loss in data. This is recommended. 
		fileClass.saveCustomConfig();
	}
		// Make an onCommand method and make a simple command that adds the players name to a list in the custom file.
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
			
			Player player = (Player) sender;
			
			if(cmd.getName().equalsIgnoreCase("addme")){
				if(sender instanceof Player){
					String playerName = player.getName();
					// Create a list to later store to the custom config file.
					List<String> playerNames = new ArrayList<String>();
					playerNames.add(playerName);
					
					// Put the list in the file and save the file.
					fileClass.getCustomConfig().set("Players", playerNames);
					fileClass.saveCustomConfig();
					player.sendMessage("You have been added to the list!");
					
				}else{
					sender.sendMessage("This command can not be executed by the console!");
				}
				return true;
			}
			return false;
		}



}
