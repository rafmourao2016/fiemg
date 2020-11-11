/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoDAO.DAO;

import br.com.projetoDAO.model.Pessoa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Casa
 */
public class PessoaDAOTest {

    Pessoa p;

    public PessoaDAOTest() {
        p = new Pessoa("rafael", "ti");
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testConsulta() {
        System.out.println("consulta");
        PessoaDAO instance = new PessoaDAO();
        //   if (instance.consulta()) {
        ///       System.out.println("Teste ok");
        //   } else {
        //    fail("Erro no teste de consulta");

        assertTrue(instance.consulta());

    }

    @Test
    public void testInserir(){
        System.out.println("inserir");
        PessoaDAO pd = new PessoaDAO();
        assertTrue(pd.inserir(p));
        
    
}
   @Test
    public void testeatualizar(){
        System.out.println("atualizar");
        PessoaDAO pd = new PessoaDAO();
        assertTrue(pd.atualizar(p));
    
}

   @Test
    public void testeremover(){
        System.out.println("remover");
        PessoaDAO pd = new PessoaDAO();
        assertTrue(pd.remover(p));
    
}
    
    

}
