package com.dulcepan.api;

import com.dulcepan.api.data.ClientDataApi;
import com.dulcepan.api.swagger.ClientApiSwagger;
import com.dulcepan.dto.ClientDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientApi implements ClientApiSwagger {

    private ClientDataApi clientDataApi;
    private static Logger LOG = LoggerFactory.getLogger(ClientApi.class);

    @Autowired
    public ClientApi(ClientDataApi clientDataApi) {
        this.clientDataApi = clientDataApi;
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping({"/",""})
    public ResponseEntity<Object> findAllClient(){
        LOG.info("Find all client");
        return new ResponseEntity<>(clientDataApi.findAllClient(), HttpStatus.ACCEPTED);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/rut/{rut}")
    public ResponseEntity<Object> findByRut(@PathVariable("rut") String rut){
        return new ResponseEntity<>(clientDataApi.findByRut(rut),HttpStatus.ACCEPTED);
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/name/{name}")
    public ResponseEntity<Object> findByName(@PathVariable("name") String name){
        return new ResponseEntity<>(clientDataApi.findByNameClientContaining(name), HttpStatus.ACCEPTED);
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/create")
    public ResponseEntity<Object> createClient(@RequestBody ClientDto clientDto){
        LOG.info("Create client");
        return new ResponseEntity<>(clientDataApi.createClient(clientDto),HttpStatus.ACCEPTED);
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping("/update")
    public ResponseEntity<Object> updateClient(@RequestBody ClientDto clientDto){
        LOG.info("Update client");
        return new ResponseEntity<>(clientDataApi.updateClient(clientDto),HttpStatus.ACCEPTED);
    }

}
