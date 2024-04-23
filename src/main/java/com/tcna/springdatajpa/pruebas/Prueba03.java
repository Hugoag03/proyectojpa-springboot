package com.tcna.springdatajpa.pruebas;

import com.tcna.springdatajpa.entitites.entity3.Editor;
import com.tcna.springdatajpa.entitites.entity3.Revista;
import com.tcna.springdatajpa.repositories.repository3.EditorRepository;
import com.tcna.springdatajpa.repositories.repository3.RevistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Prueba03 implements CommandLineRunner {

    @Autowired
    private EditorRepository editorRepository;

    @Autowired
    private RevistaRepository revistaRepository;
    @Override
    public void run(String... args) throws Exception {
        Editor editor = new Editor();
        editor.setNombre("Editorial xyz");

        Revista revista1 = new Revista();
        revista1.setNombre("Revista A");
        revista1.setEditor(editor);

        Revista revista2 = new Revista();
        revista2.setNombre("Revista B");
        revista2.setEditor(editor);

        editor.getRevistas().add(revista1);
        editor.getRevistas().add(revista2);

        editorRepository.save(editor);

        Optional <Editor> editorGuardado = editorRepository.findById(editor.getId());
        if(editorGuardado.isPresent()){
            Editor editorObtenido = editorGuardado.get();
            System.out.println("Editor obtenido: " + editorObtenido.getNombre());

            editorObtenido.getRevistas().size();

            //Actualizar el nombre del editor
            editorObtenido.setNombre("Editorial ABC");
            editorRepository.save(editorObtenido);
            System.out.println("Editor actualizado: " + editorObtenido.getNombre());

            //Crear una nueva revista
            Revista revista3 = new Revista();
            revista3.setNombre("Revista C");
            revista3.setEditor(editorObtenido);
            revistaRepository.save(revista3);
            System.out.println("Revista creada: " + revista3.getNombre());

            Optional<Revista> revistaOptional = revistaRepository.findById(revista3.getId());
            if(revistaOptional.isPresent()){
                Revista revistaEliminar = revistaOptional.get();
                revistaRepository.delete(revistaEliminar);
                System.out.println("Revista eliminada: " + revistaEliminar.getNombre());
            }else{
                System.out.println("Revista no encontrada");
            }

        }else{
            System.out.println("Editor no encontrado");
        }
    }
}