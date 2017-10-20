INSERT INTO Color (ID, NAME, CREATED_ON, LASTMODIFIED_ON, VERSION)
VALUES
       (nextval('COLOR_SEQ'), 'Antracietgrijs', current_timestamp, null, 1),
       (nextval('COLOR_SEQ'), 'Blauw Facelift', current_timestamp, null, 1),
       (nextval('COLOR_SEQ'), 'Blauw metallic', current_timestamp, null, 1),
       (nextval('COLOR_SEQ'), 'Bordeaux metallic', current_timestamp, null, 1),
       (nextval('COLOR_SEQ'), 'Daytonagrijs metallic', current_timestamp, null, 1),
       (nextval('COLOR_SEQ'), 'Donkerblauw metallic', current_timestamp, null, 1),
       (nextval('COLOR_SEQ'), 'Donkergroen metallic', current_timestamp, null, 1),
       (nextval('COLOR_SEQ'), 'Geel', current_timestamp, null, 1),
       (nextval('COLOR_SEQ'), 'Glacier zilver metallic', current_timestamp, null, 1),
       (nextval('COLOR_SEQ'), 'Grijs', current_timestamp, null, 1),
       (nextval('COLOR_SEQ'), 'Groen metallic', current_timestamp, null, 1),
       (nextval('COLOR_SEQ'), 'Rood', current_timestamp, null, 1),
       (nextval('COLOR_SEQ'), 'Rood metallic', current_timestamp, null, 1),
       (nextval('COLOR_SEQ'), 'Lichtblauw metallic', current_timestamp, null, 1),
       (nextval('COLOR_SEQ'), 'Monacoblauw metallic', current_timestamp, null, 1),
       (nextval('COLOR_SEQ'), 'Sapphire zwart metallic', current_timestamp, null, 1),
       (nextval('COLOR_SEQ'), 'Spacegrey metallic', current_timestamp, null, 1),
       (nextval('COLOR_SEQ'), 'Titaanzilver', current_timestamp, null, 1),
       (nextval('COLOR_SEQ'), 'Valencia orange metallic', current_timestamp, null, 1),
       (nextval('COLOR_SEQ'), 'Wit', current_timestamp, null, 1),
       (nextval('COLOR_SEQ'), 'Zilverblauw', current_timestamp, null, 1),
       (nextval('COLOR_SEQ'), 'Zilvergrijs', current_timestamp, null, 1),
       (nextval('COLOR_SEQ'), 'Zilvergrijs metallic', current_timestamp, null, 1),
       (nextval('COLOR_SEQ'), 'Zwart', current_timestamp, null, 1),
       (nextval('COLOR_SEQ'), 'Zwart metallic', current_timestamp, null, 1);


INSERT INTO Brand (ID, NAME, CREATED_ON, LASTMODIFIED_ON, VERSION)
VALUES
       (nextval('BRAND_SEQ'), 'Alfa Romeo', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Aston Martin', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Audi', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Bentley', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'BMW', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Bugatti', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Dodge', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Ferrari', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Ford', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Jaguar', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Lamborghini', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Lotus', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Maserati', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Mc Laren', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Mercedes-Benz', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Mini Cooper', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Nissan', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Opel', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Peugeot', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Plymouth', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Porsche', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Prima', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Renault', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Seat', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Shelby', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Subaru', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Toyota', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'TVR', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Venturi', current_timestamp, null, 1),
       (nextval('BRAND_SEQ'), 'Volkswagen', current_timestamp, null, 1);


INSERT INTO Model (ID, BRAND_ID, NAME, TYPE, PRODUCTION_DATE, CREATED_ON, LASTMODIFIED_ON, VERSION)
VALUES
       (nextval('MODEL_SEQ'), (SELECT id from Brand where name = 'Alfa Romeo'), 'X','147 GTA', to_timestamp('01/01/2003', 'dd/MM/yyy'), current_timestamp, null, 1),
       (nextval('MODEL_SEQ'), (SELECT id from Brand where name = 'Aston Martin'), 'X', 'DB 7 Vantage', null, current_timestamp, null, 1),
       (nextval('MODEL_SEQ'), (SELECT id from Brand where name = 'Audi'), 'X', 'A3 S3', to_timestamp('01/01/2001', 'dd/MM/yyy'), current_timestamp, null, 1),
       (nextval('MODEL_SEQ'), (SELECT id from Brand where name = 'Bentley'), 'X', 'Continental Supersports', null, current_timestamp, null, 1),
       (nextval('MODEL_SEQ'), (SELECT id from Brand where name = 'BMW'), 'X', '1 Serie E82 135i', to_timestamp('01/01/2007', 'dd/MM/yyy'), current_timestamp, null, 1);

INSERT INTO Car (ID, ITEM_REF, BRAND_ID, MODEL_ID, COLOR_ID, SCALE, LIMITED_EDITION, COUPE, BOXED, CREATED_ON, LASTMODIFIED_ON, VERSION)
VALUES
       (nextval('CAR_SEQ'), 'OT150', (SELECT id from Brand where name = 'Alfa Romeo'), (SELECT id FROM Model where brand_id = (SELECT id from Brand where name = 'Alfa Romeo') and type = '147 GTA'), (SELECT id from Color where name = 'Rood'), 'RATIO_1_43', 1250, FALSE, FALSE, current_timestamp, null, 1),
       (nextval('CAR_SEQ'), '67537', (SELECT id from Brand where name = 'Aston Martin'), (SELECT id FROM Model where brand_id = (SELECT id from Brand where name = 'Aston Martin') and type = 'DB 7 Vantage'), (SELECT id from Color where name = 'Bordeaux metallic'), 'RATIO_1_43', 0, FALSE, FALSE, current_timestamp, null, 1),
       (nextval('CAR_SEQ'), 'OT062', (SELECT id from Brand where name = 'Audi'), (SELECT id FROM Model where brand_id = (SELECT id from Brand where name = 'Audi') and type = 'A3 S3'), (SELECT id from Color where name = 'Zilvergrijs'), 'RATIO_1_43', 1750, FALSE, FALSE,current_timestamp, null, 1),
       (nextval('CAR_SEQ'), '18038', (SELECT id from Brand where name = 'Bentley'), (SELECT id FROM Model where brand_id = (SELECT id from Brand where name = 'Bentley') and type = 'Continental Supersports'), (SELECT id from Color where name = 'Antracietgrijs'), 'RATIO_1_43', 1250, FALSE, FALSE, current_timestamp, null, 1),
       (nextval('CAR_SEQ'), '80 43 0 427 065', (SELECT id from Brand where name = 'BMW'), (SELECT id FROM Model where brand_id = (SELECT id from Brand where name = 'BMW') and type = '1 Serie E82 135i'),(SELECT id from Color where name = 'Zilverblauw'), 'RATIO_1_43', 1250, TRUE, FALSE, current_timestamp, null, 1);

