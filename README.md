# Custom theming for Cameo/MagicDraw

# Problem statement

Cameo/MagicDraw on Linux operating system does not look nearly 
as professional as in Windows. This is due fact that Cameo/Magicdraw
uses the standard look and feel which is not visually appealing and
the fonts are very small, especially on a smaller (14-inch) screen.

# Solution

I created a plugin enabling users to use the wonderful open source 
FlatLAF look and feel theme (https://www.formdev.com/flatlaf/). 

# Demo

![image](https://user-images.githubusercontent.com/8182138/194689638-86fe9c18-868b-44a4-a4e8-8d8419bac6af.png)

# Download release

You can directly download the release without build from the following address:

https://github.com/modeldriven-hu/lookandfeel/releases/tag/1.0.0

# Build the project

## Requirements

- Cameo/MagicDraw latest
- Java JDK 11
- Maven

## Check out the repository

`git clone https://github.com/modeldriven-hu/lookandfeel.git`

## Configure environment variable

Configure Cameo/MagicDraw root directory according to local setup, for example:

`set CAMEO_ROOT=C:/home/Tools/Cameo`

or when using PowerShell:

`$env:CAMEO_ROOT = "C:/Home/Tools/Cameo"`

or under Linux:

'export CAMEO_ROOT=/home/zsolt/tools/cameo'

## Building

Execute `mvn clean package` in the git folder

# Installation

## Extract into Cameo plugins folder

Extract `target/hu.modeldriven.lookandfeel.zip` into `CAMEO_ROOT/plugins`

## Modify the classpath

Although Cameo is able to load our plugin at startup but it seems to have
some issues with the dependent FlatLaf library. The solution for the 
problem right now is to add the library to the classpath of Cameo directly.

In `CAMEO_ROOT/lib` folder there is a file called `classpath.jar`. This is a 
standard zip file. 

### Modify classpath.jar by hand
* Extract the file `META-INF/MANIFEST.MF` to some location. This file contains the list of dependencies. 
* Add  the text `flatlaf-2.5.jar` to the end of the file right after `y.jar`
* Save the file and copy it back to the jar file

### Replace classpath.jar 

An alternative solution is to simply replace the existing classpath.jar file with the file from the release.
Just download the file from https://github.com/modeldriven-hu/lookandfeel/releases/download/1.0.0/classpath.jar
and overwrite the existing `classpath.jar` with the downloaded one.

## Add flatlaf-2.5.jar to lib 

You need also to add flatlaf-2.5.jar to the `CAMEO_ROOT/lib` folder. The jar file is located in `hu.modeldriven.lookandfeel.zip`
which you either downloaded from the website our built yourself.

* Copy `flatlaf-2.5.jar` file into `CAMEO_ROOT/lib` folder

## Restart

In order to use the plugin you need to restart Cameo.

# Usage

In the `Options` menu select `Flat look and feel` then select
the desired theme and press Apply.
