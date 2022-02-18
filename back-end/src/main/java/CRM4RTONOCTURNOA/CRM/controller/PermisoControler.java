package CRM4RTONOCTURNOA.CRM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import CRM4RTONOCTURNOA.CRM.entity.Permiso;
import CRM4RTONOCTURNOA.CRM.service.PermisoService;

@RestController
@CrossOrigin({ "http://localhost:4200" })
@RequestMapping("/api/permiso")
public class PermisoControler {

    @Autowired
    PermisoService permisoService;

    // Create
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Permiso save(@RequestBody Permiso permiso) {
        return permisoService.save(permiso);
    }

    // Read
    @GetMapping("/{id}")
    public Permiso findById(@PathVariable Long id) {
        return permisoService.findById(id);
    }

    // Update
    @PutMapping("/update")
    public Permiso update(@RequestBody Permiso permiso) {
        return permisoService.save(permiso);
    }

    // Delete
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        permisoService.deleteById(id);
    }

    @GetMapping("/findAll")
    public List<Permiso> findAll() {
        return permisoService.findAll();
    }

 

}
