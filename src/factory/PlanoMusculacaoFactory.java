package factory;
import model.*;
import java.util.*;

public class PlanoMusculacaoFactory extends PlanoTreinoFactory {
    public PlanoTreino criarPlano() {
        List<Exercicio> exercicios = List.of(
                new Exercicio("Supino", "Supino reto com barra", "00:30:00")
        );
        return new PlanoTreino(1, "Musculação", exercicios);
    }
}
