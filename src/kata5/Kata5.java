package kata5;

import java.io.IOException;
import java.util.List;
import static kata5.CrearTabla.createNewTable;

public class Kata5 {

    public static void main(String[] args) throws IOException {
        SelectApp app = new SelectApp();
        //app.selectAll();
        createNewTable();

        String ruta = "email.txt";
        List<String> emails = MailListReader.read(ruta);

        InsertarDatosTabla idt = new InsertarDatosTabla();
        for (String email : emails) {
            idt.insert(email);
        }

    }

}
