CREATE TABLE public.sequence (
    sequence_name varchar(100) NOT NULL PRIMARY KEY,
    next_val bigint
);

INSERT INTO sequence(sequence_name, next_val) VALUES ('product', 0);
INSERT INTO sequence(sequence_name, next_val) VALUES ('salesman', 0);
INSERT INTO sequence(sequence_name, next_val) VALUES ('sale', 0);
INSERT INTO sequence(sequence_name, next_val) VALUES ('sale_item', 0);