
CREATE TABLE IF NOT EXISTS public.inventory (
	id bigserial NOT NULL,
	sku_code varchar(255) NULL,
	quantity integer NULL,
	CONSTRAINT inventory_pkey PRIMARY KEY (id)
)