package cl.uchile.dcc.scrabble.Tipos.DefaultOper;

import cl.uchile.dcc.scrabble.Tipos.IStype;
import cl.uchile.dcc.scrabble.Tipos.Logical.SBool;
import cl.uchile.dcc.scrabble.Tipos.Numbers.SBin;
import cl.uchile.dcc.scrabble.Tipos.Numbers.SFloat;
import cl.uchile.dcc.scrabble.Tipos.Numbers.SInt;



/**
 * interface to return null for all invalid operations with default methods, since valid operations
 * will get overridden
 */
public interface DefaultOper {
    default IStype toBool() { return null; }
    default IStype toFloat(){
        return null;
    }
    default IStype toInt(){ return null; }
    default IStype toBin(){
        return null;
    }
    default IStype BinSum(SBin o){
        return null;
    }
    default IStype IntSum(SInt o){
        return null;
    }
    default IStype FloatSum(SFloat o){
        return null;
    }
    default IStype BoolSum(SBool o){
        return null;
    }
    default IStype BinResta(SBin o){
        return null;
    }
    default IStype IntResta(SInt o){
        return null;
    }
    default IStype FloatResta(SFloat o){
        return null;
    }
    default IStype BoolResta(SBool o){
        return null;
    }
    default IStype BinMul(SBin o){
        return null;
    }
    default IStype IntMul(SInt o){
        return null;
    }
    default IStype FloatMul(SFloat o){
        return null;
    }
    default IStype BoolMul(SBool o){
        return null;
    }
    default IStype BinDiv(SBin o){
        return null;
    }
    default IStype IntDiv(SInt o){
        return null;
    }
    default IStype FloatDiv(SFloat o){
        return null;
    }
    default IStype BoolDiv(SBool o){
        return null;
    }
    default IStype binAnd(SBin o){
        return null;
    }
    default IStype binOr(SBin o){
        return null;
    }
    default IStype FloatAnd(SFloat o){
        return null;
    }
    default IStype FloatOr(SFloat o){
        return null;
    }
    default IStype IntAnd(SInt o){
        return null;
    }
    default IStype IntOr(SInt o){
        return null;
    }
    default IStype boolAnd(SBool o){
        return null;
    }
    default IStype boolOr(SBool o){
        return null;
    }
    default IStype RestaString(IStype o){
        return null;
    }
    default IStype MulString(IStype o){
        return null;
    }
    default IStype DivString(IStype o){
        return null;
    }
    default IStype andString(IStype o){
        return null;
    }
    default IStype orString(IStype o){
        return null;
    }
}