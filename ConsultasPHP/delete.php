<?php

        if($_SERVER['REQUEST_METHOD'] == 'POST') {

            require_once("db.php");
            $clave = $_POST['clave'];

            $query = "DELETE FROM productos WHERE clave = '$clave'";
            $result = $mysql->query($query);

                if($mysql->affected_rows > 0 ){
                    if($result === TRUE){
                        echo "EL USUARIO FUE REMOVIDO SATISFACTORIAMENTE";
                    }

                }else {
                    echo"No se encontro ningun resultado";
                }

                $mysql->close();
        }