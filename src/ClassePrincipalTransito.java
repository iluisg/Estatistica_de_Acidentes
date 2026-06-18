
import java.io.IOException;
import javax.swing.JOptionPane;

public class ClassePrincipalTransito {

    public static void main(String args[]) throws IOException {
        ArquivoEstatistica[] estatistica = new ArquivoEstatistica[10];
        ClasseMetodoTransito m = new ClasseMetodoTransito();

        int opc = 0;
        while (opc != 9) {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Menu Principal"
                    + "\n 1 - Cadastro estatística"
                    + "\n 2 - Consulta por quantidade de acidentes "
                    + "\n 3 - Consulta por estatísticas de acidente"
                    + "\n 4 - Acidentes acima da médias das 10 cidades "
                    + "\n 9 - Finaliza"));

            switch (opc) {
                case 1:
                    estatistica = m.CadastraAcidente(estatistica);
                    break;
                case 2:
                    m.ConsultaQuantidade(estatistica);
                    break;
                case 3:
                    m.ConsultaEstatistica(estatistica);
                    break;
                case 4:
                    m.ConsultaAcimaMedia(estatistica);
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Programa finalizado!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA!");
            }
        }
    }
}
