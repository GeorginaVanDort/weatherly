#Weatherly

Weekly Independent project for Android. Stage THREE.

Welcome to the Weatherly App. At this stage this app is a bare-bones skeleton app that will be built upon in the coming weeks.

Users are asked to Log in or create a new account. This process uses the Firebase Authentication protocol.

User is then asked to choose from a set of hardcoded cities. This will eventually be replaced with the Google Places place-picker. Users have the option to set the city as their home city or just view the weather.

The user is then presented with the current temperature and summary with dynamic data from DarkSky.
User can click on the rain cloud to view the rain forecast in 5-minute intervals. 

Users can click on "save to favorites" to add the location to a list stored in Firebase. **Favorites list can be viewed by clicking on menu -> favorites and is populated through the FirebaseUI library.**   

Users can also click on the location name to be taken to the Google maps app. This will show the exact location of the lat/long variables being used to retrieve the weather.

In future stages, users will be able to create and edit a collection of cities which will be stored in Firebase. I hope to use geolocation services to select Lat/Long values for precise weather forecasts.

This App currently has the following features:
 - API call to Dark Sky using the OKHTTP3 library.
 - A nifti sign in page with Firebase Authentication
 - Favorites list saves to firebase
 - Favorites list is created with the Firebase UI recycler adapter
 - Home city is saved to Shared Preferences
 - Dialogs are used when logging in and authenticating new accounts

   
Technologies Used:
Android Studio 2.3.2

Installation

 - Download Zip file, unzip, open folder in Android Studio.
 - Download any dependencies or packages required to open the project. 
 - Run the project to launch the emulator. Please select Nexus 6P.
 - Please use Android Studio 2.3.2!

Known Bugs
- The city input is hardcoded to a limited list of locations.
 - The confirmation page is still a mock up at this stage. **Choose any option to move to the next activity.**
 - Some icons are still missing and are represented with an image placeholder.
 - Rain forecasts are not rounded to the nearest 5minute mark (but will be in a future release).
 - The ability to click through to the Maps App is not clear - I am working on a solution that indicates to the user this is possible without cluttering up the display.

Future Goals

 - Max and Min temperature values will be added soon.
 - Implement Google Places API to select locations
 - Swipe in-activity to view other locations
 - An hourly view fragment that swipes horizontally nested in the Forecast display
 - Swipe-up for rain forecast
 - Dynamic color-changes depending on temperature


This app was built in Android Studio 2.3.2. It may not open correctly on earlier versions. It was tested primarily on a Nexus 6P and could look a little weird on other devices at the moment.
Support and Contact:
https://github.com/GeorginaVanDort/
