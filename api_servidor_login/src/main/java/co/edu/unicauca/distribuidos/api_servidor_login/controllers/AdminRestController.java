package co.edu.unicauca.distribuidos.api_servidor_login.controllers;

import co.edu.unicauca.distribuidos.api_servidor_login.services.DTO.AdminDTO;
import co.edu.unicauca.distribuidos.api_servidor_login.services.services.IAdminService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.validation.FieldError;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("admins")
public class AdminRestController {
    //INYECCION DE DEPENDENCIAS
    @Autowired
    private IAdminService adminService;

    @GetMapping("/")
    @ResponseBody
    public List<AdminDTO> findAll(){
        return this.adminService.findAll();
    }

    @GetMapping("/{usuario}")
    @ResponseBody
    public AdminDTO findById(@PathVariable String usuario){
        return adminService.findById(usuario);
    }

    @PostMapping("/")
    @ResponseBody
    public AdminDTO create(@Valid @RequestBody AdminDTO cliente){
        return this.adminService.save(cliente);
    }

    @PutMapping("/{usuario}")
    @ResponseBody
    public AdminDTO update(@RequestBody AdminDTO cliente, @PathVariable String usuario){
        AdminDTO objAdmin = null;
        AdminDTO adminActual = this.adminService.findById(usuario);
        if(adminActual != null){
            objAdmin = this.adminService.update(usuario,cliente);
        }
        return objAdmin;
    }

    @DeleteMapping("/{usuario}")
    @ResponseBody
    public boolean delete (@PathVariable String usuario){
        boolean flag = false;
        AdminDTO adminActual = this.adminService.findById(usuario);
        if(adminActual != null){
            flag = this.adminService.delete(usuario);
        }
        return flag;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		return errors;
	}
}
