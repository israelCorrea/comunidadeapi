package com.digitalinnovationone.comunidadeapi.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoLogradouro {

	VILA(0), LARGO(1), TRAVESSA(2), VIELA(3), LOTEAMENTO(4), PATIO(5), VIADUTO(6), 
	AREA(7), VIA(8), AEROPORTO(9), VEREDA(10), DISTRITO(11), VALE(12), NUCLEO(13), 
	TREVO(14), FAZENDA(15), TRECHO(16), ESTRADA(17), SITIO(18), FEIRA(19), SETOR(20), 
	MORRO(21), RUA(22), CHACARA(23), RODOVIA(24), RESIDENCIAL(25), AVENIDA(26), 
	COLONIA(27), RECANTO(28), QUADRA(29), PRACA(30), CONDOMINIO(31), PASSARELA(32), 
	PARQUE(33), ESPLANADA(34), LAGOA(35), FAVELA(36), LADEIRA(37), LAGO(38), 
	CONJUNTO(39), JARDIM(40), ESTACAO(41), CAMPO(42), ALAMEDA(43);
    
    private final int valor;
	
}
