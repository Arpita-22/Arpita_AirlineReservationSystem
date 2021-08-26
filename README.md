# Airline Reservation System

This website is for searching for flights and booking flights.

This website has a signup and login feature for user security implemented with spring security. 

The search functionality on the search page allows the user to search the available flights.

To use the full functionality of the application, the user has to `login` first. If the User has not logged in then clicking on the signUp link in the `login` page  would take the user to the `sign up` page and after signing Up the User is taken back to the login page and after logging in they can access the main page.

	

After `login`  the user is taken to the index page where on the navigation bar the User name is displayed with a welcome message.

User can view all available flights using the `All available Flights` link.

User can view their booking history by clicking on `View Booking` link.

To book a flight, User has to select the Source and destination and also the dates for arrival and departure of flights and then click on the search button which takes them to a `search` page with the list of available flights along with the times they are available and price.

User can now choose to book a flight from the said list and on clicking the link `book flight` it takes them to a separate page `passenger_info` page, where the user has to  fill up a form and provide personal details. User can choose to book a flight for one or many passengers and can also book for other passengers. 


After confirming the passenger details, User is now take into a separate page where they can view the details of the passenger they have entered and if need be can update the passenger details or remove passenger details by clicking on the respective links.

Clicking on the update passenger link takes them to a similar form like `passenger_info` but with already their details and they can update any single field and upon updating it takes them back to the passenger list.

Upon clicking on the confirm booking, user is taken to the `confirm_booking page` where the details of the flight and passenger information is shown.

In the confirm booking page, User can either  choose to delete the booking or generate ticket. Deleting booking takes them to another page with the message that their booking has been deleted. 

If the User chooses the other option then a ticket is generated along with their PNR Number and price and all the details of flight and passenger.

Clicking on the `Home` link takes the User back to the main page. The`logout` link at the top of the main page logs out the user from the application and takes them back to the login page.



When the user `hovers` over a `link` it changes to a different color. Html `form` is used for the `sign up` ,`login` and `search page`. Html `table` is used in the search page. 

Each separate page contains a link `Home` at the top which when clicked takes them back to the `index page`.



`Technical Challenges`

* The passengers date of birth, it was not coming the same from front end to backend and vice-versa. I opted to replace date with local date which solved my problem but then I did not need my init binder method anymore.

* I had to modify my mapping so that I was able to save it to the right table and because of it my tests were failing so I had to modify it and also change my code in the process.

* In one of my controller methods , I was redirecting to a page where in after the redirect my page was showing but without the styling. I had to put my styling inside my jsp pages to keep that from happening.



Github Link: https://github.com/Arpita-22/Arpita_AirlineReservationSystem/tree/development

Author: Arpita Dutta