package br.cefetmg.games.movement.behavior;

import br.cefetmg.games.movement.AlgoritmoMovimentacao;
import br.cefetmg.games.movement.Direcionamento;
import br.cefetmg.games.movement.Pose;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector3;

/**
 * Guia o agente de forma a fugir na direção contrária ao alvo.
 *
 * @author Flávio Coutinho <fegemo@cefetmg.br>
 */
public class Fugir extends AlgoritmoMovimentacao {

    private static final char NOME = 'w';

    public Fugir(float maxVelocidade) {
        super(NOME);
        this.maxVelocidade = maxVelocidade;
    }

    @Override
    public Direcionamento guiar(Pose agente) {
        Direcionamento output = new Direcionamento();
        Vector3 vel = agente.posicao;
        output.velocidade = new Vector3(vel.x, vel.y, vel.z).sub(super.alvo.getObjetivo()).nor().scl(super.maxVelocidade);
        agente.olharNaDirecaoDaVelocidade(output.velocidade);
        return output;
    }

    @Override
    public int getTeclaParaAtivacao() {
        return Keys.F;
    }

}
