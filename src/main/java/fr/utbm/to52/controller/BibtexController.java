package fr.utbm.to52.controller;

import fr.utbm.to52.service.GenerateBibtexFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;


@RestController
public class BibtexController {

    @Autowired
    private GenerateBibtexFile str;

    @GetMapping("/bibtexpublications/id/{publicationId}")
    public String bibtex(@PathVariable Long publicationId) throws IOException {
       return str.toString(publicationId);
    }

    @GetMapping("/bibtexpublications/")
    public String bibtexAllPub() throws IOException {
        return str.toString();
    }

    @GetMapping("/bibtexpublicationsfile/")
    public void bibtexAllPubFile() throws IOException {
        String string;
        string= str.toString();
        str.CreateBibtexFile(string);
    }

    @GetMapping("/bibtexpublicationsfile/id/{publicationId}")
    public void bibtexAllPubFileById(@PathVariable Long publicationId) throws IOException {
        String string;
        string= str.toString(publicationId);
        str.CreateBibtexFile(string);
    }
}
