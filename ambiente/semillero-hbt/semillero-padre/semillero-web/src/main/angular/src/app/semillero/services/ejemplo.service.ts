import { Injectable } from '@angular/core';
import { Injector } from "@angular/core";
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { AbstractService } from './template.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ComicDTO } from '../dto/comic.dto';
import { PersonaDTO } from '../dto/persona.dto';
import { PersonaComicDTO } from '../dto/personaComic.dto';

/**
 * Servicio encargado de llamar a los servicios REST de
 * ejemplo
 */
@Injectable({
  providedIn: 'root'
})
export class EjemploService extends AbstractService {

  /**
   * Constructor
   */
  constructor(injector: Injector, private httpClient : HttpClient) {
    super(injector);
  }

  
  public consultarComics(): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarComic/consultarComics');
  } 

 /**
   * @author Tulio Estrella
   * @description Consume el servicio de consultarPersonas
   */
  public consultarPersonas(): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarPersonas/consultarPersonas');
  }

  public crearComic(comicDTO : ComicDTO): Observable<any> {
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarComic/crear',comicDTO);
  }

  /**
   * @author Tulio Estrella
   * @param personaDTO
   * @description Consume el servicio de crear personta
   */
  public crearPersona(personaDTO : PersonaDTO): Observable<any> {
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarPersonas/create',personaDTO);
  }

  /**
   * @author Tulio Estrella
   * @param compra
   * @description Consume el servicio de comprar comics
   */
  public comprarComic(compra : Array<PersonaComicDTO>): Observable<any> {
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarComic/comprar',compra);
  }
}
