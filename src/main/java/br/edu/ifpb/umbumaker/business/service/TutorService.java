package br.edu.ifpb.umbumaker.business.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.umbumaker.model.Tutor;
import br.edu.ifpb.umbumaker.model.repository.ContaAcessoRepository;
import br.edu.ifpb.umbumaker.model.repository.TutorRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TutorService {
	
	@Autowired
	private ContaAcessoRepository contaAcessoRepository;

	@Autowired
	private TutorRepository tutorRepository;

	public Tutor criarTutor(Tutor tutor) {
		//salvando conta acesso
		contaAcessoRepository.save(tutor.getContaAcesso());
		
		return tutorRepository.save(tutor);
	}

	public Tutor atualizarTutor(Long id, Tutor tutor) {
		Tutor tutorExitente = tutorRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Tutor não encontrado."));

		tutorExitente.getContaAcesso().setNome(tutor.getContaAcesso().getNome());
		tutorExitente.getContaAcesso().setEmail(tutor.getContaAcesso().getEmail());
		tutorExitente.getContaAcesso().setSenha(tutor.getContaAcesso().getSenha());
		tutorExitente.getContaAcesso().setTelefone(tutor.getContaAcesso().getTelefone());
		tutorExitente.getContaAcesso().setLinkWhatsapp(tutor.getContaAcesso().getLinkWhatsapp());
		tutorExitente.getContaAcesso().setAtivo(tutor.getContaAcesso().isAtivo());
		tutorExitente.getContaAcesso().setQrcode(tutor.getContaAcesso().getQrcode());
		
		//salvando conta acesso
		contaAcessoRepository.save(tutorExitente.getContaAcesso());

		return tutorRepository.save(tutorExitente);
	}

	public void deletarTutor(Long id) {
		Optional<Tutor> tutor = tutorRepository.findById(id);
        if (tutor.isEmpty()) {
            throw new EntityNotFoundException("Tutor não encontrado.");
        }

      //deletar gestor
        tutorRepository.deleteById(id);
        
      //deletar conta acesso
      	contaAcessoRepository.deleteById(tutor.get().getContaAcesso().getIdContaAcesso());

	}

	public List<Tutor> listarTutor() {
		return tutorRepository.findAll();
	}

//    public List<Tutor> listarTutorPorNome(String nome) {
//        return tutorRepository.findByNome(nome);
//    }

}