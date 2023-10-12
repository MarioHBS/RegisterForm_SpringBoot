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

function telephone(doc, event) {
    const pure = doc.value.replace(/\D/g, '');
    const sz = pure.length;

    if (sz > 11) {
        event.returnValue = false
        return;
    };

    var regex = /^[a-z]/i;
    if (!regex.test(event.key)) {
        // console.log("value: " + doc.value);
        // console.log("pure: " + pure);
        console.log("sz: " + sz);

        if (sz === 0) doc.value += '(';
        if (sz >= 2) {
            doc.value = pure.replace(/^(\d{2})$/, '($1)');
        }
        if (sz === 3) {
            doc.value = pure.replace(/^(\d{2})(\d+)$/, '($1) $2');
        }
        if (sz >= 4) doc.value = pure.replace(/^(\d{2})(\d{1})(\d+)$/, '($1) $2 $3');
        if (sz > 7) doc.value = pure.replace(/^(\d{2})(\d{1})(\d{4})(\d+)$/, '($1) $2 $3-$4');
    }
    // return "";
};