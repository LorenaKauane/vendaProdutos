/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaVenda.teste;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author IAGO
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ClienteTest.class,
    ProdutoTest.class,
    VendaTest.class,})
public class AllTest {

}
