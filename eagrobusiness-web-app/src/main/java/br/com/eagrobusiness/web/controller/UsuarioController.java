package br.com.eagrobusiness.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.eagrobusiness.web.dao.repository.UsuarioRepository;
//import br.com.eagrobusiness.infra.lib.model.usuario.Usuario;
import br.com.eagrobusiness.web.model.UsuarioModel;
import br.com.eagrobusiness.web.service.UsuarioService;

@Controller
public class UsuarioController {


    private static final String USUARIO = "usuario";
 
  @Autowired
  private UsuarioService servico;
    
	@GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
    	ModelAndView mv=new ModelAndView(USUARIO);//nome da view que será retornada
    	mv.addObject(USUARIO, new UsuarioModel());//objeto que será usado na view
        return mv;
    }
    @GetMapping("/lista-usuarios")
    public ModelAndView listarUsuarios() {
    	ModelAndView mv=new ModelAndView("lista-usuarios");
    	mv.addObject("listaUsuarios", listar());
        return mv;
    }
    @PostMapping("/salvar")
    public String salvar(UsuarioModel usuario) {
     	 
    	 servico.salvar(usuario);
        return "redirect:/lista-usuarios";
    }
    private List<UsuarioModel> listar(){     	
    	return servico.listarTodos();
    }
}
