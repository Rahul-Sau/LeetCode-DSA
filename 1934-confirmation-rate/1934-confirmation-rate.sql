# Write your MySQL query statement below
select s.user_id,
round(avg(IF(c.action='confirmed',1.00,0)),2)confirmation_rate
from Signups s
left join confirmations c
on s.user_id = c.user_id
group by s.user_id