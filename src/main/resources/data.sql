INSERT INTO restaurant(name, address, cuisineType, rating)
VALUES('Fine Dining', '123 Main St', 'European', 5);

INSERT INTO restaurant(name, address, cuisineType, rating)
VALUES('Taco Bell', '456 Elm St', 'Fast Food', 3);

INSERT INTO restaurant(name, address, cuisineType, rating)
VALUES('Sushi Place', '789 Oak St', 'Japanese', 4);


INSERT INTO chef(firstName, lastName, expertise, experienceYears, restaurantId)
VALUES('John', 'Doe', 'Sous Chef', 5, 1);

INSERT INTO chef(firstName, lastName, expertise, experienceYears, restaurantId)
VALUES('Jane', 'Doe', 'Pastry Chef', 7, 1);

INSERT INTO chef(firstName, lastName, expertise, experienceYears, restaurantId)
VALUES('Mike', 'Smith', 'Head Chef', 10, 2);

INSERT INTO chef(firstName, lastName, expertise, experienceYears, restaurantId)
VALUES('Emily', 'Johnson', 'Sushi Chef', 8, 3);

INSERT INTO chef(firstName, lastName, expertise, experienceYears, restaurantId)
VALUES('Anna', 'Williams', 'Pastry Chef', 6, 3);

INSERT INTO chef(firstName, lastName, expertise, experienceYears, restaurantId)
VALUES('Mark', 'Brown', 'Sous Chef', 4, 2);