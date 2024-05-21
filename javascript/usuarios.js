const bcrypt = require('bcrypt');

// Função para gerar o hash da senha
async function gerarHashSenha(senha) {
    const hash = await bcrypt.hash(senha, 10); // O segundo parâmetro é o fator de custo
    return hash;
}

// Função para verificar se a senha fornecida corresponde ao hash armazenado
async function verificarSenha(senha, hash) {
    const match = await bcrypt.compare(senha, hash);
    return match;
}

// Exemplo de uso
async function exemplo() {
    const senhaOriginal = "senha123";
    const hash = await gerarHashSenha(senhaOriginal);
    console.log("Hash da senha original:", hash);

    // Simulando verificação da senha
    const senhaDigitada = "senha123";
    const resultado = await verificarSenha(senhaDigitada, hash);
    console.log("As senhas correspondem:", resultado);
}

// Chamada da função exemplo
exemplo();
