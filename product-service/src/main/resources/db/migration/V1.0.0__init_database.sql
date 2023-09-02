-- public.product definition

-- Drop table

-- DROP TABLE public.product;

CREATE TABLE public.product (
	id bigserial NOT NULL,
	description varchar(255) NULL,
	"name" varchar(255) NULL,
	price numeric(38, 2) NULL,
	CONSTRAINT product_pkey PRIMARY KEY (id)
)