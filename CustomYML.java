// Change this to your plugins package.
package com.github.seplugins.customyml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class CustomYML {
	
	/*
	 Simple Custom YML file utility class by @SE Plugins.
	 
	 This utility may be updated from time to time to make your life even easier, so check back at the original post/github page every once in a while.
	 
	 An example plugin using this utility is available on the github page, get the link from the post on Bukkit.
	 
	 Remember to make an object to this class from any class that needs to access the methods. For an example, look at the example plugin.
	 */
	
	// Create an object to the class that extends Java Plugin. CHANGE MainClass so it points to the name of your main class.
	public static MainClass plugin;
	public CustomYML(MainClass plugin){
		CustomYML.plugin = plugin;
	}
	
	/*
	  Initialize the file configuration and file. To change the names/ make several custom config files 
	  		just change the "customConfig" and "customConfigFile" names and wherever else they may be present below.
	 */
	private FileConfiguration customConfig = null;
	private File customConfigFile = null;

	/*
	 Setup the reload method as well as create the file if it is not present. IMPORTANT READ BELOW:
	 	1) Change the "customConfigFile.yml" fields to whatever you want the actual file to be named (or leave it the same if you wish)
	 	2) Make sure you fixed the object to the main class at the top of the class (pointing to the name of the class that extense Java Plugin)
	 */
	public void reloadCustomConfig(){
		if (customConfigFile == null){
			customConfigFile = new File(plugin.getDataFolder(), "customConfigFile.yml");
		}
	
		customConfig = YamlConfiguration.loadConfiguration(customConfigFile);
		
		// Looks for the default file in the jar. Make sure you create the file and add the defaults. (name of it must be whatever you switched "customConfigFile.yml" for.
		InputStream defConfigStream = plugin.getResource("customConfigFile.yml");
		if(defConfigStream != null){
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
			customConfig.setDefaults(defConfig);
		}
	}

		// Get's the custom config file. You will call this method whenever getting a value from the file. If the file doesn't yet exist, it will be created with the defaults copied.
	public FileConfiguration getCustomConfig(){
		if(customConfig == null){
			reloadCustomConfig();
		}
		return customConfig;
	}

		/*
		 	Saves all changes / stuffs to the custom config file. If an errors occurs while saving, it will be logged in the console.
		 	You should call this method in the onDisable() method in your main class to prevent loosing changes.
		 */
	public void saveCustomConfig(){
		if(customConfig == null || customConfigFile == null){
			return;
		}
		try{
			getCustomConfig().save(customConfigFile);
		} catch (IOException ex){
			plugin.getLogger().log(Level.SEVERE, "Could not save config to " + customConfigFile, ex);
		}
	}

		// This isn't required and shouldn't be used unless you know what you're doing with it.
	public void saveDefaultConfig(){
		if(customConfigFile == null){
			customConfigFile = new File(plugin.getDataFolder(), "homeLocations.yml");
		}
		if(!customConfigFile.exists()){
			plugin.saveResource("customConfigFile.yml", false);
		}
	}

}
