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

@Controller
public class UsuarioController {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    private static final String USUARIO = "usuario";

  @Autowired
  private UsuarioRepository repo;
    
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
    	 String nome =usuario.getName();
    	 System.out.println(nome);
//    	 Usuario usr=Usuario.builder().username(usuario.getUsername())
//    			 .passowrd(passwordEncoder().encode("123456")).build();
    	 
//    	 servico.salvar(usr);
        return "redirect:/lista-usuarios";
    }
    private List<UsuarioModel> listar(){
    	List<UsuarioModel> usuarios = new ArrayList<UsuarioModel>();
    	UsuarioModel usr1 = new UsuarioModel();
    	usr1.setName("Usuario 1");
    	usr1.setUsername("usr1");
    	usuarios.add(usr1);
    	UsuarioModel usr2 = new UsuarioModel();
    	usr2.setName("Usuario 2");
    	usr2.setUsername("usr2");
    	usuarios.add(usr2);
    	
    	return usuarios;
    }
}
