# SE09-SP2: TV-2 Credit Management System

TV-2 Credit Management System is a demo-system demonstrating how to handle credits credits for TV content. 

This project is developed throughout use-cases, specified requirements and contribuation by SDU & TV-2.

## <a name="team-members"></a>Team Members

* [Rasmus Enemark Jacobsen](https://github.com/ras-e)
* [Jens Christian Laue Schütt](https://github.com/Jensschytt)
* [Simon Eldahl](https://github.com/Simoneldahlgit)
* [Christoffer Jensen](https://github.com/ChristofferCor)
* [Anders Østerby](https://github.com/andenbat)

## Installation

The source code is mainly focused on Postgres SQL language and their DB. It is therefore expected that the preferred IDE is connected to PgAdmin.

If above is fullfilled, run the SQL files found in the source code. Start with 1_SETUP_SQL and follow up with the insert statements given in 2_NEXT_SETUP.

If above is fullfilled, 3 demo-users are available. 
Log in with username "admin" pw "admin" to access the admin accesscontrol and explore connected features.
Log in with username "producer" pw "producer" to access the producer accesscontrol and explore connected features.
Log in with username "user" pw "user" to access the general user accesscontrol and explore connected features.
 - You're also able to sign up your own user, but it will be based as a normal user.

Please contact us for any issues that may occure. 

## Functions
- Easy and navigiable UI.
- Access control with a login-system, giving a seperation between a consumer and an administrative system.

* / Consumers:
  * Search for specific persons, programs or a certain credit and the contributators connected hereof. 
* / Admin & Producer: (Both with different rights)
  * Manageable credits tied to productions, 
  * Addable credits / Abiliy to create
