insert into product(id, name, price) values (1, 'Mouse Gamer Redragon Cobra', 99);
insert into product(id, name, price) values (2, 'Aspirador de Pó Robô', 1500);
insert into product(id, name, price) values (3, 'Memória Kingston Fury Beast, 8GB, 2666MHz, DDR4', 289);

insert into salesman(id, name, registration) values (1, 'Dária Quintais Varela', 'DQV');
insert into salesman(id, name, registration) values (2, 'Eder Muniz Fontoura', 'EMF');
insert into salesman(id, name, registration) values (3, 'Amadeu Noite Perdigão', 'ANP');

--Salesman Dária
--#Sale 01
insert into sale(id, salesman_id, total_price) values (1, 1, 93570.00);
insert into sale_item(sale_id, id, product_id, amount) values (1, 1, 1, 100);
insert into sale_item(sale_id, id, product_id, amount) values (1, 2, 2, 50);
insert into sale_item(sale_id, id, product_id, amount) values (1, 3, 3, 30);

--#Sale 02
insert into sale(id, salesman_id, total_price) values (2, 1, 15420.00);
insert into sale_item(sale_id, id, product_id, amount) values (2, 4, 1, 80);
insert into sale_item(sale_id, id, product_id, amount) values (2, 5, 2, 5);

--#Sale 03
insert into sale(id, salesman_id, total_price) values (3, 1, 4950.00);
insert into sale_item(sale_id, id, product_id, amount) values (3, 6, 1, 50);

--Salesman Eder
--#Sale 04
insert into sale(id, salesman_id, total_price) values (4, 2, 48960.00);
insert into sale_item(sale_id, id, product_id, amount) values (4, 7, 1, 40);
insert into sale_item(sale_id, id, product_id, amount) values (4, 8, 2, 30);

--#Sale 05
insert into sale(id, salesman_id, total_price) values (5, 2, 1445.00);
insert into sale_item(sale_id, id, product_id, amount) values (5, 9, 3, 5);

--Salesman Amadeu
--#Sale 06
insert into sale(id, salesman_id, total_price) values (6, 3, 7500.00);
insert into sale_item(sale_id, id, product_id, amount) values (6, 10, 2, 5);

update sequence
set next_val = (select max(id) from product)
where sequence_name = 'product';

update sequence
set next_val = (select max(id) from salesman)
where sequence_name = 'salesman';

update sequence
set next_val = (select max(id) from sale)
where sequence_name = 'sale';

update sequence
set next_val = (select max(id) from sale_item)
where sequence_name = 'sale_item';