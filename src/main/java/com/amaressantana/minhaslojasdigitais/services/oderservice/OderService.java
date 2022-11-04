package com.amaressantana.minhaslojasdigitais.services.oderservice;

import com.amaressantana.minhaslojasdigitais.model.Oder;
import com.amaressantana.minhaslojasdigitais.repositorys.OderRepositoey;
import com.amaressantana.minhaslojasdigitais.services.exeptions.EntityNotFoundExcepion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;

@Service
@Transactional
public class OderService {

    private final OderRepositoey oderRepositoey;
    public OderService(OderRepositoey oderRepositoey) {
        this.oderRepositoey = oderRepositoey;
    }
    public Oder saveOder(Oder oder){
        oder.setDataCriacao(Instant.now());
        return oderRepositoey.saveAndFlush(oder);
    }
    public Oder findById(Long id){
        Optional<Oder> oder=oderRepositoey.findById(id);
        return oder.orElseThrow(
                ()->new EntityNotFoundExcepion("id "+ id + " not found"));
    }
    public Page<Oder> findAll(Pageable pageable){
        Page<Oder> oders=oderRepositoey.findAll(pageable);
        return oders;
    }
    public Oder atualizarOder(Long id,Oder oder){
        findById(id);
        oder.setId(id);
        oder.setDataAtualizacao(Instant.now());
        return oderRepositoey.saveAndFlush(oder);
    }
    public void deletarOder(Long id){
        findById(id);
        oderRepositoey.deleteById(id);
    }
}
