INSERT INTO sys_user(id, user_name, user_password, user_email, user_info, head_img, create_time)
VALUES (1, 'admin', '123456', 'admin@mybatis.tk', '管理员 ', null, '2016-04-01 17:00:58');
INSERT INTO sys_user
VALUES ('1001', 'test', '123456', 'test@mybatis.tk', '测试用户', null, '2016-04-01 17:01:52');

INSERT INTO sys_role
VALUES (1, '管理员', '1', '2016-04-01 17:02:14', '1');
INSERT INTO sys_role
VALUES (2, '普通用户', '1', '2016-04-01 17:02:34', '1');

insert into sys_user_role
values ('1', '1');
insert into sys_user_role
values ('1', '2');
insert into sys_user_role
values ('1001', '2');

insert into sys_privilege
values (1, '用户管理', '/users');
insert into sys_privilege
values (2, '角色管理', '/roles');
insert into sys_privilege
values (3, '系统日志', '/logs');
insert into sys_privilege
values (4, '人员维护', '/persons');
insert into sys_privilege
values (5, '单位维护', '/companies');

insert into sys_role_privilege
values ('1', '1');
insert into sys_role_privilege
values ('1', '3');
insert into sys_role_privilege
values ('1', '2');
insert into sys_role_privilege
values ('2', '4');
insert into sys_role_privilege
values ('2', '5');



create table sys_user
(
    id            bigint auto_increment primary key,
    user_name     varchar(50) null,
    user_password varchar(50) null,
    user_email    varchar(50) null,
    user_info     text        null,
    head_img      blob        null,
    create_time   datetime    null
)
    comment '用户表';


create table sys_role
(
    id          bigint auto_increment
        primary key,
    role_name   varchar(50) null,
    enabled     int         null,
    create_time datetime    null,
    create_by   bigint      null
)
    comment '角色表';


create table sys_privilege
(
    id             bigint auto_increment
        primary key,
    privilege_name varchar(50)  null,
    privilege      varchar(200) null
)
    comment '权限表';