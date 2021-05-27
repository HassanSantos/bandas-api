import com.cadastro.banda.demo.repository.PessoaRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class RepositoryTestConfiguration {
    @Bean
    @Primary
    public PessoaRepository pessoaRepository(){
        return Mockito.mock(PessoaRepository.class);
    }
}
