import { Component, OnInit } from '@angular/core';

/**
 * @description Componente direccion, muestra nombre y direccion de contacto (taller 1)
 * 
 * @author Tulio Estrella <tulfer01@gmail.com>
 */
@Component({
  selector: 'mensaje-direccion',
  templateUrl: './mensaje-direccion-component.html',
})
export class MensajeDireccionComponent implements OnInit {
  
  public nombre : string;
  public direccion : string;
  
  /**
   * Constructor de la clase
   */
  constructor() {
    console.log("entro al constructor del componente mensaje direccion");
  }

  /**
   * Evento angular que se ejecuta al iniciar el componente
   */
  ngOnInit(): void {
    this.nombre = "Tulio Estrella";
    this.direccion = "Monteria";
    
  }

}