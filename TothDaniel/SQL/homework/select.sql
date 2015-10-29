select c.customer_name,ad.city,ad.street,ad.house_number,ad.floor_number,ad.door_number,ad.bell_name,
com.company_name,c.tel_number1,c.tel_number2,c.tel_number3,o.comment,o.discount_percent,c.banned,c.premium,c.number_of_orders
from customer c inner join company com on c.company_id=com.id
inner join orders o on o.customer_id=c.id
inner join address ad on ad.id=o.address_id;