<?php

    if ($_SERVER['REQUEST_METHOD']== 'POST') {

        require_once("db.php");

      	$clave= $_POST['clave'];
        $nombre = $_POST['nombre'];
        $precio = $_POST['precio'];
        $descripcion = $_POST['descripcion'];
        $cantidad = $_POST['cantidad'];
    

    $query =  "INSERT INTO productos (clave,nombre_producto,precio_producto,descripcion_producto,cantidad_producto) VALUES ('$clave','$nombre', '$precio', '$descripcion', '$cantidad')";
    $result = $mysql -> query($query);

    if($result === true) {
        echo "the user was created succesfully";
    }
    else {
        echo "Error, failed in the creation";
    }
    $mysql -> close();

}