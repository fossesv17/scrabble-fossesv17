package cl.uchile.dcc.scrabble.Model.Tipos;

import cl.uchile.dcc.scrabble.Model.Tipos.Logical.SBool;
import cl.uchile.dcc.scrabble.Model.Tipos.Numbers.SBin;
import cl.uchile.dcc.scrabble.Model.Tipos.Numbers.SFloat;
import cl.uchile.dcc.scrabble.Model.Tipos.Numbers.SInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertNull;

public class InvalidOperationsTest {
    private SString SS;
    private SInt SI;
    private SFloat SF;
    private SBin SB;
    private SBool SBL;
    private IStype[] t;

    @BeforeEach
    void setUp(){
        SS = new SString("hola");
        SI = new SInt(1);
        SF = new SFloat(1.0);
        SB = new SBin("01");
        SBL = new SBool(true);
        t = new IStype[]{SBL, SB, SI, SF, SS};
    }

    @Test
    void negTest(){
        for (int i=2;i<4;i++) {
            assertNull(t[i].neg());
        }
    }

    @Test
    void SumaTest(){
        var r0 = SI.Suma(SBL);
        var r1 = SI.Suma(SS);
        var r2 = SF.Suma(SS);
        var r3 = SF.Suma(SBL);
        var r4 = SBL.Suma(SS);
        var r5 = SBL.Suma(SBL);
        var r6 = SBL.Suma(SF);
        var r7 = SBL.Suma(SI);
        var r8 = SBL.Suma(SB);
        var r9 = SB.Suma(SS);
        var r10 = SB.Suma(SBL);
        var r11 = SB.Suma(SF);
        IStype[] res = {r0,r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11};
        for (IStype r : res){
            assertNull(r);
        }
    }

    @Test
    void RestaTest(){
        var r0 = SI.Resta(SBL);
        var r1 = SI.Resta(SS);
        var r2 = SF.Resta(SS);
        var r3 = SF.Resta(SBL);
        var r4 = SBL.Resta(SS);
        var r5 = SBL.Resta(SBL);
        var r6 = SBL.Resta(SF);
        var r7 = SBL.Resta(SI);
        var r8 = SBL.Resta(SB);
        var r9 = SB.Resta(SS);
        var r10 = SB.Resta(SBL);
        var r11 = SB.Resta(SF);
        var r12 = SS.Resta(SI);
        var r13 = SS.Resta(SF);
        var r14 = SS.Resta(SB);
        var r15 = SS.Resta(SBL);
        var r16 = SS.Resta(SS);
        IStype[] res = {r0,r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16};
        for (IStype r : res){
            assertNull(r);
        }
    }

    @Test
    void MulTest(){
        var r0 = SI.Multi(SBL);
        var r1 = SI.Multi(SS);
        var r2 = SF.Multi(SS);
        var r3 = SF.Multi(SBL);
        var r4 = SBL.Multi(SS);
        var r5 = SBL.Multi(SBL);
        var r6 = SBL.Multi(SF);
        var r7 = SBL.Multi(SI);
        var r8 = SBL.Multi(SB);
        var r9 = SB.Multi(SS);
        var r10 = SB.Multi(SBL);
        var r11 = SB.Multi(SF);
        var r12 = SS.Multi(SI);
        var r13 = SS.Multi(SF);
        var r14 = SS.Multi(SB);
        var r15 = SS.Multi(SBL);
        var r16 = SS.Multi(SS);
        IStype[] res = {r0,r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16};
        for (IStype r : res){
            assertNull(r);
        }
    }

    @Test
    void DivTest(){
        var r0 = SI.Divn(SBL);
        var r1 = SI.Divn(SS);
        var r2 = SF.Divn(SS);
        var r3 = SF.Divn(SBL);
        var r4 = SBL.Divn(SS);
        var r5 = SBL.Divn(SBL);
        var r6 = SBL.Divn(SF);
        var r7 = SBL.Divn(SI);
        var r8 = SBL.Divn(SB);
        var r9 = SB.Divn(SS);
        var r10 = SB.Divn(SBL);
        var r11 = SB.Divn(SF);
        var r12 = SS.Divn(SI);
        var r13 = SS.Divn(SF);
        var r14 = SS.Divn(SB);
        var r15 = SS.Divn(SBL);
        var r16 = SS.Divn(SS);
        IStype[] res = {r0,r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16};
        for (IStype r : res){
            assertNull(r);
        }
    }

    @Test
    void andTest(){
        for (IStype op : t){
            assertNull(SI.and(op));
            assertNull(SF.and(op));
            assertNull(SS.and(op));
        }
        for (int i = 2; i<t.length;i++){
            assertNull(SBL.and(t[i]));
        }
        for (int i=2;i<t.length;i++){
            assertNull(SB.and(t[i]));
        }
    }

    @Test
    void orTest(){
        for (IStype op : t){
            assertNull(SI.or(op));
            assertNull(SF.or(op));
            assertNull(SS.or(op));
        }
        for (int i = 2;i<t.length;i++){
            assertNull(SBL.or(t[i]));
        }
        for (int i=2;i<t.length;i++){
            assertNull(SB.or(t[i]));
        }
    }

    @Test
    void transformationTest(){
        assertNull(SBL.toFloat());
        assertNull(SBL.toInt());
        assertNull(SBL.toBin());
        assertNull(SB.toBool());
        assertNull(SS.toBin());
        assertNull(SS.toInt());
        assertNull(SS.toFloat());
        assertNull(SS.toBool());
        for (int i = 1;i<t.length-1;i++){
            assertNull(t[i].toBool());
        }
    }
 }
