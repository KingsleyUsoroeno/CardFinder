# CardFinder
A Simple Android Application that integrates kotlin,Retrofit and coroutines and helps users fetch details regarding their card from the binList Api

The Application Consists of different modules
- Data
- Views
- Utils

Data represents the models and network layer that helps us connects to our remote DataSource being the binList API, the App dosent do any caching
or storing of data so all data will be lost when the App is killed on the foreground or by the user.
As well as our Repository which our respectitive ViewModels connects to.

Utils consists of constants that are used across the App.

Views consists of our UI Component such as our Fragments and Activity to host those various fragments



