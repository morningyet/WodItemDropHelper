#select id ,items_name
DELETE
from items_drop where id not in(
	select id from
	(
		(SELECT id,items_name FROM items_drop GROUP BY items_name HAVING count( * ) > 1 ) as t
	)
)
	and items_name in
(

	select items_name from
	(
		(SELECT id,items_name FROM items_drop GROUP BY items_name HAVING count( * ) > 1 ) as p
	)
)
#order by id