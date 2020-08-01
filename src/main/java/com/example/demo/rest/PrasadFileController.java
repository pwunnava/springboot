package com.example.demo.rest;


import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Address;
import com.example.demo.model.PrasadRequest;
import com.example.demo.model.ResponseObject;
import com.example.demo.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class PrasadFileController {
	
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/callAWSLambda")
	public String callAWSLambda()
	{
	
		String jsonString="";
		String url="https://pt9g4jp7wb.execute-api.us-east-2.amazonaws.com/prod/getOrder";
		PrasadRequest objRequest = new PrasadRequest();
		objRequest.setMessage("Sending Message to Prasad");
	
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		
		
		String str="{firstName:'prasad wunnava',lastName:'wunna'}";
		ResponseEntity<User> objResponse = null;
		try {
			System.out.println("ABOUT THE SENDING THE Response");
			jsonString = mapper.writeValueAsString(objRequest);
			HttpHeaders headers = new HttpHeaders();
			 headers.set("X-API-KEY", "OD02gaxX7WaxaGUMIiN767E9OVkVejOh8jzuzkBu");  
			//headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<PrasadRequest> httprequest = new HttpEntity<PrasadRequest>(objRequest,headers);
		     objResponse= this.restTemplate.exchange(url, HttpMethod.POST,httprequest,User.class);  
			//(objResponse != null) {
			System.out.println("Successfuly created createClientSession");
			User usr=objResponse.getBody();
			System.out.println("yyyyyy:->" + usr.getFirstname());
			 List<Address> lst=usr.getAddress();
			 
			 for( Address adr : lst)
			 {
				 System.out.println("The address is:-> " + adr.getStreet() + ", " +adr.getCity() + ", " + adr.getZip());
				 
			 }
			//}
			} catch (Exception e) {
				System.out.println("Error Occured..." + e.getMessage());
				str="Erro occured";
			}
		
		return str;
	}
	
	@PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String fileType=file.getContentType();
        
       long fileSize= file.getSize();
       
       System.out.println("File Name is:->" + fileName);
       System.out.println("File Size is:->" + fileSize);
       System.out.println("File Type is:->" + fileType);
       
       //You can store the file in a directory, 
       
       
     //The following will save the file in a Folder in the Server...       
       
       File convFile = new File("c:\\SaveFileInServer\\" + file.getOriginalFilename());
       try
       {
      	convFile.createNewFile();
      	FileOutputStream fos = new FileOutputStream(convFile);
      	fos.write(file.getBytes());
      	fos.close();
       }
       catch(Exception e)
       {
       	
       }     
       
       
//End of saving the files in the folder, under a server...       
       
       
       
       //you also store the file in database...
       
       
       //you can also store the file in AWS S3.

       String str="File uploaded Sucessfully!";
       return str;
    }
	
	 
	
	@RequestMapping(value = "/sendRequestParamsToREST", produces = {"application/json"}, method = RequestMethod.POST)
	public ResponseEntity<ResponseObject> SaveData(@RequestParam String rollNo, @RequestParam String name, @RequestParam String address) {
	   
	System.out.println("RollNo is:->" + rollNo);
	System.out.println("Name is:->" + name);
	System.out.println("Address is:->" + address);	
	
	String str="Data saved sucessfully....";
	
	ResponseObject rsp=new ResponseObject();
	rsp.setStatus(str);
	  return ResponseEntity.status(HttpStatus.OK).body(rsp);
	}

	
    @PostMapping("/uploadMultipleFiles")
    public ResponseEntity<ResponseObject> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
       
    	String str="";
    	 String fileName = "";    	
         String fileType="";
         long fileSize=0; 
       
    	
    	for(MultipartFile file: files)
    	{
    		 fileName=file.getOriginalFilename();
    		 fileSize=file.getSize();
    		 fileType=file.getContentType();
    		 
    		 System.out.println("The file name is:->" + fileName);
    		    System.out.println("File Size is:->" + fileSize);
    	        System.out.println("File Type is:->" + fileType);
    	        
    	 //The following will save the file in a Folder in the Server...       
    	        
    	        File convFile = new File("c:\\SaveFileInServer\\" + file.getOriginalFilename());
    	        try
    	        {
    	       	convFile.createNewFile();
    	       	FileOutputStream fos = new FileOutputStream(convFile);
    	       	fos.write(file.getBytes());
    	       	fos.close();
    	        }
    	        catch(Exception e)
    	        {
    	        	
    	        }     
    	        
    	        
    	 //End of saving the files in the folder, under a server...       
    	        
    	}
    	ResponseObject rsp=new ResponseObject();
    	rsp.setStatus(str);
    	  return ResponseEntity.status(HttpStatus.OK).body(rsp);
    	  
    }
    

	
	@RequestMapping(value = "/sendPathVariablesToREST/{rollNo}/{name}/{address}", produces = {"application/json"}, method = RequestMethod.POST)
	public ResponseEntity<ResponseObject> SendPathVariablesToRest(@PathVariable String rollNo, @PathVariable String name, @PathVariable String address) {
	   
	System.out.println("The RollNo recived is:->" + rollNo);
	System.out.println("Name is:->" + name);
	System.out.println("Address is:->" + address);	
	
	String str="Data saved sucessfully....";
	
	ResponseObject rsp=new ResponseObject();
	rsp.setStatus(str);
	  return ResponseEntity.status(HttpStatus.OK).body(rsp);
	}

}
