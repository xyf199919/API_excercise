package hello;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PostController {
	
	private List<String> posts = new ArrayList<>();
    
    
    @RequestMapping(value = "/",
			method = RequestMethod.POST,
			consumes = MediaType.MULTIPART_FORM_DATA_VALUE)

	public ResponseEntity<Object> fileUpload(@RequestParam(required=false, value="file") MultipartFile file, 
			@RequestParam(required=false, value="post") String str) throws IOException
	{
    	if (file != null) {
    		new File("./upload-dir").mkdir();
        	File convertFile = new File("./upload-dir/" + file.getOriginalFilename());
    		convertFile.createNewFile();
    		FileOutputStream fout = new FileOutputStream(convertFile);
    		fout.write(file.getBytes());
    		fout.close();
    		return new ResponseEntity<>("File has uploaded successfully", HttpStatus.OK);
    	} else if (str != null) {
    		posts.add(str);
    		return new ResponseEntity<>("Post uploaded successfully", HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>("nothing to upload", HttpStatus.OK);
    	}
	}

    
//
//    @RequestMapping("/greeting")
//    public Post greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        return new Post(counter.incrementAndGet(),
//                            String.format(template, name));
//    }
     
    @RequestMapping("/")
    public List<String> getAllPosts() {
    	return posts;
    }
//    
//    @RequestMapping(method=RequestMethod.POST, value="/posts")
//    public void addPost(@RequestBody Post post) {
//    	posts.add(post);
//    }
    
    
    
}