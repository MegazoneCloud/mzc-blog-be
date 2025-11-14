package mzc.study.blog_be.util.files;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUtils {

    public Map<String, String> uploadFile( MultipartFile file ){
        Map<String, String> result = new HashMap<>();
        
        return result;
    }

}
