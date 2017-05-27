# Weatherly

Weekly Independent project for Android. Stage ONE.

Welcome to the Weatherly App. At this stage this app is a bare-bones skeleton app that will be built upon in the coming weeks.

Users can input a City and will be taken to a mock confirmation activity that populates a list of possible cities based on input. This will eventually (hopefully) be achieved with Google Places Autocomplete.

The user is then presented with a mock-up of the current temperature and summary for the chosen city. This will be replaced with dynamic data from DarkSky next week.

User can click on another link to view the rain forecast in 5-minute intervals (also a mock up at this stage). The custom adapter here has a placeholder for forecast icons.

In future stages, users will be able to create and edit a collection of cities which will be stored in Firebase. I hope to use geolocation services to select Lat/Long values for precise weather forecasts.


This App currently has the following features:
 
- 4 activities that the user can navigate to.

- Hierarchy that allows for an Up Button.

- 2 lists - one for city names and one for rain forecasts.

- A custom ArrayAdapter and a custom BaseAdapter.

- Custom Font.

- Intents to take city input from user and pass along activities.

- City input is checked for null input.  

- ButterKnife is used to bind all views.

- View.OnClickListener interface is used to set click listeners to view elements.

- Toast and dialog fragments implemented to alert user to errors and results.

##### Technologies Used:

Android Studio 2.3.2

##### Installation

Download Zip file, unzip, open folder in Android Studio. Download any dependencies or packages required to open the project.
Run the project to launch the emulator. Please select Nexus 6P.
Please use Android Studio 2.3.2! 

##### Known Bugs

This app was built in Android Studio 2.3.2. It may not open correctly on earlier versions. It was tested primarily on a Nexus 6P and could look a little weird on other devices at the moment.

##### Support and Contact:

https://github.com/GeorginaVanDort/




