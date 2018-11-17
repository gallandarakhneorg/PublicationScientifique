package fr.utbm.to52.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public abstract class Article extends Publication implements Serializable {

    @Column(nullable = false)
    private String Journal;

    @Column
    private String Publisher;

    @Column(nullable = false)
    private String Kartil;

    @Column(nullable = false)
    private long ImpactFactor;

    @Column(nullable = false)
    private String BestPaperRank;

    @Column
    private String Number;

    @Column
    private String Editor;

    @Column
    private String Volume;

    @Column
    private String Pages;

    public Article(long idPublication, PublicationType publicationType, String englishTitle, String frenchTitle, Date year, Date month, String note, String linkImage, String pdfLink, String issn, String anAbstract, String keyWords, Project project, Set<Author> authors, String journal, String publisher, String kartil, long impactFactor, String bestPaperRank, String number, String editor, String volume, String pages) {
        super(idPublication, publicationType, englishTitle, frenchTitle, year, month, note, linkImage, pdfLink, issn, anAbstract, keyWords, project, authors);
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

    public Article(String journal, String publisher, String kartil, long impactFactor, String bestPaperRank, String number, String editor, String volume, String pages) {
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

    public String getKartil() {
        return Kartil;
    }

    public void setKartil(String kartil) {
        Kartil = kartil;
    }

    public long getImpactFactor() {
        return ImpactFactor;
    }

    public void setImpactFactor(long impactFactor) {
        ImpactFactor = impactFactor;
    }

    public String getBestPaperRank() {
        return BestPaperRank;
    }

    public void setBestPaperRank(String bestPaperRank) {
        BestPaperRank = bestPaperRank;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getEditor() {
        return Editor;
    }

    public void setEditor(String editor) {
        Editor = editor;
    }

    public String getVolume() {
        return Volume;
    }

    public void setVolume(String volume) {
        Volume = volume;
    }

    public String getPages() {
        return Pages;
    }

    public void setPages(String pages) {
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
}

