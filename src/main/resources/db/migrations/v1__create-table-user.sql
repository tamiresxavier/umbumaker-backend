create table contaAcesso{
    email TEXT not null,
    senha TEXT not null,
    desde Date,
    nome TEXT not null,
    telefone TEXT,
    qrCode TEXT,
    ativo BIT not null,
    linkWhatsapp TEXT


}