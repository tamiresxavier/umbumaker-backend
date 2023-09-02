package br.edu.ifpb.umbumaker.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.umbumaker.model.Gestor;
import br.edu.ifpb.umbumaker.model.repository.ContaAcessoRepository;
import br.edu.ifpb.umbumaker.model.repository.GestorRepository;
import jakarta.persistence.EntityNotFoundException;

//O GestorService esta chamando o GestorRepository e o ContaAcessoRepository
//com essas duas dempendecias, no metodo criarGestor estar criando uma
//ContaAcesso no banco e depois um Gestor o alterar e o deletar esta seguindo a mesma logica
//vou ver se esta dando certo :-O


@Service
public class GestorService {
	
	@Autowired
	private ContaAcessoRepository contaAcessoRepository;
	
	@Autowired
	private GestorRepository gestorRepository;
	
	public Gestor criarGestor(Gestor gestor) {
		
		//salvando conta acesso
		contaAcessoRepository.save(gestor.getContaAcesso());
		
		return gestorRepository.save(gestor);
	}
	
	public Gestor atualizarGestor(Long id, Gestor gestor) {
		
		Gestor gestorExitente = gestorRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Gestor não encontrado."));
		
		gestorExitente.getContaAcesso().setNome(gestor.getContaAcesso().getNome());
		gestorExitente.getContaAcesso().setEmail(gestor.getContaAcesso().getEmail());
		gestorExitente.getContaAcesso().setSenha(gestor.getContaAcesso().getSenha());
		gestorExitente.getContaAcesso().setTelefone(gestor.getContaAcesso().getTelefone());
		gestorExitente.getContaAcesso().setLinkWhatsapp(gestor.getContaAcesso().getLinkWhatsapp());
		gestorExitente.getContaAcesso().setAtivo(gestor.getContaAcesso().isAtivo());
		gestorExitente.getContaAcesso().setQrcode(gestor.getContaAcesso().getQrcode());
		
		//salvando conta acesso
		contaAcessoRepository.save(gestorExitente.getContaAcesso());
		
		return gestorRepository.save(gestorExitente);
	}
	
	public void deletarGestor(Long id) {
		Optional<Gestor> gestor = gestorRepository.findById(id);
        if (gestor.isEmpty()) {
            throw new EntityNotFoundException("Gestor não encontrado.");
        }

      //deletar gestor
        gestorRepository.deleteById(id);
        
      //deletar conta acesso
      	contaAcessoRepository.deleteById(gestor.get().getContaAcesso().getIdContaAcesso());
      	
    }

    public List<Gestor> listarGestor() {
    	
        return gestorRepository.findAll();
    }
    
//mestar gestor por nome esta dando erro porque Gesrto não tem esse atributo,
//quem tem esse atributo é a ContaAcesso
    public List<Gestor> listarGestorPorNome(String nome) {
    	ArrayList<Gestor> gestores = new ArrayList<Gestor>();
    	for (Gestor gestor : listarGestor()) {
    		if(gestor.getContaAcesso().getNome().equals(nome)) {
    			gestores.add(gestor);
    		}
    	}
    	
    	if (gestores.isEmpty()) {
            throw new EntityNotFoundException("Gestor não encontrado.");
        }
    	
        return gestores;
    }

}