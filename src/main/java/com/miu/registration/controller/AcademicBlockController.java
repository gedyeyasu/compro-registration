package com.miu.registration.controller;


import com.miu.registration.exception.NotFoundException;
import com.miu.registration.service.IAcademicBlockService;
import com.miu.registration.service.DTO.AcademicBlockDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/academic-blocks")
public class AcademicBlockController {

    private final IAcademicBlockService academicBlockService;

    @GetMapping
    public ResponseEntity<?> displayAcademicBlock(){

        Collection<AcademicBlockDTO> academicBlockDTO = academicBlockService.getAll();
        return new ResponseEntity<>(academicBlockDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> displayAcademicBlockById(@PathVariable("id") long id){
        AcademicBlockDTO academicBlockDTO = academicBlockService.getAcademicBlock(id);
        if(academicBlockDTO ==null){
            return new ResponseEntity<NotFoundException>(new NotFoundException("Academic Block with " +
                    "Id= "+id+" not found."),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(academicBlockDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveAcademicBlock(@RequestBody AcademicBlockDTO academicBlockDTO){
        academicBlockService.create(academicBlockDTO);
        return new ResponseEntity<AcademicBlockDTO>(academicBlockDTO,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<?> deleteAcademicBlock(@PathVariable("id") long id){

       AcademicBlockDTO academicBlockDTO = academicBlockService.getAcademicBlock(id);
       if(academicBlockDTO ==null){
           return new ResponseEntity<NotFoundException>(new NotFoundException("Academic Block with " +
                   "Id= "+id+" not found."),HttpStatus.NOT_FOUND);
       }

       academicBlockService.delete(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAcademicBlock(@PathVariable("id")long id,@RequestBody AcademicBlockDTO academicBlockDTO){
        academicBlockService.update(id,academicBlockDTO);
        return new ResponseEntity<>( HttpStatus.OK);
    }


}
