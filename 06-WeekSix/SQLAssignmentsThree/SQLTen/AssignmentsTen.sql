SELECT city.city, country.country
FROM city LEFT JOIN country
ON city.country_id = country.country_id;

SELECT payment.payment_id, customer.first_name, customer.last_name
FROM customer RIGHT JOIN payment
ON customer.customer_id = payment.customer_id;

SELECT rental.rental_id, customer.first_name, customer.last_name
FROM rental RIGHT JOIN customer
ON rental.customer_id = customer.customer_id;