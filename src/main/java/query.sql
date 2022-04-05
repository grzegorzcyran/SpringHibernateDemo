select * from actor;

select district, a.* from address a;

select district as obszar, address as adres_1, postal_code as kod_pocztowy from address as a;

select a.district as obszar, a.address as adres_1, a.postal_code as kod_pocztowy from address as a;

select * from address;

--jeśli chcemy wybrać tylko takie gdzie jest kod pocztowy
select * from address
where postal_code is not null
  and postal_code != '';

select *
from address
where district = 'California';
select *
from address
where district <> 'California';

select * from city;

select a.address, a.district, a.postal_code, a.phone, c.city, k.country
from address as a
         join city as c on a.city_id = c.city_id
         join country as k on k.country_id = c.country_id;



select a.address, a.district, a.postal_code, a.phone, c.city
from address as a, city as c, country k
where a.city_id = c.city_id
  and c.country_id = k.country_id;

--relacja wiele do wielu
--przez tabelę pośrednią
select a.first_name, a.last_name, f.title
from actor as a
         join film_actor fa on a.actor_id = fa.actor_id
         join film f on fa.film_id = f.film_id
where f.title = 'Academy Dinosaur';

select a.first_name, a.last_name, f.title
from actor as a
         join film_actor fa on a.actor_id = fa.actor_id
         join film f on fa.film_id = f.film_id and f.title = 'Academy Dinosaur';


select * from customer;

select * from staff;

select * from store;

select a.address, a.district, a.postal_code,  s.first_name, s.last_name from address a
                                                                                 left join staff s on a.address_id = s.address_id;

select a.address, a.district, a.postal_code,  s.first_name, s.last_name from staff s right join address a on a.address_id = s.address_id;


select count(district), district
from address
group by district;

--dla "zgrupowanych" zapytań nie ma "where", jest "having"
select count(district), district
from address
group by district
having count(district) >= 4
order by count(district) desc;

select * from address
where district = 'West Bengali';

select * from address
where district = 'West Bengali'
  and postal_code > '60000';

select * from address
where district in ('West Bengali', 'Alberta', 'QLD');

select * from address
where district in ('West Bengali', 'Alberta', 'QLD')
--and (postal_code > '40000' or postal_code is null); to nie działa bo pole jest puste ale nie null ;P
  and (postal_code > '40000' or postal_code = '')
order by address;

--->>>>>>>>>>>>>>
--różnica między "left join .. on .. and"
--będziemy mieć widoczne rekordy gdzie aktor jest bez filmu
--bo grał w innych niż "Academy Dinosaur"
select a.first_name, a.last_name, f.title
from actor as a
         join film_actor fa on a.actor_id = fa.actor_id
         left join film f on fa.film_id = f.film_id and f.title = 'Academy Dinosaur';

--a "left join .. on .. where"
--będą tylko aktorzy którzy grali w "Academy Dinosaur"
--bo WHERE działa PRZED!!!! left joinem obcinając zbiór danych na których left join ma działać
select a.first_name, a.last_name, f.title
from actor as a
         join film_actor fa on a.actor_id = fa.actor_id
         left join film f on fa.film_id = f.film_id
where f.title = 'Academy Dinosaur';
--<<<<<<<<<<<<<<<

--distinct zwraca unikaty
select distinct(replacement_cost) from film;

--sprawdzenie ile razy taki replacement_cost występuje
select replacement_cost, count(replacement_cost) from film
group by replacement_cost;

--unikalne rekordy z zapytania które może zwracać duplikaty
select distinct a.first_name, a.last_name
from actor as a
         join film_actor fa on a.actor_id = fa.actor_id and a.first_name = 'Penelope'
         left join film f on fa.film_id = f.film_id

--podzapytania
select distinct a.first_name, a.last_name
from actor as a
         join film_actor fa on a.actor_id = fa.actor_id
where film_id in (select film_id from film where title = 'Academy Dinosaur')

--UNION ALL
select f.title from actor a join
                    film_actor fa on a.actor_id = fa.actor_id and  a.actor_id = 1
                            join film f on fa.film_id = f.film_id
union all
select f.title from actor a join
                    film_actor fa on a.actor_id = fa.actor_id and  a.actor_id = 10
                            join film f on fa.film_id = f.film_id;


--vs
--UNION
select f.title from actor a join
                    film_actor fa on a.actor_id = fa.actor_id and  a.actor_id = 1
                            join film f on fa.film_id = f.film_id
union
select f.title from actor a join
                    film_actor fa on a.actor_id = fa.actor_id and  a.actor_id = 10
                            join film f on fa.film_id = f.film_id;

--vs
--UNION ALL z subquery
select distinct title from (
                               select f.title from actor a join
                                                   film_actor fa on a.actor_id = fa.actor_id and  a.actor_id = 1
                                                           join film f on fa.film_id = f.film_id
                               union all
                               select f.title from actor a join
                                                   film_actor fa on a.actor_id = fa.actor_id and  a.actor_id = 10
                                                           join film f on fa.film_id = f.film_id) subquery;


select * from actor where actor_id = 1;

update actor set last_name = 'Cruz' where actor_id = 1

--transakcja bazodanowa


