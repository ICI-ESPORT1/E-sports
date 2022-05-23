package Modelo.Encriptar;
/**
 * @Author Inigo Bruk
 * @Version 1.0
 */
public class encriptacion {
    public encriptacion() {

    }

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

