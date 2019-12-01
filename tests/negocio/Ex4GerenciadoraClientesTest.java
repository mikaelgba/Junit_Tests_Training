package negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


//Classe de teste criada para garantir o funcionamento das principais opera��es
//sobre clientes, realizadas pela classe {@link GerenciadoraClientes}.

// @author Michael Oliveira
//@date 27/11/2019 

public class Ex4GerenciadoraClientesTest {

	private GerenciadoraClientes gerClientes;
	
	//Teste b�sico da pesquisa de um cliente a partir do seu ID.

	@Test
	public void testPesquisaCliente() {
		
		// criando alguns clientes
		Cliente cliente01 = new Cliente(1, "Belle Dephine", 20, "BelleDephine@gmail.com", 1, true); 		
		Cliente cliente02 = new Cliente(2, "Amber Heard", 33, "AmberHeard@gmail.com", 2, true); 	
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);

		// ========== Execução==========
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
		// ========== Testes ==========
		assertThat(cliente.getId(), is(1));	
	}
	
	//Teste b�sico da remoção de um cliente a partir do seu ID.
	@Test
	public void testRemoveCliente() {
		
		// criando alguns clientes
		Cliente cliente01 = new Cliente(1, "Belle Dephine", 20, "BelleDephine@gmail.com", 1, true); 		
		Cliente cliente02 = new Cliente(2, "Amber Heard", 33, "AmberHeard@gmail.com", 2, true); 	
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		// ========== Execução ==========
		boolean clienteRemovido = gerClientes.removeCliente(2);
		
		// ========== Testes ========== 
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(2));		
	}
}