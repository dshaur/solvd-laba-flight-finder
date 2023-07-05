use sz_flightfinder;

SELECT
  f.flight_id,
  al.name AS airline_name,
  src.name AS source_airport_name,
  src_city.name AS source_city_name,
  src_country.name AS source_country_name,
  dest.name AS destination_airport_name,
  dest_city.name AS destination_city_name,
  dest_country.name AS destination_country_name,
  f.price
FROM flights f
JOIN airlines al ON f.airline_id = al.airline_id
JOIN airports src ON f.source_airport_id = src.airport_id
JOIN airports dest ON f.destination_airport_id = dest.airport_id
JOIN cities src_city ON src.city_id = src_city.city_id
JOIN cities dest_city ON dest.city_id = dest_city.city_id
JOIN countries src_country ON src_city.country_id = src_country.country_id
JOIN countries dest_country ON dest_city.country_id = dest_country.country_id;
