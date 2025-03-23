package ProgramRh.Controllers;

import ProgramRh.domain.Curriculo.Curriculo;

import java.util.Optional;

public class CurriculoController {
    import ProgramRh.Dto.CurriculoDTO;
import ProgramRh.Servicos.CurriculoService;
import ProgramRh.domain.curriculo.Curriculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

    @RestController
    @RequestMapping("/curriculos")
    public class CurriculoController {

        @Autowired
        private CurriculoService curriculoService;

        @PostMapping("/upload")
        public ResponseEntity<?> uploadCurriculo(@RequestPart("curriculo") CurriculoDTO curriculoDTO,
                                                 @RequestPart("arquivo") MultipartFile arquivoCurriculo) throws IOException {
            Curriculo curriculoSalvo = curriculoService.salvarCurriculo(curriculoDTO, arquivoCurriculo);
            return ResponseEntity.ok(curriculoSalvo);
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> buscarCurriculo(@PathVariable Long id) {
            Optional<Curriculo> curriculo = curriculoService.buscarCurriculoPorId(id);
            if (curriculo.isPresent()) {
                return ResponseEntity.ok(curriculo.get());
            }
            return ResponseEntity.notFound().build();
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> excluirCurriculo(@PathVariable Long id) {
            curriculoService.excluirCurriculo(id);
            return ResponseEntity.noContent().build();
        }
    }
}
