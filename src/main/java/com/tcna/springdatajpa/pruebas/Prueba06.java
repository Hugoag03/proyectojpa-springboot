package com.tcna.springdatajpa.pruebas;

import com.tcna.springdatajpa.entitites.entity6.Aerolinea;
import com.tcna.springdatajpa.entitites.entity6.Vuelo;
import com.tcna.springdatajpa.repositories.repository6.AerolineaRepository;
import com.tcna.springdatajpa.repositories.repository6.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Prueba06 implements CommandLineRunner {

    @Autowired
    private AerolineaRepository aerolineaRepository;

    @Autowired
    private VueloRepository vueloRepository;

    @Override
    public void run(String... args) throws Exception {
        Aerolinea aerolinea = new Aerolinea();

        aerolinea.setNombre("Aerolínea 1");

        Vuelo vuelo1 = new Vuelo();
        vuelo1.setDestino("Cádiz");
        vuelo1.setNumeroVuelo(1);

        Vuelo vuelo2 = new Vuelo();
        vuelo2.setDestino("Puerto Real");
        vuelo2.setNumeroVuelo(2);

        aerolinea.getVuelos().add(vuelo1);
        aerolinea.getVuelos().add(vuelo2);

        aerolineaRepository.save(aerolinea);

        //Leer aerolínea desde el repo
        Aerolinea aerolineaDesdeBd = aerolineaRepository.findById(aerolinea.getId()).orElse(null);
        System.out.println("Aerolinea: " + aerolineaDesdeBd.getNombre());

        //Eliminar aerolinea
        aerolineaRepository.delete(aerolineaDesdeBd);

        //Comprobar que la aerolinea y vuelos se han eliminado
        List<Vuelo> vuelos = vueloRepository.findAll();
        System.out.println("Número de vuelos en la base de datos: " + vuelos.size());
    }
}
