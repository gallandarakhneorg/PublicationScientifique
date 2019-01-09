package fr.utbm.to52.service;

import fr.utbm.to52.dao.AuthorDao;
import fr.utbm.to52.dao.PublicationDao;
import fr.utbm.to52.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class GenerateBibtexFile <T extends Publication>{

    @Autowired
    private PublicationDao<T> pubDao;

    @Autowired
    private AuthorDao auth;

    public String toString (Long publicationId)
    {
        Publication pub;
        pub= pubDao.findOne(publicationId);
        Class cls = pub.getClass();
        String Maclass= cls.getName();
        if(pub instanceof Article) {
            Maclass="Article";
        }
        if(pub instanceof Conference) {
            Maclass="Conference";
        }
        if(pub instanceof Book) {
            Maclass="Book";
        }
        if(pub instanceof InBook) {
            Maclass="InBook";
        }
        if(pub instanceof Manuel) {
            Maclass="Manuel";
        }
        if(pub instanceof MpThesis) {
            Maclass="MpThesis";
        }
        if(pub instanceof Proceeding) {
            Maclass="Proceeding";
        }
        if(pub instanceof TechReport) {
            Maclass="TechReport";
        }
        String result = "";
        result=result+ "@"+Maclass+"{" +pub.getIdPublication()+",\n";
        if (pub.getAbstract()!=null){
            result= result +"abstract= {"+pub.getAbstract()+"},\n ";
        }
        if (pub.getEnglishTitle()!=null){
            result= result +"language= { French }, \n";
            result= result+ "title = {" +pub.getFrenchTitle()+"}, \n";
        }else{ result=result +"language = {English}, \n";
                result= result +"title ={" +pub.getEnglishTitle()+"}, \n ";}
        if (pub.getIssn()!=null){
            result= result + "issn= {"+pub.getIssn()+"}, \n";
        }
        if (pub.getKeyWords()!=null){
            result= result +  "keywords= {"+ pub.getKeyWords()+"}, \n";
        }
        if (pub.getLinkImage()!=null){
            result= result +  "linkImage= {"+pub.getLinkImage()+"}, \n";
        }
        if (pub.getMonth()!=null){
            result= result +  "month= {" +pub.getMonth()+"}, \n";
        }
        if (pub.getNote()!=null){
            result= result + "note= {" +pub.getNote()+"}, \n";
        }
        if (pub.getPdfLink()!=null){
            result= result + "pdfLink= {" +pub.getPdfLink()+"}, \n";
        }
        if (pub.getYear()!=null){
            result= result + "year = {" +pub.getYear()+"},\n";
        }
        List<Author> authors;
        String str;
        authors=getPublicationsAuthors(publicationId);
        Article ar = new Article();
        str= ar.print(authors);
        if (str!=null){
            result=result + "author= {"+str+"}, \n ";
        }

        if(pub instanceof Article) {
            pub = (Article) pub;
            if (((Article) pub).getJournal() != null) {
                result = result + "journal={" + ((Article) pub).getJournal() + "}, \n";
            }
            if (((Article) pub).getPublisher() != null) {
                result = result + "publisher= {" + ((Article) pub).getPublisher() + "}, \n";
            }
            if (((Article) pub).getKartil() != null) {
                result = result + "kartil= {" + ((Article) pub).getKartil() + "}, \n";
            }
            if (((Article) pub).getImpactFactor() != null) {
                result = result + "impactFactor={" + ((Article) pub).getImpactFactor() + "}, \n";
            }
            if (((Article) pub).getBestPaperRank() != null) {
                result = result + "bestPaperRank={" + ((Article) pub).getBestPaperRank() + "}, \n";
            }
            if (((Article) pub).getNumber() != null) {
                result = result + "number= {" + ((Article) pub).getNumber() + "}, \n";
            }
            if (((Article) pub).getEditor() != null) {
                result = result + "editor={" + ((Article) pub).getEditor() + "}, \n";
            }
            if (((Article) pub).getVolume() != null) {
                result = result + "volume= {" + ((Article) pub).getVolume() + "}, \n";
            }
            if (((Article) pub).getPages() != null) {
                result = result + "pages={" + ((Article) pub).getPages() + "}, \n";
            }
        }
        if(pub instanceof Conference) {
            pub = (Conference) pub;
            if (((Conference) pub).getConferenceName() != null) {
                result = result + "conferenceName={" + ((Conference) pub).getConferenceName() + "}, \n";
            }
            if (((Conference) pub).getPublisher() != null) {
                result = result + "publisher= {" + ((Conference) pub).getPublisher() + "}, \n";
            }
            if (((Conference) pub).getRanking() != null) {
                result = result + "ranking= {" + ((Conference) pub).getRanking() + "}, \n";
            }
            if (((Conference) pub).getSeries() != null) {
                result = result + "series= {" + ((Conference) pub).getSeries() + "}, \n";
            }
            if (((Conference) pub).getOrganization() != null) {
                result = result + "organization= {" + ((Conference) pub).getOrganization() + "}, \n";
            }
            if (((Conference) pub).getEditor() != null) {
                result = result + "editor= {" + ((Conference) pub).getEditor() + "}, \n";
            }
            if (((Conference) pub).getVolume() != null) {
                result = result + "volume= {" + ((Conference) pub).getVolume() + "}, \n";
            }
            if (((Conference) pub).getPages() != null) {
                result = result + "pages= {" + ((Conference) pub).getPages() + "}, \n";
            }
        }
        if(pub instanceof Book) {
            if (((Book) pub).getVolume() != null) {
                result = result + "volume= {" + ((Book) pub).getVolume() + "}, \n";

            }
            if (((Book) pub).getSeries() != null) {
                result = result + "series= {" + ((Book) pub).getSeries() + "}, \n";
            }
            if (((Book) pub).getPublisher() != null) {
                result = result + "publisher= {" + ((Book) pub).getPublisher() + "}, \n";
            }
            if (((Book) pub).getEdition() != null) {
                result = result + "edition={" + ((Book) pub).getEdition() + "}, \n";
            }
            if (((Book) pub).getIsbn() != null) {
                result = result + "isbn={" + ((Book) pub).getIsbn() + "}, \n";
            }
        }
        if(pub instanceof InBook) {
            if (((InBook) pub).getVolume() != null) {
                result = result + "volume={" + ((InBook) pub).getVolume() + "}, \n";
            }
            if (((InBook) pub).getPages() != null) {
                result = result + "pages={" + ((InBook) pub).getPages() + "}, \n";
            }
            if (((InBook) pub).getEdition() != null) {
                result = result + "edition=" + ((InBook) pub).getEdition() + ", \n";
            }
            if (((InBook) pub).getPublisher() != null) {
                result = result + "publisher= {" + ((InBook) pub).getPublisher() + "}, \n";
            }
            if (((InBook) pub).getSeries() != null) {
                result = result + "series={" + ((InBook) pub).getSeries() + "}, \n";
            }
            if (((InBook) pub).getChapter() != null) {
                result = result + "isbn={" + ((InBook) pub).getChapter() + "}, \n";
            }
        }
        if(pub instanceof Manuel) {
            if (((Manuel) pub).getEdition() != null) {
                result = result + "edition={" + ((Manuel) pub).getEdition() + "}, \n";
            }
            if (((Manuel) pub).getOrganization() != null) {
                result = result + "organization={" + ((Manuel) pub).getOrganization() + "}, \n";
            }
            if (((Manuel) pub).getNumber() != null) {
                result = result + "number=" + ((Manuel) pub).getNumber() + ", \n";
            }
            if (((Manuel) pub).getInstitution() != null) {
                result = result + "institution={" + ((Manuel) pub).getInstitution() + "}, \n";
            }
        }
        if(pub instanceof MpThesis) {
            if (((MpThesis) pub).getSchool() != null) {
                result = result + "institution={" + ((MpThesis) pub).getSchool() + "}, \n";
            }
        }
        if(pub instanceof Proceeding) {
            if (((Proceeding) pub).getPublisher() != null) {
                result = result + "publisher={" + ((Proceeding) pub).getPublisher() + "}, \n";
            }
            if (((Proceeding) pub).getVolume() != null) {
                result = result + "volume={" + ((Proceeding) pub).getVolume() + "}, \n";
            }
            if (((Proceeding) pub).getSeries() != null) {
                result = result + "series={" + ((Proceeding) pub).getSeries() + "}, \n";
            }
            if (((Proceeding) pub).getOrganization() != null) {
                result = result + "organization={" + ((Proceeding) pub).getOrganization() + "}, \n";
            }
            if (((Proceeding) pub).getEditor() != null) {
                result = result + "editor={" + ((Proceeding) pub).getEditor() + "}, \n";
            }
        }
        if(pub instanceof TechReport) {
            if (((TechReport) pub).getNumber() != null) {
                result = result + "number={" + ((TechReport) pub).getNumber() + "}, \n";
            }
            if (((TechReport) pub).getInstitution() != null) {
                result = result + "institution={" + ((TechReport) pub).getInstitution() + "}, \n";
            }
        }
        result=result +"}";

        return result;
    }

    public String toString(){
        String result="";
        List<T> listPub= getAllPublications();
        for (Publication pub: listPub
             ) {
            result= result + toString(pub.getIdPublication())+ "\n" +"\n";
        }

        return result;

    }

    public void CreateBibtexFile(String string)
            throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("home/Documents/UTBM/TO52/bibtexfile.bib"));
        writer.write(string);
        writer.close();
    }

    public List<Author> getPublicationsAuthors(Long publicationId)
    {
        return pubDao.findAllPublicationAuthorMemberByIdPublication(publicationId);
    }
    public List<T> getAllPublications()
    {
        return pubDao.findAll();
    }
}
