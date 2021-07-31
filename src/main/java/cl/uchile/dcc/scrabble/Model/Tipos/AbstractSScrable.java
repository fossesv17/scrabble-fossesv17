package cl.uchile.dcc.scrabble.Model.Tipos;

public abstract class AbstractSScrable implements IStype {
    @Override
    public SString SumString(IStype S) {
        return new SString(S.toString().concat(this.toString()));
    }

    @Override
    public IStype neg(){
        return null;
    }

    @Override
    public IStype eval(){
        return this;
    }
}
