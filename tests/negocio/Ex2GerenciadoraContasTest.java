package negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

//Classe de teste criada para garantir o funcionamento das principais operaï¿½ï¿½es
//sobre contas, realizadas pela classe {@link GerenciadoraContas}.
// 
//@author Michael Oliveira
//@date 27/11/2019 

public class Ex2GerenciadoraContasTest {

	private GerenciadoraContas gerContas;
	
//	Teste bï¿½sico da transferï¿½ncia de um valor da conta de um cliente para outro,
//	estando ambos os clientes ativos e havendo saldo suficiente para tal transferï¿½ncia
//	ocorrer com sucesso.

	@Test
	public void testTransfereValor() {
		
		// criando alguns clientes
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contasDoBanco);

		// ========== Execução ==========
		boolean sucesso = gerContas.transfereValor(idConta01, 100, idConta02);
		
		// ========== Teste ==========
		assertTrue(sucesso);
		assertThat(conta02.getSaldo(), is(100.0));
		assertThat(conta01.getSaldo(), is(100.0));
	}
	
//	 Teste basico da tentativa de transferencia de um valor da conta de um cliente para outro
//	 quando não há saldo suficiente.
	@Test
	public void testTransfereValor_SaldoInsuficiente() {
		
		// criando alguns clientes
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, 100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);	
		gerContas = new GerenciadoraContas(contasDoBanco);

		// ========== Execução ========== 
		boolean sucesso = gerContas.transfereValor(idConta01, 200, idConta02);
		
		// ========== Teste ========== 
		assertTrue(sucesso);
		assertThat(conta01.getSaldo(), is(-100.0));
		assertThat(conta02.getSaldo(), is(200.0));
	}
}