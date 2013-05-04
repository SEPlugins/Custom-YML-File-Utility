Custom YML File Utility
========================
</br>
<p>
<font size=3>I made this utility in hopes of making some peoples life a little easier when making and working with custom yml files. You can use this utility class by just dragging the .class file into your IDE or copying the class and including the neccesary features into the classes that need to access the utilitie's methods.</font>
</p>
</br>
<p>
<font size=3>Below you will find the different methods that are included with this utility, as well as some helpful tips. Note that the utility class is the "CustomYML" file, and the example plugin is the "MainClass" file. </font>
</p>
Methods
=====
<font size=3>You can call these methods from any class by making a simple constructor/object as shown in the Tips section.</font>
getCustomConfig() 
----
<font size=3>Use this to get data or save data to the file. An example of this would be the following: <pre>getCustomConfig().getString("someValue")<code> </pre></code></font>
<font size=3>Of course, you can accomplish much more advanced things with this method, but you get the idea.
This method also checks if the file exists already. If it doesn't it will copy the defaults from the file (if you made one, which you should).
</font>

saveCustomConfig()
-
<font size=3>This method saves the file. I reccomend that you put this in the onDisable(), as well as every time you make a change, add or delete something from the file. </font>

reloadCustomConfig()
-
<font size=3>As you probably guessed, this method reloads the file. This can easily be assigned to a command to reload the file without having to stop your server.</font>
</br>
<font size=3>While there are a few other methods included, they are not required/ usually used so I will leave them out of this readme.</font>

Quick Tips
----
<font size=3> 1) Make sure you create an object/constructor/whatever to this class to use it's methods. If you don't know how, there's tons of posts on that kind of thing on the Bukkit Forums. </font>

<font size =3>2) If you want to make more than 1 custom file, simply make a copy of the class but rename the actual .yml file (the default is customConfigFile.yml).</font>

<font size=3>3) Make the default yml file just like you would a normal config.yml file. Add a new .yml file to your project (by default this MUST be called customConfigFile.yml, but can be changed in the class), and putting whatever defaults you want in there.</font> 

That's it! PM me on Bukkit @SE Plugins for help or whatever ;)
--


