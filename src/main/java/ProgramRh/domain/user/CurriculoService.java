package ProgramRh.domain.Curriculo;

import ProgramRh.Dto.CurriculoDTO;
import ProgramRh.Repositorios.CurriculoRepository;
import ProgramRh.domain.curriculo.Curriculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class CurriculoService {

    @Autowired
    private CurriculoRepository curriculoRepository;

    public Curriculo salvarCurriculo(CurriculoDTO curriculoDTO, MultipartFile arquivoCurriculo) throws IOException {
        Curriculo curriculo = new Curriculo();
        curriculo.setNome(curriculoDTO.getNome());
        curriculo.setEmail(curriculoDTO.getEmail());
        curriculo.setExperiencia(curriculoDTO.getExperiencia());
        curriculo.setTelefone(curriculoDTO.getTelefone());
        curriculo.setEndereco(curriculoDTO.getEndereco());

        if (arquivoCurriculo != null && !arquivoCurriculo.isEmpty()) {
            curriculo.setFileName(arquivoCurriculo.getOriginalFilename());
            curriculo.setContentType(arquivoCurriculo.getContentType());
            curriculo.setConteudo(arquivoCurriculo.getBytes());
        }

        return curriculoRepository.save(curriculo);
    }

    public Optional<Curriculo> buscarCurriculoPorId(Long id) {
        return curriculoRepository.findById(id);
    }

    public void excluirCurriculo(Long id) {
        curriculoRepository.deleteById(id);
    }
}
