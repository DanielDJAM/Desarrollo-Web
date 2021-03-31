package es.iespuertolacruz.daniel;

import java.util.ArrayList;

import es.iespuertolacruz.daniel.Exception.AlumnoException;
import es.iespuertolacruz.daniel.Exception.AulaException;
import es.iespuertolacruz.daniel.Exception.NotaException;
import es.iespuertolacruz.daniel.Exception.ProfesorException;

public class Gestion {

    ArrayList<Alumno> gestionAlumnos;
    ArrayList<Profesor> gestionProfesores;
    ArrayList<Nota> gestionNotas;
    ArrayList<Aula> gestionAulas;

    public Gestion() {
        if (gestionAlumnos == null){
            gestionAlumnos = new ArrayList<>();
        }
        if (gestionProfesores == null) {
            gestionProfesores = new ArrayList<>();
        }
        if (gestionNotas == null) {
            gestionNotas = new ArrayList<>();
        }
        if (gestionAulas == null) {
            gestionAulas = new ArrayList<>();
        }
    }

    /**
     * Getters de todos los ArrayLists
     */

    public ArrayList<Alumno> getGestionAlumnos() {
        return this.gestionAlumnos;
    }

    public ArrayList<Profesor> getGestionProfesores() {
        return this.gestionProfesores;
    }

    public ArrayList<Nota> getGestionNotas() {
        return this.gestionNotas;
    }

    public ArrayList<Aula> getGestionAulas() {
        return this.gestionAulas;
    }

    /**
     * ------------------ INSERTAR ------------------
     */

    /**
     * Metodo para insertar en la lista gestionAlumnos
     * 
     * @param alumno objeto a insertar
     * @throws AlumnoException envia el error a dicha clase
     */

    public void insertar(Alumno alumno) throws AlumnoException {
        if (!existe(alumno)) {
            gestionAlumnos.add(alumno);
        } else {
            throw new AlumnoException("El alumno ya existe en la lista gestionAlumnos");
        }
    }

    /**
     * Metodo para insertar en la lista gestionProfesores
     * 
     * @param profesor objeto a insertar
     * @throws ProfesorException envia el error a dicha clase
     */

    public void insertar(Profesor profesor) throws ProfesorException {
        if (!existe(profesor)) {
            gestionProfesores.add(profesor);
        } else {
            throw new ProfesorException("El profesor ya existe en la lista gestionProfesores");
        }
    }

    /**
     * Metodo para insertar en la lista gestionNotas
     * 
     * @param nota objeto a insertar
     * @throws NotaException envia el error a dicha clase
     */

    public void insertar(Nota nota) throws NotaException {
        if (!existe(nota)) {
            gestionNotas.add(nota);
        } else {
            throw new NotaException("La nota ya existe en la lista gestionNotas");
        }
    }

    /**
     * Metodo para insertar en la lista gestionAulas
     * 
     * @param aula objeto a insertar
     * @throws AulaException envia el error a dicha clase
     */

    public void insertar(Aula aula) throws AulaException {
        if (!existe(aula)) {
            gestionAulas.add(aula);
        } else {
            throw new AulaException("El aula ya existe en la lista gestionAulas");
        }
    }

    /**
     * ------------------ ELIMINAR ------------------
     */

    /**
     * Metodo para eliminar de la lista gestionAlumnos.
     * 
     * @param alumno objeto a eliminar.
     * @throws AlumnoException
     */

    public void eliminar(Alumno alumno) throws AlumnoException {
        if (existe(alumno)) {
            gestionAlumnos.remove(alumno);
        } else {
            throw new AlumnoException("El alumno no existe en la lista gestionAlumnos");
        }
    }

    /**
     * Metodo para eliminar de la lista gestionProfesores.
     * 
     * @param profesor objeto a eliminar.
     * @throws ProfesorException
     */

    public void eliminar(Profesor profesor) throws ProfesorException {
        if (existe(profesor)) {
            gestionProfesores.remove(profesor);
        } else {
            throw new ProfesorException("El profesor no existe en la lista gestionProfesores");
        }
    }

    /**
     * Metodo para eliminar de la lista gestionNotas.
     * 
     * @param nota objeto a eliminar.
     * @throws NotaException
     */

    public void eliminar(Nota nota) throws NotaException {
        if (existe(nota)) {
            gestionNotas.remove(nota);
        }else {
            throw new NotaException("La nota no existe en la lista gestionNotas");
        }
    }

    /**
     * Metodo para eliminar de la lista gestionAulas.
     * 
     * @param aula objeto a eliminar.
     * @throws AulaException
     */

    public void eliminar(Aula aula) throws AulaException {
        if (existe(aula)) {
            gestionAulas.remove(aula);
        }else {
            throw new AulaException("El aula no existe en la lista gestionAulas");
        }
    }

    /**
     * ------------------ EXISTE ------------------
     */

    /**
     * Funcion para comprobar si un alumno existe en la lista gestionAlumnos
     * 
     * @param alumno objeto a comprobar
     * @return True/false.
     */

    public boolean existe(Alumno alumno) {
        return gestionAlumnos.contains(alumno);
    }

    /**
     * Funcion para comprobar si un profespr existe en la lista gestionProfesores
     * 
     * @param profesor objeto a comprobar
     * @return True/false.
     */

    public boolean existe(Profesor profesor) {
        return gestionProfesores.contains(profesor);
    }

    /**
     * Funcion para comprobar si un nota existe en la lista gestionNotas
     * 
     * @param nota objeto a comprobar
     * @return True/false.
     */

    public boolean existe(Nota nota) {
        return gestionNotas.contains(nota);
    }

    /**
     * Funcion para comprobar si un aula existe en la lista gestionAulas
     * 
     * @param aula objeto a comprobar
     * @return True/false.
     */

    public boolean existe(Aula aula) {
        return gestionAulas.contains(aula);
    }

    /**
     * -----------------------------------BUSCAR------------------------
     */

    /**
     * Funcion para buscar las notas de un alumno por dni
     * 
     * @param dni elemento de busqueda
     * @return retorna la nota del alumno
     */

    public String buscarNota(String dni) {
        String notaAlumno = null;
        boolean encontrado = false;
        int i = 0;

        while (i < gestionAlumnos.size() && !encontrado) {
            Alumno alumno = gestionAlumnos.get(i);
            if (alumno.getDni().equals(dni)) {
                notaAlumno = alumno.getNota().toString();
                encontrado = true;
            }
            i++;
        }
        return notaAlumno;
    }

  




}
