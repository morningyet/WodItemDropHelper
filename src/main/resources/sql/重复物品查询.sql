SELECT
	count( items_name ) countNum,
	id,
	items_name,
	dungeons_name,
	branch,
	floor
FROM
	items_drop
GROUP BY
	items_name
HAVING
	countNum > 1
ORDER BY
	id DESC