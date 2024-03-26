package com.ccdev.springdatajpa.testing;

import com.ccdev.springdatajpa.entities.entity3.Editor;
import com.ccdev.springdatajpa.entities.entity3.Magazine;
import com.ccdev.springdatajpa.repositories.repository3.EditorRepository;
import com.ccdev.springdatajpa.repositories.repository3.MagazineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

//@Component
public class testing3 implements CommandLineRunner {
    @Autowired
    private EditorRepository editorRepository;
    @Autowired
    private MagazineRepository magazineRepository;

    @Override
    public void run(String... args) throws Exception {
        Editor editor = new Editor();
        editor.setName("Editor ABC");

        Magazine maganize1 = new Magazine();
        maganize1.setName("Magazine 1");
        maganize1.setEditor(editor);

        Magazine magazine2 = new Magazine();
        magazine2.setName("Magazine 2");
        magazine2.setEditor(editor);


        editor.getMagazines().add(maganize1);
        editor.getMagazines().add(magazine2);


        editorRepository.save(editor);

        Optional<Editor> editorSaved = editorRepository.findById(editor.getId());
        if (editorSaved.isPresent()) {
            Editor editorObtained = editorSaved.get();
            System.out.println("Editor: " + editorObtained.getName());

            editorObtained.setName("Editor XYZ");
            System.out.println("Updating editor...");

            editorRepository.save(editorObtained);

            System.out.println("Editor has been updated.");
            System.out.println(editorObtained.getName());


            Magazine magazine3 = new Magazine();
            magazine3.setName("Magazine 3");
            magazine3.setEditor(editorObtained);
            magazineRepository.save(magazine3);

            System.out.println("Magazine created: " + magazine3.getName());

            Optional<Magazine> magazineSaved = magazineRepository.findById(magazine2.getId());
            if (magazineSaved.isPresent()) {
                Magazine deleteMagazine = magazineSaved.get();
                System.out.println("Deleting " + deleteMagazine.getName() + " ...");
                magazineRepository.delete(deleteMagazine);
                System.out.println("Magazine deleted.");
            } else {
                System.out.println("Magazine not found");
            }
        }
    }
}
