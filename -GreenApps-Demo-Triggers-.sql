USE `GreenAppsDemo`;

DELIMITER $$
USE `GreenAppsDemo`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `GreenAppsDemo`.`actStockProductoFromDetalleCompra`
BEFORE INSERT ON `GreenAppsDemo`.`detalleCompra`
FOR EACH ROW
begin
declare stockActualCpa INT;
set @stockActualCpa = (select stockProducto from producto where idProducto = new.idProducto);
update Producto
set stockProducto = @stockActualCpa+new.unidadesCompradas where idProducto = new.idProducto;
end$$

USE `GreenAppsDemo`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `GreenAppsDemo`.`actValorCpaProductoFromDetalleCompra`
BEFORE INSERT ON `GreenAppsDemo`.`detalleCompra`
FOR EACH ROW
begin
update Producto
set valorCompraProducto = new.valorCompraProducto where idProducto = new.idProducto;
end$$

USE `GreenAppsDemo`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `GreenAppsDemo`.`actValorVtaProductoFromDetalleCompra`
BEFORE INSERT ON `GreenAppsDemo`.`detalleCompra`
FOR EACH ROW
begin
update Producto
set valorVentaProducto = new.valorVentaProducto where idProducto = new.idProducto;
end$$

USE `GreenAppsDemo`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `GreenAppsDemo`.`actStockProductoFromDetalleDevolucion`
BEFORE INSERT ON `GreenAppsDemo`.`detalleDevolucion`
FOR EACH ROW
begin
declare stockActualDvn INT;
set @stockActualDvn = (select stockProducto from producto where idProducto = new.idProducto);
update Producto
set stockProducto = @stockActualDvn+new.unidadesDevueltas where idProducto = new.idProducto;
end$$

USE `GreenAppsDemo`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `GreenAppsDemo`.`actStockProductoFromDetalleVenta`
BEFORE INSERT ON `GreenAppsDemo`.`detalleVenta`
FOR EACH ROW
begin
declare stockActualVta INT;
set @stockActualVta = (select stockProducto from producto where idProducto = new.idProducto);
update Producto
set stockProducto = @stockActualVta-new.unidadesVendidas where idProducto = new.idProducto;
end$$

USE `GreenAppsDemo`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `GreenAppsDemo`.`actStockProductoFromDetalleServicio`
BEFORE INSERT ON `GreenAppsDemo`.`detalleServicio`
FOR EACH ROW
begin
declare stockActualSvo INT;
set @stockActualSvo = (select stockProducto from producto where idProducto = new.idProducto);
update Producto
set stockProducto = @stockActualSvo-new.unidadesVendidas where idProducto = new.idProducto;
end$$

USE `GreenAppsDemo`$$
CREATE 
DEFINER=`root`@`localhost` 
TRIGGER `GreenAppsDemo`.`valorTotalDetalleServicioInsertado`
BEFORE INSERT ON `GreenAppsDemo`.`detalleServicio`
FOR EACH ROW
begin
set new.totalDetalleServicio = new.valorVentaProducto*new.unidadesVendidas;
end$$

USE `GreenAppsDemo`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `GreenAppsDemo`.`actStockProductoFromDetalleServicioModificado`
BEFORE DELETE ON `GreenAppsDemo`.`detalleServicio`
FOR EACH ROW
begin
declare stockActualSvo INT;
set @stockActualSvo = (select stockProducto from producto where idProducto = OLD.idProducto);
update Producto
set stockProducto = @stockActualSvo+OLD.unidadesVendidas where idProducto = OLD.idProducto;
end$$

USE `GreenAppsDemo`$$
CREATE 
DEFINER=`root`@`localhost` 
TRIGGER `GreenAppsDemo`.`valorTotalDetalleServicioActualizado`
BEFORE UPDATE ON `GreenAppsDemo`.`detalleServicio`
FOR EACH ROW
begin
set new.totalDetalleServicio = new.valorVentaProducto*new.unidadesVendidas;
end$$

DELIMITER ;