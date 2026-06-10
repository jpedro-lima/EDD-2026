public class TesteHash {
	public static void main(String[] args) {
		NossoHash<Integer, String> mapa = new NossoHash<Integer, String>();

		System.out.println("=== INSERÇÃO COM COLISÕES ===");
		// Com capacidade 16 e chave Integer, hash = chave % 16.
		// Logo 1, 17 e 33 caem todos na posição 1 (colisão).
		mapa.put(1, "um");
		mapa.put(17, "dezessete");
		mapa.put(33, "trinta e tres");
		// 2 e 18 caem na posição 2.
		mapa.put(2, "dois");
		mapa.put(18, "dezoito");
		// 7 cai sozinho na posição 7.
		mapa.put(7, "sete");

		System.out.println("Posições 1 e 2 devem ter cadeias (colisão):\n");
		mapa.exibeMap();

		System.out.println("\n=== GET ===");
		System.out.println("get(17): " + mapa.get(17));
		System.out.println("get(33): " + mapa.get(33));
		System.out.println("get(99) (inexistente): " + mapa.get(99));

		System.out.println("\n=== CONTAINS KEY ===");
		System.out.println("containsKey(7): " + mapa.containsKey(7));
		System.out.println("containsKey(99): " + mapa.containsKey(99));

		System.out.println("\n=== CONTAINS VALUE ===");
		System.out.println("containsValue(\"dezoito\"): " + mapa.containsValue("dezoito"));
		System.out.println("containsValue(\"mil\"): " + mapa.containsValue("mil"));

		System.out.println("\n=== CHAVE REPETIDA (novo valor inserido à frente) ===");
		System.out.println("Antes  -> get(1): " + mapa.get(1));
		mapa.put(1, "UM ATUALIZADO");
		System.out.println("Depois -> get(1): " + mapa.get(1));
		System.out.println("\nCadeia da posição 1 (o valor antigo continua atrás):");
		mapa.exibeMap();
	}
}
