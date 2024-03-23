SELECT COUNT(*) AS film_count
FROM film
WHERE length > (SELECT AVG(length) FROM film);

SELECT COUNT(*) AS film_count
FROM film
WHERE rental_rate = (SELECT MAX(rental_rate) FROM film);

SELECT *
FROM film
WHERE rental_rate = (SELECT MIN(rental_rate) FROM film)
AND replacement_cost = (SELECT MIN(replacement_cost) FROM film);

SELECT customer_id, COUNT(*) as total_transactions
FROM payment
GROUP BY customer_id
ORDER BY total_transactions DESC;
