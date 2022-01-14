package br.com.alura.rh.model;

public enum Cargo {

	ASSISTENTE{
		@Override
		public Cargo getProximoCargo(){
			return ANALISTA;
		}

	},ANALISTA {
		@Override
		public Cargo getProximoCargo() {
			return ESPECIALISTA;
		}
	},
	ESPECIALISTA {
		@Override
		public Cargo getProximoCargo() {
			return GERENTE;
		}
	},
	GERENTE {
		@Override
		public Cargo getProximoCargo() {
			return GERENTE;
		}
	};

	//metodo abstrato obrigada todas as constantes à implementá-lo
	public abstract Cargo getProximoCargo();




}
