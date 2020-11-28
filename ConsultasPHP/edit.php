<?php

    if ($_SERVER['REQUEST_METHOD'] == 'POST') {
        require_once("db.php");

        $clave = $_POST['clave'];
        $nombre = $_POST['nombre_producto'];
        $precio = $_POST['precio_producto'];
        $descripcion = $_POST['descripcion_producto'];
        $cantidad = $_POST['cantidad_producto'];

        $query = "UPDATE productos SET	clave = '$clave' ,nombre_producto = '$nombre' ,precio_producto = '$precio',descripcion_producto = '$descripcion', cantidad_producto = '$cantidad' WHERE clave = '$clave'" ;
        $result = $mysql->query($query);

        if($mysql->affected_rows > 0 ){
            if($result === TRUE){
                echo "ACTUALIZACION EXITOSA";
            }else {
                echo"Error";
            }

        }else {
            echo"No se encontro ningun resultado";
        }

        $mysql->close();
}