package negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Classe de teste criada para garantir o funcionamento das principais opera��es
//sobre clientes, realizadas pela classe {@link GerenciadoraClientes}.
//
//@author Michael Oliveira
//@date 27/07/2019 

public class Ex7GerenciadoraClientesTest {

	private GerenciadoraClientes gerClientes;
	private int idCLiente01 = 1;
	private	int idCLiente02 = 2;
	
	@Before
	public void setUp() {

		// criando alguns clientes
		Cliente cliente01 = new Cliente(idCLiente01, "Belle Dephine", 20, "BelleDephine@gmail.com", 1, true); 		
		Cliente cliente02 = new Cliente(idCLiente02, "Amber Heard", 33, "AmberHeard@gmail.com", 2, true); 	
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
	
		// a) Abriu conex�o com o BD? Ent�o...
		// b) Criou arquivos e pastas aqui? Ent�o...
		// c) Inseriu clientes fict�cios na base de dados especificamente para os testes desta classe? Ent�o...
	}
	@After
	public void tearDown() {
		gerClientes.limpa();
		
		// a) Fecha aqui!!!
		// b) Apaga todos eles aqui!!!
		// c) Apaga eles aqui!!!
	}
	
	//Teste b�sico da pesquisa de um cliente a partir do seu ID.

	@Test
	public void testPesquisaCliente() {

		// ========== Execu��o ========== 
		Cliente cliente = gerClientes.pesquisaCliente(idCLiente01);
		
		// ========== Teste ========== 
		assertThat(cliente.getId(), is(idCLiente01));
		
	}
	//Teste b�sico da remo��o de um cliente a partir do seu ID.

	@Test
	public void testRemoveCliente() {
		
		// ========== Execu��o ==========
		boolean clienteRemovido = gerClientes.removeCliente(idCLiente02);
		
		// ========== Teste ========== 
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCLiente02));
		
	}
}