package br.edu.ifpb.umbumaker.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.umbumaker.model.ContaAcesso;
import br.edu.ifpb.umbumaker.model.repository.ContaAcessoRepository;
import jakarta.persistence.EntityNotFoundException;


import java.util.List;

@Service
public class ContaAcessoService {

    @Autowired
    private ContaAcessoRepository contaAcessoRepository;

    public ContaAcesso criarContaAcesso(ContaAcesso contaAcesso) {
        return contaAcessoRepository.save(contaAcesso);
    }

    public ContaAcesso atualizarContaAcesso(Long id, ContaAcesso contaAcesso) {
        ContaAcesso contaAcessoExistente = contaAcessoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Conta de acesso não encontrada."));

        contaAcessoExistente.setSenha(contaAcesso.getSenha());
        contaAcessoExistente.setNome(contaAcesso.getNome());
        contaAcessoExistente.setTelefone(contaAcesso.getTelefone());
        contaAcessoExistente.setQrcode(contaAcesso.getQrcode());
        contaAcessoExistente.setAtivo(contaAcesso.isAtivo());
        contaAcessoExistente.setLinkWhatsapp(contaAcesso.getLinkWhatsapp());

        return contaAcessoRepository.save(contaAcessoExistente);
    }

    public void deletarContaAcesso(Long id) {
        if (!contaAcessoRepository.existsById(id)) {
            throw new EntityNotFoundException("Conta de acesso não encontrada.");
        }

        contaAcessoRepository.deleteById(id);
    }

    public List<ContaAcesso> listarContasAcesso() {
        return contaAcessoRepository.findAll();
    }

}