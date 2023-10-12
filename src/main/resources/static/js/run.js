/* $(document).ready(function () {
    var $cep = $('input[name="adr_cep"]');
    var $tel = $('input[name="number"]');

    $cep.mask('00000-000');
    $tel.mask('(00) 0 0000-0000');
}); */
function formatar(mascara, documento, event) {
    var regex = /^[a-z]/i;
    // console.log(event.key);
    if (regex.test(event.key)) {
        event.returnValue = false;
        return;
    }
    var i = documento.value.length;
    var saida = '#';//mascara.substring(0, 1);
    var texto = mascara.substring(i)
    
    if (texto.substring(0, 1) != saida) {
        documento.value += texto.substring(0, 1);
    }
    // console.log("depois: " + documento.value);
};

function telephone(doc) {
    const pure = doc.value.replace(/\D/g, '');
    // console.log("pure: " + pure);
    // var regex = /[^0-9]/;

    const formatted = pure.replace(/(\d{2})(\d{1})(\d{0,4})(\d{0,4})/, '($1) $2 $3-$4');
    doc.value = (pure.length === 2 && doc.value === '(' + pure + ')') ? pure : formatted;
};