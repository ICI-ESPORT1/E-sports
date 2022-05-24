package Modelo.Encriptar;
/**
 * Funcion para el encriptado de contraseña
 */
public class encriptacion {
    public encriptacion() {

    }

    /**
     * Funcion para encriptar la contraseña.
     * @param arg
     * @return
     */
    public String encriptar(String arg) {

        String mensaje = arg;
        char array[] = mensaje.toCharArray();

        for (int i=0; i< array.length;i++){

            array[i] = (char)(array[i] + (char)10);

        }
        String encriptado = String.valueOf(array);
        System.out.println(encriptado);
        return encriptado;
    }

    /*public String desencriptar(String arg) {
        char arrayD[] = arg.toCharArray();
        for (int i =0;i <arrayD.length; i++){
            arrayD[i] =(char)(arrayD[i]-(char)10);
        }
        String desencriptado = String.valueOf(arrayD);
        System.out.println(desencriptado);
        return desencriptado;*/
    }

