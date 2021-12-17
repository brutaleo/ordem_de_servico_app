package br.com.shift.dto;

import com.sun.xml.bind.v2.runtime.unmarshaller.Base64Data;

import java.util.Random;

public class AtualizarOrdemDeServicoDTO {

    public String convenio;

    public String gerarNumeroDeprotocolo() {

        Base64Data characters = new Base64Data();
        Random rng = new Random();
        int length = 9;

        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {

            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
}
