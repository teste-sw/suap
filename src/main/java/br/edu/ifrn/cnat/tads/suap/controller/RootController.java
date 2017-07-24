package br.edu.ifrn.cnat.tads.suap.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RootController {

    private ApiInfo info;

    public RootController() {
        this.info = new ApiInfo("suap", "online");
    }

    @RequestMapping(
    		value="/", 
    		produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody ApiInfo root() {

        return this.info;
    }

}

class ApiInfo {
	String name;
	String status;
	
	public ApiInfo(String name, String status) {
		this.name = name;
		this.status = status;
	}
	public String getName() {
		return name;
	}
//	public void setName(String name) {
//		this.name = name;
//	}
	public String getStatus() {
		return status;
	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
}
