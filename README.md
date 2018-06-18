# Course Application for Booking

- Front-end interface for new members to sign up and book facilities for their own use
- Back-end administrative interface for staff to manage members, facilities and bookings

## Installation

1. Unzip team11-cab-master.zip
2. Import the unzipped folder into your Eclipse workspace
3. Create a schema in your local database with the name 'team11_cab'
4. Execute SQL script (Unzip "SQL.zip" file and import into MYSQL Workbench)
5. Update Maven
6. Run on server
7. Go to URL 'http://localhost:8080/cab/home'


## Members

- You may sign up as a normal member directly using the front-end interface
- Alternatively, you can login as an existing member by referring to "user" table
  for username. All normal members have their passwords set as "guest" 

## Admin Users

Several admin users are hardcoded into the system at the moment:

- username: gabrielwong, password: password
- username: jawenvoon, password: password
- username: jinkang, password: password

Admins are able to access the back-end management interface.

