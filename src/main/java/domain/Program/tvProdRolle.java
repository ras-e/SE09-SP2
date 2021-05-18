package domain.Program;

public enum tvProdRolle {
    billedKunster("Billedkunster"),
    billedLydMan("Billede og lydredigering"),
    casting("Casting"),
    colorGrading("Color"),
    dirigenter("Dirigenter"),
    drone("Drone"),
    dukkefører("Dukkefører"),
    dukkeSkaber("Dukkeskaber"),
    fortæller("Fortæller"),
    fotografer("Fotografer"),
    forlæg("Forlæg"),
    grafiskDesigner("GrafiskDesigner"),
    indtalere("Indtalere"),
    kapelMester("KapelMester"),
    klipper("Klipper"),
    konceptProgramkoncept("Koncept/Programkoncept"),
    konsulent("konsulent");

    private String rolle;
    tvProdRolle(String rolle) {
        this.rolle = rolle;
    }
}
