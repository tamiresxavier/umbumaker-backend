package br.edu.ifpb.umbumaker.business.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.umbumaker.model.Associado;
import br.edu.ifpb.umbumaker.model.repository.AssociadoRepository;
import br.edu.ifpb.umbumaker.model.repository.ContaAcessoRepository;
import jakarta.persistence.EntityNotFoundException;

//O GestorService esta chamando o GestorRepository e o ContaAcessoRepository
//com essas duas dempendecias, no metodo criarGestor estar criando uma
//ContaAcesso no banco e depois um Gestor o alterar e o deletar esta seguindo a mesma logica
//vou ver se esta dando certo :-O


@Service
public class AssociadoService {
	
	@Autowired
	private ContaAcessoRepository contaAcessoRepository;
	
	@Autowired
	private AssociadoRepository associadoRepository;
	
	public Associado criarAssociado(Associado associado) {
		
		//salvando conta acesso
		contaAcessoRepository.save(associado.getContaAcesso());
		
		return associadoRepository.save(associado);
	}
	
	public Associado atualizarAssociado(Long id, Associado associado) {
		
		Associado associadoExitente = associadoRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Associado não encontrado."));
		
		associadoExitente.getContaAcesso().setNome(associado.getContaAcesso().getNome());
		associadoExitente.getContaAcesso().setEmail(associado.getContaAcesso().getEmail());
		associadoExitente.getContaAcesso().setSenha(associado.getContaAcesso().getSenha());
		associadoExitente.getContaAcesso().setTelefone(associado.getContaAcesso().getTelefone());
		associadoExitente.getContaAcesso().setLinkWhatsapp(associado.getContaAcesso().getLinkWhatsapp());
		associadoExitente.getContaAcesso().setAtivo(associado.getContaAcesso().isAtivo());
		associadoExitente.getContaAcesso().setQrcode(associado.getContaAcesso().getQrcode());
		
		//salvando conta acesso
		contaAcessoRepository.save(associadoExitente.getContaAcesso());
		
		return associadoRepository.save(associadoExitente);
	}
	
	public void deletarAssociado(Long id) {
		Optional<Associado> gestor = associadoRepository.findById(id);
        if (gestor.isEmpty()) {
            throw new EntityNotFoundException("Associado não encontrado.");
        }

      //deletar associado
        associadoRepository.deleteById(id);
        
      //deletar conta acesso
      	contaAcessoRepository.deleteById(gestor.get().getContaAcesso().getIdContaAcesso());
      	
    }

    public List<Associado> listarAssociados() {
    	
        return associadoRepository.findAll();
    }

}