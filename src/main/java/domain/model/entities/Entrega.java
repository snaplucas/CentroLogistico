package domain.model.entities;

import domain.model.enumeradores.Zona;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Entrega {

    private String id;
    private String veiculo;
    private List<Pacote> pacotes;
    private List<Passo> passos;

    public Entrega() {
        this.pacotes = new ArrayList<>();
        this.passos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public List<Pacote> getPacotes() {
        return pacotes;
    }

    public void setPacotes(List<Pacote> pacotes) {
        this.pacotes = pacotes;
    }

    public List<Passo> calcularPassos() {
        pacotes.sort(Comparator.comparingDouble(Pacote::getPeso).reversed());
        resolvePassos(pacotes, Zona.ABASTECIMENTO, Zona.TRANSFERENCIA, Zona.CAMINHAO);
        return passos;
    }

    private void resolvePassos(List<Pacote> pacotes, Zona inicial, Zona auxiliar, Zona destino) {
        if (pacotes.size() == 1) {
            passos.add(new Passo(pacotes.get(0).getId(), inicial, destino));
        } else {
            resolvePassos(pacotes.subList(1, pacotes.size()), inicial, destino, auxiliar);
            passos.add(new Passo(pacotes.get(0).getId(), inicial, destino));
            resolvePassos(pacotes.subList(1, pacotes.size()), auxiliar, inicial, destino);
        }
    }
}
