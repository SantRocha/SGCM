/*document.getElementById('cnpj').addEventListener('blur', function() {
    const cnpj = this.value.replace(/\D/g, '');

    if (cnpj.length === 14) {
        fetch(`https://www.receitaws.com.br/v1/cnpj/${cnpj}`)
            .then(response => response.json())
            .then(data => {
                if (data.status !== "ERROR") {
                    document.getElementById('email').value = data.email || '';
                    document.getElementById('nome').value = data.nome || '';
                    document.getElementById('razao_social').value = data.razao_social || '';
                    document.getElementById('representante').value = data.qsa && data.qsa[0] ? data.qsa[0].nome : '';
                    document.getElementById('telefone').value = data.telefone || '';
                    document.getElementById('resultado').innerHTML = `
                        <p><strong>Nome:</strong> ${data.nome}</p>
                        <p><strong>Razão Social:</strong> ${data.razao_social}</p>
                        <p><strong>Email:</strong> ${data.email}</p>
                        <p><strong>Telefone:</strong> ${data.telefone}</p>
                        <p><strong>Representante:</strong> ${data.qsa && data.qsa[0] ? data.qsa[0].nome : ''}</p>
                    `;
                } else {
                    document.getElementById('resultado').innerHTML = `<p>CNPJ não encontrado.</p>`;
                }
            })
            .catch(error => console.error('Erro ao buscar o CNPJ:', error));
    } else {
        alert('CNPJ inválido.');
    }
});*/

// Adiciona funcionalidade ao botão Enviar e envia os dados do formulário para a tabela
let idTabela = document.querySelector('table');
form.addEventListener('submit', (event) => {
    event.preventDefault();
    // Cria um objeto com os dados do convenio
    let convenio = {
        id: idTabela.tBodies[0].rows.length + 1,
        ativo: true,
        cnpj: form.cnpj.value,
        email: form.email.value,
        nome: form.nome.value,
        razao_social: form.razao_social.value,
        representante: form.representante.value,
        telefone: form.telefone.value
    };
    // Insere o convenio na tabela
    inserirConvenio(convenio);
    form.reset();
    form.classList.add('inativo');
    botaoAdicionar.classList.remove('inativo');
});

// Adiciona as informações na tabela
const inserirConvenio = (item) => {
    let tabela = document.querySelector('table');

    // Cria elementos de célula para cada informação do convenio
    let linha = document.createElement('tr');
    let id = document.createElement('td');
    let ativo = document.createElement('td')
    let cnpj = document.createElement('td');
    let nome = document.createElement('td');
    let email = document.createElement('td');
    let razao_social = document.createElement('td');
    let representante = document.createElement('td');
    let telefone = document.createElement('td');
    let acoes = document.createElement('td');

    // Define o texto de cada célula com as informações do convenio
    id.textContent = item.id;
    ativo.textContent = item.ativo;
    cnpj.textContent = item.cnpj;
    nome.textContent = item.nome;
    email.textContent = item.email;
    razao_social.textContent = item.razao_social;
    representante.textContent = item.representante;
    telefone.textContent = item.telefone;

    // Adiciona os botões de ação na célula de ações
    acoes.innerHTML = ` <a class="editar">Editar</a>
                        <a class="excluir">Excluir</a>`;

    // Adiciona as células à linha da tabela
    linha.appendChild(id);
    linha.appendChild(ativo)
    linha.appendChild(cnpj);
    linha.appendChild(nome);
    linha.appendChild(email);
    linha.appendChild(razao_social);
    linha.appendChild(representante);
    linha.appendChild(telefone);
    linha.appendChild(acoes);

    // Adiciona a linha à tabela
    tabela.tBodies[0].appendChild(linha)

    // Adiciona a funcionalidade de exclusão ao botão "Excluir"
    let botaoExcluir = linha.querySelector('.excluir');
    botaoExcluir.addEventListener('click', () => {
        linha.remove();
        rodapeTabela();// chamaa  funçao para reduzir
    })
    rodapeTabela();//chama a funçao para adicionar 
};

// Carrega as Informações do JSON na tabela
const carregaTabela = () => {
    // Define a URL do arquivo JSON
    let url = 'https://my-json-server.typicode.com/juniorlimeiras/json/convenios'
    // Realiza uma solicitação fetch para obter os dados do JSON
    fetch(url).then(resposta => {
        return resposta.json();
    }).then(dados => {
        // Para cada item no JSON, insere o convenio na tabela
        for(const item of dados) {
            inserirConvenio(item);
        }
    }).catch(erro => (
        console.error(erro)
    ));
}
// Chama a função para carregar a tabela quando a página é carregada
carregaTabela();

// Atualiza o rodapé para a quantidade de linha da tabela.
const rodapeTabela = () => {
    const totalSpan = document.getElementById('total');
    const totalRegistros = idTabela.tBodies[0].rows.length;
    totalSpan.textContent = totalRegistros;
};