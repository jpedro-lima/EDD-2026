public class NossoHash<K, V> {
	private Entrada<K, V>[] tabela;
	private int capacidade;

	@SuppressWarnings("unchecked")
	public NossoHash() {
		this.capacidade = 16;
		this.tabela = new Entrada[capacidade];
	}

	private int hash(K key) {
		return Math.abs(key.hashCode()) % capacidade;
	}

	public void put(K key, V value) {
		int posicao = hash(key);

		Entrada<K, V> entrada = new Entrada<>(key, value);
		entrada.proximo = tabela[posicao];
		tabela[posicao] = entrada;
	}

	public V get(K key) {
		int posicao = hash(key);

		Entrada<K, V> atual = tabela[posicao];
		while (atual != null) {
			if (key.equals(atual.key)) return atual.value;
			atual = atual.proximo;
		}

		return null;
	}

	public boolean containsKey(K key) {
		int posicao = hash(key);

		Entrada<K, V> atual = tabela[posicao];
		while (atual != null) {
			if (key.equals(atual.key)) return true;
			atual = atual.proximo;
		}

		return false;
	}

	public boolean containsValue(V value) {
		for (int i = 0; i < capacidade; i++) {
			Entrada<K, V> atual = tabela[i];
			while (atual != null) {
				if (value.equals(atual.value)) return true;
				atual = atual.proximo;
			}
		}

		return false;
	}

	public void exibeMap() {
		for (int i = 0; i < capacidade; i++) {
			System.out.print("posicao " + i + ": ");

			Entrada<K, V> atual = tabela[i];
			if (atual == null) {
				System.out.println("(vazia)");
				continue;
			}

			while (atual != null) {
				System.out.print("[" + atual.key + " = " + atual.value + "]");
				if (atual.proximo != null) System.out.print(" -> ");
				atual = atual.proximo;
			}
			System.out.println();
		}
	}

	public void exibeValores() {
		for (int i = 0; i < capacidade; i++) {
			Entrada<K, V> atual = tabela[i];
			while (atual != null) {
				System.out.println(atual.value);
				atual = atual.proximo;
			}
		}
	}
}
