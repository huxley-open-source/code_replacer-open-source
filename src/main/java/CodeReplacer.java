import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by rodrigo on 18/07/15.
 */
public class CodeReplacer {

    public static final Charset CHARSET = StandardCharsets.UTF_8;

    static String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }


    public static void main(String args[]) throws IOException {
        final String baseDir = System.getProperty("user.home") + "/dev/code_template/src/main/java/";
        final String suffix = ".user";

        String codeTemplate = readFile(baseDir + "template1.c", CHARSET);

        String inputFiles[] = {"code1"};

        ArrayList<String> userInput;

        String from[] = new String[inputFiles.length + 2];
        String to[] = new String[inputFiles.length + 2];
        // remover ${begin_visible} e ${end_visible}, por isso que o array acima tem o +2 no tamanho

        from[0] = "${begin_visible}";
        to[0] = "";
        from[1] = "${end_visible}";
        to[1] = "";

        int i=2;

        for (String fileName : inputFiles) {
            String varName = fileName;
            from[i] = "${"+varName+"}";

            fileName = baseDir+ fileName + suffix;
            String userCode = readFile(fileName, CHARSET);

            to[i] = userCode;
            i++;
        }


        //TODO: teremos problemas com linguagens que precisam de identação: Python
        codeTemplate = StringUtils.replaceEach(codeTemplate, from, to);
        System.out.println(codeTemplate);

    }
}
