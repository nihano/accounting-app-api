insert into roles(insert_date_time, insert_user_id, is_deleted, last_update_date_time,
                  last_update_user_id, description)
values ('2022-09-09 00:00:00', 1, false, '2022-09-09 00:00:00', 1, 'Root User'),
       ('2022-09-09 00:00:00', 1, false, '2022-09-09 00:00:00', 1, 'Admin'),
       ('2022-09-09 00:00:00', 1, false, '2022-09-09 00:00:00', 1, 'Manager'),
       ('2022-09-09 00:00:00', 1, false, '2022-09-09 00:00:00', 1, 'Employee');

insert into addresses(insert_date_time, insert_user_id, is_deleted, last_update_date_time, last_update_user_id,
                      address_line1, address_line2, city, state, country, zip_code)
values ('2022-09-15 00:00:00', 1, false, '2022-09-15 00:00:00', 1,
        '7925 Jones Branch Dr, #3300', 'Tysons', 'Virginia', 'VA', 'United States', '22102-1234'),
       ('2022-09-15 00:00:00', 1, false, '2022-09-15 00:00:00', 1,
        'Future Street', 'Times Square', 'Atlanta', 'Alabama', 'United States', '54321-4321'),
       ('2022-09-15 00:00:00', 1, false, '2022-09-15 00:00:00', 1,
        'North Street', 'Circle Square', 'San Francisco', 'California', 'United States', '65245-8546'),
       ('2022-09-15 00:00:00', 1, false, '2022-09-15 00:00:00', 1,
        'West Street', 'Triangle Square', 'Los Angeles', 'California', 'United States', '54782-5214'),
       ('2022-09-15 00:00:00', 1, false, '2022-09-15 00:00:00', 1,
        'East Street', 'Cube Square', 'Los Angeles', 'California', 'United States', '54782-5214'),
       ('2022-09-15 00:00:00', 1, false, '2022-09-15 00:00:00', 1,
        'South Street', 'Times Square', 'Los Angeles', 'California', 'United States', '54782-5214'),
       ('2022-09-15 00:00:00', 1, false, '2022-09-15 00:00:00', 1,
        'SouthWest Street', 'Puzzle Square', 'Los Angeles', 'California', 'United States', '65654-8989'),
       ('2022-09-15 00:00:00', 1, false, '2022-09-15 00:00:00', 1,
        'OwerWest Street', 'Android Square', 'Los Angeles', 'Phoneix', 'United States', '65654-8989');;

insert into companies(insert_date_time, insert_user_id, is_deleted, last_update_date_time, last_update_user_id,
                      title, phone, website, address_id, company_status)
values ('2022-09-15 00:00:00', 1, false, '2022-09-15 00:00:00', 1,
        'CYDEO','+1 (652) 852-8888', 'https://www.cydeo.com', 1, 'ACTIVE'),
       ('2022-09-15 00:00:00', 1, false, '2022-09-15 00:00:00', 1,
        'Green Tech','+1 (652) 852-3246', 'https://www.greentech.com', 2, 'ACTIVE'),
       ('2022-09-15 00:00:00', 1, false, '2022-09-15 00:00:00', 1,
        'Blue Tech','+1 (215) 654-5268', 'https://www.bluetech.com', 3, 'ACTIVE'),
       ('2022-09-15 00:00:00', 1, false, '2022-09-15 00:00:00', 1,
        'Red Tech','+1 (215) 846-2642', 'https://www.redtech.com', 4, 'PASSIVE');

