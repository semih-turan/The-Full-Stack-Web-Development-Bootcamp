SELECT rating FROM film
GROUP BY rating;

SELECT replacement_cost, COUNT(*) AS film_count
FROM film
GROUP BY replacement_cost
HAVING COUNT(*) > 50
ORDER BY replacement_cost DESC;

SELECT store_id, COUNT(*) FROM customer
GROUP BY store_id;

SELECT country_id, COUNT(*) as city_count FROM city 
GROUP BY country_id 
ORDER BY city_count DESC
LIMIT 1;