# How to begin:

## 1: Download and install IntelliJ IDEA
You should get free access through the University of Oklahoma.
Dowload link: https://www.jetbrains.com/idea/?var=1
Install and use your University of Oklahoma email to authenticate that you're a student. Also connect your account to github to make life easier.

## 2: Clone the repository
Check out this link for an explanation:
https://stackoverflow.com/questions/2505096/clone-a-private-repository-github
You will have to make a personal access token and use it to clone the repository onto your computer.
The command is **git clone https://*pat*@github.com/*your account or organization*/*repo*.git**
Make sure in the terminal that you are located in the file path that you want the repository to be saved in when you type this command!

## 3: Open the project in IntelliJ
Once you are logged in to Intellij, from the home screen you should be able to open a project from your files.

## 4: Compile using Maven
click the dropdown at the top for Run/Debug Configurations and select "Edit Configurations"
    It probably says something like "Current File" when you first look at it.
    Add a new configuration and use Maven.
On the command line, you should have javafx:run
Under Maven Options and Java Options, you can inherit from settings, but make sure that you are using SDK 22.

If it says something other than that, apply your changes
   go to File  Project Structure > SDKs.
   Then click the "+" and Download JDK to get Version 22.

Once you have ensured that the run command is correct and the JDK version is correct, click the Run/Debug dropdown again and run CalorieMinder [javafx:run]

## 5: run the GUI or any other application
Once the compiler has successfully run and does not return any errors, you are good to run any file with a "Main" function as an application.

## 6: Committing and Pushing changes
Try not significantly change file structures without consulting the group first.
To commit changes, just click the second option on the left that looks like a line with a circle in the middle
Give your commit a message, and click "commit"
then go to your terminal and type git push


