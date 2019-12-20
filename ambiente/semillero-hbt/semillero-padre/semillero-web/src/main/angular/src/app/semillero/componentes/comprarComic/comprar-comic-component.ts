import { Component, OnInit } from '@angular/core';
import { PersonaDTO } from '../../dto/persona.dto';
import { ComicDTO } from '../../dto/comic.dto';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { EjemploService } from '../../services/ejemplo.service';
import { PersonaComicDTO } from '../../dto/personaComic.dto';

/**
 * @description La clase CrearPersonaComponent permite crear personas
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
    selector: 'comprar-comic',
    templateUrl: './comprar-comic-component.html'
})
export class ComprarComicComponent implements OnInit{

    /**
     * Atributo que contiene los controles del formulario
     */
    public comprarComicForm : FormGroup;

    /**
     * Atributo que contiene la informacion de la persona
     */
    public personas: Array<PersonaDTO>;

    /**
     * Atributo que contiene la informacion del comic
     */
    public comics: Array<ComicDTO>;


    /**
     * Atributo que contiene lo que va a comprar
     */
    public personaComic: PersonaComicDTO;

    /**
     * Atributo para determinar si se realizo la compra correctamente
     */
    public comprado : any;

    /**
     * Atributo para determina si ocurrio un error al realizar la compra
     */
    public noComprado : any;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted : boolean;
    
    /**
     * @description Este es el constructor del componente ComprarComicComponent
     * @author Tulio Estrella <tulfer01@gmail.com>
     */
    constructor(private comicService: EjemploService,
    private fb : FormBuilder,
    private router : Router) {
        this.comprarComicForm = this.fb.group({
            persona : [null, Validators.required],
            comic : [null]
        });
    }
        

    /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Tulio Estrella <tulfer01@gmail.com>
     */
    
    ngOnInit(): void {
        console.log("Ingreso al al evento oninit");
        this.comicService
        .consultarComics()
        .subscribe((comics: ComicDTO[]) => {
            this.comics = comics;
        });

        this.comicService
        .consultarPersonas()
        .subscribe((personas: PersonaDTO[]) => {
            this.personas = personas;
        });
    }
        
    /**
     * @description Metodo que permite validar el formulario y crear una persona
     */
    public comprarComic() : void {
        this.submitted = true;
        if(this.comprarComicForm.invalid) {
            return;
        }
        this.personaComic = new PersonaComicDTO();
        this.personaComic.idPersona = this.comprarComicForm.controls.persona.value;
        this.personaComic.idComic = this.comprarComicForm.controls.comic.value;

        let acomprar = [this.personaComic];
        this.comicService.comprarComic(acomprar).subscribe(respuesta => {
            console.log(respuesta);
            if(respuesta.exitoso == true){
                this.comprado = true;
                this.limpiarFormulario();
            }else{
                this.noComprado = true;
            }
            setTimeout(()=> {
                //Se le asigna false a borrado para que no lo muestre.
                this.comprado = false;
                //Se le asigna false a mostrarMensaje para que no lo muestre
                this.noComprado = false;
            }, 3000);
        }); 
    }

    private limpiarFormulario() : void {
        this.submitted = false;
        this.comprarComicForm.controls.persona.setValue(null);
        this.comprarComicForm.controls.comic.setValue(null);
    }

    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Tulio Estrella
     */
    get f() { 
        return this.comprarComicForm.controls;
    }

}
