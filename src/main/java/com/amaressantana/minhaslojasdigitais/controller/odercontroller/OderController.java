package com.amaressantana.minhaslojasdigitais.controller.odercontroller;

import com.amaressantana.minhaslojasdigitais.DTOS.OderDTO;
import com.amaressantana.minhaslojasdigitais.model.Oder;
import com.amaressantana.minhaslojasdigitais.services.oderservice.OderService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oders")
public class OderController {

    private final OderService oderService;
    public OderController(OderService oderService) {
        this.oderService = oderService;
    }
    @PostMapping
    public ResponseEntity<Object> saveOder(@RequestBody @Valid OderDTO oderDTO){
        var order=new Oder();
        BeanUtils.copyProperties(oderDTO,order);
        return ResponseEntity.status(HttpStatus.CREATED).body(oderService.saveOder(order));
    }
    @GetMapping
    public ResponseEntity<Page<Oder>> findAll(Pageable pageable){
        Page<Oder> oders=oderService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(oders);
    }

}
