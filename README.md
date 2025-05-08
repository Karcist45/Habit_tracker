# Habit Tracker
It is known that consistency is key. This projects helps users to track their daily healthy habits by sending them emails and tracking their progress. For example drinking plenty of water, following sleeping schedule, doing exercises and being productive. 

This project will be extended
## Architecture
- Spring boot as an application skeleton, making  configuration much easier
- Spring Web MVC - to build RESTful interface
- Spring Data JPA(Hibernate) - to create a persistent data storage
- PostgreSQL - to store data
- Google SMTP - to send email notifications
## Entity Scheme
```plantuml
entity "habits" {
*habit_id : bigint
description : varchar(255)
owner : bigint <<FK>> // users(user_id)

}

entity "users" {
*user_id : bigint
username : varchar(255)
password : varchar(255)
email : varchar(255)
}

entity "habit_records"{
*habit_record_id : bigint
timestamp : timestamp
habit_id :  <<FK>> // habits(habit_id)
}

"users" ||--o|"habits" : "Creates"
"habits" ||--o|"habit_records" : "Tracks"

```