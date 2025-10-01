package testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.hamcrest.MatcherAssert.assertThat;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;

import configuracao.ConfiguracaoApi;
import io.qameta.allure.*;
import modelo.Usuario;



@Epic("API REQRES.IN")
@Feature("CRUD USUARIO")
@TestMethodOrder(OrderAnnotation.class)
public class UsuarioTest extends ConfiguracaoApi  {
    
	@Test
	@Order(1)
	@DisplayName("1 - Consultar o usuario pelo id cadastrado")	
	@Story("1 - Consultar o usuario pelo id cadastrado")
    public void consultarUsuarioCadastradoComIdValido() {   	       	    	
    
		Usuario usr = servUsuario.obterUsuarioId("2");	
		assertThat( usr.getFirst_name(),is ("Janet"));
    	
    }
    
	@Test	
	@Order(2)
    @DisplayName("2 - Consultar quantidade de usuario existente em uma pagina")
	@Story("2 - Consultar quantidade de usuario existente em uma pagina")
    public void consultarUsuariosPorPaginas() {
   
    List <Usuario> usr = servUsuario.obterUsuariosPagina("2");	
    	
     	
    assertThat(usr.size(), is(6));
    
    	
    }
    
	@Test	
	@Order(3)
    @DisplayName("3 - Consultar ID inexistente")
	@Story("3 - Consultar ID inexistente")
    public void consultarUsuarioinvalido() {
    	       	    	
		servUsuario.consultarIdInexistente("9999999999999999999");  	
         	
           	
    }
    
	@Test	
	@Order(4)
    @DisplayName("4 - Incluir novo usuario")
	@Story("4 - Incluir novo usuario")
    public void criarUsuario() {    	 
    
		servUsuario.cadastrarUsuario(usuarioTeste.usuarioValido());
    	
    }
    
	@Test
	@Order(5)
    @DisplayName("5 - Alterar o nome de um usuario")
	@Story("5 - Alterar o nome de um usuario")
    public void alterarUsuario() {     		
     	
		servUsuario.alterarUsuario(servUsuario.obterUsuario(),"TESTE NOVO");
    
    
    }
        
	@Test
	@Order(6)
    @DisplayName("6 - Deletar um usuario")
	@Story("6 - Deletar um usuario")
    public void deletarUsuario() {
	
		servUsuario.deletarUsuario(servUsuario.obterUsuario());   
	   
	   
   }
   
   
    
    
}