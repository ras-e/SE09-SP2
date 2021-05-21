package domain.Program;

public enum Category {drama("Drama"),
    komedie("Komedie"),
    thriller("Thriller"),
    krimi("Krimi"),
    Dokumentar("Dokumentar"),
    Fantasy("Fantasy"),
    gyser("Gyser"),
    ScienceFiction("Science Fiction"),
    Romantiskkomedie("Romantisk komedie"),
    Musikals("Musikals"),
    Drama("Drama");


    //indsæt evt kategorier her
    // f.eks. SUNDAY, MONDAY, THUESDAY..
    private String kategori;
    Category(String kategori) {
        this.kategori = kategori;
    }
}
