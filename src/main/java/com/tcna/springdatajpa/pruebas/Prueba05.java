package com.tcna.springdatajpa.pruebas;

import com.tcna.springdatajpa.entitites.entity5.Equipo;
import com.tcna.springdatajpa.entitites.entity5.Jugador;
import com.tcna.springdatajpa.repositories.repository5.EquipoRepository;
import com.tcna.springdatajpa.repositories.repository5.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class Prueba05 implements CommandLineRunner {

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private JugadorRepository jugadorRepository;


    @Override
    public void run(String... args) throws Exception {

        Equipo equipo = new Equipo();
        equipo.setNombre("Real Madrid");

        Jugador jugador1 = new Jugador();
        jugador1.setNombre("Hugo");
        jugador1.setNumeroCamiseta(8);

        Jugador jugador2 = new Jugador();
        jugador2.setNombre("Zentrillo");
        jugador2.setNumeroCamiseta(10);

        equipo.getJugadores().add(jugador1);
        equipo.getJugadores().add(jugador2);

        equipoRepository.save(equipo);

        //jugador1.setEquipo(equipo);
        //jugador2.setEquipo(equipo);

        //Leer el equipo y sus jugadores
        Equipo equipoGuardado = equipoRepository.findById(equipo.getId()).orElse(null);
        if(equipoGuardado != null){
            System.out.println("Equipo: " + equipoGuardado.getNombre());
            System.out.println("Jugadores en el equipo (USANDO LAZY)");
            for (Jugador jugador: equipo.getJugadores()){
                System.out.println("-" + jugador.getNombre() + "(Camiseta #" + jugador.getNumeroCamiseta() + ")");
            }
        }

        //Realizar operaciones de actualización y eliminación
        if(equipoGuardado != null){
            //Actualizar un jugador en el equipo
            Jugador jugadorActualizado = equipoGuardado.getJugadores().get(0);
            jugadorActualizado.setNumeroCamiseta(7);

            //No es necesario guardar nuevamente el equipo, ya que las actualziaciones se aplican automáticamente debido al CascadeType.MERGE

            //Leer el equipo y sus jugadores nuevamente
            Equipo equipoActualizado = equipoRepository.findById(equipoGuardado.getId()).orElse(null);
            if(equipoActualizado != null){
                System.out.println("Equipo actualizado: " + equipoActualizado.getNombre());
                System.out.println("Jugadores actualizados");
                for (Jugador jugador : equipoActualizado.getJugadores()){
                    System.out.println("-" + jugador.getNombre() + "(Camiseta #" + jugador.getNumeroCamiseta() + ")");
                }

                //Eliminar un jugador del equipo
                equipoActualizado.getJugadores().remove(1);

                //No es necesario guardar nuevamente el equipo, ya que las actualziaciones se aplican automáticamente debido al CascadeType.MERGE

                equipoRepository.delete(equipoActualizado);
            }
        }
        //Verificamos si el equipo ha sido eliminado
        Equipo equipoEliminado = equipoRepository.findById(equipo.getId()).orElse(null);
            if(equipoEliminado == null){
                System.out.println("Equipo eliminado con éxito");
            }
        }
    }
