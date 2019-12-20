import { Component, OnInit, Injector } from '@angular/core';
import { ComicDTO } from '../../dto/comic.dto';
import { EjemploService } from '../../services/ejemplo.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

/**
 * @description Componente que muestra una lista de objetos comic (taller 2)
 * 
 * @author Tulio Estrella <tulfer01@gmail.com>
 */
@Component({
    selector: 'listar-comic',
    templateUrl: './lista-comic-component.html'
})
export class ListaComicComponent implements OnInit {

    /**
     * Atributo que contendrá todos los comics de tipo comicDTO 
     */
    public listaComic : Array<ComicDTO>;
  
    /**
     * Atributo para saber que comic se borrará
     */
    public borrado : any;

    /**
     * Atributo que define si se muestra o no un mensaje
     */
    public mostrarMensaje : boolean;

    public injector : Injector;
    public http : HttpClient;
    /**
     * Constructor de la clase
     */
    constructor(private comicService: EjemploService) {
        console.log("entro al constructor del componente lista comic");
    }

    /**
     * Evento angular que se ejecuta al iniciar el componente
     */
    ngOnInit(): void {
        this.comicService
        .consultarComics()
        .subscribe((comics: ComicDTO[]) => {

            this.listaComic = comics;

        });
        
        // this.listaComic = [
        //     {
        //         id :  "1",
        //         nombre :  "SpiderMan",
        //         editorial :  "Marvel",
        //         tematica :  "Super Heroe",
        //         numeroPaginas :  25,
        //         precio :  15.200,
        //         autores :  "StanLee",
        //         color :  true,
        //         fechaVenta :  new Date("1993-02-23"),
        //         estado :  "ACTIVO",
        //         imagen : "spiderman.jpg"
        //     },
        //     {
        //         id :  "2",
        //         nombre :  "SuperMan",
        //         editorial :  "DC Comics",
        //         tematica :  "Super Heroe",
        //         numeroPaginas :  32,
        //         precio :  11.300,
        //         autores :  "DC Comic",
        //         color :  true,
        //         fechaVenta :   new Date("1991-06-12"),
        //         estado :  "ACTIVO",
        //         imagen : "superman.jpg"
        //     },
        //     {
        //         id :  "3",
        //         nombre :  "Batman",
        //         editorial :  "DC Comics",
        //         tematica :  "Super Heroe",
        //         numeroPaginas :  20,
        //         precio :  10.500,
        //         autores :  "DC Comic",
        //         color :  true,
        //         fechaVenta :   new Date("1998-04-15"),
        //         estado :  "ACTIVO",
        //         imagen : "batman.jpg"
        //     },
        //     {
        //         id :  "4",
        //         nombre :  "Hulk",
        //         editorial :  "Marvel",
        //         tematica :  "Super Heroe",
        //         numeroPaginas :  15,
        //         precio :  9.600,
        //         autores :  "StanLee",
        //         color :  true,
        //         fechaVenta :   new Date("1992-04-12"),
        //         estado :  "ACTIVO",
        //         imagen : "hulk.jpg"
        //     },
        //     {
        //         id :  "5",
        //         nombre :  "IronMan",
        //         editorial :  "Marvel",
        //         tematica :  "Super Heroe",
        //         numeroPaginas :  32,
        //         precio :  16.100,
        //         autores :  "StanLee",
        //         color :  true,
        //         fechaVenta :   new Date("2008-01-20"),
        //         estado :  "ACTIVO",
        //         imagen : "ironman.jpg"
        //     }
        // ]
        
    }

    /**
     * Metodo encargado de eliminar un comic, teniendo en cuenta la posicion del comic.
     * @param idComic Valor que indica el id del comic que se desea eliminar de la lista.
     */
    deleteComic(idComic : any){

        this.borrado = this.listaComic[idComic];

        //Se obtiene el comic deseado(pasado por parametro) de la lista de los comics
        this.listaComic = this.listaComic.filter((value,i) => i !== idComic);
        //Se da el valor a mostrarMensaje para saber si existe o no el comic que se desea borrar
        this.mostrarMensaje = !this.borrado;

        //Se ejecuta lo que esta dentro de las llaves luego de pasado 5000 milisegundos
        setTimeout(()=> {
            //Se le asigna false a borrado para que no lo muestre.
            this.borrado = false;
            //Se le asigna false a mostrarMensaje para que no lo muestre
            this.mostrarMensaje = false;
        }, 3000);
    }

}