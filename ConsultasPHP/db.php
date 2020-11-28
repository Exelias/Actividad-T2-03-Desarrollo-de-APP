<?php

    $mysql = new mysqli(
        "db5001211410.hosting-data.io",
        "dbu612564",
        "2cSnky36HbyDzHm*",
        "dbs1036078"
    );

    if ($mysql -> connect_error) {
        die("failed to connect" . $mysql -> connect_error);
    }
