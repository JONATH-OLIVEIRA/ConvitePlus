package com.conviteplus.conviteplus.service;

import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Service;

import com.conviteplus.conviteplus.exceptions.AnfitriaoNaoEncontradoException;
import com.conviteplus.conviteplus.model.Anfitriao;
import com.conviteplus.conviteplus.repository.AnfitriaoRepository;

@Service
public class AnfitriaoService {
    private final AnfitriaoRepository anfitriaoRepository;

    public AnfitriaoService(AnfitriaoRepository anfitriaoRepository) {
        this.anfitriaoRepository = anfitriaoRepository;
    }

    public Anfitriao cadastrarAnfitriao(Anfitriao anfitriao) {
        return anfitriaoRepository.save(anfitriao);
    }

       
    public Anfitriao buscarPorId(Long id) {
        return anfitriaoRepository.findById(id)
                .orElseThrow(() -> new AnfitriaoNaoEncontradoException(id));
    }
}
