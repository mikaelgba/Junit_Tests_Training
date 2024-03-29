package negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Classe de teste criada para garantir o funcionamento das principais opera��es
//sobre clientes, realizadas pela classe {@link GerenciadoraContas}.
//
//@author Michael Oliveira
//@date 27/07/2019 
public class Ex4GerenciadoraContasTest {

	private GerenciadoraContas gerContas;
	
//	  Teste b�sico da transfer�ncia de um valor da conta de um cliente para outro,
//	  estando ambos os clientes ativos e havendo saldo suficiente para tal transfer�ncia
//	  ocorrer com sucesso.

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

		// ========== Execu��o ========== 
		boolean sucesso = gerContas.transfereValor(idConta01, 100, idConta02);
		
		// ========== Teste ========== 
		assertTrue(sucesso);
		assertThat(conta02.getSaldo(), is(100.0));
		assertThat(conta01.getSaldo(), is(100.0));
	}
    // Teste b�sico da tentativa de transfer�ncia de um valor da conta de um cliente para outro
    // quando n�o h� saldo suficiente, mas o saldo � positivo.

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

		// ========== Execu��o ========== 
		boolean sucesso = gerContas.transfereValor(idConta01, 200, idConta02);
		
		// ========== Teste ========== 
		assertTrue(sucesso);
		assertThat(conta01.getSaldo(), is(-100.0));
		assertThat(conta02.getSaldo(), is(200.0));
	}

     //	Teste b�sico da tentativa de transfer�ncia de um valor da conta de um cliente para outro
     //	quando n�o h� saldo suficientee o saldo � negativo.

	@Test
	public void testTransfereValor_SaldoNegativo() {

		// criando alguns clientes
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contasDoBanco);

		// ========== Execu��o ========== 
		boolean sucesso = gerContas.transfereValor(idConta01, 200, idConta02);
		
		// ========== Teste ========== 
		assertTrue(sucesso);
		assertThat(conta01.getSaldo(), is(-300.0));
		assertThat(conta02.getSaldo(), is(200.0));
	}
	
	//Teste b�sico da tentativa de transfer�ncia de um valor da conta de um cliente para outro
	//quando o saldo do cliente origem � negativo e do cliente destino tamb�m � negativo.

	@Test
	public void testTransfereValor_SaldoNegativoParaNegativo() {

		// criando alguns clientes
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, -100, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contasDoBanco);

		// ========== Execu��o ========== 
		boolean sucesso = gerContas.transfereValor(idConta01, 200, idConta02);
		
		// ========== Teste ========== 
		assertTrue(sucesso);
		assertThat(conta01.getSaldo(), is(-300.0));
		assertThat(conta02.getSaldo(), is(100.0));
	}
	
	 // Teste b�sico da tentativa de transfer�ncia de um valor nulo da conta de um cliente para outro.

	@Test
	public void testTransfereValor_Nenhum() {

		// criando alguns clientes
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, -100, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contasDoBanco);

		// ========== Execu��o ==========
		boolean sucesso = gerContas.transfereValor(idConta01, 2, idConta02);
	
		// ========== Teste ========== 
		assertTrue(sucesso);
		assertThat(conta01.getSaldo(), is(-102.0));
		assertThat(conta02.getSaldo(), is(-98.0));
	}	
}