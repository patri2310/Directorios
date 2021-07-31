package test.commad;

import com.despegar.command.CommandLs;
import com.despegar.tree.Dir;
import com.despegar.tree.TreeFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CommandLsTest {

    public static final Dir TREE_FACTORY = new TreeFactory().factory();

    @InjectMocks
    CommandLs commandLs;

    @Test
    public void directory_list() throws IOException {
        String allWrittenLines = getString(TREE_FACTORY, null);
        assertEquals("file-1 - 1\n" +
                "file-2 - 1\n" +
                "file-3 - 1\n" +
                "file-4 - 1\n", allWrittenLines);
    }

    @Test
    public void directory_listAll() throws IOException {
        String allWrittenLines = getString(TREE_FACTORY, "-r");
        assertEquals("file-1 - 1\n" +
                "file-2 - 1\n" +
                "file-3 - 1\n" +
                "file-4 - 1\n" +
                "directorio: patricia\n" +
                "directorio: downloads\n" +
                "download1 - 1\n" +
                "download2 - 2\n" +
                "download3 - 3\n" +
                "download4 - 4\n" +
                "download5 - 5\n" +
                "directorio: images\n" +
                "image-1 - 1\n" +
                "image-2 - 2\n" +
                "image-3 - 3\n" +
                "image-4 - 4\n" +
                "image-5 - 5\n" +
                "directorio: despegar\n" +
                "sensitive.conf - 100\n", allWrittenLines);
    }

    private String getString(Dir dir, String parameter) throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
        commandLs.execute(dir, parameter);
        bo.flush();
        return bo.toString();
    }


}
