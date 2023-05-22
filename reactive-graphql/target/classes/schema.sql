create table player(
  id serial primary key auto_increment,
  name varchar(255) not null,
  age serial not null,
  club varchar(255) not null,
  nationality varchar(255) not null
  );