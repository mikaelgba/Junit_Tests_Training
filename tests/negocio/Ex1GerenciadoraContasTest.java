package negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Ex1GerenciadoraContasTest {

	private GerenciadoraContas gerContas;
	
	@Test
	public void testTransfereValor() {
		
		// criando alguns clientes
		ContaCorrente conta01 = new ContaCorrente(1, 350, true);
		ContaCorrente conta02 = new ContaCorrente(2, 50, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contasDoBanco);

		// ========== Execução ==========
		gerContas.transfereValor(1, 100, 2);
		
		// ========== Testes ==========
		assertThat(conta02.getSaldo(), is(150.0));
		assertThat(conta01.getSaldo(), is(250.0));
	}
}