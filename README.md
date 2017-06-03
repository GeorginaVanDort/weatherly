#Weatherly

Weekly Independent project for Android. Stage TWO.

Welcome to the Weatherly App. At this stage this app is a bare-bones skeleton app that will be built upon in the coming weeks.

Users can input a City and will be taken to a mock confirmation activity (**click any city to continue!**) that populates a list of possible cities based on input. *At the moment this is hardcoded to Portland, OR.*  This will eventually (hopefully) be achieved with Google Places Autocomplete.

The user is then presented with the current temperature and summary with dynamic data from DarkSky.
User can click on the rain cloud to view the rain forecast in 5-minute intervals. The recycler adapter here has a placeholder for the forecast icons that will be implemented soon.

Users can also click on the current location (Portland) to be taken to the Google maps app. This will show the exact location of the lat/long variables being used to retrieve the weather.

In future stages, users will be able to create and edit a collection of cities which will be stored in Firebase. I hope to use geolocation services to select Lat/Long values for precise weather forecasts.

This App currently has the following features:
 - API call to Dark Sky using the OKHTTP3 library.
 - Code refactored into packages for Models, UI, Adapters and Services
 - 2 models to hold forecast data.
 - A recycler view to display 5 minute rain forecasts
 - Implicit intent allows users to navigate to the Maps app by clicking on the location name.
 - Parceling of data
 - 4 activities that the user can navigate to.
 - Hierarchy that allows for an Up Button.
 - Custom Fonts. 
 - Intents to take city input from user and pass along activities. 
 - City input is checked for null input. 
 - ButterKnife is used to bind all views.
 - View.OnClickListener interface is used to set click listeners to view
   elements.
 - Toast and dialog fragments implemented to alert user to
   errors and results.
   
Technologies Used:
Android Studio 2.3.2

Installation

 - Download Zip file, unzip, open folder in Android Studio.
 - Download any dependencies or packages required to open the project. 
 - Run the project to launch the emulator. Please select Nexus 6P.
 - Please use Android Studio 2.3.2!

Known Bugs
- The city input is hardcoded to Portland for right now (Perfect if you live here! :D) 
 - The confirmation page is still a mock up at this stage. **Choose any option to move to the next activity.**
 - Some icons are still missing and are represented with an image placeholder.
 - Rain forecasts are not rounded to the nearest 5minute mark (but will be in a future release).
 - The ability to click through to the Maps App is not clear - I am working on a solution that indicates to the user this is possible without cluttering up the display.

Future Goals

 - Max and Min temperature values will be added soon.
 - Implement Google Places API to select locations
 - Use firebase or preferences to store locations
 - Swipe in-activity to view other locations
 - An hourly view fragment that swipes horizontally nested in the Forecast display
 - Swipe-up for rain forecast
 - Ability to add new locations from the forecast page


This app was built in Android Studio 2.3.2. It may not open correctly on earlier versions. It was tested primarily on a Nexus 6P and could look a little weird on other devices at the moment.
Support and Contact:
https://github.com/GeorginaVanDort/
