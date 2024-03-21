SELECT country, city
FROM country INNER JOIN city
ON country.country_id = city.country_id
ORDER BY country ASC;

SELECT payment.payment_id, customer.first_name, customer.last_name 
FROM customer INNER JOIN payment
ON customer.customer_id = payment.customer_id
ORDER BY customer ASC;

SELECT DISTINCT rental.customer_id, customer.first_name, customer.last_name
FROM customer INNER JOIN rental
ON customer.customer_id = rental.customer_id
ORDER BY customer_id ASC
