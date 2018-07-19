package br.com.ufba.atendimento;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

import br.com.ufba.utils.FileContext;

public class AtendimentoContext {

	private Queue<Senha> senhas;
	private final int TEMPO_DE_ESPERA = 5000;
	private int ultimoId;
	private FileContext fileContext;

	public AtendimentoContext() {

		fileContext = new FileContext();

		try {
			this.senhas = (Queue<Senha>) fileContext.getFile("dados");

			if (this.senhas == null) {
				this.senhas = new LinkedList<>();
				fileContext.saveFile("dados", this.senhas);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Senha atender() {
		Calendar calendar = Calendar.getInstance();

		Queue<Senha> senhasAntigasPreferenciais = this.senhas.stream()
				.filter(s -> s.getDataAtendimento() == null && s.getTipo().equals("P"))
				.sorted(Comparator.comparing(Senha::getDataRegistro)).collect(Collectors.toCollection(LinkedList::new));

		for (Senha senha : senhasAntigasPreferenciais) {
			calendar.setTime(senha.getDataRegistro());

			if (calendar.getTimeInMillis() >= this.TEMPO_DE_ESPERA) {
				senha.setDataAtendimento(new Date());
				return senha;
			}
		}

		Senha senhaNormal = this.senhas.peek();
		senhaNormal.setDataAtendimento(new Date());

		return senhaNormal;
	}

	public void gerarSenhaNormal() {
		this.ultimoId++;
		Senha senha = new Senha(this.ultimoId, "N");
		senhas.add(senha);
	}

	public void gerarSenhaPreferencial() {
		this.ultimoId++;
		Senha senha = new Senha(this.ultimoId, "P");
		senhas.add(senha);
	}

	public Queue<Senha> getTodasAsSenhas() {
		return this.senhas;
	}

	public Queue<Senha> getTodasAsSenhasNaoAtendidas() {
		return this.senhas.stream().filter(s -> s.getDataAtendimento() == null)
				.sorted(Comparator.comparing(Senha::getDataRegistro)).collect(Collectors.toCollection(LinkedList::new));
	}
}
