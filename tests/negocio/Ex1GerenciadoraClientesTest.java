package negocio;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Ex1GerenciadoraClientesTest {

	@Test
	public void testPesquisaCliente() {

		// criando alguns clientes
		Cliente cliente01 = new Cliente(1, "Belle Dephine", 20, "BelleDephine@gmail.com", 1, true); 		
		Cliente cliente02 = new Cliente(2, "Amber Heard", 33, "AmberHeard@gmail.com", 2, true); 	
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
		assertThat(cliente.getId(), is(1));
		assertThat(cliente.getEmail(), is("BelleDephine@gmail.com"));
		
	}
}