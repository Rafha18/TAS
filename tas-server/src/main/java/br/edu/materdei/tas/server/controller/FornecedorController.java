package br.edu.materdei.tas.server.controller;

import br.edu.materdei.tas.compra.entity.FornecedorEntity;
import br.edu.materdei.tas.compra.service.FornecedorService;
import br.edu.materdei.tas.core.exception.ResourceNotFoundException;
import br.edu.materdei.tas.server.utils.CustomErrorResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rafael Quadra
 */
@RestController
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    @GetMapping("fornecedores")
    public ResponseEntity<List<FornecedorEntity>> findAll() {

        try {
            List<FornecedorEntity> fornecedores = service.findAll();

            return new ResponseEntity(fornecedores, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity(new CustomErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("fornecedores")
    public ResponseEntity create(@RequestBody FornecedorEntity fornecedor) {
        try {
            this.service.save(fornecedor);
            return new ResponseEntity(fornecedor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(new CustomErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("fornecedores/{id}")
    public ResponseEntity findByID(@PathVariable("id") Integer id) {
        try {

            FornecedorEntity fornecedor = this.service.findById(id);
            return new ResponseEntity(fornecedor, HttpStatus.OK);

        } catch (ResourceNotFoundException e) {
            return new ResponseEntity(new CustomErrorResponse("Não existe um fornecedor com este codigo"),
                    HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity(new CustomErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("fornecedores/{id}")
    public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody FornecedorEntity fornecedor) {
        try {

            FornecedorEntity found = this.service.findById(id);

            fornecedor.setId(found.getId());

            this.service.save(fornecedor);

            return new ResponseEntity(fornecedor, HttpStatus.OK);

        } catch (ResourceNotFoundException e) {
            return new ResponseEntity(new CustomErrorResponse("Não existe um fornecedor com este codigo"),
                    HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity(new CustomErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("fornecedores/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        try {
            FornecedorEntity found = this.service.findById(id);

            this.service.delete(found.getId());

            return new ResponseEntity(HttpStatus.NO_CONTENT);

        } catch (ResourceNotFoundException e) {

            return new ResponseEntity(new CustomErrorResponse("Não existe um fornecedor com este codigo"),
                    HttpStatus.NOT_FOUND);

        } catch (Exception e) {

            return new ResponseEntity(new CustomErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
