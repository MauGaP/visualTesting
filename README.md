# visualTesting
This is a project I started to explore some concepts about Visual Testing.
First of all, install java and maven.

It uses 
- Shutterbug to capture the screenshots.
- Selenium for everything related to UI interaction.

#DriverLocation
place chromedriver (https://chromedriver.chromium.org/downloads) in folder:
- `src/test/resources/driver`

# To execute
The following command can be executed to capture the screenshots 
- `mvn clean verify -Dcucumber.options="--tags @ImageCapture"`

The following command can be executed to execute the comparison between the capture images and the Golden images
- `mvn clean verify -Dcucumber.options="--tags @ImageCompare"`

### Note
Note that, in order to execute this module you have to manually pick which images are your Golden Images, and place them in the following folder structure:
 
`/screenshots/Golden_Image/<images with the same name of the captured ones>`

the result of the comparison will be located at:

`/screenshots/Comparison_Result/<resulting images>`  

Another dependency is ImageMagick Installed in the System that execute this tests, I'm working on a solutions to this, in order to execute this tests everywhere (like Jenkins)