package fr.utbm.to52.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import static javax.persistence.EnumType.STRING;

@Entity
@DiscriminatorValue("Article")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(Include.NON_NULL)
public  class Article extends Publication implements Serializable {

    @Column(nullable = true)
    private String Journal;

    @Column
    private String Publisher;

    @Column(nullable = true)
    private Long Kartil;

    @Column(nullable = true)
    private Long ImpactFactor;

    @Column(nullable = true)
    private String BestPaperRank;

    @Column(nullable = true)
    private Long Number;

    @Column(nullable = true)
    private String Editor;

    @Column(nullable = true)
    private Long Volume;

    @Column(nullable = true)
    private Long Pages;

    
    public Article(String Journal, String Publisher, Long Kartil, Long ImpactFactor, String BestPaperRank, Long Number, String Editor, Long Volume, Long Pages, Long idPublication, PublicationType publicationType, String englishTitle, String frenchTitle, Long year, Long month, String note, String linkImage, String pdfLink, String issn, String anAbstract, String keyWords,Set<Author> authors) {
        super(idPublication, publicationType, englishTitle, frenchTitle, year, month, note, linkImage, pdfLink, issn, anAbstract, keyWords, authors);
        this.Journal = Journal;
        this.Publisher = Publisher;
        this.Kartil = Kartil;
        this.ImpactFactor = ImpactFactor;
        this.BestPaperRank = BestPaperRank;
        this.Number = Number;
        this.Editor = Editor;
        this.Volume = Volume;
        this.Pages = Pages;
    }
    
    
    

    public Article(String journal, String publisher, Long kartil, Long impactFactor, String bestPaperRank, Long number, String editor, Long volume, Long pages) {
        Journal = journal;
        Publisher = publisher;
        Kartil = kartil;
        ImpactFactor = impactFactor;
        BestPaperRank = bestPaperRank;
        Number = number;
        Editor = editor;
        Volume = volume;
        Pages = pages;
    }

    public Article() {

    }

    public String getJournal() {
        return Journal;
    }

    public void setJournal(String journal) {
        Journal = journal;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public Long getKartil() {
        return Kartil;
    }

    public void setKartil(Long kartil) {
        Kartil = kartil;
    }

    public Long getImpactFactor() {
        return ImpactFactor;
    }

    public void setImpactFactor(Long impactFactor) {
        ImpactFactor = impactFactor;
    }

    public String getBestPaperRank() {
        return BestPaperRank;
    }

    public void setBestPaperRank(String bestPaperRank) {
        BestPaperRank = bestPaperRank;
    }

    public Long getNumber() {
        return Number;
    }

    public void setNumber(Long number) {
        Number = number;
    }

    public String getEditor() {
        return Editor;
    }

    public void setEditor(String editor) {
        Editor = editor;
    }

    public Long getVolume() {
        return Volume;
    }

    public void setVolume(Long volume) {
        Volume = volume;
    }

    public Long getPages() {
        return Pages;
    }

    public void setPages(Long pages) {
        Pages = pages;
    }

    @Override
    public boolean equals(Object o) {


        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        if (!super.equals(o)) return false;
        Article article = (Article) o;
        return getImpactFactor() == article.getImpactFactor() &&
                Objects.equals(getJournal(), article.getJournal()) &&
                Objects.equals(getPublisher(), article.getPublisher()) &&
                Objects.equals(getKartil(), article.getKartil()) &&
                Objects.equals(getBestPaperRank(), article.getBestPaperRank()) &&
                Objects.equals(getNumber(), article.getNumber()) &&
                Objects.equals(getEditor(), article.getEditor()) &&
                Objects.equals(getVolume(), article.getVolume()) &&
                Objects.equals(getPages(), article.getPages());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getJournal(), getPublisher(), getKartil(), getImpactFactor(), getBestPaperRank(), getNumber(), getEditor(), getVolume(), getPages());
    }

    @Override
    public String toString() {
        return "Article{" + "Journal=" + Journal + ", Publisher=" + Publisher + ", Kartil=" + Kartil + ", ImpactFactor=" + ImpactFactor + ", BestPaperRank=" + BestPaperRank + ", Number=" + Number + ", Editor=" + Editor + ", Volume=" + Volume + ", Pages=" + Pages + '}';
    }
    
    public String print(List<Author> author){
        String listAuth="";
        for (Author auth: author
             ) {
            listAuth=listAuth + " "+ auth.getMember().getLastName()+",";
        }
        return listAuth;
    }

}

