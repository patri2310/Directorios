package test.commad;

import com.despegar.command.Ls;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CommandLsTest {


    @Test
    public void directory_list() throws IOException {

        Ls commandLs1 = new Ls("ls", Optional.empty(), "/");
        String allWrittenLines = getString(commandLs1);
        assertEquals("directorio: patricia\n" +
                "directorio: despegar\n" +
                "archivo: file-1 - 1\n" +
                "archivo: file-2 - 1\n" +
                "archivo: file-3 - 1\n" +
                "archivo: file-4 - 1\n", allWrittenLines);
    }

    @Test
    public void directory_listAll() throws IOException {
        Ls commandLs2 = new Ls("ls", Optional.of("-r"), "/");
        String allWrittenLines = getString(commandLs2);
        assertEquals("archivo: file-1 - 1\n" +
                "archivo: file-2 - 1\n" +
                "archivo: file-3 - 1\n" +
                "archivo: file-4 - 1\n" +
                "directorio: patricia\n" +
                "directorio: downloads\n" +
                "archivo: download1 - 1\n" +
                "archivo: download2 - 2\n" +
                "archivo: download3 - 3\n" +
                "archivo: download4 - 4\n" +
                "archivo: download5 - 5\n" +
                "directorio: images\n" +
                "archivo: image-1 - 1\n" +
                "archivo: image-2 - 2\n" +
                "archivo: image-3 - 3\n" +
                "archivo: image-4 - 4\n" +
                "archivo: image-5 - 5\n" +
                "directorio: despegar\n" +
                "archivo: sensitive.conf - 100\n", allWrittenLines);
    }

    private String getString(Ls commandLs) throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
        commandLs.execute();
        bo.flush();
        return bo.toString();
    }


}
