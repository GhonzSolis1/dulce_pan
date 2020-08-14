package com.dulcepan.api.swagger;

import com.dulcepan.dto.ClientDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

@Api(tags = "client-resource")
public interface ClientApiSwagger {


    @ApiOperation(value = "Listar Clientes", notes = "Se listan los clientes que tienen Market")
     ResponseEntity<Object> findAllClient();

    @ApiOperation(value = "Buscar Por Rut")
     ResponseEntity<Object> findByRut(String rut);

    @ApiOperation(value = "Buscar Por nombre")
     ResponseEntity<Object> findByName( String name);

    @ApiOperation(value = "Crear Cliente")
     ResponseEntity<Object> createClient(ClientDto clientDto) ;

    @ApiOperation(value = "Actualizar")
     ResponseEntity<Object> updateClient (ClientDto clientDto);



}
