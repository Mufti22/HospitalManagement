alter table user1
    add constraint type1 check ( type = 'headdoctor' or type = 'doctor' or type = 'patient' );

alter table whour
    add constraint status check ( status = 'a' or status = 'p' );

ALTER TABLE whour ALTER COLUMN status SET DEFAULT 'a';