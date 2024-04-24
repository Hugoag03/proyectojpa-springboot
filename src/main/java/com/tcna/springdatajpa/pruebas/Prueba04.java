package com.tcna.springdatajpa.pruebas;

import com.tcna.springdatajpa.entitites.entity4.Automovil;
import com.tcna.springdatajpa.entitites.entity4.Propietario;
import com.tcna.springdatajpa.repositories.repository4.AutomovilRepository;
import com.tcna.springdatajpa.repositories.repository4.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Prueba04 implements CommandLineRunner {

    @Autowired
    private PropietarioRepository propietarioRepository;

    @Autowired
    private AutomovilRepository automovilRepository;

    @Override
    public void run(String... args) throws Exception {
        Propietario propietario = new Propietario();
        propietario.setNombre("Juanito alimaña");

        Automovil automovil = new Automovil();
        automovil.setMarca("Toyota");
        automovil.setModelo("Camry");

        propietario.setAutomovil(automovil);
        automovil.setPropietario(propietario);

        propietarioRepository.save(propietario);
        //automovilRepository.save(automovil);

        //Leer un propietario
        Long propietarioId = propietario.getId();
        Propietario propietarioLeido = propietarioRepository.findById(propietarioId).orElse(null);
        if(propietarioLeido != null){
            System.out.println("Propietario leído: " + propietarioLeido.getNombre());
        }

        //Actualizar el automovil asociado al propietario
        Automovil automovilUpdate = propietario.getAutomovil();
        automovilUpdate.setMarca("Honda");
        automovilUpdate.setModelo("Accord");
        automovilRepository.save(automovilUpdate);

        //Eliminar el automovil asociado al propietario
        propietarioRepository.delete(propietario);

        //Verificar si el propietario ha sido eliminado
        Propietario propietarioDelete = propietarioRepository.findById(propietarioId).orElse(null);
        if(propietarioDelete == null){
            System.out.println("Propietario eliminado con éxito");
        }
    }
}
