package com.moisesflima.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.moisesflima.websocket.dto.Mensagem;
import com.moisesflima.websocket.dto.MensagemProcessada;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ChatController {

    @MessageMapping("/chat") // binding/ligação com o broker definido na classe de config
    @SendTo("/topico/mensagens") // define local para envio da mensagem processada
    public MensagemProcessada send(final Mensagem mensagem) throws Exception {

    	/*
    	 * Implementação da regra de negócio que será processada no servidor
    	 * e retornada para os clientes através do tópico
    	 */
    	
    	// em nosso exemplo temos apenas uma adição do timestamp na mensagem
        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new MensagemProcessada(mensagem.getOrigem(), mensagem.getTexto(), time);
        
    }

}
