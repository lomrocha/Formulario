public class CalcularIdade {
	private String[] dataNascimento;
	private String[] dataAtual;
	
	public CalcularIdade(String[] dataNascimento, String[] dataAtual) {
		this.dataNascimento = dataNascimento;
		this.dataAtual = dataAtual;
	}
	
	int getIdade() {		
		int idade = Integer.parseInt(dataAtual[0]) - Integer.parseInt(dataNascimento[0]);
		if(Integer.parseInt(dataNascimento[1]) >  Integer.parseInt(dataAtual[1]) 
		|| Integer.parseInt(dataNascimento[1]) == Integer.parseInt(dataAtual[1])
		&& Integer.parseInt(dataNascimento[2]) >  Integer.parseInt(dataAtual[2])) {
			idade--;
		}
		
		return idade;
	}
}
