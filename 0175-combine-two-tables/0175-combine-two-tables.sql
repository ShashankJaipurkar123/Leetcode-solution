select firstName,  lastName, city, state
from person
left join Address
on person.personId = Address.personId