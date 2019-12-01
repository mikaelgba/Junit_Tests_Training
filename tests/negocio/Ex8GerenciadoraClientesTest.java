package negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Classe de teste criada para garantir o funcionamento das principais operações
//sobre clientes, realizadas pela classe {@link GerenciadoraClientes}.
//
//@author Michael Oliveira
//@date 27/07/2019 
public class Ex8GerenciadoraClientesTest {

	private GerenciadoraClientes gerClientes;
	private int idCLiente01 = 1;
	private	int idCLiente02 = 2;
	
	@Before
	public void setUp() {

		Cliente cliente01 = new Cliente(1, "Belle Dephine", 20, "BelleDephine@gmail.com", 1, true); 		
		Cliente cliente02 = new Cliente(2, "Amber Heard", 33, "AmberHeard@gmail.com", 2, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
	}

	@After
	public void tearDown() {
		gerClientes.limpa();
	}
	
	//Teste básico da pesquisa de um cliente a partir do seu ID.

	@Test
	public void testPesquisaCliente() {

		// ========== Execução ==========
		Cliente cliente = gerClientes.pesquisaCliente(idCLiente01);
		
		// ========== Teste ==========
		assertThat(cliente.getId(), is(idCLiente01));
		
	}
	
	//Teste básico da pesquisa por um cliente que não existe.

	@Test
	public void testPesquisaClienteInexistente() {

		/* ========== Execução ========== */
		Cliente cliente = gerClientes.pesquisaCliente(1001);
		
		/* ========== Teste ========== */
		assertNull(cliente);		
	}
	
	//Teste básico da remoção de um cliente a partir do seu ID.

	@Test
	public void testRemoveCliente() {
		
		/* ========== Execução ========== */
		boolean clienteRemovido = gerClientes.removeCliente(idCLiente02);
		
		/* ========== Teste ========== */
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCLiente02));		
	}
	
	//Teste da tentativa de remoção de um cliente inexistente.
	
	@Test
	public void testRemoveClienteInexistente() {

		/* ========== Execução ========== */
		boolean clienteRemovido = gerClientes.removeCliente(1001);
		
		/* ========== Teste ========== */
		assertThat(clienteRemovido, is(false));
		assertThat(gerClientes.getClientesDoBanco().size(), is(2));
		
	}
	//Validação da idade de um cliente quando a mesma está no intervalo permitido.

	@Test
	public void testClienteIdadeAceitavel() throws IdadeNaoPermitidaException {
	
		Cliente cliente = new Cliente(1, "Belle Dephine", 20, "BelleDephine@gmail.com", 1, true); 
		
		// ========== Execução ==========
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
		
		// ========== Teste ==========
		assertTrue(idadeValida);	
	}
	
	//Validação da idade de um cliente quando a mesma está no intervalo permitido.

	@Test
	public void testClienteIdadeAceitavel_02() throws IdadeNaoPermitidaException {
	
		Cliente cliente = new Cliente(1, "Belle Dephine", 20, "BelleDephine@gmail.com", 1, true); 
		
		// ========== Execução ========== 
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
		
		// ========== Teste ========== 
		assertTrue(idadeValida);	
	}
	
	//Validação da idade de um cliente quando a mesma está no intervalo permitido.

	@Test
	public void testClienteIdadeAceitavel_03() throws IdadeNaoPermitidaException {

		Cliente cliente = new Cliente(1, "Belle Dephine", 65, "BelleDephine@gmail.com", 1, true); 
		
		// ========== Execução ========== 
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
		
		// ========== Teste ========== 
		assertTrue(idadeValida);	
	}
	
	//Validação da idade de um cliente quando a mesma está abaixo intervalo permitido.

	@Test
	public void testClienteIdadeAceitavel_04() throws IdadeNaoPermitidaException {
	
		Cliente cliente = new Cliente(1, "Belle Dephine", 17, "BelleDephine@gmail.com", 1, true); 

		// ========== Execução ========== 
		try {
			gerClientes.validaIdade(cliente.getIdade());
			fail();
		} catch (Exception e) {
			// ========== Teste ==========
			assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
		}	
	}
	
	//Validação da idade de um cliente quando a mesma está acima intervalo permitido.
	
	@Test
	public void testClienteIdadeAceitavel_05() throws IdadeNaoPermitidaException {
	
		Cliente cliente = new Cliente(1, "Belle Dephine", 66, "BelleDephine@gmail.com", 1, true); 
		// ========== Execução ========== 
		try {
			gerClientes.validaIdade(cliente.getIdade());
			fail();
		} catch (Exception e) {
			// ========== Teste========== 
			assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
		}	
	}	
}