package negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// * Classe de teste criada para garantir o funcionamento das principais opera��es
// * sobre clientes, realizadas pela classe {@link GerenciadoraClientes}.

//@author Michael Oliveira
//@date 27/07/2019 
 
public class Ex6GerenciadoraClientesTest {

	private GerenciadoraClientes gerClientes;
	private int idCliente01 = 1;
	private	int idCliente02 = 2;
	
	@Before
	public void setUp() {
		
		// criando alguns clientes
		Cliente cliente01 = new Cliente(idCliente01, "Belle Dephine", 20, "BelleDephine@gmail.com", 1, true); 		
		Cliente cliente02 = new Cliente(idCliente02, "Amber Heard", 33, "AmberHeard@gmail.com", 2, true); 	
		
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
	//Teste b�sico da pesquisa de um cliente a partir do seu ID.

	@Test
	public void testPesquisaCliente() {

		// ========== Execu��o ========== */
		Cliente cliente = gerClientes.pesquisaCliente(idCliente01);
		
		// ========== Teste ==========
		assertThat(cliente.getId(), is(idCliente01));		
	}
	
	//Teste b�sico da remo��o de um cliente a partir do seu ID.

	@Test
	public void testRemoveCliente() {
		
		// ========== Execu��o ========== 
		boolean clienteRemovido = gerClientes.removeCliente(idCliente02);
		
		// ========== Teste ========== 
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCliente02));
		
	}
}