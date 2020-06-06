# MySQL Server Startup Automation
<p>I like to manage my small server through the commend prompt and I got tired of starting it manually. <br>
So I decided to automate this proccess the old fashioned way, using a Bash script</p>

## Registration
<p>I made 3 files, one of which is a Start.bat shortcut on my desktop. <br>
Start.bat opens the 2 other scripts minimized and then exits.</p>
<img src="https://imgur.com/T6Dykd1.png" width="600" title="Registration Page">

### Login.bat
<p>Login.bat starts by naming the new command promt window to "LOGIN". <br>
Then it navigates to the /bin folder and starts MySQL with username "root" and waits for password input</p>
<img src="https://imgur.com/5dPptKp.png" width="600" title="Login Page">

### Startup.bat
<p>Startup.bat changes the name of the command prompt window to "!SERVER!" and the inner color to red<br>
Then it navigates to the /bin folder and starts mysqld and inputs --console</p>
<img src="https://imgur.com/m7MwVAs.png" width="600" title="Login Page">


# That's it, no more manual startup
### and no more having 2-3 cmd windows all named command prompt :@