package negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Ex2GerenciadoraClientesTest {

	private GerenciadoraClientes gerClientes;
	
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
		
		boolean clienteRemovido = gerClientes.removeCliente(2);
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
		//Testar se cliente 2 foi removido e que cliente 1 permanece
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(2));
		assertThat(cliente.getNome(), is("Belle Dephine"));
		
	}
}