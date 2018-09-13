package br.cefetmg.games.movement.behavior;

import br.cefetmg.games.movement.AlgoritmoMovimentacao;
import br.cefetmg.games.movement.Direcionamento;
import br.cefetmg.games.movement.Pose;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector3;

/**
 * Guia o agente na direção do alvo.
 *
 * @author Flávio Coutinho <fegemo@cefetmg.br>
 */
public class Chegar extends AlgoritmoMovimentacao {

    private static final char NOME = 'a';
    private float satisfacao;

    public Chegar() {
        super(NOME);
    }

    public Chegar(float maxVelocidade, float satisfacao) {
        super(NOME);
        this.maxVelocidade = maxVelocidade;
        this.satisfacao = satisfacao;
    }

    @Override
    public Direcionamento guiar(Pose agente) {
        Direcionamento output = new Direcionamento();
        Vector3 vel = super.alvo.getObjetivo();
        vel = new Vector3(vel.x, vel.y, vel.z).sub(agente.posicao);
        agente.olharNaDirecaoDaVelocidade(vel);
        if (vel.len() > satisfacao)
            output.velocidade = vel.nor().scl(super.maxVelocidade);
        
        return output;
    }

    @Override
    public int getTeclaParaAtivacao() {
        return Keys.A;
    }
}
