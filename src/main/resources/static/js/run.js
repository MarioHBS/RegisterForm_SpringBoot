const cep = document.querySelector('input[name="adr_cep"]');
const loc = document.querySelector('input[name="adr_location"]');
const complement = document.querySelector('input[name="adr_complement"]');
const neighbor = document.querySelector('input[name="adr_neighbor"]');
const city = document.querySelector('input[name="adr_city"]');
const state = document.querySelector('input[name="adr_state"]');

var prev_error = false;
var script;

function formatar(mascara, documento, event) {
    var regex = /^[a-z]/i;
    // console.log(event.key);
    if (documento.value.length === 8) prev_error = false;
    if (regex.test(event.key)) {
        event.preventDefault();
        return;
    }
    var saida = '#';//mascara.substring(0, 1);
    var texto = mascara.substring(documento.value.length)

    if (texto[0] != saida) {
        documento.value += texto[0]
    }
    // console.log("depois: " + documento.value);
};

function fill(crt = "") {
    console.log('chamando fill');
    loc.value = crt;
    complement.value = crt;
    neighbor.value = crt;
    city.value = crt;
    state.value = crt;
};

function buscarCep(content) {
    console.log(content);
    const pure = String(content).replace(/\D/g, '');

    if (pure.length > 1 && pure.length === 8 && !prev_error) {
        fill('   ****');

        script = document.createElement('script');
        script.src = 'https://viacep.com.br/ws/' + pure + '/json/?callback=tratar_cep';
        document.body.appendChild(script);
    } else {
        fill();
    }    
};

function tratar_cep(content) {
    if (!("erro" in content)) {
        loc.value = content.logradouro;
        complement.value = content.complemento;
        neighbor.value = content.bairro;
        city.value = content.localidade;
        state.value = content.uf;
    } else {
        prev_error = true;
        document.body.removeChild(script);
        alert("CEP inválido");
        fill();
        cep.focus();
    }
};

function telephone(doc) {
    const pure = doc.value.replace(/\D/g, '');
    // console.log("pure: " + pure);
    // var regex = /[^0-9]/;
    
    const formatted = pure.replace(/(\d{2})(\d{1})(\d{0,4})(\d{0,4})/, '($1) $2 $3-$4');
    doc.value = (pure.length === 2 && doc.value === '(' + pure + ')') ? pure : formatted;
};
/* $(document).ready(function () {
    var $cep = $('input[name="adr_cep"]');
    var $tel = $('input[name="number"]');

    $cep.mask('00000-000');
    $tel.mask('(00) 0 0000-0000');
}); */