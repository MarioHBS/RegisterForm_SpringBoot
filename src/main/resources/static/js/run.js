$(document).ready(function () {
    var $cep = $('input[name="adr_cep"]');
    var $tel = $('input[name="number"]');

    $cep.mask('00000-000');
    $tel.mask('(00) 0 0000-0000');
});