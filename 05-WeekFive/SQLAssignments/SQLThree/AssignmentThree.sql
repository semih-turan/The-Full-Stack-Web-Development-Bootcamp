SELECT country FROM country
WHERE country LIKE 'A%a';

SELECT country FROM country
WHERE country LIKE '_____n';

SELECT title FROM film
WHERE title ILIKE '%t%t%t%t%';

SELECT * FROM film
WHERE title ILIKE 'C%'AND length > 90 AND rental_rate = 2.99;
