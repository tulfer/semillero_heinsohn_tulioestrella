import { Component, OnInit } from '@angular/core';
import { PersonaDTO } from '../../dto/persona.dto';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { EjemploService } from '../../services/ejemplo.service';

/**
 * @description La clase CrearPersonaComponent permite crear personas
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
    selector: 'crear-persona',
    templateUrl: './crear-persona-component.html'
})
export class CrearPersonaComponent implements OnInit{
    
    /**
     * Atributo que contiene los controles del formulario
     */
    public crearPersonaForm : FormGroup;

    /**
     * Atributo que contendra la informacion de la persona
     */
    public persona: PersonaDTO;

    public idPersona : number = 0;

    /**
     * Atributo para saber si se creo exitosamente la persona
     */
    public creado : any;

    /**
     * Atributo para determina si ocurrio un error al crear la persona
     */
    public noCreado : any;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted : boolean;

    /**
     * @description Este es el constructor del componente CrearPersonaComponent
     * @author Tulio Estrella <tulfer01@gmail.com>
     */
    constructor(private comicService: EjemploService,
        private fb : FormBuilder,
        private router : Router) {
        this.crearPersonaForm = this.fb.group({
            nombre : [null, Validators.required],
            tipoDocumento : [null],
            documento : [null],
            fechaNacimiento : [null]
        });
    }

    /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Tulio Estrella <tulfer01@gmail.com>
     */
    ngOnInit(): void {
        console.log("Ingreso al al evento oninit");
        this.persona = new PersonaDTO();
    }

    /**
     * @description Metodo que permite validar el formulario y crear una persona
     */
    public crearPersona() : void {
        this.submitted = true;
        if(this.crearPersonaForm.invalid) {
            return;
        }
        this.idPersona++;
        this.persona = new PersonaDTO();
        this.persona.nombre = this.crearPersonaForm.controls.nombre.value;
        this.persona.tipoDocumento = this.crearPersonaForm.controls.tipoDocumento.value;
        this.persona.documento = this.crearPersonaForm.controls.documento.value;
        this.persona.fechaNacimiento = this.crearPersonaForm.controls.fechaNacimiento.value;
        this.comicService.crearPersona(this.persona).subscribe(respuesta => {
            console.log(respuesta);
            if(respuesta.exitoso == true){
                this.creado = true;
                this.limpiarFormulario();
            }else{
                this.noCreado = true;
            }
            setTimeout(()=> {
                //Se le asigna false a borrado para que no lo muestre.
                this.creado = false;
                //Se le asigna false a mostrarMensaje para que no lo muestre
                this.noCreado = false;
            }, 3000);
        }); 
    }

    private limpiarFormulario() : void {
        this.submitted = false;
        this.crearPersonaForm.controls.nombre.setValue(null);
        this.crearPersonaForm.controls.tipoDocumento.setValue(null);
        this.crearPersonaForm.controls.documento.setValue(null);
        this.crearPersonaForm.controls.fechaNacimiento.setValue(null);
    }

    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Tulio Estrella
     */
    get f() { 
        return this.crearPersonaForm.controls;
    }
}