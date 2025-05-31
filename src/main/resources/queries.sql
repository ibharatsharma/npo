
select u.id, username, password, a.name from site_user u, user_authorities ua, authority a
where ua.user_id = ua.user_id and ua.authority_id = a.id
and u.username = 'ibharatsharma@gmail.com';