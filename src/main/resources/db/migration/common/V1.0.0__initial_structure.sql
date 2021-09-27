CREATE TABLE public.salesman (
	id bigint NOT NULL PRIMARY KEY,
	name VARCHAR (50),
	registration VARCHAR (20)
);

CREATE TABLE public.product (
	id bigint NOT NULL PRIMARY KEY,
	name VARCHAR (50),
	price decimal(12,2)
);

CREATE TABLE public.sale (
	id bigint NOT NULL PRIMARY KEY,
	salesman_id bigint NOT NULL,
	total_price decimal(12,2)
);

CREATE TABLE public.sale_item (
	id bigint NOT NULL PRIMARY KEY,
	sale_id bigint NOT NULL,
	product_id bigint NOT NULL,
	amount int NOT NULL
);

ALTER TABLE sale ADD CONSTRAINT fk_sale_salesman FOREIGN KEY (salesman_id) REFERENCES salesman(id);
ALTER TABLE sale_item ADD CONSTRAINT fk_sale_item_product FOREIGN KEY (product_id) REFERENCES product(id);
ALTER TABLE sale_item ADD CONSTRAINT fk_sale_item_sale FOREIGN KEY (sale_id) REFERENCES sale(id);

