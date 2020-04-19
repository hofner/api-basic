
/*
1)Create query to update column transferred_to to 'Invalid_destination' in Storage table if
transferred_to column is equal 100.
*/
update storage set transfered_to='Invalid_destination' 
where transfered_to='100';

/*
2) Create query to select all products of Dell manufacturer.
*/
select * from product where maker='Dell';

/*
3) Create query to delete rows from Storage table that have value 'Invalid_destination' in
transferred_to column.
*/
delete from storage where transfered_to ='Invalid_destination';

/*
4) Create query to select most expensive product for every maker. Output should have maker,
product model and price.
*/


SELECT product.maker, 
       product.model, 
       Max(printer.price) 
FROM   product, 
       printer 
WHERE  product.model = printer.model 
UNION 
SELECT product.maker, 
       product.model, 
       Max(laptop.price) 
FROM   product, 
       laptop 
WHERE  product.model = laptop.model 
UNION 
SELECT product.maker, 
       product.model, 
       Max(pc.price) 
FROM   product, 
       pc 
WHERE  product.model = pc.model; 

/*
5) Create query to select overall amount of laptops that Hitachi manufactures.
*/

SELECT Count(laptop.model) 
FROM   product, 
       laptop 
WHERE  product.model = laptop.model 
       AND product.maker = 'Hitachi'; 

/*
6) Create query to select all devices ordered from most expensive ones to cheapest. Output should
have serial number, maker, price, type.
*/
SELECT * 
FROM   (SELECT printer.serial_number, 
               product.maker, 
               printer.price, 
               product.type 
        FROM   product, 
               printer 
        WHERE  product.model = printer.model 
        UNION 
        SELECT laptop.serial_number, 
               product.maker, 
               laptop.price, 
               product.type 
        FROM   product, 
               laptop 
        WHERE  product.model = laptop.model 
        UNION 
        SELECT pc.serial_number, 
               product.maker, 
               pc.price, 
               product.type 
        FROM   product, 
               pc 
        WHERE  product.model = pc.model) devices 
ORDER  BY price DESC; 

/*
7) Create query to select makers that make more printers than pc\laptops.
*/

SELECT maker, 
       pc, 
       laptop, 
       printer 
FROM   (SELECT makers.maker, 
               Ifnull(col_pc.pc, 0)           pc, 
               Ifnull(col_laptop.laptop, 0)   laptop, 
               Ifnull(col_printer.printer, 0) printer 
        FROM   (SELECT DISTINCT maker 
                FROM   product) makers 
               LEFT JOIN (SELECT maker, 
                                 Count(type) pc 
                          FROM   product 
                          GROUP  BY maker, 
                                    type 
                          HAVING type = 'pc')col_pc 
                      ON makers.maker = col_pc.maker 
               LEFT JOIN (SELECT maker, 
                                 Count(type) laptop 
                          FROM   product 
                          GROUP  BY maker, 
                                    type 
                          HAVING type = 'laptop')col_laptop 
                      ON makers.maker = col_laptop.maker 
               LEFT JOIN (SELECT maker, 
                                 Count(type) printer 
                          FROM   product 
                          GROUP  BY maker, 
                                    type 
                          HAVING type = 'printer')col_printer 
                      ON makers.maker = col_printer.maker) totales 
WHERE  totales.printer > totales.pc 
       AND totales.printer > laptop; 

/*
8) Create query to select most expensive PC without CD drive for makers who manufacture only
PCs. Output should have serial_number, maker, price.
*/

SELECT pc.serial_number, 
       product_a.maker, 
       Max(pc.price) price1 
FROM   pc, 
       product product_a, 
       (SELECT elems.maker 
        FROM   (SELECT DISTINCT maker, 
                                type 
                FROM   product 
                WHERE  type = 'pc') makers1, 
               (SELECT maker, 
                       Count(type) typec 
                FROM   (SELECT DISTINCT maker, 
                                        type 
                        FROM   product) mprods 
                GROUP  BY maker 
                HAVING typec = 1) elems 
        WHERE  makers1.maker = elems.maker) makers_a 
WHERE  makers_a.maker = product_a.maker 
       AND pc.model = product_a.model 
       AND pc.cd IS NULL 
GROUP  BY product_a.maker; 



/*
9) Create query to select what's cheaper pc or laptop (considering speed, ram, hd). If maker
doesn't manufacture pc then laptop should be shown as cheapest and vice versa.
As input you have speed, ram, hd.
as output you should show at least maker, serial_number, speed, ram, hd, price.
*/

SELECT product.maker, 
       pc.serial_number, 
       pc.speed, 
       pc.ram, 
       pc.hd, 
       pc.price, 
       product.type 
FROM   pc, 
       product 
WHERE  pc.model = product.model 
UNION 
SELECT product.maker, 
       laptop.serial_number, 
       laptop.speed, 
       laptop.ram, 
       laptop.hd, 
       laptop.price, 
       product.type 
FROM   laptop, 
       product 
WHERE  laptop.model = product.model 
ORDER  BY maker, 
          price; 