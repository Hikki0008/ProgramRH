package ProgramRh.Repositorios;
@Repository
public interface CurriculoRepository {import ProgramRh.domain.curriculo.Curriculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    public interface CurriculoRepository extends JpaRepository<Curriculo, Long> {
    }
}
