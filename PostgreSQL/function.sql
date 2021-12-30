alter table user1
    add constraint type1 check ( type = 'headdoctor' or type = 'doctor' or type = 'patient' );