create table if not exists list_table(
    id int auto_increment primary key,
    title varchar(255) not null,
    isCompleted boolean  default false
);