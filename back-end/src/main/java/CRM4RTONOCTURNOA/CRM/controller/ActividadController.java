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

import CRM4RTONOCTURNOA.CRM.entity.Actividad;
import CRM4RTONOCTURNOA.CRM.service.ActividadService;

@RestController
@CrossOrigin({"http://localhost:4200"})
@RequestMapping("/api/actividad") //ruta en la q se va a eschuchar al controller
public class ActividadController{
    @Autowired
    ActividadService actividadService; 

    //Create
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Actividad save(@RequestBody Actividad actividad)
    {
        System.out.println("Reciviendo save");
        return actividadService.save(actividad);
    }

    //Read
    @GetMapping("/{id}")
    public Actividad findById(@PathVariable Long id)
    {
        return actividadService.findById(id);
    }

    //Update
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public Actividad update(@RequestBody Actividad actividad)
    {
        return actividadService.save(actividad);
    }
    //Delete
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id)
    {
        actividadService.deleteById(id);
    }

    //Con el getMapping va a eschucar la ruta que necesitamos
    
    @GetMapping("/findAll") //ruta
    public List<Actividad> findAll() 
    {
        return actividadService.findAll(); //llama al servicio quien se encarga del acceso 
        //a la informacion
    }
}