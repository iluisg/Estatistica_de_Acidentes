
class ArquivoEstatistica {

    int CodigoCidade;
    String NomeCidade;
    int QtdAcidentes;

    ArquivoEstatistica() {
        this(0, "", 0);
    }

    ArquivoEstatistica(int CityCode,
            String NameCode,
            int TrafficAccident) {
        CodigoCidade = CityCode;
        NomeCidade = NameCode;
        QtdAcidentes = TrafficAccident;
    }
}
