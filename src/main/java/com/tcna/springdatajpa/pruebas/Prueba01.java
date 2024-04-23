package com.tcna.springdatajpa.pruebas;

import com.tcna.springdatajpa.entitites.entity1.Direccion;
import com.tcna.springdatajpa.entitites.entity1.Estudiante;
import com.tcna.springdatajpa.repositories.repository1.DireccionRepository;
import com.tcna.springdatajpa.repositories.repository1.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class Prueba01 implements CommandLineRunner {


    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private DireccionRepository direccionRepository;

    @Override
    public void run(String... args) throws Exception {
        Direccion direccion = new Direccion();
        direccion.setCalle("12345678 Calle Pincipal");
        direccion.setCiudad("Ciudad Ejemplo3");
        direccion.setCodigoPostal("11111");

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre("Mario");
        estudiante.setDireccion(direccion);

        estudianteRepository.save(estudiante);

        estudiante.setNombre("Mario actualizado");
        estudianteRepository.save(estudiante);

        Iterable<Estudiante> estudiantes = estudianteRepository.findAll();
        for(Estudiante e : estudiantes){
            System.out.println("Estudiante: " + e.getNombre() + ", Dirección: " + e.getDireccion().getCalle());
        }
    }
}
