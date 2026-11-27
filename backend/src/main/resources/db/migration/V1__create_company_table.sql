create table company (
   id           uuid primary key,
   company_name varchar(150) not null,
   gstin        varchar(15),
   email        varchar(150),
   phone        varchar(20),
   address      text,
   state_code   varchar(2),
   is_active    boolean not null default true,
   created_at   timestamp not null default current_timestamp,
   updated_at   timestamp not null default current_timestamp
);

-- Index for GSTIN lookup
create index idx_company_gstin on
   company (
      gstin
   );

-- Index for company name lookup
create index idx_company_name on
   company (
      company_name
   );