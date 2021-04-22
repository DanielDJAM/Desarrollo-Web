package es.iespuertolacruz.daniel;

import java.util.ArrayList;

public class GestionAlumnos {

    ArrayList<Alumno> alumnos;
    Alumno alumno;

    public GestionAlumnos(){
        alumnos = new ArrayList<>();
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void insertar(Alumno alumno){
        alumnos.add(alumno);
    }

    public void eliminar(Alumno alumno){
        alumnos.remove(alumno);
    }

    //Evalua la nota, no el estado

    public String contarAprobadosSuspendidos(Alumno alumno){
        int i = 0;
        int aprobados = 0;
        int suspendidos = 0;
        while (i <= alumnos.size()){
            if(alumno.isEstado()==true){
                aprobados += 1;
            }else{
                suspendidos +=1;
            }
            i++;
        }
        return "Aprobados: " + aprobados + "Suspendidos: " + suspendidos;
    }

    
}
