use sz_flightfinder;

UPDATE flights f
JOIN airports a ON f.source_airport_id = a.airport_id
JOIN airports b ON f.destination_airport_id = b.airport_id
SET f.price = (ROUND(0.1 * (6371 * 2 * ASIN(SQRT(POWER(SIN((RADIANS(a.latitude) - RADIANS(b.latitude)) / 2), 2) + COS(RADIANS(a.latitude)) * COS(RADIANS(b.latitude)) * POWER(SIN((RADIANS(a.longitude) - RADIANS(b.longitude)) / 2), 2)))), 2) +
              CASE
                WHEN (6371 * 2 * ASIN(SQRT(POWER(SIN((RADIANS(a.latitude) - RADIANS(b.latitude)) / 2), 2) + COS(RADIANS(a.latitude)) * COS(RADIANS(b.latitude)) * POWER(SIN((RADIANS(a.longitude) - RADIANS(b.longitude)) / 2), 2)))) > 6000 THEN
                  CASE
                    WHEN (6371 * 2 * ASIN(SQRT(POWER(SIN((RADIANS(a.latitude) - RADIANS(b.latitude)) / 2), 2) + COS(RADIANS(a.latitude)) * COS(RADIANS(b.latitude)) * POWER(SIN((RADIANS(a.longitude) - RADIANS(b.longitude)) / 2), 2)))) > 9000 THEN f.price + 1500
                    ELSE f.price + 1000
                  END
                ELSE f.price
              END);
